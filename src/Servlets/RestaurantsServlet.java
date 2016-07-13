package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.RestaurantDB;
import model.RReview;
import model.Restaverage;

/**
 * Servlet implementation class ShowRestaurantsServlet
 */
@WebServlet("/ShowRestaurantsServlet")
public class RestaurantsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();	
		//String name = request.getParameter("name");
		//String type = request.getParameter("type");		
		String nextURL;
		List<Restaverage> restaurants = null;
			
		restaurants = RestaurantDB.getRestaurants();
				
		session.setAttribute("restaurants", restaurants);		
			
		nextURL = "/restaurants.jsp";
				
		request.getRequestDispatcher(nextURL).forward(request, response);
		return;
	}

}
