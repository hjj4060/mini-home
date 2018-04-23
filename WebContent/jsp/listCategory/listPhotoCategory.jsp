<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="navi" tagdir="/WEB-INF/tags" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/jsp/include/basicInclude.jsp"%>
</head>
<body>
	<div class="row justify-content-center">

		<div class="header">
			<c:import url="/jsp/include/header.jsp" />
		</div>

		<div class="content row">
			<div class="container">
				<center>
					<p class="h1">사진첩</p>
					<table class="table">
					<thead>
						<tr>
							<th>하위 카테고리</th>
						</tr>
					</thead>	
					<tbody>
					
					<c:forEach var = "s" items="${list}" varStatus="loop">
						<tr>
							<td><a href="${pageContext.request.contextPath}/jsp/photogallary/listphotogallary?homepage_no=${s.homepageNo}&category_group_no=${s.categoryGroupNo}&category_no=${s.categoryNo}">${s.name}</a></td>
						</tr>
					</c:forEach>
					
					<c:if test="${empty list}">
						<tr>
							<td colspan='4'>입력된 게시물이 없습니다.</td>
						</tr>
					</c:if>
					</tbody>
					</table>						
				<div align="right">
				<a href="${pageContext.request.contextPath}
				/jsp/photogallary/modifyformphotogallarycategorylist
				?homepage_no=${homepage_no}
				&category_group_no=${category_group_no}">카테고리 편집</a>
				</div>
				</center>
								
			</div>
		</div>
		
		
		<div class="footer">
			<c:import url="/jsp/include/footer.jsp" />
		</div>
		
	</div>
	
	
	<
</body>
</html>