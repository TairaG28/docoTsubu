package test;

import dao.Code1306_MutterDAO;
import model.Code1305_Mutter;

public class Code13ex_DelMutterTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		testExecute2(); //ログイン失敗テスト
		testExecute1(); //ログイン成功テスト

	}

	public static void testExecute1() {

		/*Code1305_Mutter(int id, String userName, String text,String timeStamp,String email){*/

		Code1305_Mutter delMutter =
				new Code1305_Mutter(17,"テスト","test","2022-12-19 18:48:34","test@sukkiri.com");

		Code1306_MutterDAO dao = new Code1306_MutterDAO();
		boolean result = dao.remove(delMutter);

		if(result){
			System.out.println("testExcute1:成功しました");
		}else{
			System.out.println("testExcute1:失敗しました");
		}

	}


	public static void testExecute2() {

		Code1305_Mutter delMutter =
				new Code1305_Mutter(17,"テスト","test","2022-12-19 18:48:34","test@sukkiri.commmmm");

		Code1306_MutterDAO dao = new Code1306_MutterDAO();
		boolean result = dao.remove(delMutter);


		if(!result){
			System.out.println("testExcute2:成功しました");
		}else{
			System.out.println("testExcute2:失敗しました");
		}
	}

}
