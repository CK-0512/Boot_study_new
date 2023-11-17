<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${row==1}">
	<script>
		alert("삭제되었습니다");
		location.replace("/Adm/Member/memberList");
	</script>
</c:if>
<c:if test="${row==0}">
	<script>
		alert("삭제를 실패하였습니다");
		history.back();
	</script>
</c:if> 
