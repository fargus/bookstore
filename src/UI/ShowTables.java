package UI;

import java.util.*;

import javax.persistence.EntityManager;

import db.Author;
import db.Book;
import db.Client;
import db.Sellhistory;

public class ShowTables {
	
	public static void showBook(Book book){
		System.out.println("Id\tTitle\tPrice\tAuthors");
		System.out.print(book.getId()+"\t"+book.getTitle()+"\t"+book.getPrice()+"\t");
		for(Author a:book.getIdauthors()){
			System.out.print(a.getName()+"/");
		}
		System.out.println();
		
	}
	public static int showBooks(EntityManager em){
		
		Book b;
		String name;
		int current_id;
		int last_id=0;
		List l;
		
		l=em.createQuery(
				"select book, author.name " +
				"from Book as book left join" +
				" book.idauthors as author").getResultList();
		if(l.size()==0){
			System.out.println("Books not find!");
			return 0;
		}
		else{
			System.out.print("Id\tTitle\tPrice\tAuthors");
			for(int i=0;i<l.size();i++){
				Object[] row=(Object[])l.get(i);
				b=(Book)row[0];
				current_id=b.getId();
				name=row[1].toString();
				if(current_id!=last_id){
					System.out.print("\n"+b.getId()+"\t"+b.getTitle()+"\t"+b.getPrice()+"\t"+name);
				}
				else{
					System.out.print(","+name);
				}
				last_id=current_id;
			}
			System.out.print("\n\n");
			return l.size();
		}
	}	
	public static int showAuthors(EntityManager em){
		
		List l;
		Author a;
		
		l=em.createQuery("from Author").getResultList();
		if(l.size()!=0){
			System.out.println("*Id*\t*Name*");
			for(Object obj:l){
				a=(Author)obj;
				System.out.println(a.getId()+"\t\t"+a.getName());
			}	
			return l.size();
		}
		else{
			System.out.println("Authors not find");
			return 0;
		}
	}
	public static int showHistory(EntityManager em){
		List l=em.createQuery("select sell, client.name, book.title  " +
				"from Client as client " +
				"join client.sellhistory as sell " +
				"join sell.book as book").getResultList();
		
		if(l.size()==0){
			System.out.println("History not find!");
			return 0;
		}
		else{
			System.out.println("Id\tBook\tClient\tPrice\tDate");
			for(int i=0;i<l.size();i++){
				Object[] obj=(Object[]) l.get(i);
				Sellhistory sell=(Sellhistory)obj[0];
				System.out.println(sell.getId()+"\t"+obj[2]+"\t"+obj[1]+"\t"+sell.getPrice()+"\t"+sell.getDate().toString().substring(0,10));
			}
			return l.size();
		}
	}
	public static int showClients(EntityManager em){
		
		List<Client> l=em.createQuery("from Client").getResultList();
		if(l.size()!=0){
			System.out.println("Id\tName\tLogin\tisAdmin");
			for(Client c:l){
				System.out.println(c.getId()+"\t"+c.getName()+"\t"+c.getLogin()+"\t"+c.isAdmin());
			}
			return l.size();
		}
		else{
			System.out.println("Clients not find!");
			return 0;
		}
	}
	public static int showBooksByTitle(EntityManager em){
		System.out.println("Input title:");
   		String findstring=ConsoleInput.getString();
   		List l=em.createQuery("from Book " +
   				"where title like '%"+findstring+"%'").getResultList();
   		
   		if(l.size()==0){
   			System.out.println("Books not find!");
   		}
   		else{
   			System.out.println("Id\tTitle\tPrice");
   	    	for(Object obj:l){
   	    		Book b=(Book)obj;
   	   			System.out.println(b.getId()+"\t"+b.getTitle()+"\t"+b.getPrice());
   	   		}	
   		}
   		return l.size();
	}
	public static int showBooksByAuthor(EntityManager em){
		System.out.println("Input author:");
    	String findstring=ConsoleInput.getString();
   		List l=em.createQuery("select book from Book as book" +
   				" inner join book.idauthors as author " +
   				"where author.name like '%"+findstring+"%'").getResultList();
   		if(l.size()==0){
   			System.out.println("Books not find!");
   		}
   		else{
   			System.out.println("Id\tTitle\tPrice");
   	    	for(Object obj:l){
   	    		Book b=(Book)obj;
   	   			System.out.println(b.getId()+"\t"+b.getTitle()+"\t"+b.getPrice());
   	   		}	
   		}
   		return l.size();
	}
	public static int showPopBookByQty(EntityManager em){
		
		List<Object[]> l=em.createQuery("select book.id, book.title, count(*) as col " +
				"from Book as book " +
				"join book.sellhistory as sell " +
				"group by book.title " +
				"order by col desc limit 1").getResultList();
		
		if(l.size()!=0){
			System.out.println("Id\tTitle\tQuantity");
			System.out.println(l.get(0)[0]+"\t"+l.get(0)[1]+"\t"+l.get(0)[2]);
			return l.size();
		}
		else{
			System.out.println("Book not find!");
			return 0;
		}
	}	
	public static int showPopBookByTotal(EntityManager em){
		
		List<Object[]> l=em.createQuery("select book.id, book.title, count(*)*book.price as total " +
				"from Book as book " +
				"join book.sellhistory as sell " +
				"group by book.title " +
				"order by total desc limit 1").getResultList();
		if(l.size()!=0){
			System.out.println("Id\tTitle\tTotal");
			System.out.println(l.get(0)[0]+"\t"+l.get(0)[1]+"\t"+l.get(0)[2]);
			return l.size();
		}
		else{
			System.out.println("Book not find!");
			return 0;
		}
	}
	public static int showUnsoldBooks(EntityManager em){
		
		List<Book> l=em.createQuery("select book " +
				"from Book as book " +
				"left join book.sellhistory as sell " +
				"where sell.book is null").getResultList();
		
		if(l.size()!=0){
			System.out.println("Id\tTitle\tPrice");
			for(Book book:l){
				System.out.println(book.getId()+"\t"+book.getTitle()+"\t"+book.getPrice());
			}
			return l.size();
		}
		else{
			System.out.println("Books not find!");
			return 0;
		}
	}
	public static void showAithorWOBook(EntityManager em){
		
		List<Author> l=em.createQuery("select author " +
				"from Author as author " +
				"left join author.idbooks as book " +
				"where book.id is null").getResultList();
		if(l.size()!=0){
			System.out.println("Id\tName");
			for(Author author:l){
				System.out.println(author.getId()+"\t"+author.getName());
			}
		}
		else{
			System.out.println("Authors not find!");
		}
	}
	public static void showAveragePriceByAuthor(EntityManager em){
		
		List<Object[]> l=em.createQuery("select author.name, " +
				"avg(book.price) " +
				"from Author as author " +
				"left join author.idbooks as book " +
				"group by author.name").getResultList();
		if(l.size()!=0){
			System.out.println("Name\t\tAvgPrice");
			for(Object[] obj:l){
				if(obj[1]==null){
					obj[1]=0;
				}
				System.out.println(obj[0]+"\t\t"+obj[1]);
			}
		}
		else{
			System.out.println("Authors not find!");
		}
		
	}
	public static void showAuth2SoldMin(EntityManager em){
		
		List<Author> l=em.createQuery("from Author as author " +
				"where 1<(select count(*) " +
				"from Book as book " +
				"join book.sellhistory as sell " +
				"join book.idauthors as author_b " +
				"where author.id=author_b.id)").getResultList();
		if(l.size()!=0){
			System.out.println("Id\tName");
			for(Author author:l){
				System.out.println(author.getId()+"\t"+author.getName());
			}
		}
		else{
			System.out.println("Authors not find!");
		}
	}
}
