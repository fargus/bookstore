package main;

import db.MyEntityManagerFactory;
import UI.ClientConsole;


public class Application {

	public static void main(String[] args){
		
		ClientConsole.run();
		MyEntityManagerFactory.getInstance().closeEntityManagerFactory();
		System.out.print("Ok");
		
	}
}
