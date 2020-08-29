package com.sapient.datetimecalculator.dbms;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CalculatorOutputDao {
	private SessionFactory factory;

	public CalculatorOutputDao() {
		factory = new Configuration().configure().buildSessionFactory();
	}

	public Integer insert(CalculatorOutput output) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer id = null;

		try {
			tx = session.beginTransaction();
			id = (Integer) session.save(output);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return id;
	}
}
