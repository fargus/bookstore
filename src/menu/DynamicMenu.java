package menu;

import java.util.HashMap;

public class DynamicMenu {
	
	private int numOfAction;
	private String header;
	private HashMap<Integer, MenuElement> action;
	private static DynamicMenu instance;
	
	private DynamicMenu(){
		numOfAction=0;
		header="";
		action=new HashMap<Integer, MenuElement>();
	}
	
	public static synchronized DynamicMenu getInstance(){
		if(instance==null){
			instance=new DynamicMenu();
		}
		return instance;
	}

	public void setHeader(String header) {
		this.header = header;
	}
	
	public String getHeader(){
		return header;
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
		header="";
		action.clear();
	}
	
	public void showMenu(){
		
		System.out.println("*---------------------------*");
		System.out.println("*"+header+"*");
		System.out.println("*---------------------------*");
		for(int i=1;i<=numOfAction;i++){
			System.out.println("* "+i+":"+action.get(i).getName()+"*");
		}
		System.out.println("*---------------------------*");
		System.out.println("*\t0:Exit\t\t\t*");
		System.out.println("*---------------------------*");
		System.out.println("Choose your action:-->");
	}
	
	
}
