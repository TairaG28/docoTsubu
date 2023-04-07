package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Code1305_Mutter;

public class Code1306_MutterDAO {

		 // データベースのURLを指定
		 private final String DB_PATH =
				 "jdbc:mysql://localhost:3306/docotsubu";

		//送信するクエリの文字コード設定(データベースのアドレスに付け足される)
		private final String DB_CHARACTER_ENCODE =
		"?useUnicode=true&characterEncoding=utf8";

		// データベースのユーザー名
		private final String DB_USER = "root";

		// データベースのパスワード
		 private final String DB_PASS = "root";

		 // JDBCドライバ
		 private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

		public Code1306_MutterDAO() {
			try {

				Class.forName(JDBC_DRIVER);

			} catch (ClassNotFoundException e) {

				e.printStackTrace();

			}

		}


		//データベースのつぶやき取得
		 public List<Code1305_Mutter> findAll() {
		 List<Code1305_Mutter> mutterList = new ArrayList<Code1305_Mutter>();

		 try(Connection conn =
		 DriverManager.getConnection
		 (DB_PATH + DB_CHARACTER_ENCODE,DB_USER,DB_PASS)) {
		 // -- 以降はtryブロック終了まで変更なし --

			 //SELECT文の準備

			 String sql =
					 "SELECT ID,NAME,TEXT,TIMESTAMP,EMAIL FROM MUTTER ORDER BY ID DESC";
			 PreparedStatement pStmt = conn.prepareStatement(sql);

			 //SELECTを実行
			 ResultSet rs = pStmt.executeQuery();

			 //SELECT文の結果をArrayListに格納
			 while (rs.next()) {
				int id = rs.getInt("ID");
				String userName = rs.getString("NAME");
				String text = rs.getString("TEXT");
				String email = rs.getString("EMAIL");

				// DateTime型のカラムから日時データを取得
				Date datetime = rs.getTimestamp("TIMESTAMP");
				// 「yyyy年MM月dd日 hh時mm分ss秒」形式のフォーマットを定義
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒");
				// 定義したフォーマットでmutterクラスの引数に代入
				String timeStamp = sdf.format(datetime);

				Code1305_Mutter mutter = new Code1305_Mutter(id,userName,text,timeStamp,email);
				mutterList.add(mutter);
			}

		 } catch (SQLException e) {
		 // -- catch文も変更なし --
			 e.printStackTrace();
			 return null;

		 }
		 return mutterList;


		 }

		 public boolean create(Code1305_Mutter mutter) {

			 //データベースへの接続
			 try(Connection conn =
					 DriverManager.getConnection
					 (DB_PATH + DB_CHARACTER_ENCODE,DB_USER,DB_PASS)
			 ){
				 // -- 以降はtryブロック終了まで変更なし --

				 //INSERT文の準備（IDは自動連番なので指定しなくてよい）
				 String sql = "INSERT INTO MUTTER(NAME,TEXT,EMAIL) VALUES(?,?,?)";
				 PreparedStatement pStmt= conn.prepareStatement(sql);

				 //INSERT文中の「？」に使用する値を設定しSQLを完成
				 pStmt.setString(1,mutter.getUserName());
				 pStmt.setString(2,mutter.getText());
				 pStmt.setString(3,mutter.getEmail());

				 //INSERT文を実行（resultには追加された行数が代入される）
				 int result = pStmt.executeUpdate();
				 if(result !=1){
					 return false;
				 }

			 } catch (SQLException e) {
				 //-- catch文も変更なし --
				 e.printStackTrace();
				 return true;
			 }

			 return true;

		 }

		 public boolean remove(Code1305_Mutter delmutter){

			 /*int id ,String email*/

			 // データベースへ接続
			 try (
				Connection conn = DriverManager.getConnection(
						DB_PATH + DB_CHARACTER_ENCODE, DB_USER, DB_PASS
				)
			 ){
				 //SELECT文を準備
				 String sql ="SELECT ID, EMAIL FROM MUTTER";
				 PreparedStatement pStmt = conn.prepareStatement(sql);

				 //SELECT文を実行し、結果表（ResuletSet）を取得
				 ResultSet rs = pStmt.executeQuery();

				 //該当する従業員の情報をデータベースから削除する
				 //従業員を削除した場合はtrue、該当従業員がいない場合や
				 //エラーが発生した場合はfalseを戻り値として返す
				 while (rs.next()) {

					int delId = delmutter.getId();
					String delEmail = delmutter.getEmail();

					int cId = rs.getInt("ID");
					String cEmail = rs.getString("EMAIL");

					if( delId == cId && delEmail.equals(cEmail)  ){
						 String sql2 ="DELETE FROM MUTTER WHERE ID =? AND EMAIL =?";
						 PreparedStatement pStmt2 = conn.prepareStatement(sql2);
						 pStmt2.setInt(1, delId);
						 pStmt2.setString(2, delEmail);
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
