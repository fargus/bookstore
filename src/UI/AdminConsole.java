package UI;

import javax.persistence.EntityManager;
import managers.AuthorManager;
import managers.BookManager;
import managers.ClientManager;
import managers.HistoryManager;
import db.MyEntityManager;

public class AdminConsole {
	
	
	
	public static void run(){
		adminAction();
	}
	
	private static void showAdminMenu(){
		System.out.println("*---------------------------*");
		System.out.println("*\tAdmin console\t\t*");
		System.out.println("*---------------------------*");
		System.out.println("*\t1:Manage books\t\t*");
		System.out.println("*\t2:Manage authors\t*");
		System.out.println("*\t3:Manage clients\t*");
		System.out.println("*\t4:Manage history\t*");
		System.out.println("*---------------------------*");
		System.out.println("*\t0:Exit admin console\t*");
		System.out.println("*---------------------------*");
	}
	private static void adminAction(){

		int number;
		
        do{
        	showAdminMenu();
        	System.out.println("Choose your action:-->");
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
		em.getTransaction().begin();
		
		do{
			System.out.println("*---------------------------*");
			System.out.println("*\tManage clients\t\t*");
			System.out.println("*---------------------------*");
			System.out.println("*\t1:Show clients\t\t*");
			System.out.println("*\t2:Add clients\t\t*");
			System.out.println("*\t3:Del clients\t\t*");
			System.out.println("*---------------------------*");
			System.out.println("*\t0:Exit client manage\t*");
			System.out.println("*---------------------------*");
			
			System.out.println("Choose your action:-->");
			
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
		em.getTransaction().commit();
		em.close();
	}
	private static void manageHistory(){
		
		int mng_history=0;
		EntityManager em=MyEntityManager.getEM();
		em.getTransaction().begin();
		
		do{
			System.out.println("*---------------------------*");
			System.out.println("*\tManage history\t\t*");
			System.out.println("*---------------------------*");
			System.out.println("*\t1:Show history\t\t*");
			System.out.println("*\t2:Del history\t\t*");
			System.out.println("*\t3:Total by date\t\t*");
			System.out.println("*\t4:Total by date&clients\t*");
			System.out.println("*\t5:SuperQuery\t\t*");
			System.out.println("*---------------------------*");
			System.out.println("*\t0:Exit history manage\t*");
			System.out.println("*---------------------------*");
		
			System.out.println("Choose your action:-->");
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
		em.getTransaction().commit();
		em.close();
	}
	private static void manageBooks(){
		
		int mng_book;
		EntityManager em=MyEntityManager.getEM();
		em.getTransaction().begin();
		
		do{
			System.out.println("*---------------------------*");
			System.out.println("*\tManage books\t\t*");
			System.out.println("*---------------------------*");
			System.out.println("*\t1:Show books\t\t*");
			System.out.println("*\t2:Add books\t\t*");
			System.out.println("*\t3:Del books\t\t*");
			System.out.println("*\t4:Add author to book\t*");
			System.out.println("*\t5:Change author\t\t*");
			System.out.println("*\t6:Del author\t\t*");
			System.out.println("*\t7:Change price\t\t*");
			System.out.println("*---------------------------*");
			System.out.println("*\t0:Exit book manage\t*");
			System.out.println("*---------------------------*");

        	System.out.println("Choose your action:-->");
        	
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
		em.getTransaction().commit();
		em.close();
	}
	private static void manageAuthors(){
		
		int mng_author;
		EntityManager em=MyEntityManager.getEM();
		em.getTransaction().begin();
		
		do{
			System.out.println("*---------------------------*");
			System.out.println("*\tManage author\t\t*");
			System.out.println("*---------------------------*");
			System.out.println("*\t1:Show authors\t\t*");
			System.out.println("*\t2:Add author\t\t*");
			System.out.println("*---------------------------*");
			System.out.println("*\t0:Exit author manage\t*");
			System.out.println("*---------------------------*");

        	System.out.println("Choose your action:-->");
        	
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
		em.getTransaction().commit();
		em.close();
	}
}
