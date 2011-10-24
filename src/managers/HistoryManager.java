package managers;

import java.util.List;
import javax.persistence.EntityManager;

import menu.DynamicMenu;

import UI.ConsoleInput;
import UI.ShowMenu;
import UI.ShowTables;

import db.Author;
import db.Client;
import db.MyEntityManager;
import db.Sellhistory;

public class HistoryManager {
	
	
	public static void manageHistory(){
		
		EntityManager em=MyEntityManager.getEM();

		int number;
        
        do{
        	ShowMenu.showMngHistMenu(em);
        	number = ConsoleInput.getInt();
        	if(number==0){
        		continue;
        	}
        	else if(DynamicMenu.getInstance().getMenuElements().get(number)==null){
        		System.out.println("Invalid input,Try again");
        	}
        	else{
        		DynamicMenu.getInstance().getMenuElements().get(number).getAction().action();
        	}
       	}
		while (number!=0);
		
		em.close();
	}
	
	
	public static void deleteEntry(EntityManager em){
		
		System.out.println("*---------------------------*");
		System.out.println("*\tDelete history\t\t*");
		System.out.println("*---------------------------*");
		
		if(ShowTables.showHistory(em)!=0){
			
			Sellhistory s;
			System.out.println("Input entry id to delete:");
			s=em.find(Sellhistory.class,ConsoleInput.getInt());
			if(s==null){
				System.out.println("Entry not find!");
			}
			else{
				em.getTransaction().begin();
				em.remove(s);
				em.getTransaction().commit();
				System.out.println("Entry deleted");
			}
		}
		
	}	
	public static void totalOnDate(EntityManager em){
		
		List<Object[]> l=em.createQuery("select sell.date, sum(book.price) " +
				"from Book as book " +
				"join book.sellhistory as sell " +
				"group by sell.date").getResultList();
		if(l.size()!=0){
			System.out.println("Date\t\tTotal");
			for(Object[] obj:l){
				System.out.println(obj[0].toString().substring(0, 10)+"\t\t"+obj[1]);
			}
		}
		else{
			System.out.println("History not find!");
		}
	}	
	public static void totalOnDateByClient(EntityManager em){
		
		List<Object[]> l=em.createQuery("select client.name, sell.date, sum(book.price) " +
				"from Book as book " +
				"join book.sellhistory as sell " +
				"join sell.client as client " +
				"group by client.name, sell.date").getResultList();
		
		if(l.size()!=0){
			System.out.println("Name\tDate\t\tTotal");
			for(Object[] obj:l){
				System.out.println(obj[0]+"\t"+obj[1].toString().substring(0, 10)+"\t"+obj[2]);
			}
		}
		else{
			System.out.println("History not find!");
		}
	}
	public static void superQuery(EntityManager em){
		
		boolean flag_1=false;
		boolean flag_2=false;
		String begin_date;
		String end_date;
		Author author;
		Client client;
		
		
		if(ShowTables.showAuthors(em)!=0){
			do{
				System.out.println("Input author id:");
				author=em.find(Author.class,ConsoleInput.getInt());
				if(author==null){
					System.out.println("Wrong author id!");
				}
				else{
					flag_1=true;
				}
			}while(!flag_1);
			
			
			if(ShowTables.showClients(em)!=0){
				do{
					System.out.println("Input client id:");
					client=em.find(Client.class,ConsoleInput.getInt());
					if(client==null){
						System.out.println("Wrong client id!");
					}
					else{
						flag_2=true;
					}
				}while(!flag_2);
				
				
				System.out.println("Input begin date(yyyy-MM-dd):");
				begin_date=ConsoleInput.getDate();
				System.out.println("Input end date(yyyy-MM-dd):");
				end_date=ConsoleInput.getDate();;
				
				List<Object[]> l=em.createQuery("select client.name, " +
						"author.name, sell.date, count(*) " +
						"from Author as author " +
						"join author.idbooks as book " +
						"join book.sellhistory as sell " +
						"join sell.client as client " +
						"group by client.name, author.name " +
						"having client.name='"+client.getName()+"' " +
								"and author.name='"+author.getName()+"' " +
								"and sell.date between '"+begin_date+"' " +
										"and '"+end_date+"'").getResultList();
				if(l.size()==0){
					System.out.println("Client\tAuthor\tDate\tQuantity");
					System.out.println(client.getName()+"\t"+author.getName()+"\t-\t0");
				}
				else{
					System.out.println("Client\tAuthor\tDate\t\tQuantity");
					for(int i=0;i<l.size();i++){
						Object[] obj=(Object[]) l.get(i);
						System.out.println(client.getName()+"\t"+author.getName()+"\t"+obj[2].toString().substring(0, 10)+"\t"+obj[3]);
					}
				}
			}
			else{
				System.out.println("Exit super query");
			}
		}
		else{
			System.out.println("Exit super query");
		}
	}
}