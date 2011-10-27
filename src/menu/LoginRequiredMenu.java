package menu;

import Security.Security;
import UI.ConsoleInput;

public class LoginRequiredMenu extends DynamicMenu {

	@Override
	public void showMenu() {
		int number;
	       do{
	       	if(Security.getInstance().isLoginStatus()){
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
	       	}
	       	else{
	       		number=0;
	       	}
  	}
		while (number!=0);

	}

}
