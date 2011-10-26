package UI;

import javax.persistence.EntityManager;

import menu.DynamicMenu;

import db.MyEntityManager;

public class ClientConsole {
	
	public static void run(){
		menuAction();
	}
	
	public static void menuAction(){
      
		int number;
		EntityManager em=MyEntityManager.getEM();
		
		do{
			ShowMenu.showMainMenu(em);
        	number = ConsoleInput.getInt();
        	if(number==0){
        		continue;
        	}
        	else if(ShowMenu.getMenu().getMenuElements().get(number)==null){
        		System.out.println("Invalid input,Try again");
        	}
        	else{
        		ShowMenu.getMenu().getMenuElements().get(number).getAction().action();
        	}
        	em.clear();
       	}
		while (number!=0);

        em.close();
	}
}
