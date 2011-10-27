package managers;

import javax.persistence.EntityManager;

import menu.Title;

import UI.ConsoleInput;
import db.Author;


public class AuthorManager {
	
	private static Title title=new Title("\tAdd author\t\t");
	
	public static void addAuthor(EntityManager em){
		
		Author a=new Author();
		
		title.showTitle();
		
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
