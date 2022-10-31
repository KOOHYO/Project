<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>
	<div class="container">
		<div class="row justify-content-md-center">
			<div class="col-7">
				<h1>ListPage</h1>
				<table class="table">
				  <thead>
				    <tr>
						<th scope="col">NUM</th>
						<th scope="col">TITLE</th>
						<th scope="col">WRITER</th>
						<th scope="col">DATE</th>
						<th scope="col">HIT</th>
				    </tr>
				  </thead>
				  <tbody class="table-group-divider">
				  	<c:forEach items="${qnaVOs}" var="vo">
					    <tr>
						<th scope="row">${vo.num}</th>
						<td><a href="./detail?num=${vo.num}">${vo.title}</a></td>
						<td>${vo.writer}</td>
						<td>${vo.regDate}</td>
						<td>${vo.hit}</td>
					    </tr>
				  	</c:forEach>
				  </tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>