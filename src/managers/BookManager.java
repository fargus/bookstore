package managers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

import menu.DynamicMenu;
import menu.MenuAction;

import UI.ConsoleInput;
import UI.ShowMenu;
import UI.ShowTables;

import db.Author;
import db.Book;
import db.Client;
import db.MyEntityManager;
import db.Sellhistory;

public class BookManager {
	
	
	public static void manageBooks(){
		
		EntityManager em=MyEntityManager.getEM();

		int number;
        
        do{
        	ShowMenu.showMngBooksMenu(em);
        	number = ConsoleInput.getInt();
        	if(number==0){
        		continue;
        	}
        	else if(DynamicMenu.getInstance().getMenuElements().get(number)==null){
        		System.out.println("Invalid input,Try again");
        	}
        	else{
        		DynamicMenu.getInstance().getMenuElements().get(number).getAction().action();
        	}
       	}
		while (number!=0);

		em.close();
	}
	
	public static void addBook(EntityManager em){
		
		int author_id;
		Book b=new Book();
		Author a=new Author();
		Collection<Author> col=new ArrayList<Author>();
		boolean flag_1=false;
		
		System.out.println("*---------------------------*");
		System.out.println("*\tAdd book\t\t*");
		System.out.println("*---------------------------*");
		System.out.println("Input book title:");
		b.setTitle(ConsoleInput.getString());
		
		System.out.println("Input book price:");
		b.setPrice(ConsoleInput.getFloat());
		ShowTables.showAuthors(em);
		
		do{
			if(!flag_1){
				System.out.println("Input book's author id:");
			}
			else{
				System.out.println("Input book's author id\n" +
				"\t(0 to add book):");
			}
			author_id=ConsoleInput.getInt();
			a=em.find(Author.class,author_id);
			if(a!=null){
				if(!col.contains(a)){
					col.add(a);
					flag_1=true;
					System.out.println("*Author added*");
				}
				else{
					System.out.println("*Book already have this author!*");
				}
			}
			else{
				if((author_id!=0)||(flag_1==false)){
					System.out.println("Invalid author id!");
				}
			}
		}while((author_id!=0)||(flag_1==false));
		
		b.setIdauthors(col);
		
		em.getTransaction().begin();
		try{
			em.persist(b);
			System.out.println("\n*\tNew book "+b.getTitle()+" added\t*\n");
		}catch(Exception e){
			System.out.println("Books already exist!");
			em.getTransaction().rollback();
		}
		if(em.getTransaction().isActive()){
			em.getTransaction().commit();
		}
	}
	public static void delBook(EntityManager em){
		
		Book book;
		
		System.out.println("*---------------------------*");
		System.out.println("*\tAdd book\t\t*");
		System.out.println("*---------------------------*");
		
		if(ShowTables.showBooks(em)!=0){
			System.out.println("Input book id to delete:");
			
			book=em.find(Book.class,ConsoleInput.getInt());
			if(book==null){
				System.out.println("Book not find!");
			}
			else{
				em.getTransaction().begin();
				em.remove(book);
				em.getTransaction().commit();
				System.out.println("Book "+book.getTitle()+" deleted");
			}
		}
	}
	public static void addAuthToBook(EntityManager em){
		
		Book book;
		Author author;
		boolean flag_1=false;
		boolean flag_2=false;
		
		System.out.println("*---------------------------*");
		System.out.println("*\tAdd author to book\t*");
		System.out.println("*---------------------------*");
		
		if(ShowTables.showBooks(em)!=0){
			
			do{
				System.out.println("Input book id to add author");
				book=em.find(Book.class,ConsoleInput.getInt());
				if(book==null){
					System.out.println("Book not find!");
				}
				else{
					flag_1=true;
				}
			}while(!flag_1);
			
			ShowTables.showBook(book);
			System.out.println("*---------------------------*");
			ShowTables.showAuthors(em);
			
			do{
				System.out.println("Input author id to add");
				author=em.find(Author.class,ConsoleInput.getInt());
				if(author==null){
					System.out.println("Author not find!");
				}
				else{
					flag_2=true;
				}
			}while(!flag_2);
			
			if(book.getIdauthors().contains(author)){
				System.out.println("Book has this author already!");
			}
			else{
				book.getIdauthors().add(author);
				em.getTransaction().begin();
				em.flush();
				em.getTransaction().commit();
				System.out.println("Author "+author.getName()+" added to book "+book.getTitle());
			}
		}
	}
	public static void changeAuth(EntityManager em){
		
		Book book;
		Author author;
		int author_id;
		boolean flag_1=false;
		boolean flag_2=false;
		boolean flag_3=false;
		
		System.out.println("*---------------------------*");
		System.out.println("*\tChange author\t*");
		System.out.println("*---------------------------*");
		
		if(ShowTables.showBooks(em)!=0){
			
			do{
				System.out.println("Input book id to change author");
				book=em.find(Book.class,ConsoleInput.getInt());
				if(book==null){
					System.out.println("Book not find!");
				}
				else{
					flag_1=true;
				}
			}while(!flag_1);
			
			System.out.println("Book's authors:");
			System.out.println("Id\tName");
			for(Author a:book.getIdauthors()){
				System.out.println(a.getId()+"\t"+a.getName());
			}
			System.out.println("*---------------------------*");
			
			do{
				System.out.println("Input author id to change");
				author_id = ConsoleInput.getInt();
				for(Author a:book.getIdauthors()){
					if(a.getId()==author_id){
						book.getIdauthors().remove(a);
						flag_2=true;
						break;
					}
				}
				if(!flag_2){
					System.out.println("Wrong author id!");
				}
				
			}while(!flag_2);
			
			ShowTables.showAuthors(em);
			do{
				System.out.println("Input new author id");
				author=em.find(Author.class,ConsoleInput.getInt());
				if(author==null){
					System.out.println("Author not find!");
				}
				else if(book.getIdauthors().contains(author)){
					System.out.println("Book has this author already!");
				}
				else{
					book.getIdauthors().add(author);
					em.getTransaction().begin();
					em.flush();
					em.getTransaction().commit();
					System.out.println("Author "+author.getName()+" added to book "+book.getTitle());
					flag_3=true;
				}
				
			}while(!flag_3);
		}
	}
	public static void delAuthFromBook(EntityManager em){
		
		Book book;
		int author_id;
		boolean flag_1=false;
		boolean flag_2=false;
		
		System.out.println("*---------------------------*");
		System.out.println("*  Delete author from book  *");
		System.out.println("*---------------------------*");
		
		if(ShowTables.showBooks(em)!=0){
			
			do{
				System.out.println("Input book id to delete author");
				book=em.find(Book.class,ConsoleInput.getInt());
				if(book==null){
					System.out.println("Book not find!");
				}
				else if(book.getIdauthors().size()==1){
					System.out.println("Book have 1 author, nothing to delete!");
					return;
				}
				else{
					flag_1=true;
				}
			}while(!flag_1);
			
			System.out.println("Book's authors:");
			System.out.println("Id\tName");
			for(Author a:book.getIdauthors()){
				System.out.println(a.getId()+"\t"+a.getName());
			}
			System.out.println("*---------------------------*");
			
			do{
				System.out.println("Input author id to delete");
				author_id = ConsoleInput.getInt();
				for(Author a:book.getIdauthors()){
					if(a.getId()==author_id){
						book.getIdauthors().remove(a);
						em.getTransaction().begin();
						em.flush();
						em.getTransaction().commit();
						flag_2=true;
						System.out.println("Author "+a.getName()+" deleted from book "+book.getTitle());
						break;
					}
				}
				if(!flag_2){
					System.out.println("Wrong author id!");
				}
				
			}while(!flag_2);
		}
	}
	public static void changePrice(EntityManager em){
		
		Book book=new Book();
		boolean flag_1=false;
		
		System.out.println("*---------------------------*");
		System.out.println("\tChange price");
		System.out.println("*---------------------------*");
		
		if(ShowTables.showBooks(em)!=0){
			while(!flag_1){
				System.out.println("\nInput book's id to change price:");
				book=em.find(Book.class,ConsoleInput.getInt());
				if(book==null){
					System.out.println("Invalid book id!");
				}
				else{
					flag_1=true;
				}
			}
			
			System.out.println("Input new price:");
			book.setPrice(ConsoleInput.getFloat());
			em.getTransaction().begin();
			em.flush();
			em.getTransaction().commit();
			System.out.println("Price change:"+book.getTitle()+"-"+book.getPrice()+"");
		}
	}
	public static void buyBookMenu(EntityManager em){
		int number;
        
        do{
        	ShowMenu.showBuyBookMenu(em);
        	number = ConsoleInput.getInt();
        	if(number==0){
        		continue;
        	}
        	else if(DynamicMenu.getInstance().getMenuElements().get(number)==null){
        		System.out.println("Invalid input,Try again");
        	}
        	else{
        		DynamicMenu.getInstance().getMenuElements().get(number).getAction().action();
        	}
       	}
		while (number!=0);
	}
	public static void buyBook(EntityManager em){
		
		int bayid;
		String confirm="";
		Book book=new Book();
		Client client=em.find(Client.class, 1);
		boolean flag_1=false;
		
		em.getTransaction().begin();
		
		if(em.createQuery("from Book").getResultList().size()==0){
			System.out.println("Nothing to buy!");
		}
		else{
			
			while(!flag_1){
				System.out.println("Input id book to buy:");
				bayid=ConsoleInput.getInt();
				book=em.find(Book.class,bayid);
				if(book==null){
					System.out.println("Invalid book id!");
				}
				else{
					flag_1=true;
				}
			}
			
			while(!(confirm.equals("Y"))&&!(confirm.equals("N"))){
				System.out.println("Realy want to buy "
						+book.getTitle()+" for "+book.getPrice()+" ?(Y/N)");
				confirm=ConsoleInput.getString();
			}
			
			if (confirm.equals("Y")){
				Sellhistory sh=new Sellhistory();
				java.util.Date date=new java.util.Date();
				// FIXME : using deprecated API 
				Date sqlDate=new Date(date.getYear(),date.getMonth() , date.getDate());
				sh.setBook(book);
				sh.setClient(client);
				sh.setPrice(book.getPrice());
				sh.setDate(sqlDate);
				em.persist(sh);
				System.out.println("*-----------------------*");
				System.out.println("* Thank's for purchase  *");
				System.out.println("*-----------------------*");
			}
			else{
				System.out.println(":)");;
			}
		}
		em.getTransaction().commit();
	}	
	public static void findBooks(EntityManager em){
		
		int number;
        
        do{
        	ShowMenu.showFindBookMenu(em);
        	number = ConsoleInput.getInt();
        	if(number==0){
        		continue;
        	}
        	else if(DynamicMenu.getInstance().getMenuElements().get(number)==null){
        		System.out.println("Invalid input,Try again");
        	}
        	else{
        		DynamicMenu.getInstance().getMenuElements().get(number).getAction().action();
        	}
       	}
		while (number!=0);
		
	}
}
