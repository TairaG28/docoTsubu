<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "model.Code1001_User" %>

<%
Code1001_User loginUser = (Code1001_User) session.getAttribute("loginUser");
%>


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

<h1>どこつぶログイン</h1>

<% if(loginUser != null){ %>

<p>ログインに成功しました</p>
<p>ようこそ！　<%= loginUser.getName() %>さん </p>
<a href="/docoTsubu/Code1309_Main">つぶやき投稿・閲覧へ</a>

<% }else{ %>

<p>ログインに失敗しました</p>
<a href = "/docoTsubu/">TOPへ</a>

<% } %>

</main>

</div>

</body>
</html>