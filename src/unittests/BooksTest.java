package unittests;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

import db.Books;


public class BooksTest {
	
	private static Books book=new Books();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		  book.setPrice(333);
	}
	
	@Test
	public void checkPrice() throws Exception{
		float price=book.getPrice();
		assertEquals(price,333,0.001);
	}
	
	@Test(expected=NullPointerException.class)
	public void checkTitleException () throws Exception{
		book.getTitle();
	}
}
