package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import db.Authors;
import db.Books;
import db.Clients;
import db.MyEntityManager;
import db.Sellhistory;

public class ConsoleClient {
	private static EntityManager em=MyEntityManager.getEM();
	
	public static void run(){
		System.out.println("Input your HQL query:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = null;
        try {
			while (!(tmp = br.readLine()).equals("quit")) {
			    System.out.println(tmp);
			    Query q=em.createQuery(tmp);
			    List l=q.getResultList();
			    if(!l.isEmpty()){printDefaultTable(l);}
			    System.out.println("Input your HQL query:");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Invalid query!");
			run();
		}
		
	}
	
	private static void printBooksTable(Object row){
		Books b=(Books)row;
	    	System.out.print(b.getId()+"\t"+b.getTitle()+"\t"+b.getPrice()+"\t");
		
	}
	
	private static void printAuthorsTable(Object row){
		Authors a=(Authors)row;
	    	System.out.print(a.getId()+"\t"+a.getName()+"\t");
		
	}
	private static void printClientsTable(Object row){
		Clients c=(Clients)row;
	    	System.out.println(c.getId()+"\t"+c.getName()+"\t");
	}
	private static void printSellTable(Object row){
		Sellhistory s=(Sellhistory)row;
	    	System.out.println(s.getId()+"\t"+s.getDate()+"\t"+s.getIdbooks()+"\t"+s.getIdclients()+"\t"+s.getPrice()+"\t");
	}
	private static void printDefaultTable(List l){
		String s=l.get(0).getClass().getSimpleName().toString();
		if(s.equals("Books")||s.equals("Authors")||s.equals("Clients")||s.equals("Sellhistory")){
			for(int j=0;j<l.size();j++){
				if(l.get(j) instanceof Books){printBooksTable(l.get(j));}
		    	else if (l.get(j) instanceof Authors){printAuthorsTable(l.get(j));}
		    	else if (l.get(j) instanceof Clients){printClientsTable(l.get(j));}
		    	else if (l.get(j) instanceof Sellhistory){printSellTable(l.get(j));}
				System.out.println();
			}
			
		}
		else if(s.equals("Object[]")){
			for(int i=0;i<l.size();i++){
				Object[] row=(Object[])l.get(i);
				//System.out.println(row.length);
				for(int j=0;j<row.length;j++){
					//System.out.println(row[j].getClass());
					if(row[j] instanceof Books){printBooksTable(row[j]);}
					else if (row[j] instanceof Authors){printAuthorsTable(row[j]);}
					else if (row[j] instanceof Clients){printClientsTable(l);}
					else if (row[j] instanceof Sellhistory){printSellTable(l);}
					else{System.out.print(row[j]+"\t");}
				}
				System.out.println();
			}

		}
		else{
			for(int i=0;i<l.size();i++){
				System.out.println(l.get(i));
			}
		}
	}
}
