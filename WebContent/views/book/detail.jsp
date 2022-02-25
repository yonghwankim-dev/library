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
	href="/Library/resources/css/reset/reset.css">
<link rel="stylesheet"
	href="/Library/resources/css/book/detail.css">
<title>도서 상세정보</title>
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
								<td>${book.author_name}</td>
							</tr>
							<tr>
								<th scope="row">서명</th>
								<td>${book.book_name}</td>
							</tr>
							<tr>
								<th scope="row">발행사항</th>
								<td>${book.pub_com}, ${book.pub_year}.</td>
							</tr>
							<tr>
								<th scope="row">ISBN</th>
								<td>${book.isbn}</td>
							</tr>
						</tbody>
					</table>
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
								<th>도서상태</th>
								<th>반납예정일</th>
								<th>예약</th>
								<th>서비스</th>
							</tr>
						</thead>
						<tbody>
						<!-- 
							<c:forEach var="book_owner" items="${bookOwner_list}"
								varStatus="status">
								<tr>
									<td>${status.index+1}</td>
									<td>${book_owner.registered_number}</td>
									<td>${book_owner.library_name}</td>
									
									<td>
										 
										<c:if test="${book_owner.loan_availability=='1'}">
											<span>대출가능</span>
										</c:if> 
										
										<c:if test="${book_owner.loan_availability=='0'}">
											<span>대출중</span>
										</c:if>
									</td>
									<td>
										 
										<c:if test="${book_owner.loan_availability=='0'}">
											<span>${book_owner.return_scheduled_date}</span>
										</c:if>
									</td>
									<td>
										<c:if test="${book_owner.loan_availability=='0' 
														and not empty member
														and book_owner.member_number ne member.member_number}">
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
										<c:if test="${book_owner.loan_availability=='1' and not empty member}">
											<a href="/Library/book/loan/loan?registered_number=${book_owner.registered_number}">대출</a>
											<a href="/Library/book/loan/loan?registered_number=${book_owner.registered_number}">상호대차</a>					
										</c:if> 
										
										<c:if test="${book_owner.loan_availability=='0' 
													and not empty member 
													and book_owner.member_number eq member.member_number}">
											<a href="/Library/book/returnBook/returnBook?registered_number=${book_owner.registered_number}">반납</a>
										</c:if>
									</td>
								</tr>
							</c:forEach>
							 -->
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