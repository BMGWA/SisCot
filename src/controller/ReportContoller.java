package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuotationDAO;
import model.Quotation;

/**
 * Servlet implementation class Report
 */
@WebServlet("/Report")
public class ReportContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReportContoller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Quotation quotation = new Quotation();
		quotation =  getQuotation(request);
		
		// Get the request
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		if (session.getAttribute("user") != null) {
			String user = (String) session.getAttribute("userType");
			
			if (user.equals("manager")) {
				//Implement method to manager 
			}
			else if (user.equals("provider")) {
				//Implement method to provider 
			}
		}

		// Dispacher the result from the view of confirmation
		/*
		 * RequestDispatcher rd; rd =
		 * request.getRequestDispatcher("/index.jsp"); rd.forward(request,
		 * response);
		 */
	}

	private Quotation getQuotation(HttpServletRequest request) {
		
		String quotationId = request.getParameter("quotationId");
		int integerQuotationID = Integer.parseInt(quotationId);
			
		QuotationDAO quotationdao = new QuotationDAO();
		Quotation quotation = new Quotation();
		quotation = quotationdao.selectQuotationByID(integerQuotationID);
				
		return quotation;
	}

}
