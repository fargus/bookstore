package Security;

import java.util.List;

import javax.persistence.EntityManager;

import UI.ConsoleInput;

import menu.Title;

import db.Client;
import db.MyEntityManagerFactory;

public class Security {
	
	private boolean loginStatus;
	private Client user;
	private static Security instance;
	private EntityManager em;
	private Title loginTitle;
	private Title regTitle;
	
	private Security(){
		loginStatus=false;
		em=MyEntityManagerFactory.getInstance().getEntityManagerFactory().createEntityManager();
		loginTitle=new Title("\t\tLogin\t\t");
		regTitle=new Title("\t  Registration\t\t");
	}
	
	public static synchronized Security getInstance(){
		if(instance==null){
			instance=new Security();
		}
		return instance;
	}
	
	public void logIn(){
		loginTitle.showTitle();
		System.out.println("Input login:");
		
		List<Client> l=em.createQuery("from Client as client where client.login='"+ConsoleInput.getString()+"'").getResultList();
		if(l.size()!=0){
			user=l.get(0);
			loginStatus=true;
		}
		else{
			System.out.println("Login not find!");
		}
	}
	
	public void registration(){
		regTitle.showTitle();
		
		Client client=new Client();
		
		System.out.println("Input user name:");
		client.setName(ConsoleInput.getString());
		
		System.out.println("Input user login:");
		client.setLogin(ConsoleInput.getString());
		
		client.setAdmin(false);
		
		em.getTransaction().begin();
		try{
			em.persist(client);
			System.out.println("\n* New user "+client.getLogin()+" added\t*\n");
		}catch(Exception e){
			System.out.println("Login already exist!");
			em.getTransaction().rollback();
		}
		if(em.getTransaction().isActive()){
			em.getTransaction().commit();
		}
	}
	
	public void logOut(){
		loginStatus=false;
		user=null;
	}
	
	public boolean isLoginStatus(){
		return loginStatus;
	}
	
	public String getUserName(){
		return user.getName();
	}
	
	public String getUserLogin(){
		return user.getLogin();
	}
	
	public int getUserId(){
		return user.getId();
	}
	
	public boolean isAdmin(){
		if(user!=null){
			return user.isAdmin();
		}
		return false;
	}
}
