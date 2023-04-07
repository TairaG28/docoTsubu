package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Code1305_Mutter;
import model.Code1307_PostMutterLogic;
import model.Code1308_GetMutterListLogic;
import model.Code13ex_LoginEnt;

/**
 * Servlet implementation class Code1008_Main
 */
@WebServlet("/Code1309_Main")
public class Code1309_Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Code1309_Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		//つぶやきリストを取得して、リクエストスコープに保存

		Code1308_GetMutterListLogic getMutterListLogic =
				new Code1308_GetMutterListLogic();
		List<Code1305_Mutter> mutterList = getMutterListLogic.execute();
		request.setAttribute("mutterList", mutterList);

		//ログインしているかを確認するため
		//セッションスコープからユーザー情報を取得

		HttpSession session = request.getSession();
		Code13ex_LoginEnt loginUser =
				(Code13ex_LoginEnt) session.getAttribute("loginUser");

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
		if(text != null && text.length() !=0 && text.length()<=100){

		//セッションスコープに保存されたユーザー情報を取得
			HttpSession session = request.getSession();
			Code13ex_LoginEnt loginUser =
				(Code13ex_LoginEnt) session.getAttribute("loginUser");

		//つぶやきをつぶやきリストに追加

			Code1305_Mutter mutter = new Code1305_Mutter(loginUser.getName(),text,loginUser.getEmail());
			Code1307_PostMutterLogic postMutterLogic = new Code1307_PostMutterLogic();
			postMutterLogic.execute(mutter);

		} else{
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "つぶやきが未入力。または文字数多すぎ");

		}
		//つぶやきリストを取得して、リクエストスコープに保存
		Code1308_GetMutterListLogic getMutterListLogic =
				new Code1308_GetMutterListLogic();
		List<Code1305_Mutter> mutterList = getMutterListLogic.execute();
		request.setAttribute("mutterList", mutterList);

		//メイン画面にフォワード
			RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/code1009_main.jsp");
				dispatcher.forward(request, response);



	}

}
