package customTools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.RReview;
import model.RRestaurant;
import model.RUser;

public class RestaurantDB {

	public static StringBuffer getReviewString(RReview review) {
		StringBuffer reviewstr = new StringBuffer();

		reviewstr.append(review.getRRestaurant().getName() 
				+ "\t" + review.getRating() + "\t" 
				+ review.getReview() + "\t"
				+ review.getRUser().getName());

		return reviewstr;

	}

	public static List<RReview> getReviews() {
		// System.out.println("getReviews: ");

		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<RReview> reviews = null;

		String qString = "select r from RReview r";
		// String qString =
		// "select r.review, r.rating from RReview r JOIN r.restaurantid";

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
	public static List<RReview> getRestaurants() {
		// System.out.println("getReviews: ");

		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<RRestaurant> restaurants = null;

		String qString = "select r from RRestaurant r";		

		try {
			TypedQuery<RRestaurant> query = em.createQuery(qString, RRestaurant.class);
			
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

}
