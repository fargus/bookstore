package managers;

import java.util.List;

import javax.persistence.EntityManager;

import menu.LoginFreeMenu;
import menu.DynamicMenu;
import menu.Title;

import Security.Security;
import UI.ConsoleInput;
import UI.ShowTables;
import db.Client;
import db.Sellhistory;


public class ClientManager {
	
	private static Title title=new Title("\tYour sellhistory\t");
	
	public static void changeRights(EntityManager em){
		
		boolean flag_1=false;
		Client client=new Client();
		
		if(ShowTables.showClients(em)!=0){
			while(!flag_1){
				System.out.println("\nInput client's id to change rights:");
				client=em.find(Client.class,ConsoleInput.getInt());
				if(client==null){
					System.out.println("Invalid book id!");
				}
				else{
					flag_1=true;
				}
			}
			client.setAdmin(!client.isAdmin());
			em.getTransaction().begin();
			em.flush();
			em.getTransaction().commit();
			System.out.println("Rights change:"+client.getLogin()+" isAdmin-"+client.isAdmin()+"");
		}

	}
	public static void delClient(EntityManager em){
		
		if(ShowTables.showClients(em)!=0){
			Client del_client=new Client();
			System.out.println("Input client id to delete:");
			del_client=em.find(Client.class,ConsoleInput.getInt());
			if(del_client==null){
				System.out.println("Client not find");
			}
			else{
				em.getTransaction().begin();
				em.remove(del_client);
				em.getTransaction().commit();
				System.out.println("Client "+del_client.getName()+" delete");
			}
		}
	}
	public static void showYourHostory(EntityManager em){
		
		if(Security.getInstance().isLoginStatus()){
			title.showTitle();

			List l=em.createQuery("select sell, client.name, book.title  " +
					"from Client as client " +
					"join client.sellhistory as sell " +
					"join sell.book as book " +
					"where client.name='"+Security.getInstance().getUserName()+"'").getResultList();
			if(l.size()==0){
				System.out.println("History not find!");
			}
			else{
				System.out.println("Book\tClient\tPrice\tDate");
				for(int i=0;i<l.size();i++){
					Object[] obj=(Object[]) l.get(i);
					Sellhistory sell=(Sellhistory)obj[0];
					System.out.println(obj[2]+"\t"+obj[1]+"\t"+sell.getPrice()+"\t"+sell.getDate().toString().substring(0, 10));
				}	
			}
		}
		else{
			System.out.println("You are not login!");
		}
		
	}	
}
