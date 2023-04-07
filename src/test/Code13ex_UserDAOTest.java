package test;

import dao.Code13ex_UserDAO;
import model.Code13ex_LoginEnt;
import model.Code13ex_UserEnt;

public class Code13ex_UserDAOTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		testFindByLogin1(); //ユーザー見つかる
		testFindByLogin2(); //ユーザー見つからない

	}

	public static void testFindByLogin1() {
		Code13ex_LoginEnt loginEnt = new Code13ex_LoginEnt("test@sukkiri.com", "1234");
		Code13ex_UserDAO dao = new Code13ex_UserDAO();
		Code13ex_UserEnt result = dao.findByLogin(loginEnt);

		if(
				result != null &&

				result.getPass().equals("1234") &&
				result.getName().equals("テスト") &&
				result.getEmail().equals("test@sukkiri.com")

		){
			System.out.println("testFindByLogin1:成功しました");

		}else {
			System.out.println("testFindByLogin1:失敗しました");
		}

	}

	public static void testFindByLogin2() {
		Code13ex_LoginEnt loginEnt = new Code13ex_LoginEnt("test@sukkiri.com", "12345");
		Code13ex_UserDAO dao = new Code13ex_UserDAO();
		Code13ex_UserEnt result = dao.findByLogin(loginEnt);

		if(result == null){
			System.out.println("testFindByLogin2:成功しました");

		}else {
			System.out.println("testFindByLogin2:失敗しました");
		}

	}

}
