package org.perscholas.database.entity.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.perscholas.database.entity.Order;
import org.perscholas.database.entity.OrderDetail;

public class OrderDetailDAO {

	public OrderDetail findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();  
		String hql = "From OrderDetail o WHERE o.id = :id";
		TypedQuery<OrderDetail> query = session.createQuery(hql, OrderDetail.class);
		query.setParameter("id",  id);
		
		OrderDetail result = query.getSingleResult();
		session.close();
		return result;
	}

	public void save(OrderDetail orderDetail) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction t = session.beginTransaction();
		session.saveOrUpdate(orderDetail);
		t.commit();
		session.close();
	}

	public OrderDetail findByOrderIdAndProductId(Integer orderId, Integer productId) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "From OrderDetail o WHERE o.order.id = :order_id and o.product.id= :product_id";
		TypedQuery<OrderDetail> query = session.createQuery(hql, OrderDetail.class);
		query.setParameter("order_id",  orderId);
		query.setParameter("product_id",  productId);

		try {
			OrderDetail result = query.getSingleResult();
			session.close();
			return result;
		} catch (NoResultException nre) {
			return null;
		}
	}
}
