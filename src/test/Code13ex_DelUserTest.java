package test;

import model.Code13ex_DelUserLogic;
import model.Code13ex_LoginEnt;

public class Code13ex_DelUserTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		testExecute2(); //ログイン失敗テスト
		testExecute1(); //ログイン成功テスト


	}

	public static void testExecute1() {

		Code13ex_LoginEnt loginEnt = new Code13ex_LoginEnt("nana@test.com", "0000");
		Code13ex_DelUserLogic bo = new Code13ex_DelUserLogic();
		boolean result = bo.execute(loginEnt);

		if(result){
			System.out.println("testExcute1:成功しました");
		}else{
			System.out.println("testExcute1:失敗しました");
		}
	}


	public static void testExecute2() {

		Code13ex_LoginEnt loginEnt = new Code13ex_LoginEnt("nana@test.com", "0000000");
		Code13ex_DelUserLogic bo = new Code13ex_DelUserLogic();
		boolean result = bo.execute(loginEnt);


		if(!result){
			System.out.println("testExcute2:成功しました");
		}else{
			System.out.println("testExcute2:失敗しました");
		}
	}

}
