package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the RESTAVERAGE database table.
 * 
 */
@Entity
@NamedQuery(name="Restaverage.findAll", query="SELECT r FROM Restaverage r")
public class Restaverage implements Serializable {
	private static final long serialVersionUID = 1L;

	private String address;

	private BigDecimal avgrating;

	private String description;

	private String name;

	@Id
	private BigDecimal restaurantid;

	public Restaverage() {
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getAvgrating() {
		return this.avgrating;
	}

	public void setAvgrating(BigDecimal avgrating) {
		this.avgrating = avgrating;
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

	public BigDecimal getRestaurantid() {
		return this.restaurantid;
	}

	public void setRestaurantid(BigDecimal restaurantid) {
		this.restaurantid = restaurantid;
	}

}