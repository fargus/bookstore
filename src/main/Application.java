package main;

import UI.ClientConsole;

// FIXME : Что за абсолютные пути в build path? 
// разберись почему это плохо и исправь.
public class Application {

	public static void main(String[] args){
	
		// FIXME : реализуй логин , чтобы юзеры пользовались только своими данными и не могли лазить в чужие.
		ClientConsole.run();
		System.out.print("Ok");
		
	}
}
