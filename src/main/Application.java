package main;

import Security.Security;
import UI.ClientConsole;


public class Application {

	public static void main(String[] args){
	
		// FIXME : реализуй логин , чтобы юзеры пользовались только своими данными и не могли лазить в чужие.
		//Security.getInstance().logIn("Vadim");
		ClientConsole.run();
		
		//Security.getInstance().logIn("Vadim");
		//Security.getInstance().logOut();
		//System.out.println(Security.getInstance().isLoginStatus());
		//Security.getInstance().registration();
		//Security.getInstance().logIn();
		//System.out.println(Security.getInstance().isLoginStatus());
		System.out.print("Ok");
		
	}
}
