package org.perscholas.database.entity.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.perscholas.database.entity.Customer;
import org.perscholas.database.entity.Order;

public class OrderDAO {

	public Order findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();  
		String hql = "From Order o WHERE o.id = :id";
		TypedQuery<Order> query = session.createQuery(hql, Order.class);
		query.setParameter("id",  id);
		
		try {
			Order result = query.getSingleResult();
			return result;
		} catch (NoResultException nre) {
			return null;
		}
	}

	public List<Order> findByCustomerId(Integer customerId) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
//		Customer customer = new Customer();
//		customer.setId(customerId);
		String hql = "From Order o WHERE o.customer.id = :customerId";
		TypedQuery<Order> query = session.createQuery(hql, Order.class);
//		query.setParameter("customerObj",  customer);
		query.setParameter("customerId",  customerId);
		List<Order> result = query.getResultList();
		session.close();
		return result;
	}
	
	public void save(Order order) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();  
		org.hibernate.Transaction t = session.beginTransaction();
		session.saveOrUpdate(order);
		t.commit();
		session.close();
	}
	
}
