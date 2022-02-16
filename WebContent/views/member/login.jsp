<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="/Library/resources/css/reset/reset.css">
   	<link rel="stylesheet" href="/Library/resources/css/member/login.css">
<title>통합 도서관 로그인</title>
</head>
<body>
    <!-- 로그인 -->
    <div class="login__container">
        <h1>통합 도서관 로그인</h1>
        <!-- 이메일/비밀번호 -->
        <form action="/Library/home/login" method="post">
            <div class="container">
                <label for="email"><b>E-mail</b></label>
                <input type="text" placeholder="E-mail을 입력해주세요" name="email" required>
                
                <label for="password"><b>비밀번호</b></label>
                <input type="password" placeholder="비밀번호를 입력해주세요" name="password" required>
                
                <button type="submit">로그인</button>
            </div>
            
            <!-- 뒤로가기  -->
            <div class="container">
                <a href="/Library/home" class="cancelbtn">뒤로가기</a>
            </div>
        </form>
		<c:if test="${not empty loginResult}">
        	<script>alert("${loginResult}");</script>
        </c:if>
    </div>
</body>
</html>