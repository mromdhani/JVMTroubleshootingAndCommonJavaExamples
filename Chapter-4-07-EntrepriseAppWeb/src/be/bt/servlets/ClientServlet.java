package be.bt.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.bt.slsb.CalculLocal;

@WebServlet("/client")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB   // Here is a dependency injection !!!
	private CalculLocal calculLocal;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int a = 11;
		int b = 22;
		
	    int resultat = calculLocal.add(a, b);
	    
	    PrintWriter out = response.getWriter();
	    out.print("<h2> The result of  11 + 22 is : "+resultat+ "</h2>");
	    
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
