package UI;

public class ShowMenu {
	
	public static void showMenu(){
		// FIXME : Dynamic menu 
		// point is to make menu dynamic 
		// which means that you can create new menu items on-the-fly
		// try to implement it . it's up to you how to do this. 
		// the only requirement is to link showing menu item and its action together
		System.out.println("*---------------------------*");
		System.out.println("*\tWelcome to bookstore\t*");
		System.out.println("*---------------------------*");
		System.out.println("*\t1:Show books\t\t*");
		System.out.println("*\t2:Find books\t\t*");
		System.out.println("*\t3:Show authors\t\t*");
		System.out.println("* 4:Show authors w/o books\t*");
		System.out.println("* 5:Show avg price by author*");
		System.out.println("* 6:Show author with 2 books*\n*\t\tsold min\t*");
		System.out.println("*\t7:Bay book\t\t*");
		System.out.println("*\t8:Show history\t\t*");
		System.out.println("*---------------------------*");
		System.out.println("*\t9:Admin console\t\t*");
		System.out.println("*\t0:Exit\t\t\t*");
		System.out.println("*---------------------------*");
		System.out.println("Choose your action:-->");
	}
	
	// FIXME : Dynamic menu 
	public static void showAdminMenu(){
		System.out.println("*---------------------------*");
		System.out.println("*\tAdmin console\t\t*");
		System.out.println("*---------------------------*");
		System.out.println("*\t1:Manage books\t\t*");
		System.out.println("*\t2:Manage authors\t*");
		System.out.println("*\t3:Manage clients\t*");
		System.out.println("*\t4:Manage history\t*");
		System.out.println("*---------------------------*");
		System.out.println("*\t0:Exit admin console\t*");
		System.out.println("*---------------------------*");
		System.out.println("Choose your action:-->");
	}
	
	// FIXME : Dynamic menu 
	public static void showMngClientsMenu(){
		System.out.println("*---------------------------*");
		System.out.println("*\tManage clients\t\t*");
		System.out.println("*---------------------------*");
		System.out.println("*\t1:Show clients\t\t*");
		System.out.println("*\t2:Add clients\t\t*");
		System.out.println("*\t3:Del clients\t\t*");
		System.out.println("*---------------------------*");
		System.out.println("*\t0:Exit client manage\t*");
		System.out.println("*---------------------------*");
		
		System.out.println("Choose your action:-->");
	}
	
	// FIXME : Dynamic menu 
	public static void showMngHistMenu(){
		System.out.println("*---------------------------*");
		System.out.println("*\tManage history\t\t*");
		System.out.println("*---------------------------*");
		System.out.println("*\t1:Show history\t\t*");
		System.out.println("*\t2:Del history\t\t*");
		System.out.println("*\t3:Total by date\t\t*");
		System.out.println("*\t4:Total by date&clients\t*");
		System.out.println("*\t5:SuperQuery\t\t*");
		System.out.println("*---------------------------*");
		System.out.println("*\t0:Exit history manage\t*");
		System.out.println("*---------------------------*");
	
		System.out.println("Choose your action:-->");
	}
	
	// FIXME : Dynamic menu 
	public static void showMngBooksMenu(){
		System.out.println("*---------------------------*");
		System.out.println("*\tManage books\t\t*");
		System.out.println("*---------------------------*");
		System.out.println("*\t1:Show books\t\t*");
		System.out.println("*\t2:Add books\t\t*");
		System.out.println("*\t3:Del books\t\t*");
		System.out.println("*\t4:Add author to book\t*");
		System.out.println("*\t5:Change author\t\t*");
		System.out.println("*\t6:Del author\t\t*");
		System.out.println("*\t7:Change price\t\t*");
		System.out.println("*---------------------------*");
		System.out.println("*\t0:Exit book manage\t*");
		System.out.println("*---------------------------*");

    	System.out.println("Choose your action:-->");
	}
	
	// FIXME : Dynamic menu 
	public static void showMngAuthMenu(){
		System.out.println("*---------------------------*");
		System.out.println("*\tManage author\t\t*");
		System.out.println("*---------------------------*");
		System.out.println("*\t1:Show authors\t\t*");
		System.out.println("*\t2:Add author\t\t*");
		System.out.println("*---------------------------*");
		System.out.println("*\t0:Exit author manage\t*");
		System.out.println("*---------------------------*");

    	System.out.println("Choose your action:-->");
	}
}
