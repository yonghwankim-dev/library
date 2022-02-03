<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="header">
	<!-- 로그인 및 회원가입 -->
	<div class="header_column">
		<ul>
			<!-- 비로그인 -->
			<c:if test="${empty member}">
				<li><a href="/Library/home/login" title="LOGIN">Login</a></li>
			</c:if>
			<!-- 로그인 -->
			<c:if test="${not empty member}">
				<!-- 로그아웃, 대출조회/연장, 대출기록 -->
				<li>Login : ${member.mem_name}</li>
				<li><a href="/Library/book/extension/extensionBook"
					title="대출현황">대출현황</a>
				<li><a href="/Library/book/history/myloan_history" title="대출기록">대출기록</a>
				<li><a href="/Library/book/reserve/myReserve" title="예약현황">예약현황</a></li>
				<li><a href="/Library/home/logout" title="LOGOUT">LOGOUT</a></li>
			</c:if>
			<!-- 회원가입 -->
			<li><a href="/Library/home/signUp" title="SignUp">SignUp</a></li>
		</ul>
	</div>
</div>