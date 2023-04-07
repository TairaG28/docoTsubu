package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Code13ex_LoginEnt;
import model.Code13ex_UserEnt;

public class Code13ex_UserDAO {


	 // データベースのURLを指定
	 private final String DB_PATH =
			 "jdbc:mysql://localhost:3306/docotsubu";

	 // 送信するクエリの文字コード設定(データベースのアドレスに付け足される)
	 private final String DB_CHARACTER_ENCODE =
	 "?useUnicode=true&characterEncoding=utf8";

	 // データベースのユーザー名
	 private final String DB_USER = "root";

	 // データベースのパスワード
	 private final String DB_PASS = "root";

	 // JDBCドライバ
	 private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	 public Code13ex_UserDAO() {

		 try{

		 Class.forName(JDBC_DRIVER);

		 }catch(ClassNotFoundException e){

		 e.printStackTrace();

		 }

	 }

	 public List<Code13ex_UserEnt> findAll() {

		 List<Code13ex_UserEnt > usersList = new ArrayList<Code13ex_UserEnt >();

	 // データベースへ接続
	 try (
		Connection conn = DriverManager.getConnection(
				DB_PATH + DB_CHARACTER_ENCODE, DB_USER, DB_PASS
		)
	 ){
	 // -- 以降は変更なし --

		 //SELECT文を準備
		 String sql ="SELECT NAME,PASS,EMAIL FROM USERS";
		 PreparedStatement pStmt = conn.prepareStatement(sql);

		 //SELECT文を実行し、結果表（ResuletSet）を取得
		 ResultSet rs = pStmt.executeQuery();

		 //結果表に格納されたレコードの内容を
		//Code1302_Employeeインスタンスに設定し、ArrayListインスタンスに追加
		 while (rs.next()) {

			//レコードの値を取得する
			String name = rs.getString("NAME");
			String pass = rs.getString("PASS");
			String email = rs.getString("EMAIL");

			//取得した値をEmployeeインスタンスに格納する
			Code13ex_UserEnt user =
					new Code13ex_UserEnt(name,pass,email);

			//ArrayListインスタンスにEmployeeインスタンスを追加する
			usersList.add(user);

		 }

	 } catch (SQLException e) {

	 e.printStackTrace();
	 return null;

	 }

	 return usersList;
	 }

	 public Code13ex_UserEnt findByLogin(Code13ex_LoginEnt loginEnt) {

		 Code13ex_UserEnt userEnt = null;

		 try (
					Connection conn = DriverManager.getConnection(
							DB_PATH + DB_CHARACTER_ENCODE, DB_USER, DB_PASS
					)
				 ){
				 // -- 以降は変更なし --

					 //SELECT文を準備
					 String sql =
							"SELECT NAME, PASS, EMAIL FROM USERS WHERE EMAIL =? AND PASS = ?";

					 PreparedStatement pStmt = conn.prepareStatement(sql);
					 //SELECT文の？の箇所に以下を代入
					 pStmt.setString(1, loginEnt.getEmail());
					 pStmt.setString(2, loginEnt.getPass());

					 //SELECT文を実行し、結果表（ResuletSet）を取得
					 ResultSet rs = pStmt.executeQuery();

					 //一致したユーザーが存在した場合
					 //そのユーザーを表すCode1402_Accountインスタンスを生成
					 while (rs.next()) {
						 //結果表からデータを取得

						 String name = rs.getString("NAME");
						 String pass = rs.getString("PASS");
						 String email = rs.getString("EMAIL");
						 loginEnt.setName(name);
						 userEnt = new Code13ex_UserEnt(name, pass, email);
					 }

				 } catch (SQLException e) {

				 e.printStackTrace();
				 return null;

				 }
		 	//見つかったユーザーまたはnullを返す。
		 	return userEnt;

	 }

	//練習問題13-02のremoveメソッド
		 //呼び出される際に、従業員IDとして文字列を１つ受け取る
	 public boolean remove(Code13ex_LoginEnt loginEnt){



		 // データベースへ接続
		 try (
			Connection conn = DriverManager.getConnection(
					DB_PATH + DB_CHARACTER_ENCODE, DB_USER, DB_PASS
			)
		 ){
			 //SELECT文を準備
			 String sql ="SELECT PASS, EMAIL FROM USERS";
			 PreparedStatement pStmt = conn.prepareStatement(sql);

			 //SELECT文を実行し、結果表（ResuletSet）を取得
			 ResultSet rs = pStmt.executeQuery();

			 //該当する従業員の情報をデータベースから削除する
			 //従業員を削除した場合はtrue、該当従業員がいない場合や
			 //エラーが発生した場合はfalseを戻り値として返す
			 while (rs.next()) {
				 String delEmail = loginEnt.getEmail();
				 String delPass = loginEnt.getPass();

				String cEmail = rs.getString("EMAIL");
				String cPass = rs.getString("PASS");

				if( delEmail.equals(cEmail) && delPass.equals(cPass) ){
					 String sql2 ="DELETE FROM USERS WHERE EMAIL =? AND PASS = ?";
					 PreparedStatement pStmt2 = conn.prepareStatement(sql2);
					 pStmt2.setString(1,delEmail);
					 pStmt2.setString(2,delPass);
					 pStmt2.executeUpdate();

					 return true;
				}

			 }

			 return false;


		 } catch (SQLException e) {

			 e.printStackTrace();
			 return false;

		 }

	 }


	 public boolean create(Code13ex_LoginEnt loginEnt) {

		 //データベースへの接続
		 try(Connection conn =
				 DriverManager.getConnection
				 (DB_PATH + DB_CHARACTER_ENCODE,DB_USER,DB_PASS)
		 ){
			 // -- 以降はtryブロック終了まで変更なし --

			 //INSERT文の準備（IDは自動連番なので指定しなくてよい）
			 String sql = "INSERT INTO USERS(NAME,PASS,EMAIL) VALUES(?,?,?)";
			 PreparedStatement pStmt= conn.prepareStatement(sql);

			 //INSERT文中の「？」に使用する値を設定しSQLを完成
			 pStmt.setString(1,loginEnt.getName());
			 pStmt.setString(2,loginEnt.getPass());
			 pStmt.setString(3,loginEnt.getEmail());

			 //INSERT文を実行（resultには追加された行数が代入される）
			 int result = pStmt.executeUpdate();

			 if(result !=1){
				 return false;
			 }

		 } catch (SQLException e) {
			 //-- catch文も変更なし --
			 e.printStackTrace();
			 return false;
		 }

		 return true;

	 }













}
