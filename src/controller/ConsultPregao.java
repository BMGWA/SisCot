package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pregao;
import dao.PregaoDAO;

@WebServlet("/ConsultPregao")
public class ConsultPregao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ConsultPregao() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws
		ServletException, IOException {
		ArrayList<Pregao> pregaoList = new ArrayList<Pregao>();
		PregaoDAO pregaodao = new PregaoDAO();
		
		pregaoList = pregaodao.listPregao();		
		
		request.setAttribute("pregaoList", pregaoList);
				
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/ConsultPregaoList.jsp");
        rd.forward(request,response);
	}
}
