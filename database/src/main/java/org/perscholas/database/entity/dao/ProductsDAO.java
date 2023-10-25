package org.perscholas.database.entity.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.perscholas.database.entity.Customer;
import org.perscholas.database.entity.Product;

import java.util.List;

public class ProductsDAO {

	public Product findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
//		String hql = "From Customer c WHERE c.id = ?1";
		String hql = "From Product p WHERE p.id = :id";
		TypedQuery<Product> query = session.createQuery(hql, Product.class);
		query.setParameter("id",  id);
		try {
			Product result = query.getSingleResult();
			return result;
		} catch (NoResultException nre) {
			return null;
		}
	}

	public List<Product> findByName(String productName) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
//		String hql = "From Customer c WHERE c.id = ?1";
		String hql = "From Product p WHERE p.productName like :productName ";
		TypedQuery<Product> query = session.createQuery(hql, Product.class);
		query.setParameter("productName",  "%"+productName+"%");

		List<Product> result = query.getResultList();
		return result;
	}
}
