package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Code13ex_DelUserLogic;
import model.Code13ex_LoginEnt;

/**
 * Servlet implementation class Code13ex_DelUser
 */
@WebServlet("/Code13ex_DelUser")
public class Code13ex_DelUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Code13ex_DelUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(
						"/WEB-INF/jsp/code13ex_delUser.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("delEmail");
		String pass = request.getParameter("delPass");


		//Userインスタンス（ユーザー情報）の生成
		Code13ex_LoginEnt loginEnt = new Code13ex_LoginEnt(email,pass);

		//退会処理
		Code13ex_DelUserLogic delUserLogic = new Code13ex_DelUserLogic();
		boolean isRemove = delUserLogic.execute(loginEnt);

		//退会成功時の処理
		if(isRemove){
			//セッションスコープを破棄
			HttpSession session = request.getSession();
			session.invalidate();

			request.setAttribute("resultMsg", "退会が完了しました。ご利用ありがとうございました。");

		}else{
			request.setAttribute("errorMsg", "退会が失敗しました。最初からやり直してください。");
			System.out.print("失敗してるよー");
		}

		RequestDispatcher dispatcher =
				request.getRequestDispatcher(
						"/WEB-INF/jsp/code13ex_delUserResult.jsp");
		dispatcher.forward(request, response);

	}

}
