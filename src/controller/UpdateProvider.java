package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Provider;
import dao.ProviderDAO;

@WebServlet("/UpdateProvider")
public class UpdateProvider extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public UpdateProvider() {
		super();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String messageUpdateConfirmation = "Iniciada";
		boolean wasUpdated = sendToProviderDAO(request);
		
		if(wasUpdated) {
			messageUpdateConfirmation = "Fornecedor atualizado com sucesso!";
		}
		else {
			messageUpdateConfirmation = "Fornecedor não foi atualizado!";
		}
		
		request.setAttribute("mensage", messageUpdateConfirmation);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/ProviderResponse.jsp");
        rd.forward(request,response);
	}
	
	public boolean sendToProviderDAO(HttpServletRequest request) {
		boolean wasUpdated = false;
		HttpSession session = request.getSession();
		String actualProviderCnpj = (String) request.getParameter("actualCnpj");
		
		System.out.println("Cnpj atual: " + actualProviderCnpj);
				
		Provider provider = new Provider();
		
		provider.setProviderCnpj(request.getParameter("user"));
		provider.setProviderName((String)session.getAttribute("user"));
		provider.setProviderEmail(request.getParameter("email"));
		provider.setProviderPassword(request.getParameter("password"));
		provider.setProviderDdd(Integer.parseInt(request.getParameter("ddd")));
		provider.setProviderPhone(Integer.parseInt(request.getParameter("phone")));
		provider.setProviderAdress(request.getParameter("adress"));
		provider.setProviderCity(request.getParameter("city"));
		provider.setProviderState(request.getParameter("state"));
		provider.setProviderZip(Integer.parseInt(request.getParameter("zip")));
		
		ProviderDAO providerDAO = new ProviderDAO();
		
		wasUpdated = providerDAO.updateProvider(actualProviderCnpj, provider);
		
		return wasUpdated;
	}
}
