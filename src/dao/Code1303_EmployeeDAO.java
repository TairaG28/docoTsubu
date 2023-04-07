package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Code1302_Employee;

public class Code1303_EmployeeDAO {


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

		 public Code1303_EmployeeDAO() {

			 try{

			 Class.forName(JDBC_DRIVER);

			 }catch(ClassNotFoundException e){

			 e.printStackTrace();

			 }

		 }

		 public List<Code1302_Employee> findAll() {

			 List<Code1302_Employee > empList = new ArrayList<Code1302_Employee >();

		 // データベースへ接続
		 try (
			Connection conn = DriverManager.getConnection(
					DB_PATH + DB_CHARACTER_ENCODE, DB_USER, DB_PASS
			)
		 ){
		 // -- 以降は変更なし --

			 //SELECT文を準備
			 String sql ="SELECT ID,NAME,AGE FROM EMPLOYEE";
			 PreparedStatement pStmt = conn.prepareStatement(sql);

			 //SELECT文を実行し、結果表（ResuletSet）を取得
			 ResultSet rs = pStmt.executeQuery();

			 //結果表に格納されたレコードの内容を
			//Code1302_Employeeインスタンスに設定し、ArrayListインスタンスに追加
			 while (rs.next()) {

				//レコードの値を取得する
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");

				//取得した値をEmployeeインスタンスに格納する
				Code1302_Employee employee =
						new Code1302_Employee(id, name, age);

				//ArrayListインスタンスにEmployeeインスタンスを追加する
				empList.add(employee);

			 }

		 } catch (SQLException e) {

		 e.printStackTrace();
		 return null;

		 }

		 return empList;
		 }


		 //練習問題13-02のremoveメソッド
		 //呼び出される際に、従業員IDとして文字列を１つ受け取る
		 public boolean remove(String removeID){

			 // データベースへ接続
			 try (
				Connection conn = DriverManager.getConnection(
						DB_PATH + DB_CHARACTER_ENCODE, DB_USER, DB_PASS
				)
			 ){
				 //SELECT文を準備
				 String sql ="SELECT ID FROM EMPLOYEE";
				 PreparedStatement pStmt = conn.prepareStatement(sql);

				 //SELECT文を実行し、結果表（ResuletSet）を取得
				 ResultSet rs = pStmt.executeQuery();

				 //該当する従業員の情報をデータベースから削除する
				 //従業員を削除した場合はtrue、該当従業員がいない場合や
				 //エラーが発生した場合はfalseを戻り値として返す
				 while (rs.next()) {
					String cString = rs.getString("ID");

					if(removeID.equals(cString)  ){
						 String sql2 ="DELETE FROM EMPLOYEE WHERE ID ='"+removeID+"'";
						 PreparedStatement pStmt2 = conn.prepareStatement(sql2);
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


}
