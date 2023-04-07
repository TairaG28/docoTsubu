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

<main  class="mainDelMtr">

<h1>つぶやき削除</h1>

 <p>一度、削除すると二度と同じつぶやきは表示されません。<br>
 以下のつぶやきを削除しますか？</p>

<div class = "mtrBox">
 <p class="mtrLblName"> 【<c:out value="${delMutterUserName}"/>】</p>

 <p class="mtrLblTxt" style="white-space:pre-wrap;"><c:out value="${delMutterText}"/></p>

  <p class="mtrLblTime"><c:out value="${delMutterTime}"/></p>

</div>

<form action = "/docoTsubu/Code13ex_DelMutter" method = "post">

<input type = "hidden" name = "delMutterInfo" value="false">
<input type = "hidden" name = "delMutterId" value="${delMutterId}">
<input type = "hidden" name = "delMutterUserName" value="${delMutterUserName}">
<input type = "hidden" name = "delMutterText" value="${delMutterText}">
<input type = "hidden" name = "delMutterTime" value="${delMutterTime}">
<input type = "hidden" name = "delMutterEmail" value="${delMutterEmail}">

<div class="delMutterBttn" align="right" >
<input  type = "submit" value="つぶやきを削除">
</div>

</form>


 <a href="/docoTsubu/Code1309_Main">つぶやき投稿・閲覧へ</a>


</main>


</div>

</body>
</html>