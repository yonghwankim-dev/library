
<div class="nav">
	<!-- 도서 검색 버튼 -->
	<div class="nav_row">
		<!-- 통합검색/상세검색 -->
		<ul class="srchTab">
			<li>
				<button id="srchTab" class="srchTab_item active">통합 검색</button>
			</li>
			<li>
				<button id="srchDtlTab" class="srchTab_item">상세 검색</button>
			</li>
		</ul>
	</div>

	<!-- 도서 통합검색 -->
	<div class="nav_row">
		<div class="container" id="srch">
			<form action="/Library/search" method="post">
				<input class="box inputBox" type="text" name="content" placeholder="통합검색"/>
				<input class="box submitBox" type="submit" value="검색"/>
			</form>
		</div>
	</div>

	<!-- 도서 상세 검색-->
	<div class="nav_row">
		<div class="container" id="detailSrh">
			<form action="/Library/detailSearch" method="post">
				<table>
					<tbody>
						<tr>
							<td>도서관</td>
							<td>
								<select name="lib_name">
									<option value="전체" selected>전체</option>
									<option value="충남대학교 도서관">충남대학교 도서관</option>
									<option value="목원대학교 도서관">목원대학교 도서관</option>
									<option value="우송대학교 도서관">우송대학교 도서관</option>
									<option value="한남대학교 도서관">한남대학교 도서관</option>
									<option value="배재대학교 도서관">배재대학교 도서관</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>도서이름</td>
							<td><input class="inputBox" type="text" name="book_name"/></td>
						</tr>
						<tr>
							<td>저자이름</td>
							<td><input class="inputBox" type="text" name="author_name"/></td>
						</tr>
						<tr>
							<td>출판사</td>
							<td><input class="inputBox" type="text" name="pub_com"/></td>
						</tr>
						<tr>
							<td>발행년도</td>
							<td>
								<input type="number" min="1900" max="2099" step="1" name="pub_year_start">
								<span>-</span>
								<input type="number" min="1900" max="2099" step="1" name="pub_year_end">
							</td>
						</tr>
					</tbody>
				</table>
				<input class="box submitBox" type="submit" value="검색"/>
			</form>
		</div>
	</div>
</div>