package managers;

import java.util.List;

import javax.persistence.EntityManager;

import UI.ConsoleInput;
import UI.ShowTables;
import db.Clients;
import db.Sellhistory;

public class ClientManager {
	
	public static void addClient(EntityManager em){
		
		Clients new_client=new Clients();
		
		System.out.println("Input client name:");	
		new_client.setName(ConsoleInput.getString());
		
		em.getTransaction().begin();
		try{
			em.persist(new_client);	
			System.out.println("New client "+new_client.getName()+" added");
		}catch(Exception e){
			System.out.println("Client already exist!");
			em.getTransaction().rollback();
		}
		if(em.getTransaction().isActive()){
			em.getTransaction().commit();
		}
	}
	public static void delClient(EntityManager em){
		
		if(ShowTables.showClients(em)!=0){
			Clients del_client=new Clients();
			System.out.println("Input client id to delete:");
			del_client=em.find(Clients.class,ConsoleInput.getInt());
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
		// FIXME : переменная объявляется там где используется , это не паскаль
		List l;
		
		System.out.println("*---------------------------*");
		System.out.println("*\tYour sellhistory\t*");
		System.out.println("*---------------------------*");
		System.out.println("Input your name:-->");

		l=em.createQuery("select sell, client.name, book.title  " +
				"from Clients as client " +
				"join client.sellhistory as sell " +
				"join sell.book as book " +
				"where client.name='"+ConsoleInput.getString()+"'").getResultList();
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
}
