package menu;

import Security.Security;
import UI.ConsoleInput;


public class LoginFreeMenu extends DynamicMenu {

	
	@Override
	public void showMenu() {
		
		int number;
		do{
			setLoginAction(Security.getInstance().isLoginStatus());
			showNames();
        	number = ConsoleInput.getInt();
        	if(number==0){
        		continue;
        	}
        	else if(getMenuElements().get(number)==null){
        		System.out.println("Invalid input,Try again");
        	}
        	else{
        		getMenuElements().get(number).getAction().action();
        	}
        	getEm().clear();
       	}
		while (number!=0);
	}

}
