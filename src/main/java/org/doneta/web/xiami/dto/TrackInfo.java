package org.doneta.web.xiami.dto;

import org.doneta.base.dto.BaseBean;
import org.doneta.web.xiami.bo.XiamiDecryptKey;

/**
 * TrackInfo
 * 
 * @author Hypnusds
 */
public class TrackInfo extends BaseBean {

	private static final long serialVersionUID = 9218169555359887996L;

	private String songName;
	private String artistName;
	private String albumName;
	private String albumCover;
	private String path;

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getAlbumCover() {
		return albumCover;
	}

	public void setAlbumCover(String albumCover) {
		int endIndex = albumCover.lastIndexOf(TARGET);
		this.albumCover = albumCover.substring(0, endIndex) + REPLACEMENT;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = XiamiDecryptKey.getInstance().decryptKey(path);
	}
	
	private static final String TARGET = "_3.jpg";
	private static final String REPLACEMENT = "_2.jpg";

}
