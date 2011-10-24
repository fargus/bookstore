package UI;

import javax.persistence.EntityManager;

import managers.AuthorManager;
import managers.BookManager;
import managers.ClientManager;
import managers.HistoryManager;
import menu.DynamicMenu;
import menu.MenuAction;

public class ShowMenu {
	
	public static void showMainMenu(final EntityManager em){
		
		DynamicMenu.getInstance().cleanMenu();
		DynamicMenu.getInstance().setHeader("\tWelcome to bookstore\t");
		DynamicMenu.getInstance().setAction("\tShow books\t\t", new MenuAction(){public void action(){ShowTables.showBooks(em);}});
		DynamicMenu.getInstance().setAction("\tFind books\t\t", new MenuAction(){public void action(){BookManager.findBooks(em);}});
		DynamicMenu.getInstance().setAction("\tShow authors\t\t", new MenuAction(){public void action(){ShowTables.showAuthors(em);}});
		DynamicMenu.getInstance().setAction("Show authors w/o books\t", new MenuAction(){public void action(){ShowTables.showAithorWOBook(em);}});
		DynamicMenu.getInstance().setAction("Show avg price by author", new MenuAction(){public void action(){ShowTables.showAveragePriceByAuthor(em);}});
		DynamicMenu.getInstance().setAction("Show author with 2 books*\n*\t\tsold min\t", new MenuAction(){public void action(){ShowTables.showAuth2SoldMin(em);}});
		DynamicMenu.getInstance().setAction("\tBuy book\t\t", new MenuAction(){public void action(){BookManager.buyBookMenu(em);}});
		DynamicMenu.getInstance().setAction("\tShow history\t\t", new MenuAction(){public void action(){ClientManager.showYourHostory(em);}});
		DynamicMenu.getInstance().setAction("\tAdmin console\t\t", new MenuAction(){public void action(){AdminConsole.run();}});
		DynamicMenu.getInstance().showMenu();
	}
	
	public static void showAdminMenu(){
		
		DynamicMenu.getInstance().cleanMenu();
		DynamicMenu.getInstance().setHeader("\tAdmin console\t\t");
		DynamicMenu.getInstance().setAction("\tManage books\t\t", new MenuAction(){public void action(){BookManager.manageBooks();}});
		DynamicMenu.getInstance().setAction("\tManage authors\t", new MenuAction(){public void action(){AuthorManager.manageAuthors();}});
		DynamicMenu.getInstance().setAction("\tManage clients\t", new MenuAction(){public void action(){ClientManager.manageClients();}});
		DynamicMenu.getInstance().setAction("\tManage history\t", new MenuAction(){public void action(){HistoryManager.manageHistory();}});
		DynamicMenu.getInstance().showMenu();
		
	}
	
	public static void showMngClientsMenu(final EntityManager em){
	
		DynamicMenu.getInstance().cleanMenu();
		DynamicMenu.getInstance().setHeader("\tManage clients\t\t");
		DynamicMenu.getInstance().setAction("\tShow clients\t\t", new MenuAction(){public void action(){ShowTables.showClients(em);}});
		DynamicMenu.getInstance().setAction("\tAdd clients\t\t", new MenuAction(){public void action(){ClientManager.addClient(em);}});
		DynamicMenu.getInstance().setAction("\tDel clients\t\t", new MenuAction(){public void action(){ClientManager.delClient(em);}});
		DynamicMenu.getInstance().showMenu();
		
	}
	
	public static void showMngHistMenu(final EntityManager em){
		
		DynamicMenu.getInstance().cleanMenu();
		DynamicMenu.getInstance().setHeader("\tManage history\t\t");
		DynamicMenu.getInstance().setAction("\tShow history\t\t", new MenuAction(){public void action(){ShowTables.showHistory(em);}});
		DynamicMenu.getInstance().setAction("\tDel history\t\t", new MenuAction(){public void action(){HistoryManager.deleteEntry(em);}});
		DynamicMenu.getInstance().setAction("\tTotal by date\t\t", new MenuAction(){public void action(){HistoryManager.totalOnDate(em);}});
		DynamicMenu.getInstance().setAction("\tTotal by date&clients\t", new MenuAction(){public void action(){HistoryManager.totalOnDateByClient(em);}});
		DynamicMenu.getInstance().setAction("\tSuperQuery\t\t", new MenuAction(){public void action(){HistoryManager.superQuery(em);}});
		DynamicMenu.getInstance().showMenu();
		
	}
	
