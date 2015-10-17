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

/**
 * Servlet implementation class IncludeProduct
 */
@WebServlet("/IncludeProduct")
public class InsertProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**Creating new Product
     * @see HttpServlet#HttpServlet()
     */
    public InsertProduct() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String messageAddConfirmation = "Iniciada";
		//Get name and description of the IncludeProducView
		String nameProduct = request.getParameter("name");
		boolean wasAdd = includeProduct(nameProduct);
		
		if (wasAdd) {
			messageAddConfirmation = "Produto adicionado com sucesso!";
		}
		else {
			messageAddConfirmation = "Produto Não Foi Adicionado!";
		}
		
		//Set the mensage for send to Product Response
		request.setAttribute("mensage", messageAddConfirmation);
		
		//Dispacher the result from the view of confirmation		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/ProductResponse.jsp");
        rd.forward(request,response);
	}
	
	public boolean includeProduct(String nameProduct){
		boolean wasAdd = false;
			
		Product product = new Product(); 
		product.setProductName(nameProduct);
		product.setProductPrice(0.0);
		product.setProductProvider(null);
		
		//Flag to verify if the Product was add in the DataBase
		
		
		//Acess the DAO class and adding the new product
		ProductDAO productdao = new ProductDAO();
		wasAdd = productdao.insertProduct(product);
		
		return wasAdd;
	}

}
