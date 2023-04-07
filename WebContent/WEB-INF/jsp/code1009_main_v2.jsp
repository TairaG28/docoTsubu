<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
<%@ page import = "model.Code1001_User,
					model.Code1002_Mutter,
					java.util.List" %>

<%

//セッションスコープに保存された情報を取得
Code1001_User loginUser = (Code1001_User) session.getAttribute("loginUser");

//アプリケーションスコープに保存されたつぶやきリストを取得
List<Code1002_Mutter> mutterList =
	(List<Code1002_Mutter>) application.getAttribute("mutterList");

//リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String) request.getAttribute("errorMsg");

%>

--%>

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

<div class = "baseMain">

<main class="mainMtr">

<h1>どこつぶメイン</h1>

<p>
<%-- <%= loginUser.getName() %>さん、ログイン中 --%>

<c:out value="${loginUser.name}"/>さん、ログイン中

<a href = "/docoTsubu/Code1010_Logout">ログアウト</a>
</p>

<p><a href = "/docoTsubu/Code1309_Main" ></a></p>
<form action = "/docoTsubu/Code1309_Main" method = "post">
<input type = "text" name = "text">
<input type = "submit" value = "つぶやく">
</form>


<%-- <% if(errorMsg != null){ %>
<p><%= errorMsg %></p>
<% } %>

<ul>

<% for(Code1002_Mutter mutter:mutterList){%>

<li><%= mutter.getUserName() %>:<%= mutter.getText() %></li>

<%}%>

</ul>
 --%>


<p>JSTL 使用版</p>
<c:if test="${not empty errorMsg}">
<p>${errorMsg}</p>
</c:if>


<c:forEach var = "mutter" items="${mutterList}">


<div class = "mtrBox">
 <p class="mtrLblName"> 【<c:out value="${mutter.userName}"/>】</p>

 <p class="mtrLblTxt"><c:out value="${mutter.text}"/></p>

  <p class="mtrLblTime"><c:out value="${mutter.timeStamp}"/></p>

</div>


</c:forEach>
</div>



</main>


</body>
</html>