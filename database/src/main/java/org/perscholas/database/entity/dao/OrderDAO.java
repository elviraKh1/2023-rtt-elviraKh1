package org.perscholas.database.entity.dao;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;  
import org.perscholas.database.entity.Order;

public class OrderDAO {

	public Order findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();  
		String hql = "From Order o WHERE o.id = :id";
		TypedQuery<Order> query = session.createQuery(hql, Order.class);
		query.setParameter("id",  id);
		
		Order result = query.getSingleResult();
		return result;
	}
}
