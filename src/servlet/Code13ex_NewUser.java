package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Code13ex_LoginEnt;
import model.Code13ex_NewUserLogic;

/**
 * Servlet implementation class Code13ex_NewUser
 */
@WebServlet("/Code13ex_NewUser")
public class Code13ex_NewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Code13ex_NewUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		//ログイン結果画面にフォワード

		RequestDispatcher dispatcher =
				request.getRequestDispatcher(
						"/WEB-INF/jsp/code13ex_newUser.jsp");
		dispatcher.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("newName");
		String email = request.getParameter("newEmail");
		String pass = request.getParameter("newPass");


		//Userインスタンス（ユーザー情報）の生成
		Code13ex_LoginEnt loginEnt = new Code13ex_LoginEnt(name,email,pass);

		//登録処理
		Code13ex_NewUserLogic newUserLogic = new Code13ex_NewUserLogic();
		boolean isCreate = newUserLogic.execute(loginEnt);

		//登録成功時の処理
		if(isCreate){
			request.setAttribute("resultMsg", "登録完了しました。トップからログインしてください。");

		}else{
			request.setAttribute("errorMsg", "登録が失敗しました。最初からやり直してください。");
			//System.out.print("登録失敗してるよー");
		}

		RequestDispatcher dispatcher =
				request.getRequestDispatcher(
						"/WEB-INF/jsp/code13ex_newUserResult.jsp");
		dispatcher.forward(request, response);


	}

}
