<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    	<meta name="title" content="Xiami(虾米)网 音乐链接 " /> 
    	<meta name="keywords" content="xiama 虾米 音乐 外链" /> 
    	<meta name="description" content="Xiami(虾米)网 音乐链接  外部链接" /> 
    	<meta name="author" content="Hypnusds, chinni " /> 
        <title>Xiami(虾米)网 音乐链接</title>
        <!-- Include CommonsHead -->
        <%@ include file="/include/commonsHead.jsp"%>
        <!-- CommonsHead End -->
        <!-- Include Dialog -->
        <%@ include file="/include/dialog.jsp"%>
        <!-- Include Dialog End -->
    </head>
    <body>
        <div>您输入的链接格式不正确 或 你输入的songid不存在</div>
        <div>e.g. : <a href=" <%=basePath %>/file/mp3/1769196206.mp3" rel="noreferrer"> <%=basePath %>/file/mp3/1769196206.mp3</a></div>
        <div>e.g. : <a href=" <%=basePath %>/xiami.dox?songid=1769196206" rel="noreferrer"> <%=basePath %>/xiami.dox?songid=1769196206</a></div>
        <div>Listen模式</div>
        <div>e.g. : <a href=" <%=basePath %>/xiami.dox?songid=1769196206&listen=true" > <%=basePath %>/xiami.dox?songid=1769196206&listen=true</a></div>
        <div><button class="big awesome" >点击体验Listen模式</button></div>
    </body>
</html>