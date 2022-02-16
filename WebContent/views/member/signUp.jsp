<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/Library/resources/css/reset/reset.css">
   	<link rel="stylesheet" href="/Library/resources/css/member/signUp.css">
    <title>회원가입</title>
</head>
<body>
	<!-- 회원가입 -->
    <div class="signUp__container">
        <h1>통합 도서관 회원가입</h1>
        <!-- 섬명/이메일/비밀번호/비밀번호 확인/가입도서관명 -->
        <form action="/Library/home/signUp" method="post">
            <div class="container">
                <label for="name"><b>성명</b></label>
                <input type="text" placeholder="성명을 입력해주세요" name="name" required>
                
                <label for="email"><b>E-mail</b></label>
                <input type="text" placeholder="이메일을 입력해주세요" name="email" required>

                <label for="password"><b>비밀번호</b></label>
                <input type="password" placeholder="비밀번호를 입력해주세요" name="password" required>
                
                <label for="confirm_password"><b>비밀번호 확인</b></label>
                <input type="password" placeholder="비밀번호를 입력해주세요" name="confirm_password" required>
                
                <label for="registered_liibrary_Name"><b>가입 도서관명</b></label><br>
                <select id="registered_Library_Name" name="library_name">
                	<c:forEach var="library" items="${librarys}" varStatus="status">
                		<c:if test="${status.index==0}">
                			<option value="${status.index+1}" selected>${library.lib_name}</option>
                		</c:if>
                		<c:if test="${status.index!=0}">
                			<option value="${status.index+1}">${library.lib_name}</option>
                		</c:if>
	        
                	</c:forEach>
                    
                </select>

                <button type="submit">회원가입</button>
            </div>
            
            <!-- 취소 -->
            <div class="container">
                <a href="/Library/home" class="cancelbtn">취소</a>
            </div>
        </form>
        
        <c:if test="${not empty signUpResult}">
        	<script>alert("${signUpResult}");</script>
        </c:if>
    </div>
</body>
</html>