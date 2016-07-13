package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the R_USERS database table.
 * 
 */
@Entity
@Table(name="R_USERS")
@NamedQuery(name="RUser.findAll", query="SELECT r FROM RUser r")
public class RUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long userid;

	private String email;

	private String name;

	private String zipcode;

	//bi-directional many-to-one association to RReview
	@OneToMany(mappedBy="RUser")
	private List<RReview> RReviews;

	public RUser() {
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public List<RReview> getRReviews() {
		return this.RReviews;
	}

	public void setRReviews(List<RReview> RReviews) {
		this.RReviews = RReviews;
	}

	public RReview addRReview(RReview RReview) {
		getRReviews().add(RReview);
		RReview.setRUser(this);

		return RReview;
	}

	public RReview removeRReview(RReview RReview) {
		getRReviews().remove(RReview);
		RReview.setRUser(null);

		return RReview;
	}

}