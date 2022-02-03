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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/myloan_history.css">
<script src="https://kit.fontawesome.com/f3e90f406f.js" crossorigin="anonymous"></script>
<title>대출기록</title>
</head>
<body>
	<!-- 도서 대출기록 -->
	<div class="main">
		<h1>대출기록</h1>
		
		
		<div class="nav__row">
			<!-- 도서 대출기록 상세 검색-->
			<div class="nav__row__searchInput" id="detailedSearch">
				<form class="searchInput__form" id="detailedSearch__form" name="searchInput__form" action="/Library/book/history/myloan_history" method="post">
					<!-- 검색 조건 : 도서관/서명 -->
					<ul id="searchInput__form__conditionList">
						<li class="searchInput__form__condition">
							<select class="condition__select" name="condition__category">
								<option value="도서관">도서관</option>
								<option value="서명">서명</option>
							</select> 
							<input type="text" class="condition__input" name="condition__input">
						</li>
					</ul>
					<!-- 검색 조건 추가 -->
					<div class="searchInput__form__addConditionBtn">
						<input id="addConditionBtn" type="button" value="검색 조건 추가" onclick="add_conditionBox()">
					</div>
					
					
					<!-- 검색 조건 : 대출일/반납일 -->
					<div class="searchInput__form__historyDateCondition">
						<!-- 대출일/반납일 -->
						<select class="condition__select" name="loan_return_categorys">
								<option value="대출일">대출일</option>
								<option value="반납일">반납일</option>
						</select>
						<input class="historyDateCondition__input" type="text" name="start_date" placeholder="시작일(2021-06-21)">
						<span>-</span> 
						<input class="historyDateCondition__input" type="text" name="end_date" placeholder="종료일(2021-06-21)">
					</div>
					
					<!-- 상세 검색 버튼 -->
					<div class="searchInput__form__box">
						<input type="submit" title="검색" class="searchInput__form__submit" value="&#xf002;">
					</div>
				</form>
			</div>
		</div>
	</div>



	<form action="" method="post">
		<div class="main__listTable">
			<table>
				<thead>
					<tr>
						<th>No.</th>
						<th>서명/저자</th>
						<th>도서관명</th>
						<th>소장처/자료실</th>
						<th>등록번호</th>
						<th>대출일</th>
						<th>반납일</th>
						<th>최종연장횟수</th>
						<th>연체일수</th>
						<th>반납유형</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="re" items="${myReturn_list}" varStatus="status">
					<tr>
						<td>${status.index+1}</td>
						<!-- No. -->
						<td>${ re.book_name}/${re.author_name}</td>
						<!-- 서명/저자-->
						<td>${re.library_name}</td>
						<!-- 도서관명 -->
						<td>${re.ownlocation}</td>
						<!-- 소장처/자료실-->
						<td>${re.registered_number}</td>
						<!-- 등록번호 -->
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${re.loan_date}" /></td>
						<!-- 대출일 -->
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${re.return_date}" /></td>
						<!-- 반납예정일 -->
						<td>${re.final_extension_count}</td>
						<!-- 최종연장횟수 -->
						<td>${re.days_due}</td>
						<!-- 연체일수  -->
						<td>
							<c:if test="${re.days_due>=1}">
								연체반납
							</c:if>
							<c:if test="${re.days_due==0}">
								정상반납
							</c:if>
						</td>
						<!-- 반납유형 -->
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- 뒤로가기 버튼 -->
		<div class="detailBtn">
			<a href="/Library/index/index">뒤로가기</a>
		</div>
	</form>

	<script src="${pageContext.request.contextPath}/js/history.js"></script>
</body>
</html>