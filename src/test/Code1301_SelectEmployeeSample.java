package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Code1301_SelectEmployeeSample {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		// JDBCドライバーの接続
		 try {

			 Class.forName("com.mysql.jdbc.Driver");

		 } catch(ClassNotFoundException e) {

			 e.printStackTrace();

		 }

		 try (
				 Connection conn =
				 DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/docotsubu"+
						"?useUnicode=true&characterEncoding=utf8",
						"root",
						"root"
				)
		){
			//SELECT文を準備
			 String sql ="SELECT ID,NAME,AGE FROM EMPLOYEE";
			 PreparedStatement pStmt = conn.prepareStatement(sql);

			 //SELECT文を実行し、結果表（ResuletSet）を取得
			 ResultSet rs = pStmt.executeQuery();

			 //結果表に格納されたレコードの内容を表示
			 while (rs.next()) {

				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");

				//取得したデータを出力
				System.out.println("ID:"+id);
				System.out.println("名前:"+name);
				System.out.println("年齢:"+age);

			 }

		 }catch (SQLException e) {

		 e.printStackTrace();

		 }
	}
}
