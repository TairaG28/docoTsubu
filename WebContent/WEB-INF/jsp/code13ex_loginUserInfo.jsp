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

<h1>ユーザー・登録情報</h1>

<p>名前：<c:out value="${loginUser.name}"/></p>
<p>メールアドレス：<c:out value="${loginUser.email}"/></p>
<p>パスワード：<c:out value="${loginUser.pass}"/></p>

<a href="/docoTsubu/Code1309_Main">つぶやき投稿・閲覧へ</a>

</main>

</div>
</body>
</html>