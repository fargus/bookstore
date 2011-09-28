package DAO;

import java.util.Collection;

public interface ElementDAO<E> {
	 public void addElement(E el); 
     public void updateElement(E el); 
     public E getElementByID(int elId); 
     public Collection<E> getAllElements(); 
     public void deleteElement(E el); 

}
