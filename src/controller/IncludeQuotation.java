package controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
@WebServlet("/IncludePregao")
public class IncludeQuotation extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
    
   /**Creating new Pregao
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
		String textDate = request.getParameter("date");
		Date pregaoDate = convertTextDateToDate(textDate);
		boolean wasAdd = includePregao(managerName, pregaoDate);
		
		if(wasAdd) {
			messageAddConfirmation = "Pregão foi criado com sucesso!";
		}
		else {
			messageAddConfirmation = "Erro! Houve um problema na criação do Pregão!";
		}
		//Set the mensage for send to Product Response
		request.setAttribute("mensage", messageAddConfirmation);
		
		//Dispacher the result from the view of confirmation		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/ProductResponse.jsp");
        rd.forward(request,response);
	}
	
	private Date convertTextDateToDate(String textDate) {
		Date date = null;
		
		try {
           DateFormat formatter =  new SimpleDateFormat("dd/MM/yyyy");
           date = new java.sql.Date(((java.util.Date)formatter.parse(textDate)).getTime());
            
        } catch (ParseException e) {
        	System.out.println("Erro de conversão da data");
        }
		return date;
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
