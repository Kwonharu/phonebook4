<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전화번호부</h1>
	<h2>리스트</h2>
   
	<p>등록된 전화번호 리스트 입니다.</p>
   
    <!-- 반복문시작 -->
		<c:forEach items="${requestScope.personList}" var="personVo">
			<table border="1">
				<tr>
					<td>이름(name)</td><td>${personVo.name}</td>
				</tr>
		   		<tr>
					<td>핸드폰(hp)</td><td>${personVo.hp}</td>
				</tr>
		   		<tr>
					<td>회사(company)</td><td>${personVo.company}</td>
				</tr>
				<tr>
					<td><a href="/phonebook4/updateform/${personVo.person_id}">[수정]</a></td>
					<td><a href="/phonebook4/delete/${personVo.person_id}">[삭제]</a></td>
				</tr>
			</table>
			<br>
		</c:forEach>
	<!-- 반복문 끝 -->
	
	<a href="/phonebook4/writeform">전화번호 등록폼</a> <br>
	<br><br><br><br><br><br><br>
</body>
</html>

