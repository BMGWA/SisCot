package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuotationDAO;
import model.Product;
import model.Quotation;
import model.Report;
import model.ReportManager;
import model.ReportProvider;

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

		int quotationID = getQuotationID(request);

		// Create a quotation with ID
		Quotation quotation = new Quotation();
		quotation = getQuotation(quotationID);

		ArrayList<Product> products = new ArrayList<>();
		QuotationDAO quotationdao = new QuotationDAO();

		products = quotationdao.getListProductsInAQuotation(quotationID);

		// Get the request
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		Report report = new Report();

		if (session.getAttribute("user") != null) {
			String user = (String) session.getAttribute("userType");

			if (user.equals("manager")) {
				report = new ReportManager(products, quotation, 0.0);
			} else if (user.equals("provider")) {
				String providerName = (String) session.getAttribute("user");
				report = new ReportProvider(products, quotation, 0.0, providerName);
			}
		}

		ArrayList<ArrayList> productsForProvider = new ArrayList<>();
		productsForProvider = report.showProducts();

		request.setAttribute("listProducts", productsForProvider.get(0));
		request.setAttribute("listProviders", productsForProvider.get(1));
		
		ArrayList<String> tes = new ArrayList<>();
		tes = productsForProvider.get(1);
		
		for (String string : tes) {
			System.out.println("Fornecedores: " + string);
		}

		// Dispacher the result from the view of confirmation
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/ShowReport.jsp");
		rd.forward(request, response);

	}

	private int getQuotationID(HttpServletRequest request) {

		String quotationId = request.getParameter("quotationId");
		int integerQuotationID = Integer.parseInt(quotationId);

		return integerQuotationID;
	}

	private Quotation getQuotation(int integerQuotationID) {

		QuotationDAO quotationdao = new QuotationDAO();
		Quotation quotation = new Quotation();
		quotation = quotationdao.selectQuotationByID(integerQuotationID);

		return quotation;
	}

}
