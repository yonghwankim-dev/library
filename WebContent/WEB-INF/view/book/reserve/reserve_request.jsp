<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/reserve_request.css">
    <title>도서 예약 신청</title>
</head>
<body>
    <!-- 도서 예약 신청 -->
    <div class="main">
        <h1>도서 예약 신청</h1>
        <form action="/Library/book/reserve/request?registered_number=${registered_number}" method="post">
            <div class="main__info">
            	<!-- 예약 유효일 -->
                <label for="reserve_effective_date"><b>예약 유효일</b></label>
                <input type="text" placeholder="2021-06-15" name="reserve_effective_date" required>
                
                <!-- 수령 도서관 -->
                <label for="received_library_name"><b>수령도서관</b></label>
                <select name="received_library_name">
                    <option>선택</option>
                    <option value="충남대학교 도서관">충남대학교 도서관</option>
                    <option value="목원대학교 중앙도서관">목원대학교 중앙도서관</option>
                    <option value="한남대학교 중앙도서관">한남대학교 중앙도서관</option>
                    <option value="우송대학교 도서관">우송대학교 도서관</option>
                    <option value="을지대학교 대전캠퍼스도서관">을지대학교 대전캠퍼스도서관</option>
                </select>
                
                <button type="submit">신청</button>
            </div>
            
            <div class="main__cancel">
                <a href="/Library/book/detail/detailed" class="cancelbtn">뒤로가기</a>
            </div>
        </form>
    </div>
</body>
</html>