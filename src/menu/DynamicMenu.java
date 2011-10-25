package menu;

import java.util.HashMap;

public class DynamicMenu {
	
	private int numOfAction;
	private String menuHeader;
	private String titleHeader;
	private HashMap<Integer, MenuElement> action;
	private static DynamicMenu instance;
	
	private DynamicMenu(){
		numOfAction=0;
		menuHeader="";
		titleHeader="";
		action=new HashMap<Integer, MenuElement>();
	}
	
	public static synchronized DynamicMenu getInstance(){
		if(instance==null){
			instance=new DynamicMenu();
		}
		return instance;
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
	
	public HashMap<Integer, MenuElement> getMenuElements(){
		return action;
	}

	public void cleanMenu(){
		numOfAction=0;
		menuHeader="";
		action.clear();
	}
	
	public void showMenu(){
		
		System.out.println("*---------------------------*");
		System.out.println("*"+menuHeader+"*");
		System.out.println("*---------------------------*");
		for(int i=1;i<=numOfAction;i++){
			System.out.println("* "+i+":"+action.get(i).getName()+"*");
		}
		System.out.println("*---------------------------*");
		System.out.println("*\t0:Exit\t\t\t*");
		System.out.println("*---------------------------*");
		System.out.println("Choose your action:-->");
	}

	public void showTitle(){
		System.out.println("*---------------------------*");
		System.out.println("*"+titleHeader+"*");
		System.out.println("*---------------------------*");
	}
	
	
}
