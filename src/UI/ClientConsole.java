package UI;

import javax.persistence.EntityManager;

import managers.BookManager;
import managers.ClientManager;

import db.MyEntityManager;

public class ClientConsole {
	
	public static void run(){
		menuAction();
	}
	
	public static void menuAction(){
      
		int number;
		EntityManager em=MyEntityManager.getEM();
		
        do{
        	ShowMenu.showMenu();
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
