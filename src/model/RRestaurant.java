package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the R_RESTAURANTS database table.
 * 
 */
@Entity
@Table(name="R_RESTAURANTS")
@NamedQuery(name="RRestaurant.findAll", query="SELECT r FROM RRestaurant r")
public class RRestaurant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long restaurantid;

	private String address;

	private String description;

	private String name;

	//bi-directional many-to-one association to RReview
	@OneToMany(mappedBy="RRestaurant")
	private List<RReview> RReviews;

	public RRestaurant() {
	}

	public long getRestaurantid() {
		return this.restaurantid;
	}

	public void setRestaurantid(long restaurantid) {
		this.restaurantid = restaurantid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RReview> getRReviews() {
		return this.RReviews;
	}

	public void setRReviews(List<RReview> RReviews) {
		this.RReviews = RReviews;
	}

	public RReview addRReview(RReview RReview) {
		getRReviews().add(RReview);
		RReview.setRRestaurant(this);

		return RReview;
	}

	public RReview removeRReview(RReview RReview) {
		getRReviews().remove(RReview);
		RReview.setRRestaurant(null);

		return RReview;
	}

}