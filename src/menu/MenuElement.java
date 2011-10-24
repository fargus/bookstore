package menu;

public class MenuElement {
	
	private String name;
	private MenuAction action;
	
	public MenuElement(String name, MenuAction action){
		this.name=name;
		this.action=action;
	}
	
	public String getName(){
		return name;
	}
	
	public MenuAction getAction(){
		return action;
	}
}
