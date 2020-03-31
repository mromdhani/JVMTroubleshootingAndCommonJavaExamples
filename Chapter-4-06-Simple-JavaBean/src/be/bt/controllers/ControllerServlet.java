package be.bt.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.bt.beans.Product;


@WebServlet("/product")
//@ServletSecurity(value=@HttpConstraint(rolesAllowed= {}, 
//             transportGuarantee=TransportGuarantee.CONFIDENTIAL), 
//             httpMethodConstraints = @HttpMethodConstraint(value = "POST",
//                                         rolesAllowed = "aa")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           
		    // Instanciate a Product
	       Product p = new Product("ThinkPad Carbon X1", 2000.5);
	       
	       // Put it in the session
	       request.setAttribute("lapTop", p);
	       
	       // Dispatch the flow to the view
	       getServletContext().getRequestDispatcher("/views/view.jsp").forward(request, response);
	   	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
