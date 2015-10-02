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

import model.Pregao;
import dao.PregaoDAO;


/**
 * Servlet implementation class IncludeProduct
 */
@WebServlet("/IncludePregao")
public class IncludePregao extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
    
   /**Creating new Pregao
    * @see HttpServlet#HttpServlet()
    */
	public IncludePregao() {
		super();
	}
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws
		ServletException, IOException {
		String messageAddConfirmation = "Iniciada";
		//Get name and description of the IncludeProducView
		String managerName = request.getParameter("managerName");
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
	
	private boolean includePregao(String managerName, Date pregaoDate) {
		boolean wasAdd = false;
		
		Pregao pregao = new Pregao();
		pregao.setManagerName(managerName);
		pregao.setPregaoDate(pregaoDate);
		pregao.setProducts(null);
		
		PregaoDAO pregaodao = new PregaoDAO();
		wasAdd = pregaodao.includePregao(pregao);
		
		return wasAdd;
	}
}
