package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QuotationDAO;
import model.Product;
import model.Quotation;

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
		
		ArrayList<Product> list = new ArrayList<>();
		
		list = quotationList.get(25).getProducts();
				
		System.out.println("Passou: " + quotationList.get(25).getManagerName());
		for (Product product : list) {
			System.out.println("Nome Produto: " + product.getProductName());
		}
		
		request.setAttribute("quotationList", quotationList);
		
				
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/ConsultQuotationList.jsp");
        rd.forward(request,response);
	}
}
