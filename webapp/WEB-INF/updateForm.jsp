<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전화번호부</h1>
	<h2>수정폼</h2>
	
	<p>정보을 수정하는 폼입니다. 수정할 정보를 입력하고 수정 버튼을 누르세요</p>
	
	<form action="/phonebook4/update" method="get">
		이름(name): <input type="text" name="name" value=""><br>
		핸드폰(hp): <input type="text" name="hp" value=""><br>
		회사(company): <input type="text" name="company" value=""><br>
		<input type="hidden" name="person_id" value="${personVo.person_id}"><br>
		<button type="submit">수정</button>
	</form>
	
	<br>
	<br>
	
	<a href="/phonebook4/list">리스트로 바로가기</a>

</body>
</html>

