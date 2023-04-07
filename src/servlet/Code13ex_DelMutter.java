package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Code1305_Mutter;
import model.Code13ex_DelMutterLogic;

/**
 * Servlet implementation class Code13ex_DelMutter
 */
@WebServlet("/Code13ex_DelMutter")
public class Code13ex_DelMutter extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Code13ex_DelMutter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String info = request.getParameter("delMutterInfo");
		int id = Integer.parseInt(request.getParameter("delMutterId"));
		String userName = request.getParameter("delMutterUserName");
		String text = request.getParameter("delMutterText");
		String email = request.getParameter("delMutterEmail");
		String timeStamp = request.getParameter("delMutterTime");

		if(info.equals("true")){

			request.setAttribute("delMutterId", id);
			request.setAttribute("delMutterUserName", userName);
			request.setAttribute("delMutterText", text);
			request.setAttribute("delMutterEmail", email);
			request.setAttribute("delMutterTime", timeStamp);

			RequestDispatcher dispatcher =
					request.getRequestDispatcher(
							"/WEB-INF/jsp/code13ex_delMutter.jsp");
			dispatcher.forward(request, response);

		}else if(info.equals("false")){

			System.out.print(id+","+ userName+","+ text+","+ timeStamp+","+ email);
			//Mutterインスタンスの生成
			Code1305_Mutter delmutter = new Code1305_Mutter(
					id, userName, text, timeStamp, email);

			//退会処理
			Code13ex_DelMutterLogic delMutterLogic = new Code13ex_DelMutterLogic();
			boolean isRemove = delMutterLogic.execute(delmutter);

			//退会成功時の処理
			if(isRemove){
				request.setAttribute("resultMsg", "つぶやきを削除しました。");

			}else{
				request.setAttribute("errorMsg", "つぶやきを削除できませんでした。");

			}

			RequestDispatcher dispatcher =
					request.getRequestDispatcher(
							"/WEB-INF/jsp/code13ex_delMutterResult.jsp");
			dispatcher.forward(request, response);


		}



	}

}
