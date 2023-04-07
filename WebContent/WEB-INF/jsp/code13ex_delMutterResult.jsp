<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Yusei+Magic&display=swap" rel="stylesheet">

<link rel='stylesheet' type='text/CSS' href='code1000_extr.css'>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>どこつぶ</title>
</head>
<body>

<div class = "base">

<main class="main">

<h1>つぶやき削除・結果</h1>

<c:choose>
  <c:when test="${not empty resultMsg}">
    <%-- 条件に当てはまる場合 --%>
    <p>${resultMsg}</p>

  </c:when>
  <c:otherwise>
    <%-- 上記すべての条件に当てはまらない場合 --%>
    <p>${errorMsg}</p>
    <p>不具合の可能性がありますので、運営までご報告お願い致します。</p>

  </c:otherwise>
</c:choose>

    <a href="/docoTsubu/Code1309_Main">つぶやき投稿・閲覧へ</a>

</main>

</div>
</body>
</html>