package UI;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;

import managers.AuthorManager;
import managers.BookManager;
import managers.ClientManager;
import managers.HistoryManager;
import db.MyEntityManager;

public class AdminConsole {
		
	public static void run(){
		adminAction();
	}
	
	private static void adminAction(){

		int number;
		
        do{
        	ShowMenu.showAdminMenu();
        	number = ConsoleInput.getInt();
        	switch(number){
        	case 1:{
        		manageBooks();
        		break;
        	}
        	case 2:{
        		manageAuthors();
        		break;
        	}
       		case 3:{
       			manageClients();
       			break;
       		}
       		case 4:{
       			manageHistory();
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
       	}
		while (number!=0);
	}	
	
	private static void manageClients(){
		
		int mng_action;
		EntityManager em=MyEntityManager.getEM();
		
		do{
			ShowMenu.showMngClientsMenu();
			mng_action=ConsoleInput.getInt();
			switch(mng_action){
			
			case 1:{
				ShowTables.showClients(em);
				break;
			}
			
			case 2:{
				ClientManager.addClient(em);
				break;
			}
			
			case 3:{
				ClientManager.delClient(em);
				break;
			}
			case -1:{
				break;
			}
			default:{
				if(mng_action!=0){
       				System.out.println("Invalid input,Try again");
       			}	
       			break;
			}
			}
		}
		while (mng_action!=0);
		em.close();
	}
	
	private static void manageHistory(){
		
		int mng_history=0;
		EntityManager em=MyEntityManager.getEM();
		
		do{
			ShowMenu.showMngHistMenu();
			mng_history =ConsoleInput.getInt();
    		switch(mng_history){
    		case 1:{
    			ShowTables.showHistory(em);
    			break;
    		}
    		case 2:{
    			HistoryManager.deleteEntry(em);
    			break;
    		}
    		case 3:{
    			HistoryManager.totalOnDate(em);
    			break;
    		}
    		case 4:{
    			HistoryManager.totalOnDateByClient(em);
    			break;
    		}
    		case 5:{
    			HistoryManager.superQuery(em);
    		}
    		case -1:{
    			break;
    		}
    		default:{
    			if(mng_history!=0){
       				System.out.println("Invalid input,Try again");
       			}	
       			break;
    		}
    		}
    	}
		while (mng_history!=0);
		em.close();
	}
	
	private static void manageBooks(){
		
		int mng_book;
		EntityManager em=MyEntityManager.getEM();
		
		do{
			ShowMenu.showMngBooksMenu();
        	mng_book = ConsoleInput.getInt();
        	switch(mng_book){
        	case 1:{
        		ShowTables.showBooks(em);
        		break;
        	}
        	case 2:{
        		BookManager.addBook(em);
        		break;
        	}
        	case 3:{
        		BookManager.delBook(em);
        		break;
        		}
       		case 4:{
       			BookManager.addAuthToBook(em);
       			break;
       		}
       		case 5:{
       			BookManager.changeAuth(em);
       			break;
       		}
       		case 6:{
       			BookManager.delAuthFromBook(em);
       			break;
       		}
       		case 7:{
       			BookManager.changePrice(em);
       			break;
       		}
       		case -1:{
       			break;
       		}
       		default:{
       			if(mng_book!=0){
       				System.out.println("Invalid input,Try again");
       			}	
       			break;
       		}
       		}
       	}
		while (mng_book!=0);
		em.close();
	}
	
	private static void manageAuthors(){
		
		int mng_author;
		EntityManager em=MyEntityManager.getEM();
		
		do{
			ShowMenu.showMngAuthMenu();
        	mng_author = ConsoleInput.getInt();
        	switch(mng_author){
        	case 1:{
        		ShowTables.showAuthors(em);
        		break;
        	}
        	case 2:{
        		AuthorManager.addAuthor(em);
        		break;
        	}
       		case -1:{
       			break;
       		}
       		default:{
       			if(mng_author!=0){
       				System.out.println("Invalid input,Try again");
       			}	
       			break;
       		}
       		}
       	}
		while (mng_author!=0);
		
		em.close();
	}
}
