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
				<form action="/Library/book/service" method="post">
				<input type="text" name="book_name" value="${book.book_name}" hidden>
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
								<th>대출</th>
								<th>반납</th>
							</tr>
						</thead>
						<tbody> 
							<c:forEach var="book" items="${bookOwnInfos}"
								varStatus="status">
								<tr id="${status.index+1}">
									<td>${status.index+1}</td>
									<td>${book.book_regi_num}</td>
									<td>${book.lib_name}</td>
									<td>${book.loan_yn}</td>
									<td>${book.book_rtn_expt_date}</td>
									<td>
										<!-- 예약 -->
									</td>
									<td>
										<!-- 대출 -->
										<c:if test="${book.loan_yn eq '대출가능'}">
											<input type="checkbox" name="loan" value="${book.book_regi_num} ${book.lib_name}"/>
										</c:if>
									</td>
									<td>
										<!-- 반납 -->
										<c:if test="${book.loan_yn eq '대출중'}">
											<input type="checkbox" name="rtn" value="${book.book_regi_num} ${book.lib_name} ${book.book_rtn_expt_date}"/>	
										</c:if>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
				<div class="detailBtn">
					<c:if test="${not empty member}">
						<input type="submit" name="service" value="대출">
						<input type="submit" name="service" value="반납">
					</c:if>
					<a href="/Library/home">뒤로가기</a>
				</div>
				</form>
			</div>	
		</div>		
	</div>
</body>
</html>