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
	href="${pageContext.request.contextPath}/css/myreserve.css">
    <title>대출기록</title>
</head>
<body>
	<!-- 예약자료 조회/취소 -->
    <div class="main">
        <h1>예약자료 조회/취소</h1>
        <form action="/Library/book/reserve/myReserve" method="post">
            <div class="main__search">
                <!-- 도서 정보 필터 -->
                <select name="category" id="main__search__category">
                    <option>서명</option>
                    <option>저자</option>
                </select>
                <input class="main__search__input" type="text" placeholder="검색어를 입력하세요" name="search_content">
                <!-- 대출시작일 - 대출종료일 -->
                <input class="main__search__input" type="text" placeholder="신청시작일" name="start_reserve">
                <input class="main__search__input" type="text" placeholder="신청종료일" name="end_reserve">

                <!-- 정렬항목 -->
                <select name="sorted" id="main__search__sorted">
                    <option>정렬항목</option>
                    <option>서명</option>
                    <option>저자</option>
                    <option>예약일</option>
                </select>
                <!-- 정렬항목에 대한 정렬순서 -->
                <select name="ordered" id="main__search__ordered">
                    <option>정렬순서</option>
                    <option>오름차순</option>
                    <option>내림차순</option>
                </select>
                <input type="submit" value="조회">
            </div>
        </form>

        <div class="main__listInfo">
        </div>

        <form action="" method="post">
            <div class="main__listTable">
                <table>
                    <thead>
                        <tr>
                            <th><input type="checkbox"></th>
                            <th>No.</th>
                            <th>서명/저자</th>
                            <th>도서관명</th>
                            <th>소장처/자료실</th>
                            <th>예약순위</th>
                            <th>예약일</th>
                            <th>도착 통보일</th>
                            <th>예약 유효일</th>
                            <th>예약 상태</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach var="re" items="${myReserve_list}" varStatus="status">
	                        <tr>
	                            <td><input type="checkbox"></td> 					<!-- 체크박스 -->
	                            <td>${status.index+1}</td>                         	<!-- No. -->
	                            <td>${re.book_name}/${re.author_names}</td>    		<!-- 서명/저자-->
	                            <td>${re.library_name}</td>    						<!-- 도서관명-->
	                            <td>${re.ownlocation}</td>           				<!-- 소장처/자료실-->
	                            <td>${re.priority}</td>                          	<!-- 에약순위 -->
	                            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${re.reserve_date}" /></td>                <!-- 예약일 -->
	                            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${re.arrive_date}" /></td>                 <!-- 도착 통보일 -->
	                            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${re.reserve_effective_date}" /></td>      <!-- 예약 유효일 -->
	                            <td>${re.status }</td>                       		<!-- 예약 상태 -->
	                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </form>
    </div>
</body>
</html>