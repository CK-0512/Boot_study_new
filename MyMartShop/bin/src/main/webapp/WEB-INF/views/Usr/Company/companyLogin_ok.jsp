<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${row==-1}">
	<script>
		alert("사명이 존재하지 않습니다");
		history.back();
	</script>
</c:if>
<c:if test="${row==0}">
	<script>
		alert("법인번호가 맞지 않습니다");
		history.back();
	</script>
</c:if>
<c:if test="${row==1}">
	<script>
		location.replace("/");
	</script>
</c:if>
