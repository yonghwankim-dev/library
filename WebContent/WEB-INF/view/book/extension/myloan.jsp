<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/myloan.css">
    <title>대출조회/연장</title>
</head>
<body>
	<!-- 대출조회/연장 -->
    <div class="main">
        <h1>대출조회/연장</h1>
        <form action="/Library/book/extension/extensionBook" method="post">
            <div class="main__listTable">
                <table>
                    <thead>
                        <tr>
                            <th><input type="checkbox" onclick="selectAll(this)"></th>	<!-- 대출 연장을 위한 체크박스 -->
                            <th>No.</th>
                            <th>서명/저자</th>
                            <th>도서관</th>
                            <th>소장처/자료실</th>
                            <th>등록번호</th>
                            <th>대출일</th>
                            <th>반납예정일</th>
                            <th>연장횟수</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:set var="registered_number" value=""/>
                    	<c:forEach var="loan" items="${myloan_list}" varStatus="status">
                    		<c:set var="registered_number" value="${registered_number} ${loan.registered_number}" />
	                        <tr>
	                            <td>
		                            <input type="checkbox" 
		                            name="extension_chk" value="${status.index}"></td> 	<!-- 대출연장 선택 체크박스 -->
	                            <td>${status.index+1}</td>                          <!-- No. -->
	                            <td>${loan.book_name}/${loan.author_name}</td>    	<!-- 서명/저자-->
	                            <td>${loan.library_name}</td>						<!-- 도서관명 -->
	                            <td>${loan.ownlocation}</td>           				<!-- 소장처/자료실-->
	                            <td>${loan.registered_number}</td>                  <!-- 등록번호 -->
	                            <td>${loan.loan_date}</td>                     		<!-- 대출일 -->
	                            <td>${loan.return_scheduled_date}</td>              <!-- 반납예정일 -->
	                            <td>${loan.current_extension_count}</td>            <!-- 연장횟수 -->
	                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            
            <!-- 대출연장 버튼 -->
            <div class="main__loanExtension">
            	<input type="hidden" name="registered_number" value="${registered_number }">	<!-- 대출연장 위한 등록번호 -->
                <input id="loanExtensionBtn" type="submit" value="대출연장">
                
            </div>
            <!-- 뒤로가기 버튼 -->
			<div class="detailBtn">
				<a href="/Library/index/index">뒤로가기</a>
			</div>
        </form>
    </div>
    <script src="${pageContext.request.contextPath}/js/extension.js"></script>
</body>
</html>