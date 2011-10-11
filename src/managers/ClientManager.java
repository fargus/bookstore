package managers;

import javax.persistence.EntityManager;

import UI.ConsoleInput;
import UI.ShowTables;
import db.Clients;

public class ClientManager {
	
	public static void addClient(EntityManager em){
		Clients new_client=new Clients();
		
		System.out.println("Input client name:");	
		new_client.setName(ConsoleInput.getString());
		
		try{
			em.persist(new_client);	
			System.out.println("New client "+new_client.getName()+" added");
		}catch(Exception e){
			System.out.println("Client already exist!");
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
				em.remove(del_client);
				System.out.println("Client "+del_client.getName()+" delete");
			}
		}
	}
}
