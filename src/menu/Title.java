package menu;

public class Title {
	
	private String title;
	
	public Title(){
		title="";
	}
	
	public Title(String title){
		this.title=title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void showTitle(){
		System.out.println("*---------------------------*");
		System.out.println("*"+title+"*");
		System.out.println("*---------------------------*");
	}
	
}
