package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Quotation;
import dao.QuotationDAO;

@WebServlet("/ConsultQuotation")
public class ConsultQuotation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ConsultQuotation() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws
		ServletException, IOException {
		ArrayList<Quotation> quotationList = new ArrayList<Quotation>();
		QuotationDAO quotationdao = new QuotationDAO();
		
		quotationList = quotationdao.listQuotation();		
		
		request.setAttribute("quotationList", quotationList);
				
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/ConsultQuotationList.jsp");
        rd.forward(request,response);
	}
}
