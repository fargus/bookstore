package menu;

import java.util.HashMap;

import Security.Security;
import UI.ClientConsole;
import UI.ShowMenu;

public class DynamicMenu {
	
	private int numOfAction;
	private String menuHeader;
	private String titleHeader;
	private HashMap<Integer, MenuElement> action;
	private static DynamicMenu instance;
	
	public DynamicMenu(){
		numOfAction=0;
		menuHeader="";
		titleHeader="";
		action=new HashMap<Integer, MenuElement>();
		action.put(88, new MenuElement("Registration\t\t",
				new MenuAction(){public void action(){Security.getInstance().registration();}}));
	}
	
	public static synchronized DynamicMenu getInstance(){
		return instance=new DynamicMenu();
	}

	public void setHeader(String header) {
		this.menuHeader = header;
	}
	
	public String getMenuHeader(){
		return menuHeader;
	}
	
	public void setTitleHeader(String titleHeader) {
		this.titleHeader = titleHeader;
	}

	public String getTitleHeader() {
		return titleHeader;
	}

	public void setAction(String name,MenuAction action) {
		numOfAction++;
		this.action.put(numOfAction, new MenuElement(name, action));
	}
	
	public void setLoginAction(boolean status){
		if(status){
			action.put(99, new MenuElement("Logout:"+Security.getInstance().getUserLogin()+"\t\t",
					new MenuAction(){public void action(){Security.getInstance().logOut();}}));
		}
		else{
			action.put(99, new MenuElement("Login\t\t\t",
					new MenuAction(){public void action(){Security.getInstance().logIn();}}));
		}
	}
	
	public HashMap<Integer, MenuElement> getMenuElements(){
		return action;
	}

	public void cleanMenu(){
		for(int i=1;i<=numOfAction;i++){
			action.remove(i);
		}
		numOfAction=0;
		menuHeader="";
	}
	
	public void showMenu(){
		
		System.out.println("*---------------------------*");
		System.out.println("*"+menuHeader+"*");
		System.out.println("*---------------------------*");
		for(int i=1;i<=numOfAction;i++){
			System.out.println("* "+i+":"+action.get(i).getName()+"*");
		}
		System.out.println("*---------------------------*");
		System.out.println("* "+88+":"+action.get(88).getName()+"*");
		System.out.println("* "+99+":"+action.get(99).getName()+"*");
		System.out.println("* 0:Exit\t\t\t*");
		System.out.println("*---------------------------*");
		System.out.println("Choose your action:-->");
	}

	public void showTitle(){
		System.out.println("*---------------------------*");
		System.out.println("*"+titleHeader+"*");
		System.out.println("*---------------------------*");
	}
	
	
}
