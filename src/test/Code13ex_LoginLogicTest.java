package test;

import model.Code13ex_LoginEnt;
import model.Code13ex_LoginLogic;

public class Code13ex_LoginLogicTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		testExecute1(); //ログイン成功テスト
		testExecute2(); //ログイン失敗テスト

	}

	public static void testExecute1() {

		Code13ex_LoginEnt loginEnt = new Code13ex_LoginEnt("test@sukkiri.com", "1234");
		Code13ex_LoginLogic bo = new Code13ex_LoginLogic();
		boolean result = bo.execute(loginEnt);

		if(result){
			System.out.println("testExcute1:成功しました");
		}else{
			System.out.println("testExcute1:失敗しました");
		}
	}


	public static void testExecute2() {
		Code13ex_LoginEnt loginEnt = new Code13ex_LoginEnt("test@sukkiri.com", "12345");
		Code13ex_LoginLogic bo = new Code13ex_LoginLogic();
		boolean result = bo.execute(loginEnt);

		if(!result){
			System.out.println("testExcute2:成功しました");
		}else{
			System.out.println("testExcute2:失敗しました");
		}
	}

}
