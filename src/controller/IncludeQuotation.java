package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Quotation;
import dao.QuotationDAO;


/**
 * Servlet implementation class IncludeProduct
 */
@WebServlet("/IncludeQuotation")
public class IncludeQuotation extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
    
   /**Creating new Quotation
    * @see HttpServlet#HttpServlet()
    */
	public IncludeQuotation() {
		super();
	}
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws
		ServletException, IOException {
		String messageAddConfirmation = "Iniciada";
		HttpSession session = request.getSession();
		//Get name and description of the IncludeProducView
		String managerName = (String) session.getAttribute("user");
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		boolean wasAdd = includePregao(managerName, sqlDate);
		
		if(wasAdd) {
			messageAddConfirmation = "Cotação criada com sucesso!";
		}
		else {
			messageAddConfirmation = "Erro! Houve um problema na criação da Cotação!";
		}
		//Set the mensage for send to Product Response
		request.setAttribute("mensage", messageAddConfirmation);
		
		//Dispacher the result from the view of confirmation		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/QuotationResponse.jsp");
        rd.forward(request,response);
	}
	
	
	private boolean includePregao(String managerName, Date quotationDate) {
		boolean wasAdd = false;
		
		Quotation quotation = new Quotation();
		quotation.setManagerName(managerName);
		quotation.setQuotationDate(quotationDate);
		quotation.setProducts(null);
		
		QuotationDAO quotationdao = new QuotationDAO();
		wasAdd = quotationdao.includeQuotation(quotation);
		
		return wasAdd;
	}
}
