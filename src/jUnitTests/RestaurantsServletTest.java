package jUnitTests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import customTools.RestaurantDB;
import model.Restaverage;

public class RestaurantsServletTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		List<Restaverage> restaurants = null;
		
		restaurants = RestaurantDB.getRestaurants();
		
		assertTrue(restaurants != null);
		
	}

}
