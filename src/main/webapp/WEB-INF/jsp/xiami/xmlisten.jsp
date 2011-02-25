<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    	<meta name="title" content="Xiami(虾米)网 音乐链接 ${track.songName}" /> 
    	<meta name="keywords" content="xiama 虾米 音乐 外链 ${track.songName}" /> 
    	<meta name="description" content="Xiami(虾米)网 音乐链接  外部链接 ${track.songName}" /> 
    	<meta name="author" content="Hypnusds, chinni" /> 
        <title>${track.songName}</title>
        <link rel="stylesheet"  type="text/css"  href="<%=request.getContextPath() %>/css/commons.css" />
        <!-- Include CommonsHead -->
        <%@ include file="/include/commonsHead.jsp"%>
        <!-- CommonsHead End -->
        <link rel="stylesheet"  type="text/css"  href="<%=request.getContextPath() %>/css/xiami.css" />
    </head>
    <body>
	   <div class="music_box">
            <div class="music_body">
                <table width="100%" height="270px">
                    <tr>
                        <td colspan="2" height="70px" class="music_info">
                            <div class="music_title"><b>${track.songName}</b></div>
                        </td>
                        <td rowspan="6" width="231px" class="CDcover">
                            <div class="cd_background">
                                <img alt="${track.songName} - ${track.artistName}" src="${track.albumCover}" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" height="50px" class="music_info">
                            <audio src="${track.path}" controls="controls"></audio>
                        </td>
                    </tr>
                    <tr>
                        <td height="20px" class="music_info"><div>演唱者</div></td>
                        <td height="20px" ><div class="detail_info">${track.artistName}</div></td>
                    </tr>
                    <tr>
                        <td height="20px" class="music_info"><div>所属专辑</div></td>
                        <td height="20px" ><div class="detail_info">${track.albumName}</div></td>
                    </tr>
                    <tr>
                        <td height="70px" class="music_download" colspan="2">
                            <a href="${track.path}" class="big awesome" rel="noreferrer" >点击下载 ${track.songName}</a>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">&nbsp;</td>
                    </tr>
                </table>
            </div>
        </div>
        <%@ include file="/include/copyright.jsp"%>
    </body>
</html>