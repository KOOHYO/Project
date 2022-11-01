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
				<form action="./list" class="row row-cols-lg-auto g-3 align-items-center">
				
				  <div class="col-12">
				    <label class="visually-hidden" for="kind">kind</label>
				    <select name="kind" class="form-select" id="kind">
				      <option class="kinds" value="contents">Contents</option>
				      <option class="kinds" value="title">Title</option>
				      <option class="kinds" value="writer">Writer</option>
				    </select>
				  </div>
				
				  <div class="col-12">
				    <label class="visually-hidden" for="search">검색어</label>
				    <div class="input-group">
				      <input type="text" name="search" value="${param.search}" class="form-control" id="search">
				    </div>
				  </div>
				
				  <div class="col-12">
				    <button type="submit" class="btn btn-primary">검색</button>
				  </div>
				</form>
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
				<div class="my-3">
					<a href="./add" class="btn btn-primary">WRITE</a>
				</div>	
				<div>
					<nav aria-label="Page navigation example">
						<ul class="pagination">
						  
						<c:if test="${pager.pre}">
							<li class="page-item">
							<a class="page-link" href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">Previous</a></li>
						</c:if>
						  
						<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
							<li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
						</c:forEach>
						    
			<%-- 	    <c:choose>
						    <c:when test="${pager.next}">
						    	<li class="page-item">
						    </c:when>
						    <c:otherwise>
						    	여기는 부트스트랩 class 속성 disabled를 이용해서 누르지못하게 막아줌
						    	<li class="page-item disabled">
						    </c:otherwise>
						</c:choose> --%>
						    
						  	<%-- 삼항연산자를 사용해서 하는 표현식 --%>
						    <li class="page-item ${pager.next?'':'disabled'}">
						    <a class="page-link" href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">Next</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</body>
</html>