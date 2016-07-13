package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the R_REVIEWS database table.
 * 
 */
@Entity
@Table(name="R_REVIEWS")
@NamedQuery(name="RReview.findAll", query="SELECT r FROM RReview r")
public class RReview implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long reviewid;

	private BigDecimal rating;

	private String review;

	@Temporal(TemporalType.DATE)
	private Date reviewdate;

	//bi-directional many-to-one association to RRestaurant
	@ManyToOne
	@JoinColumn(name="RESTAURANTID")
	private RRestaurant RRestaurant;

	//bi-directional many-to-one association to RUser
	@ManyToOne
	@JoinColumn(name="USERID")
	private RUser RUser;

	public RReview() {
	}

	public long getReviewid() {
		return this.reviewid;
	}

	public void setReviewid(long reviewid) {
		this.reviewid = reviewid;
	}

	public BigDecimal getRating() {
		return this.rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	public String getReview() {
		return this.review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Date getReviewdate() {
		return this.reviewdate;
	}

	public void setReviewdate(Date reviewdate) {
		this.reviewdate = reviewdate;
	}

	public RRestaurant getRRestaurant() {
		return this.RRestaurant;
	}

	public void setRRestaurant(RRestaurant RRestaurant) {
		this.RRestaurant = RRestaurant;
	}

	public RUser getRUser() {
		return this.RUser;
	}

	public void setRUser(RUser RUser) {
		this.RUser = RUser;
	}

}