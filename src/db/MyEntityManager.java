package db;

import javax.persistence.*;

public class MyEntityManager {
	
	// FIXME : так ты разобрался с entity manager factory ? 
	// еще одна попытка тебе  исправить это.
	public static EntityManager getEM(){
		return Persistence.createEntityManagerFactory("Lib").createEntityManager();
	}
	
}
