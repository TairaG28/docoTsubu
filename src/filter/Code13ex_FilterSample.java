package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class Code1104_FilterSample
 */
@WebFilter(urlPatterns={"/Code1309_Main","/Code13ex_NewUser"})
public class Code13ex_FilterSample implements Filter {

    /**
     * Default constructor.
     */
    public Code13ex_FilterSample() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain

	/*	HttpSession session = request.getSession();
		Code1001_User loginUser =
				(Code1001_User) session.getAttribute("loginUser");

		if(loginUser == null){//ログインしていない場合


		}else{//ログイン済みの場合


		}*/

		System.out.print("フィルタ－です");

	/*	request.setCharacterEncoding("UTF-8");*/
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
