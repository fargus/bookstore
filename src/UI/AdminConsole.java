package UI;

import Security.Security;



public class AdminConsole {
		
	public static void run(){
		adminAction();
	}
	
	private static void adminAction(){

		int number;
	       do{
	       	if(Security.getInstance().isLoginStatus()){
	       		ShowMenu.showAdminMenu();
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
	       	}
	       	else{
	       		number=0;
	       	}
     	}
		while (number!=0);
	}
}
