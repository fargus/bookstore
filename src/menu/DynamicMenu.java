package menu;

import java.util.HashMap;

import javax.persistence.EntityManager;

import db.MyEntityManager;

import Security.Security;

public abstract class DynamicMenu {
	
	private int numOfAction;
	private String menuHeader;
	private HashMap<Integer, MenuElement> action;
	private EntityManager em;
	
	public DynamicMenu(){
		numOfAction=0;
		menuHeader="";
		em=MyEntityManager.getEM();
		action=new HashMap<Integer, MenuElement>();
		action.put(88, new MenuElement("Registration\t\t",
				new MenuAction(){public void action(){Security.getInstance().registration();}}));
	}

	public void setHeader(String header) {
		this.menuHeader = header;
	}
	
	public String getMenuHeader(){
		return menuHeader;
	}
	
	public EntityManager getEm() {
		return em;
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
	
	public void showNames(){
		
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
	
	public abstract void showMenu();

}
