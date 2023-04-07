package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Code1001_User;
import model.Code1004_LoginLogic;

/**
 * Servlet implementation class Code1005_Login
 */
@WebServlet("/Code1005_Login")
public class Code1005_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Code1005_Login() {
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
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");


		//Userインスタンス（ユーザー情報）の生成
		Code1001_User user = new Code1001_User(name,pass);

		//ログイン処理
		Code1004_LoginLogic loginLogic = new Code1004_LoginLogic();
		boolean isLogin = loginLogic.execute(user);

		//ログイン成功時の処理
		if(isLogin){
			//ユーザー情報をセッションスコープに保存

			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);

		}

		//ログイン結果画面にフォワード

		RequestDispatcher dispatcher =
				request.getRequestDispatcher(
						"/WEB-INF/jsp/code1007_loginResult.jsp");
		dispatcher.forward(request, response);

	}

}
