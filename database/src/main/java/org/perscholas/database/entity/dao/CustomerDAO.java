package org.perscholas.database.entity.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.perscholas.database.entity.Customer;

public class CustomerDAO {
//the desired behavior is return single Customer
// null is indicating that is not found
	public Customer findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
//		String hql = "From Customer c WHERE c.id = ?1";
		String hql = "From Customer c WHERE c.id = :id";
		TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
		query.setParameter("id", id);

		try {
			Customer result = query.getSingleResult();
			session.close();
			return result;
		} catch (NoResultException nre) {
			return null;
		}
	}

	public Customer updateFirstName(Integer id, String firstName) {
		Customer save = findById(id);

		save.setContactFirstName(firstName);
		save(save);
		return save;
	}

	public List<Customer> findByFirstName(String fname) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "From Customer c WHERE c.contactFirstName = :firstname";
		TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
		query.setParameter("firstname", fname);

		List<Customer> result = query.getResultList();
		session.close();
		return result;
	}
	
	public void save(Customer customer) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction t = session.beginTransaction();
//		if (customer.getId())
		session.saveOrUpdate(customer);
		t.commit();
		session.close();
//		String hql = "From Customer c WHERE c.contactFirstName = :firstname";
//		TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
//		query.setParameter("firstname", fname);
//
//		List<Customer> result = query.getResultList();
//		return result;
	}
}