	public static void showMngBooksMenu(final EntityManager em){
		
    	DynamicMenu.getInstance().cleanMenu();
		DynamicMenu.getInstance().setHeader("\tManage books\t\t");
		DynamicMenu.getInstance().setAction("\tShow books\t\t", new MenuAction(){public void action(){ShowTables.showBooks(em);}});
		DynamicMenu.getInstance().setAction("\tAdd books\t\t", new MenuAction(){public void action(){BookManager.addBook(em);}});
		DynamicMenu.getInstance().setAction("\tDel books\t\t", new MenuAction(){public void action(){BookManager.delBook(em);}});
		DynamicMenu.getInstance().setAction("\tAdd author to book\t", new MenuAction(){public void action(){BookManager.addAuthToBook(em);}});
		DynamicMenu.getInstance().setAction("\tChange author\t\t", new MenuAction(){public void action(){BookManager.changeAuth(em);}});
		DynamicMenu.getInstance().setAction("\tDel author\t\t", new MenuAction(){public void action(){BookManager.delAuthFromBook(em);}});
		DynamicMenu.getInstance().setAction("\tChange price\t\t", new MenuAction(){public void action(){BookManager.changePrice(em);}});
		DynamicMenu.getInstance().showMenu();
		
	}
	
	public static void showMngAuthMenu(final EntityManager em){

    	DynamicMenu.getInstance().cleanMenu();
		DynamicMenu.getInstance().setHeader("\tManage author\t\t");
		DynamicMenu.getInstance().setAction("\tShow authors\t\t", new MenuAction(){public void action(){ShowTables.showAuthors(em);}});
		DynamicMenu.getInstance().setAction("\tAdd author\t\t", new MenuAction(){public void action(){AuthorManager.addAuthor(em);}});
		DynamicMenu.getInstance().showMenu();
		
	}
	
	public static void showFindBookMenu(final EntityManager em){
		
		DynamicMenu.getInstance().cleanMenu();
		DynamicMenu.getInstance().setHeader("\tFind books\t\t");
		DynamicMenu.getInstance().setAction("\tFind by title\t\t", new MenuAction(){public void action(){ShowTables.showBooksByTitle(em);}});
		DynamicMenu.getInstance().setAction("\tFind by author\t", new MenuAction(){public void action(){ShowTables.showBooksByAuthor(em);}});
		DynamicMenu.getInstance().setAction("Show pop book by qty\t", new MenuAction(){public void action(){ShowTables.showPopBookByQty(em);}});
		DynamicMenu.getInstance().setAction("Show pop book by total\t", new MenuAction(){public void action(){ShowTables.showPopBookByTotal(em);}});
		DynamicMenu.getInstance().setAction("\tShow unsold book\t", new MenuAction(){public void action(){ShowTables.showUnsoldBooks(em);}});
		DynamicMenu.getInstance().showMenu();
		
	}
	
	public static void showBuyBookMenu(final EntityManager em){
		DynamicMenu.getInstance().cleanMenu();
		DynamicMenu.getInstance().setHeader("\tBuy book\t\t");
		DynamicMenu.getInstance().setAction("\tSelect book from list\t", new MenuAction(){public void action(){ShowTables.showBooks(em);BookManager.buyBook(em);}});
		DynamicMenu.getInstance().setAction("\tFind book\t\t", new MenuAction(){public void action(){BookManager.findBooks(em);}});
		DynamicMenu.getInstance().setAction("\tBuy book by id\t", new MenuAction(){public void action(){BookManager.buyBook(em);}});
		DynamicMenu.getInstance().showMenu();
	}
}
