package UI;

import menu.DynamicMenu;


public class AdminConsole {
		
	public static void run(){
		adminAction();
	}
	
	private static void adminAction(){

        int number;
        
        do{
        	ShowMenu.showAdminMenu();
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
