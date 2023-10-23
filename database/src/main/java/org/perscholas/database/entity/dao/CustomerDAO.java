package org.perscholas.database.entity.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.perscholas.database.entity.Customer;

public class CustomerDAO {

	public Customer findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
//		String hql = "From Customer c WHERE c.id = ?1";
		String hql = "From Customer c WHERE c.id = :id";
		TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
		query.setParameter("id", id);

		Customer result = query.getSingleResult();
		return result;
	}

	public List<Customer> findByFirstName(String fname) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "From Customer c WHERE c.contactFirstName = :firstname";
		TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
		query.setParameter("firstname", fname);

		List<Customer> result = query.getResultList();
		return result;
	}
}
