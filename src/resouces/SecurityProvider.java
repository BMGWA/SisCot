package resouces;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SecurityProvider
 * @author tiago
 * @version 1.0
 */
@WebFilter(displayName = "SecurityProvider", 
urlPatterns = {"/error.jsp", "/ConsultProductList.jsp", "/ConsultProduct"}, 
servletNames = {"/ConsultProduct"})
public class SecurityProvider implements Filter {

    /**
     * Default constructor. 
     */
    public SecurityProvider() {
       
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//Get the request
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		//Verify if the current user have a session setted
		if(session.getAttribute("usuarioLogado") != null) {
			chain.doFilter(request, response);
		}
		else{
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("/login.jsp");
	        rd.forward(request,response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
