<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./temp/boot.jsp"></c:import>
</head>
<body>
	<h1><b>Home Page</b></h1>
	<h3><a href="./qna/list">게시판</a></h3>
	<h3><a href="./member/login">로그인</a></h3>
	<h3><a href="./member/join">회원가입</a></h3>
	<h3><a href="./member/logout">로그아웃</a></h3>
</body>
</html>