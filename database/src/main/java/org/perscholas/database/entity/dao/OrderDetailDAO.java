package org.perscholas.database.entity.dao;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;  
import org.perscholas.database.entity.Order;
import org.perscholas.database.entity.OrderDetails;

public class OrderDetailDAO {

	public OrderDetails findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();  
		String hql = "From OrderDetails o WHERE o.id = :id";
		TypedQuery<OrderDetails> query = session.createQuery(hql, OrderDetails.class);
		query.setParameter("id",  id);
		
		OrderDetails result = query.getSingleResult();
		return result;
	}
}
