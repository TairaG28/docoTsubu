package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Code1001_User;
import model.Code1002_Mutter;
import model.Code1013_PostMutterLogic;

/**
 * Servlet implementation class Code1008_Main
 */
@WebServlet("/Code1008_Main")
public class Code1008_Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Code1008_Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		//つぶやきリストをアプリケーションスコープから取得
		ServletContext application = this.getServletContext();
		List<Code1002_Mutter> mutterList =
				(List<Code1002_Mutter>) application.getAttribute("mutterList");

		//取得できなった場合はつぶやきリストを新規作成して
		//アプリケーションスコープに保存

		if(mutterList == null){
			mutterList = new ArrayList<>();
			application.setAttribute("mutterList", mutterList);
		}

		//ログインしているかを確認するため
		//セッションスコープからユーザー情報を取得

		HttpSession session = request.getSession();
		Code1001_User loginUser =
				(Code1001_User) session.getAttribute("loginUser");

		if(loginUser == null){//ログインしていない場合

		//リダイレクト
			response.sendRedirect("/docoTsubu/");

		}else{//ログイン済みの場合

		//フォワード
			RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/code1009_main.jsp");
			dispatcher.forward(request, response);
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");


		//入力値チェック
		if(text != null && text.length() !=0){

			//アプリケーションスコープに保存されたつぶやきリストを取得

			ServletContext application = this.getServletContext();
			List<Code1002_Mutter> mutterList =
				(List<Code1002_Mutter>) application.getAttribute("mutterList");

		//セッションスコープに保存されたユーザー情報を取得
			HttpSession session = request.getSession();
			Code1001_User loginUser =
				(Code1001_User) session.getAttribute("loginUser");

		//つぶやきをつぶやきリストに追加
			Code1002_Mutter mutter = new Code1002_Mutter(loginUser.getName(),text);

			Code1013_PostMutterLogic postMutterLogic = new Code1013_PostMutterLogic();
			postMutterLogic.execute(mutter, mutterList);

		//アプリケーションスコープにつぶやきリストを保存
			application.setAttribute("mutterList",mutterList);
		} else{
			//エラーメッセージをリクエストスコープに保存

			request.setAttribute("errorMsg", "つぶやきが入力されていません");

		}

		//メイン画面にフォワード
			RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/code1009_main.jsp");
				dispatcher.forward(request, response);



	}

}
