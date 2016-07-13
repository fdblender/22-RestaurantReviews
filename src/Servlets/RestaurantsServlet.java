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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();	
		//String name = request.getParameter("name");
		//String type = request.getParameter("type");		
		String nextURL;
		List<RReview> reviews = null;		
		
		reviews = RestaurantDB.getReviews();
				
		session.setAttribute("reviews", reviews);		
			
		nextURL = "/showratings.jsp";
				
		request.getRequestDispatcher(nextURL).forward(request, response);
		return;
	}

}
