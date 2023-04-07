package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Code13ex_LoginEnt;
import model.Code13ex_LoginLogic;

/**
 * Servlet implementation class Code1005_Login
 */
@WebServlet("/Code13ex_LoginSv")
public class Code13ex_LoginSv extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Code13ex_LoginSv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);


		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");


		//Userインスタンス（ユーザー情報）の生成
		Code13ex_LoginEnt loginEnt = new Code13ex_LoginEnt(email,pass);

		//ログイン処理
		Code13ex_LoginLogic loginLogic = new Code13ex_LoginLogic();
		boolean isLogin = loginLogic.execute(loginEnt);

		//ログイン成功時の処理
		if(isLogin){
			//ユーザー情報をセッションスコープに保存

			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginEnt);

		}

		//ログイン結果画面にフォワード

		RequestDispatcher dispatcher =
				request.getRequestDispatcher(
						"/WEB-INF/jsp/code1007_loginResult.jsp");
		dispatcher.forward(request, response);

	}


}
