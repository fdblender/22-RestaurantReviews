package customTools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.RReview;
import model.RRestaurant;
import model.RUser;
import model.Restaverage;

public class RestaurantDB {

	public static StringBuffer getReviewString(RReview review) {
		StringBuffer reviewstr = new StringBuffer();

		reviewstr.append(review.getRRestaurant().getName() 
				+ "\t" + review.getRating() + "\t" 
				+ review.getReview() + "\t"
				+ review.getRUser().getName());

		return reviewstr;
	}
	
	public static StringBuffer getRestaverageString(Restaverage rest) {
		StringBuffer rstr = new StringBuffer();

		rstr.append(rest.getRestaurantid()
				+ "\t" + rest.getName() + "\t" 
				+ rest.getDescription() + "\t"
				+ rest.getAvgrating());

		return rstr;
	}
	

	public static List<RReview> getReviews() {
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<RReview> reviews = null;

		String qString = "select r from RReview r";
		
		try {
			TypedQuery<RReview> query = em.createQuery(qString, RReview.class);
			// query.setParameter("userid", userid);

			reviews = query.getResultList();

			if (reviews == null) {
				System.out.println("getReviews: reviews list is null");
			} else {
				System.out.println("getReviews: Reviews");
				for (RReview review : reviews) {
					System.out.println(getReviewString(review));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return reviews;
	}
	
	// get a list of all restaurants with their rating
	public static List<Restaverage> getRestaurants() {
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Restaverage> restaurants = null;

		String qString = "select r from Restaverage r";		

		try {
			TypedQuery<Restaverage> query = em.createQuery(qString, Restaverage.class);
			
			restaurants = query.getResultList();

			if (restaurants == null) {
				System.out.println("getReviews: reviews list is null");
			} else {
				System.out.println("getReviews: Reviews");
				for (Restaverage rest : restaurants) {
					System.out.println(getRestaverageString(rest));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return restaurants;
	}

}
