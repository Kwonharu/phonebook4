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
	<h2>등록폼</h2>
	
	<p>정보을 등록하는 폼입니다. 정보를 등록하고 등록 버튼을 누르세요</p>
	
	<!-- 절대주소 표시 -->
	<form action="/phonebook4/write" method="get">
		이름(name): <input type="text" name="name" value=""><br>
		핸드폰(hp): <input type="text" name="hp" value=""><br>
		회사(company): <input type="text" name="company" value=""><br>
		
		<button type="submit">등록</button>
	</form>
	
	<br>
	<br>
	
	<a href="/phonebook4/list">리스트로 바로가기</a>

</body>
</html>


