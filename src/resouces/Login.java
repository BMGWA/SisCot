package resouces;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProviderDAO;
import model.Provider;

/**
 * Servlet implementation class Login
 * @author tiago
 * @version 1.0
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Session utilized for stores the data of users
		HttpSession session = request.getSession();
		
		//Get the data of user and verify if is a stored user
		String username = request.getParameter("login");
	    String password = request.getParameter("senha");
	    session = loginChecks(username, password , session);
	    
	    String url = null;
	    
	    //Dispatcher a url as user
	    if(session != null){
	    	url = "/index.jsp";
	    	dispatcher(request, response, url);
	    }
	    else{
	    	url = "/error.jsp";
	    	dispatcher(request, response, url);
	    }
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @param session
	 * @return A session null if the user isn't registered. And returns a pair of attributs setted if the 
	 * login is correct
	 */
	HttpSession loginChecks(String username, String password, HttpSession session){
		
		//Get all user from listProviders
		ProviderDAO providerDAO = new ProviderDAO();
		ArrayList<Provider> listProviders = new ArrayList<Provider>();
		listProviders = providerDAO.listProviders();
		
		//Search a correct user and password
		for (Provider provider : listProviders) {
			boolean isUser = provider.getProviderEmail().equals(username);
			boolean correctPassword = provider.getProviderPassword().equals(password);
			
			if(isUser && correctPassword){
				session.setAttribute("user", username);
				session.setAttribute("userType", "provider");
			}
		}
		
		return session;
	}
	
	/**
	 * Make a dispatcher for all methods with a url
	 * @param request
	 * @param response
	 * @param url
	 * @throws ServletException
	 * @throws IOException
	 */
	public void dispatcher(HttpServletRequest request, HttpServletResponse response, String url) 
			throws ServletException, IOException{
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher(url);
	    rd.forward(request,response);
	}
	
}
