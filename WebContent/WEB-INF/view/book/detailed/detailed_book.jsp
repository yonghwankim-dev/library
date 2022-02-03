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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/reset.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/detail_book.css">
<title>Detail Book</title>
</head>
<body>
	
	<div class="container">
		<!-- profile section -->
		<div class="profile">
			<!-- 도서 서명-->
			<div class="profile__header">
				<h3>${book_info.book_name }</h3>
			</div>

			<div class="profile__content">
				<!-- 도서 정보 -->
				<div class="profile__content__info">
					<table class="profile__table">
						<tbody>
							<tr>
								<th scope="row">개인저자</th>
								<td>${book_info.author_name}</td>
							</tr>
							<tr>
								<th scope="row">서명</th>
								<td>${book_info.book_name}</td>
							</tr>
							<tr>
								<th scope="row">발행사항</th>
								<td>${book_info.publishing_house},<fmt:formatDate
										pattern="yyyy" value="${book_info.year_publication}" />.
								</td>
							</tr>
							<tr>
								<th scope="row">ISBN</th>
								<td>${book_info.ISBN }</td>
							</tr>
						</tbody>
					</table>
				</div>
				
				<!-- 도서 이미지 -->
				<div class="profile__content__bgContainer">
					<img src="../../images/java_programming.jpeg" alt="자바 프로그래밍 이미지">
				</div>
			</div>
		</div>

		<!-- 소장정보 -->
		<div class="ownership">
			<!-- 소장정보 제목 -->
			<div class="ownership__header">
				<h3>소장정보</h3>
			</div>
			<!-- 소장정보 내용 -->
			<div class="ownership__content">
				<div class="ownership__content__table">
					<table>
						<thead>
							<tr>
								<th>No.</th>
								<th>등록번호</th>
								<th>도서관명</th>
								<th>소장처</th>
								<th>도서상태</th>
								<th>반납예정일</th>
								<th>예약</th>
								<th>서비스</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="book_owner" items="${bookOwner_list}"
								varStatus="status">
								<tr>
									<td>${status.index+1}</td> <!-- 순번 -->
									<td>${book_owner.registered_number}</td> <!-- 등록번호 -->
									<td>${book_owner.library_name}</td> <!-- 도서관 -->
									<td>${book_owner.ownlocation}</td> <!-- 소장처 -->
									
									<td>
										<!-- 도서상태  : 대출가능 --> 
										<c:if test="${book_owner.loan_availability=='1'}">
											<span>대출가능</span>
										</c:if> 
										<!-- 도서상태 : 대출중  --> 
										<c:if test="${book_owner.loan_availability=='0'}">
											<span>대출중</span>
										</c:if>
									</td>
									<td>
										<!-- 반납예정일 --> 
										<c:if test="${book_owner.loan_availability=='0'}">
											<span>${book_owner.return_scheduled_date}</span>
										</c:if>
									</td>
									<td>
										<!-- 예약 -->
										<!-- 예약 서비스 조건 --> 
										<!-- 1. 대출중
											 2. 로그인 상태
											 3. 해당 도서를 대출한자가 아닌 회원
											 4. 에약 미신청한 회원
										-->
										<c:if test="${book_owner.loan_availability=='0' 
														and not empty member
														and book_owner.member_number ne member.member_number}">
											<!-- 대출중인 해당 도서를 예약한 회원번호들 중 현재 로그인한 유저가 들어있는지 검사 -->
											<c:set var="flag" value="0"></c:set>
											<c:forEach var="reservation_member_number" items="${book_owner.reservation_member_number_list}">
												<c:if test="${reservation_member_number eq member.member_number}">
													<c:set var="flag" value="1"></c:set>
												</c:if>
											</c:forEach>
											<c:if test="${flag=='0'}">
												<a href="/Library/book/reserve/request?registered_number=${book_owner.registered_number}">예약</a>
											</c:if>
										</c:if>
										<c:if test="${book_owner.loan_availability=='0' and book_owner.reservation_count!=0}">
											<span>${book_owner.reservation_count}명 예약중</span>
										</c:if>
									</td>
									<td>
										<!-- 서비스 -->
										 
										<!-- 대출/상호대차 서비스 조건 -->
										<!-- 1. 대출가능
										 	 2. 로그인 상태
										-->
										<c:if test="${book_owner.loan_availability=='1' and not empty member}">
											<a href="/Library/book/loan/loan?registered_number=${book_owner.registered_number}">대출</a>
											<a href="/Library/book/loan/loan?registered_number=${book_owner.registered_number}">상호대차</a>					
										</c:if> 
										
										<!-- 반납 서비스 조건 -->
										<!-- 1. 대출중 
											 2. 로그인 상태
											 3. 해당 도서를 대출한 사람과 로그인 한 사람이 일치해야함
										-->
										<c:if test="${book_owner.loan_availability=='0' 
													and not empty member 
													and book_owner.member_number eq member.member_number}">
											<a href="/Library/book/returnBook/returnBook?registered_number=${book_owner.registered_number}">반납</a>
										</c:if>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		<!-- 뒤로가기 버튼 -->
		<div class="detailBtn">
			<a href="/Library/index/index">뒤로가기</a>
		</div>
	</div>
</body>
</html>