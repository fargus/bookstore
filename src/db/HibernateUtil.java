package db;
 
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;
import org.hibernate.SessionFactory;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		
				return new Configuration().configure().buildSessionFactory();
		}
	
	public static SessionFactory getSessionFactory() {
		
		return sessionFactory;
		}
	public static void exportTables(){
		 new SchemaExport(new Configuration().configure()).create(true, true);
    }
	public static void updateTables(){
		 new SchemaUpdate(new Configuration().configure()).execute(true, true);
   }
}