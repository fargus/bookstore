package managers;

import javax.persistence.EntityManager;

import menu.DynamicMenu;

import UI.ConsoleInput;
import UI.ShowMenu;
import UI.ShowTables;
import db.Author;
import db.MyEntityManager;

public class AuthorManager {
	
	public static void manageAuthors(){
		
		EntityManager em=MyEntityManager.getEM();
		
		int number;
        
        do{
        	ShowMenu.showMngAuthMenu(em);
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
	

	public static void addAuthor(EntityManager em){
		
		Author a=new Author();
		
		DynamicMenu.getInstance().setTitleHeader("\tAdd author\t\t");
		DynamicMenu.getInstance().showTitle();
		
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
