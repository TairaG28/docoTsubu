<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<h1>新規ユーザー登録</h1>

<form action = "/docoTsubu/Code13ex_NewUser" method = "post" >

 <p><label class = "loginLbl">ユーザー名：</label>
 <input type = "text" name = "newName" placeholder="どこつぶ太郎" required="required"></p>

 <p><label class = "loginLbl">メールアドレス：</label>
 <input  type="email"  name = "newEmail" placeholder="info@example.com" required="required"></p>

 <p><label class = "loginLbl">パスワード：</label>
 <input type = "password" name = "newPass" required="required"></p>

<input type = "submit" value="登録">
</form>

<br>

 <a href = "/docoTsubu/">TOPへ</a>

</main>


</div>
</body>
</html>