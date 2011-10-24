package unittests;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

import db.Book;

// FIXME : супер тест! А как насчет AuthorManager.java BookManager.java ClientManager.java HistoryManager.java
// где поведение твоего приложения? в классе Books? 

public class BooksTest {
	
	private static Book book=new Book();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		  book.setPrice(333);
	}
	
	@Test
	public void checkPrice() throws Exception{
		float price=book.getPrice();
		// FIXME прикольно ) , тоесть цена как бы 333 , но плавает 
		//цена float вот и плаваем поэтому
		assertEquals(price,333,0.001);
	}
	
	@Test(expected=NullPointerException.class)
	public void checkTitleException () throws Exception{
		// FIXME сакральный смысл вот этого , плиз. От человека для который понял нахрена нужны все эти тесты... 
		//прикладного смысла нет. просто показал что есть возможность проверять эксепшены
		book.getTitle();
	}
}
