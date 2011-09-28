package db;

import javax.persistence.*;

public class MyEntityManager {
	private static  EntityManager em=createEM();
	
	private static EntityManager createEM(){
		return Persistence.createEntityManagerFactory("Lib").createEntityManager();
	}
	
	public static EntityManager getEM(){
		return em;
	}
	
}
