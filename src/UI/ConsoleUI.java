package UI;

import javax.persistence.EntityManager;

import managers.BookManager;
import managers.ClientManager;

import db.MyEntityManager;

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
       			BookManager.findBooks(em);
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
       			BookManager.bayBook(em);
       			break;
       		}
        	case 8:{
       			ClientManager.showYourHostory(em);
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
}
