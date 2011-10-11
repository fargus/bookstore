package db;

import javax.persistence.*;

public class MyEntityManager {
	
	public static EntityManager getEM(){
		return Persistence.createEntityManagerFactory("Lib").createEntityManager();
	}
	
}
