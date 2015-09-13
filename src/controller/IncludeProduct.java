package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import model.Provider;

/**
 * Servlet implementation class IncludeProduct
 */
@WebServlet("/IncludeProduct")
public class IncludeProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncludeProduct() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nameProduct = request.getParameter("name");
		String descriptionProduct = request.getParameter("description");
		
		Product product = new Product(); 
		product.setProductDescription(descriptionProduct);
		product.setProductName(nameProduct);
		product.setProductPrice(0.0);
		product.setProductProvider(null);
			
		
		System.out.println("AQUUUUUUUUUI" + product.getProductDescription());
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/index.html");
        rd.forward(request,response);
	}

}
