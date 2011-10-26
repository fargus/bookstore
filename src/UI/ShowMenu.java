package UI;

import javax.persistence.EntityManager;

import Security.Security;

import managers.AuthorManager;
import managers.BookManager;
import managers.ClientManager;
import managers.HistoryManager;
import menu.DynamicMenu;
import menu.MenuAction;

public class ShowMenu {
	
	private static DynamicMenu menu=new DynamicMenu();
	
	public static void showMainMenu(final EntityManager em){
		
		getMenu().cleanMenu();
		getMenu().setLoginAction(Security.getInstance().isLoginStatus());
		getMenu().setHeader("\tWelcome to bookstore\t");
		getMenu().setAction(" Show books\t\t", new MenuAction(){public void action(){ShowTables.showBooks(em);}});
		getMenu().setAction(" Find books\t\t", new MenuAction(){public void action(){BookManager.findBooks(em);}});
		getMenu().setAction(" Show authors\t\t", new MenuAction(){public void action(){ShowTables.showAuthors(em);}});
		getMenu().setAction(" Show authors w/o books\t", new MenuAction(){public void action(){ShowTables.showAithorWOBook(em);}});
		getMenu().setAction("Show avg price by author", new MenuAction(){public void action(){ShowTables.showAveragePriceByAuthor(em);}});
		getMenu().setAction("Show author with 2 books*\n*\t\tsold min\t", new MenuAction(){public void action(){ShowTables.showAuth2SoldMin(em);}});
		if(Security.getInstance().isLoginStatus()){
			getMenu().setAction(" Buy book\t\t", new MenuAction(){public void action(){BookManager.buyBookMenu(em);}});
			getMenu().setAction(" Show history\t\t", new MenuAction(){public void action(){ClientManager.showYourHostory(em);}});
			if(Security.getInstance().isAdmin()){
				getMenu().setAction(" Admin console\t\t", new MenuAction(){public void action(){AdminConsole.run();}});
			}
		}
		
		getMenu().showMenu();
		
	}
	
	public static void showAdminMenu(){
		
		getMenu().cleanMenu();
		getMenu().setLoginAction(Security.getInstance().isLoginStatus());
		getMenu().setHeader("\tAdmin console\t\t");
		getMenu().setAction(" Manage books\t\t", new MenuAction(){public void action(){BookManager.manageBooks();}});
		getMenu().setAction(" Manage authors\t\t", new MenuAction(){public void action(){AuthorManager.manageAuthors();}});
		getMenu().setAction(" Manage clients\t\t", new MenuAction(){public void action(){ClientManager.manageClients();}});
		getMenu().setAction(" Manage history\t\t", new MenuAction(){public void action(){HistoryManager.manageHistory();}});
		
		getMenu().showMenu();
		
	}
	
	public static void showMngClientsMenu(final EntityManager em){
		
		getMenu().cleanMenu();
		getMenu().setLoginAction(Security.getInstance().isLoginStatus());
		getMenu().setHeader("\tManage clients\t\t");
		getMenu().setAction(" Show clients\t\t", new MenuAction(){public void action(){ShowTables.showClients(em);}});
		getMenu().setAction(" Change rights\t\t", new MenuAction(){public void action(){ClientManager.changeRights(em);}});
		getMenu().setAction(" Del clients\t\t", new MenuAction(){public void action(){ClientManager.delClient(em);}});
		
		getMenu().showMenu();
		
	}
	
	public static void showMngHistMenu(final EntityManager em){
		
		getMenu().cleanMenu();
		getMenu().setLoginAction(Security.getInstance().isLoginStatus());
		getMenu().setHeader("\tManage history\t\t");
		getMenu().setAction(" Show history\t\t", new MenuAction(){public void action(){ShowTables.showHistory(em);}});
		getMenu().setAction(" Del history\t\t", new MenuAction(){public void action(){HistoryManager.deleteEntry(em);}});
		getMenu().setAction(" Total by date\t\t", new MenuAction(){public void action(){HistoryManager.totalOnDate(em);}});
		getMenu().setAction(" Total by date&clients\t", new MenuAction(){public void action(){HistoryManager.totalOnDateByClient(em);}});
		getMenu().setAction(" SuperQuery\t\t", new MenuAction(){public void action(){HistoryManager.superQuery(em);}});
		
		getMenu().showMenu();
		
	}
	
	public static void showMngBooksMenu(final EntityManager em){
		
		getMenu().cleanMenu();
		getMenu().setLoginAction(Security.getInstance().isLoginStatus());
		getMenu().setHeader("\tManage books\t\t");
		getMenu().setAction(" Show books\t\t", new MenuAction(){public void action(){ShowTables.showBooks(em);}});
		getMenu().setAction(" Add books\t\t", new MenuAction(){public void action(){BookManager.addBook(em);}});
		getMenu().setAction(" Del books\t\t", new MenuAction(){public void action(){BookManager.delBook(em);}});
		getMenu().setAction(" Add author to book\t", new MenuAction(){public void action(){BookManager.addAuthToBook(em);}});
		getMenu().setAction(" Change author\t\t", new MenuAction(){public void action(){BookManager.changeAuth(em);}});
		getMenu().setAction(" Del author\t\t", new MenuAction(){public void action(){BookManager.delAuthFromBook(em);}});
		getMenu().setAction(" Change price\t\t", new MenuAction(){public void action(){BookManager.changePrice(em);}});
		
		getMenu().showMenu();
		
	}
	
	public static void showMngAuthMenu(final EntityManager em){

		getMenu().cleanMenu();
		getMenu().setLoginAction(Security.getInstance().isLoginStatus());
		getMenu().setHeader("\tManage author\t\t");
		getMenu().setAction(" Show authors\t\t", new MenuAction(){public void action(){ShowTables.showAuthors(em);}});
		getMenu().setAction(" Add author\t\t", new MenuAction(){public void action(){AuthorManager.addAuthor(em);}});
		
		getMenu().showMenu();
		
	}
	
	public static void showFindBookMenu(final EntityManager em){
		
		getMenu().cleanMenu();
		getMenu().setLoginAction(Security.getInstance().isLoginStatus());
		getMenu().setHeader(" Find books\t\t");
		getMenu().setAction(" Find by title\t\t", new MenuAction(){public void action(){ShowTables.showBooksByTitle(em);}});
		getMenu().setAction(" Find by author\t\t", new MenuAction(){public void action(){ShowTables.showBooksByAuthor(em);}});
		getMenu().setAction(" Show pop book by qty\t", new MenuAction(){public void action(){ShowTables.showPopBookByQty(em);}});
		getMenu().setAction(" Show pop book by total\t", new MenuAction(){public void action(){ShowTables.showPopBookByTotal(em);}});
		getMenu().setAction(" Show unsold book\t", new MenuAction(){public void action(){ShowTables.showUnsoldBooks(em);}});
		
		getMenu().showMenu();
		
	}
	
	public static void showBuyBookMenu(final EntityManager em){
		
		getMenu().cleanMenu();
		getMenu().setLoginAction(Security.getInstance().isLoginStatus());
		getMenu().setHeader("\tBuy book\t\t");
		getMenu().setAction(" Select book from list\t", new MenuAction(){public void action(){ShowTables.showBooks(em);BookManager.buyBook(em);}});
		getMenu().setAction(" Find book\t\t", new MenuAction(){public void action(){BookManager.findBooks(em);}});
		getMenu().setAction(" Buy book by id\t\t", new MenuAction(){public void action(){BookManager.buyBook(em);}});
		
		getMenu().showMenu();
		
	}

	public static DynamicMenu getMenu() {
		return menu;
	}
}
