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
		
		try{
			em.persist(a);
			System.out.println("\n*New author "+a.getName()+" added\t*\n");
		}catch(Exception e){
			System.out.println("Author already exist!");
		}
	}
}
