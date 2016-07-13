package jUnitTests;

import static org.junit.Assert.*;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import customTools.RestaurantDB;
import dateUtility.DateUtility;
import model.RReview;

public class ShowReviewsTest {

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
		//assertTrue();
		//assertEquals();	
		
		List<RReview> reviews = null;		
		
		reviews = RestaurantDB.getReviews();
		
		assertTrue(reviews != null);
				
	}

}
