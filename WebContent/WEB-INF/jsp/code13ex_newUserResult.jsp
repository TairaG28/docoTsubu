<%@page import="model.Code13ex_LoginEnt"%>
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

<h1>新規ユーザー登録・結果</h1>

<c:choose>
  <c:when test="${not empty resultMsg}">
    <%-- 条件に当てはまる場合 --%>

	<p>${resultMsg}</p>
    <a href = "/docoTsubu/">TOPへ</a>

  </c:when>
  <c:otherwise>
    <%-- 上記すべての条件に当てはまらない場合 --%>
    <p>${errorMsg}</p>
    <p>登録済みのメールアドレスの可能性があります。</p>
    <a href="/docoTsubu/Code13ex_NewUser">登録画面へ</a>

  </c:otherwise>
</c:choose>


</main>

</div>

</body>
</html>