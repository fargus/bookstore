package DAO;

import java.util.Collection;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;


import db.MyEntityManager;

public class ElementDAOImpl<E> implements ElementDAO<E> {
	private Class<E> elementClass;
	private EntityManager em;
	
	public ElementDAOImpl(Class<E> elementClass){
        this.elementClass = elementClass;
        em=MyEntityManager.getEM();
	}
	
	@Override
	public void addElement(E el) {
		em.getTransaction().begin();
		em.persist(el);
		em.getTransaction().commit();
	}

	@Override
	public void updateElement(E el) {
		em.getTransaction().begin();
		em.refresh(el);
		em.getTransaction().commit();
	}

	@Override
	public E getElementByID(int elId) {
		em.getTransaction().begin();
		E e=em.find(elementClass, elId);
		em.getTransaction().commit();
		return e;
	}

	@Override
	public Collection<E> getAllElements() {
		Collection<E> e;
		em.getTransaction().begin();
		e=em.createNativeQuery("select * from "+elementClass.getSimpleName()+"", elementClass).getResultList();
		em.getTransaction().commit();
		return e;
	}

	@Override
	public void deleteElement(E el) {
		em.getTransaction().begin();
		em.remove(el);
		em.getTransaction().commit();
		
	}

}
