<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="게시판" />
<%@ include file="../../common/head.jsp"%>
<body>

	<section class="mt-24">
		<div class="container mx-auto">
			<div class="mb-2 flex justify-between">
				<div>
					<span>글 개수 : ${articlesCnt }</span>
					<div class="py-1">
						<a href="/Usr/Article/articleList?type=notice">공지사항</a> <span>|||</span>
						<a href="/Usr/Article/articleList?type=review">리뷰</a> <span>|||</span>
						<a href="/Usr/Article/articleList?type=inquiry">문의</a>
					</div>
				</div>
				<div>
					<form>
						<input type="hidden" name="type" value="${type}" /> 
						<select data-value="${searchKeywordType }"
							class="select select-accent select-sm w-28" name="searchKeywordType">
							<option value="title">제목</option>
							<option value="body">내용</option>
							<option value="title,body">제목 + 내용</option>
						</select> 
						<input class="ml-2 input input-bordered input-accent input-sm w-64"
							type="text" name="searchKeyword" placeholder="검색어를 입력해주세요"
							maxlength="20" value="${searchKeyword }" />
						<button class="ml-2 btn btn-accent btn-sm">검색</button>
					</form>
				</div>
			</div>
			<div class="table-box-type-1">
				<table class="table">
					<thead>
						<tr>
							<th>번호</th>
							<th>작성일</th>
							<th>제목</th>
							<th>작성자</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="article" items="${articles }">
							<tr class="hover">
								<td>${article.a_id }</td>
								<td>${article.regDate.substring(2, 16) }</td>
								<td><a class="hover:underline" href="view?id=${article.a_id }">
									${article.title }</a></td>
								<td>${article.writerName }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<c:if test="">
				<div class="mt-2 flex justify-end">
					<a class="btn btn-accent btn-sm" href="write">게시글 작성</a>
				</div>
			</c:if>
		</div>
	</section>

	<%@ include file="../../common/foot.jsp"%>