package managers;

import javax.persistence.EntityManager;

import UI.ConsoleInput;
import db.Authors;

public class AuthorManager {

	public static void addAuthor(EntityManager em){
		
		Authors a=new Authors();
		
		System.out.println("*---------------------------*");
		System.out.println("*\tAdd author\t\t*");
		System.out.println("*---------------------------*");
		
		System.out.println("Input author's name:");
		a.setName(ConsoleInput.getString());
		
		em.getTransaction().begin();
		try{
			em.persist(a);
			System.out.println("\n*New author "+a.getName()+" added\t*\n");
		}catch(Exception e){
			System.out.println("Author already exist!");
			em.getTransaction().rollback();
		}
		if(em.getTransaction().isActive()){
			em.getTransaction().commit();
		}
	}
}
