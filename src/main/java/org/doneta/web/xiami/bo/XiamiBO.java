package org.doneta.web.xiami.bo;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.doneta.util.empty.EmptyUtils;
import org.doneta.util.stream.CloseableUtils;
import org.doneta.web.xiami.dto.TrackInfo;

/**
 * 虾米网 获取音乐信息
 * @author Hypnusds
 */
public class XiamiBO {

	public static Logger log = Logger.getLogger(XiamiBO.class);
	private TrackInfo trackInfo;

	static class SingletonHolder {
		static XiamiBO instance = new XiamiBO();
	}

	public static XiamiBO getInstance() {
		return SingletonHolder.instance;
	}
	
	public TrackInfo getTrackInfo(){
		return this.trackInfo;
	}
	
	private String getPath(String songId){
		return XIAMI_XML_PATH + songId;
	}

	/**
	 * 获取Track节点
	 * @param is XML流
	 * @return Element 
	 * @throws DocumentException
	 */
	private Element getTrackElement(InputStream is) throws DocumentException {
		if(is == null)
			return null;
		if(EmptyUtils.isEmpty(is)){
			CloseableUtils.closeStream(is);
			return null;
		}
		SAXReader reader = new SAXReader();
		Document doc = reader.read(is);
		Element rootElement = doc.getRootElement();
		CloseableUtils.closeStream(is);
		if (rootElement != null)
			return rootElement.element("track");
		return null;
	}

	/**
	 * 获取 Detail Song Info
	 * @param urlStr
	 * @return TrackInfo
	 */
	public TrackInfo getDetailSongInfo(String urlStr) {
		trackInfo = null;
		Element trackElement = null;
		try {
			trackElement = getTrackElement(getXmlSingle(urlStr));
		} catch (DocumentException e) {
			log.error(e.getMessage());
		}
		if (trackElement != null) {
			trackInfo = new TrackInfo();
			trackInfo.setSongName(trackElement.elementText("song_name"));
			trackInfo.setArtistName(trackElement.elementText("artist_name"));
			trackInfo.setAlbumName(trackElement.elementText("album_name"));
			trackInfo.setAlbumCover(trackElement.elementText("album_cover"));
			trackInfo.setPath(trackElement.elementText("location"));
		}
		return trackInfo;
	}

	/**
	 * 只获取Key
	 * @param urlStr
	 * @return String
	 */
	public String onlyGetPath(String urlStr) {
		Element trackElement = null;
		try {
			trackElement = getTrackElement(getXmlSingle(urlStr));
		} catch (DocumentException e) {
			log.error(e.getMessage());
		}
		if (trackElement != null)
			return XiamiDecryptKey.getInstance().decryptKey(trackElement.elementText("location"));
		return null;
	}

	/**
	 * 获取XML流
	 * @param urlStr
	 * @return InputStream
	 */
	private InputStream getXmlSingle(String urlStr) {
		URL url = null;
		InputStream is = null;
		try {
			url = new URL(this.getPath(urlStr));
			URLConnection connection = url.openConnection();
			is = connection.getInputStream();
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return is;
	}
	
	private static final String XIAMI_XML_PATH = "http://data.xiami.com/widget/xml-single/uid/0/sid/";

}
