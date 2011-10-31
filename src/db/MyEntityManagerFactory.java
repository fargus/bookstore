package db;

import javax.persistence.*;

public class MyEntityManagerFactory {

	private static final MyEntityManagerFactory instance=new MyEntityManagerFactory();
	protected EntityManagerFactory emf;
	
	private MyEntityManagerFactory(){ 
	}
	
	public static MyEntityManagerFactory getInstance(){
		return instance;
	}
	
	public EntityManagerFactory getEntityManagerFactory(){
		if (emf == null){
			this.emf = Persistence.createEntityManagerFactory("Lib");
		}	
		return emf;
	}
	
	public void closeEntityManagerFactory() {
	    
	    if (emf != null) {
	      emf.close();
	      emf = null;
	  }
	}
}
