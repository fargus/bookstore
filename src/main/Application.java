package main;

import javax.persistence.EntityManager;

import db.MyEntityManager;

import menu.DynamicMenu;
import menu.MenuAction;
import UI.ClientConsole;
import UI.ShowTables;

public class Application {

	public static void main(String[] args){
	
		// FIXME : реализуй логин , чтобы юзеры пользовались только своими данными и не могли лазить в чужие.
		ClientConsole.run();
		
		/*final EntityManager em=MyEntityManager.getEM();
		
		DynamicMenu.getInstance().setHeader("\tHello\t");
		DynamicMenu.getInstance().setAction("showBooks", new MenuAction(){public void action(){ShowTables.showBooks(em);}});
		DynamicMenu.getInstance().showMenu();
		*/
		
		System.out.print("Ok");
		
	}
}
