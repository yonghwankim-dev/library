<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="main">
	<!-- 도서관 소장 도서 필터링 -->
	<div class="main_row">
		<!-- 도서관 필터 목록 -->
		<form action="/Library/home" method="get">
			<select class="main_row_filterLibrary" id="libraryFilter"
				name="library" onchange="this.form.submit()">
				<option value="전체">전체</option>
				<option value="충남대학교 도서관">충남대학교 도서관</option>
				<option value="목원대학교 도서관">목원대학교 도서관</option>
				<option value="우송대학교 도서관">우송대학교 도서관</option>
				<option value="한남대학교 도서관">한남대학교 도서관</option>
				<option value="배재대학교 도서관">배재대학교 도서관</option>
			</select>
		</form>
	</div>
	<div class="main_row">
		<!-- 도서정보 -->
		<table>
			<thead>
				<tr>
					<th>No.</th>
					<th>도서이름</th>
					<th>저자이름</th>
					<th>출판사</th>
					<th>발행년도</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}" varStatus="status">
					<tr>
						<td>${status.index+1}</td>
						<td>
							<a href="/Library/book/detail?book_name=${book.book_name}" class="book">
								${book.book_name}
							</a>
						</td>
						<td>${book.authors}</td>
						<td>${book.pub_com}</td>
						<td>${book.pub_year}</td>
					</tr>
				</c:forEach>

			</tbody>

		</table>
	</div>
</div>
<script type="text/javascript">
	function replace(url){
		url = url.replace(/&/g,"%26");
		url = url.replace(/\+/g,"%2B");
		return url;
	}
	const books = document.querySelectorAll(".book");
	
	books.forEach((item)=>{
		item.href = replace(item.href);
	});
	console.log(books);
	
	
	var library = '${param.library}';
</script>