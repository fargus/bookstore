package UI;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;

import db.Books;
import db.Clients;
import db.MyEntityManager;
import db.Sellhistory;

public class ConsoleUI {
	
	public static void run(){
		menuAction();
	}
	public static void showMenu(){
		System.out.println("*---------------------------*");
		System.out.println("*\tWelcome to bookstore\t*");
		System.out.println("*---------------------------*");
		System.out.println("*\t1:Show books\t\t*");
		System.out.println("*\t2:Find books\t\t*");
		System.out.println("*\t3:Show authors\t\t*");
		System.out.println("* 4:Show authors w/o books\t*");
		System.out.println("* 5:Show avg price by author*");
		System.out.println("* 6:Show author with 2 books*\n*\t\tsold min\t*");
		System.out.println("*\t7:Bay book\t\t*");
		System.out.println("*\t8:Show history\t\t*");
		System.out.println("*---------------------------*");
		System.out.println("*\t9:Admin console\t\t*");
		System.out.println("*\t0:Exit\t\t\t*");
		System.out.println("*---------------------------*");
	}
	public static void menuAction(){
      
		int number;
		EntityManager em=MyEntityManager.getEM();
		
        do{
        	showMenu();
        	System.out.println("Choose your action:-->");
        	number = ConsoleInput.getInt();
        	
        	switch(number){
        	case 1:{
       			ShowTables.showBooks(em);
       			break;
       		}
       		case 2:{
       			findBooks(em);
       			break;
       		}
       		case 3:{
       			ShowTables.showAuthors(em);
        		break;
        	}
       		case 4:{
       			ShowTables.showAithorWOBook(em);
       			break;
       		}
       		case 5:{
       			ShowTables.showAveragePriceByAuthor(em);
       			break;
       		}
       		case 6:{
       			ShowTables.showAuth2SoldMin(em);
       			break;
       		}
        	case 7:{
       			bayBook(em);
       			break;
       		}
        	case 8:{
       			showYourHostory(em);
       			break;
       		}
       		case 9:{
       			AdminConsole.run();
       			break;
       		}
       		case -1:{
       			break;
       		}
       		default:{
       			if(number!=0){
       				System.out.println("Invalid input,Try again");
       			}	
       			break;
       		}
       		}
        	em.clear();
       	}
		while (number!=0); 
        em.close();
	}
	public static int findBooks(EntityManager em){
		
		int find_type_number;
		
		System.out.println("*---------------------------*");
		System.out.println("*\t1:Find by title\t\t*");
		System.out.println("*\t2:Find by author\t*");
		System.out.println("* 3:Show pop book by qty\t*");
		System.out.println("* 4:Show pop book by total\t*");
		System.out.println("*\t5:Show unsold book\t*");
		System.out.println("*---------------------------*");
		System.out.println("*\t0:Exit\t\t\t*");
		System.out.println("*---------------------------*");
        System.out.println("Choose your find action:-->");
       	
        find_type_number = ConsoleInput.getInt();
       	switch(find_type_number){
       	case 1:{
       		ShowTables.showBooksByTitle(em);
       		return findBooks(em);
       	}
       	case 2:{
       		ShowTables.showBooksByAuthor(em);
       		return findBooks(em);
        }
       	case 3:{
       		ShowTables.showPopBookByQty(em);	
       		return findBooks(em);
       	}
       	case 4:{
       		ShowTables.showPopBookByTotal(em);
       		return findBooks(em);
       	}
       	case 5:{
       		ShowTables.showUnsoldBooks(em);
       		return findBooks(em);
       	}
       	case 0:{
       		return 0;
       	}
       	case -1:{
			return findBooks(em);
       	}
       	default:{
       		System.out.println("Invalid input,Try again");
       		return findBooks(em);
       	}
       	}
	}
	public static void bayBook(EntityManager em){
		
		String client_name;
		int baybook_number;
		int bayid;
		String confirm="";
		Books book=new Books();
		Clients client;
		List l;
		boolean flag_1=false;
		boolean flag_2=false;
		boolean new_client_flag=false;
		
		System.out.println("*---------------------------*");
		System.out.println("*\tBay a book\t\t*");
		System.out.println("*---------------------------*");
		
		em.getTransaction().begin();
		
		if(em.createQuery("from Books").getResultList().size()==0){
			System.out.println("Nothing to bay!");
		}
		else{
			System.out.println("Input your name:");
			
			client_name=ConsoleInput.getString();
			l=em.createQuery("from Clients client " +
					"where client.name='"+client_name+"'").getResultList();
			if(l.size()==0){
				client=new Clients();
				client.setName(client_name);
				em.persist(client);
				l=em.createQuery("from Clients client " +
						"where client.name='"+client_name+"'").getResultList();
				client=(Clients)l.get(0);
				new_client_flag=true;
			}
			else{
				client=(Clients)l.get(0);
			}	
			
			while(!flag_1){
				
				System.out.println("*---------------------------*");
				System.out.println("* 1:Select book from list\t*");
				System.out.println("*\t2:Find book\t\t*");
				System.out.println("*\t3:Bay by book id\t*");
				System.out.println("*---------------------------*");
				System.out.println("Choose your method:");	
				baybook_number=ConsoleInput.getInt();
				switch(baybook_number){
				case 1:{
					ShowTables.showBooks(em);
					flag_1=true;
					break;
				}
				case 2:{
					int i=findBooks(em);
					if(i!=0){
						flag_1=true;
					}
					break;
				}
				case 3:{
					flag_1=true;
					break;
				}
				case -1:{
					break;
				}
				default:{
					System.out.println("Invalid input,Try again");
					break;
				}
				}
			}
			
			while(!flag_2){
				System.out.println("Input id book to bay:");
				bayid=ConsoleInput.getInt();
				book=em.find(Books.class,bayid);
				if(book==null){
					System.out.println("Invalid book id!");
				}
				else{
					flag_2=true;
				}
			}
			
			while(!(confirm.equals("Y"))&&!(confirm.equals("N"))){
				System.out.println("Realy want to bay "
						+book.getTitle()+" for "+book.getPrice()+" ?(Y/N)");
				confirm=ConsoleInput.getString();
			}
			
			if (confirm.equals("Y")){
				Sellhistory sh=new Sellhistory();
				java.util.Date date=new java.util.Date();
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
				if(new_client_flag){
					em.remove(client);
				}
				System.out.println(":)");;
			}
		}
		em.getTransaction().commit();
	}
	public static void showYourHostory(EntityManager em){
		
		List l;
		
		System.out.println("*---------------------------*");
		System.out.println("*\tYour sellhistory\t*");
		System.out.println("*---------------------------*");
		System.out.println("Input your name:-->");
		
		l=em.createQuery("select sell, client.name, book.title  " +
				"from Clients as client " +
				"join client.sellhistory as sell " +
				"join sell.book as book " +
				"where client.name='"+ConsoleInput.getString()+"'").getResultList();
		if(l.size()==0){
			System.out.println("History not find!");
		}
		else{
			System.out.println("Book\tClient\tPrice\tDate");
			for(int i=0;i<l.size();i++){
				Object[] obj=(Object[]) l.get(i);
				Sellhistory sell=(Sellhistory)obj[0];
				System.out.println(obj[2]+"\t"+obj[1]+"\t"+sell.getPrice()+"\t"+sell.getDate().toString().substring(0, 10));
			}	
		}
	}
}
