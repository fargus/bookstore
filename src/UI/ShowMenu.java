package UI;

import Security.Security;
import managers.AuthorManager;
import managers.BookManager;
import managers.ClientManager;
import managers.HistoryManager;
import menu.LoginRequiredMenu;
import menu.LoginFreeMenu;
import menu.DynamicMenu;
import menu.MenuAction;

public class ShowMenu {
	
	private DynamicMenu mainMenu=new LoginFreeMenu();
	private DynamicMenu adminMenu=new LoginRequiredMenu();
	private DynamicMenu mngClientsMenu=new LoginRequiredMenu();
	private DynamicMenu mngHistMenu=new LoginRequiredMenu();
	private DynamicMenu mngBooksMenu=new LoginRequiredMenu();
	private DynamicMenu mngAuthMenu=new LoginRequiredMenu();
	private DynamicMenu findBookMenu=new LoginFreeMenu();
	private DynamicMenu buyBookMenu=new LoginRequiredMenu();
	private static ShowMenu instance;
	
	private ShowMenu(){
		mainMenu.setHeader("\tWelcome to bookstore\t");
		mainMenu.setAction(" Show books\t\t", new MenuAction(){public void action(){ShowTables.showBooks(mainMenu.getEm());}});
		mainMenu.setAction(" Find books\t\t", new MenuAction(){public void action(){showFindBookMenu();}});
		mainMenu.setAction(" Show authors\t\t", new MenuAction(){public void action(){ShowTables.showAuthors(mainMenu.getEm());}});
		mainMenu.setAction(" Show authors w/o books\t", new MenuAction(){public void action(){ShowTables.showAithorWOBook(mainMenu.getEm());}});
		mainMenu.setAction("Show avg price by author", new MenuAction(){public void action(){ShowTables.showAveragePriceByAuthor(mainMenu.getEm());}});
		mainMenu.setAction("Show author with 2 books*\n*\t\tsold min\t", new MenuAction(){public void action(){ShowTables.showAuth2SoldMin(mainMenu.getEm());}});
		mainMenu.setAction(" Buy book\t\t", new MenuAction(){public void action(){showBuyBookMenu();}});
		mainMenu.setAction(" Show history\t\t", new MenuAction(){public void action(){ClientManager.showYourHostory(mainMenu.getEm());}});
		mainMenu.setAction(" Admin console\t\t", new MenuAction(){public void action(){AdminConsole.run();}});
		
		adminMenu.setHeader("\tAdmin console\t\t");
		adminMenu.setAction(" Manage books\t\t", new MenuAction(){public void action(){showMngBooksMenu();}});
		adminMenu.setAction(" Manage authors\t\t", new MenuAction(){public void action(){showMngAuthMenu();}});
		adminMenu.setAction(" Manage clients\t\t", new MenuAction(){public void action(){showMngClientsMenu();}});
		adminMenu.setAction(" Manage history\t\t", new MenuAction(){public void action(){showMngHistMenu();}});
		
		mngClientsMenu.setHeader("\tManage clients\t\t");
		mngClientsMenu.setAction(" Show clients\t\t", new MenuAction(){public void action(){ShowTables.showClients(mngClientsMenu.getEm());}});
		mngClientsMenu.setAction(" Change rights\t\t", new MenuAction(){public void action(){ClientManager.changeRights(mngClientsMenu.getEm());}});
		mngClientsMenu.setAction(" Del clients\t\t", new MenuAction(){public void action(){ClientManager.delClient(mngClientsMenu.getEm());}});
		
		mngHistMenu.setHeader("\tManage history\t\t");
		mngHistMenu.setAction(" Show history\t\t", new MenuAction(){public void action(){ShowTables.showHistory(mngHistMenu.getEm());}});
		mngHistMenu.setAction(" Del history\t\t", new MenuAction(){public void action(){HistoryManager.deleteEntry(mngHistMenu.getEm());}});
		mngHistMenu.setAction(" Total by date\t\t", new MenuAction(){public void action(){HistoryManager.totalOnDate(mngHistMenu.getEm());}});
		mngHistMenu.setAction(" Total by date&clients\t", new MenuAction(){public void action(){HistoryManager.totalOnDateByClient(mngHistMenu.getEm());}});
		mngHistMenu.setAction(" SuperQuery\t\t", new MenuAction(){public void action(){HistoryManager.superQuery(mngHistMenu.getEm());}});
		
		mngBooksMenu.setHeader("\tManage books\t\t");
		mngBooksMenu.setAction(" Show books\t\t", new MenuAction(){public void action(){ShowTables.showBooks(mngBooksMenu.getEm());}});
		mngBooksMenu.setAction(" Add books\t\t", new MenuAction(){public void action(){BookManager.addBook(mngBooksMenu.getEm());}});
		mngBooksMenu.setAction(" Del books\t\t", new MenuAction(){public void action(){BookManager.delBook(mngBooksMenu.getEm());}});
		mngBooksMenu.setAction(" Add author to book\t", new MenuAction(){public void action(){BookManager.addAuthToBook(mngBooksMenu.getEm());}});
		mngBooksMenu.setAction(" Change author\t\t", new MenuAction(){public void action(){BookManager.changeAuth(mngBooksMenu.getEm());}});
		mngBooksMenu.setAction(" Del author\t\t", new MenuAction(){public void action(){BookManager.delAuthFromBook(mngBooksMenu.getEm());}});
		mngBooksMenu.setAction(" Change price\t\t", new MenuAction(){public void action(){BookManager.changePrice(mngBooksMenu.getEm());}});
		
		mngAuthMenu.setHeader("\tManage author\t\t");
		mngAuthMenu.setAction(" Show authors\t\t", new MenuAction(){public void action(){ShowTables.showAuthors(mngAuthMenu.getEm());}});
		mngAuthMenu.setAction(" Add author\t\t", new MenuAction(){public void action(){AuthorManager.addAuthor(mngAuthMenu.getEm());}});
		
		findBookMenu.setHeader(" Find books\t\t");
		findBookMenu.setAction(" Find by title\t\t", new MenuAction(){public void action(){ShowTables.showBooksByTitle(findBookMenu.getEm());}});
		findBookMenu.setAction(" Find by author\t\t", new MenuAction(){public void action(){ShowTables.showBooksByAuthor(findBookMenu.getEm());}});
		findBookMenu.setAction(" Show pop book by qty\t", new MenuAction(){public void action(){ShowTables.showPopBookByQty(findBookMenu.getEm());}});
		findBookMenu.setAction(" Show pop book by total\t", new MenuAction(){public void action(){ShowTables.showPopBookByTotal(findBookMenu.getEm());}});
		findBookMenu.setAction(" Show unsold book\t", new MenuAction(){public void action(){ShowTables.showUnsoldBooks(findBookMenu.getEm());}});
		
		buyBookMenu.setHeader("\tBuy book\t\t");
		buyBookMenu.setAction(" Select book from list\t", new MenuAction(){public void action(){ShowTables.showBooks(buyBookMenu.getEm());BookManager.buyBook(buyBookMenu.getEm());}});
		buyBookMenu.setAction(" Find book\t\t", new MenuAction(){public void action(){showFindBookMenu();}});
		buyBookMenu.setAction(" Buy book by id\t\t", new MenuAction(){public void action(){BookManager.buyBook(buyBookMenu.getEm());}});
	}
	
	public static ShowMenu getInstance(){
		if(instance==null){
			instance=new ShowMenu();
		}
		return instance;
	}
	
	public void showMainMenu(){
		
		mainMenu.showMenu();
		
	}
	
	public void showAdminMenu(){
		
		if(Security.getInstance().isLoginStatus()){
			if(Security.getInstance().isAdmin()){
				adminMenu.showMenu();
			}
			else{
				System.out.println("You are not admin!");
			}
		}
		else{
			System.out.println("You are not login!");
		}
		
	}
	
	public void showMngClientsMenu(){
		
		mngClientsMenu.showMenu();
		
	}
	
	public void showMngHistMenu(){
		
		mngHistMenu.showMenu();
		
	}
	
	public void showMngBooksMenu(){
		
		mngBooksMenu.showMenu();
		
	}
	
	public void showMngAuthMenu(){
		
		mngAuthMenu.showMenu();
		
	}
	
	public void showFindBookMenu(){
		
		findBookMenu.showMenu();
		
	}
	
	public void showBuyBookMenu(){
		
		if(Security.getInstance().isLoginStatus()){
			buyBookMenu.showMenu();
		}
		else{
			System.out.println("You are not login!");
		}
		
	}

}
