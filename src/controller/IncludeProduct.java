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
				
		String mesageAddConfirmation = "Iniciada";
		boolean wasAdd = includeProduct(request);
		
		if (wasAdd) {
			mesageAddConfirmation = "Produto adicionado com sucesso!";
		}
		else {
			mesageAddConfirmation = "Produto Não Foi Adicionado!";
		}
		
		//Set the mensage for send to Product Response
		request.setAttribute("mensage", mesageAddConfirmation);
		
		//Dispacher the result from the view of confirmation		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/ProductResponse.jsp");
        rd.forward(request,response);
	}
	
	public boolean includeProduct(HttpServletRequest request){
		boolean wasAdd = false;
		
		//Get name and description of the IncludeProducView
		String nameProduct = request.getParameter("name");
		String descriptionProduct = request.getParameter("description");
		
		Product product = new Product(); 
		product.setProductDescription(descriptionProduct);
		product.setProductName(nameProduct);
		product.setProductPrice(0.0);
		product.setProductProvider(null);
		
		//Flag to verify if the Product was add in the DataBase
		
		
		//Acess the DAO class and adding the new product
		ProductDAO productdao = new ProductDAO();
		wasAdd = productdao.includeProduct(product);
		
		return wasAdd;
	}

}
