package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Product;
import model.Provider;

/**
 * Servlet implementation class IncludeProduct
 */
@WebServlet("/IncludeProduct")
public class IncludeProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**Creating new Product
     * @see HttpServlet#HttpServlet()
     */
    public IncludeProduct() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get name and description of the IncludeProducView
		String nameProduct = request.getParameter("name");
		String descriptionProduct = request.getParameter("description");
		
		Product product = new Product(); 
		product.setProductDescription(descriptionProduct);
		product.setProductName(nameProduct);
		product.setProductPrice(0.0);
		product.setProductProvider(null);
		
		//Flag to verify if the Product wad add in the DataBase
		boolean wasAdd = false;
		
		//Acess the DAO class and adding the new product
		ProductDAO productdao = new ProductDAO();
		wasAdd = productdao.includeProduct(product);
		
		String mesageAddConfirmation = "Iniciada";
		if (wasAdd) {
			mesageAddConfirmation = "Produto " + product.getProductName() + " adicionado com sucesso!";
		}
		else {
			mesageAddConfirmation = "Produto " + product.getProductName() + " Não Foi Adicionado!";
		}
		
		//Set the mensage for send to Product Response
		request.setAttribute("mensage", mesageAddConfirmation);
		
		//Dispacher the result from the view of confirmation		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/ProductResponse.jsp");
        rd.forward(request,response);
	}

}
