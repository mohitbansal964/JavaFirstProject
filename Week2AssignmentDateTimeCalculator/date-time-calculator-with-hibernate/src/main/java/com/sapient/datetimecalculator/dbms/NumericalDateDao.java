package com.sapient.datetimecalculator.dbms;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class NumericalDateDao {

	private SessionFactory factory;

	public NumericalDateDao() {
		factory = new Configuration().configure().buildSessionFactory();
	}

	public Integer insert(NumericalDate date) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer dateID = null;
		try {
			tx = session.beginTransaction();
			dateID = (Integer) session.save(date);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return dateID;
	}

	public NumericalDate findOne(Integer id) {
		Session session = factory.openSession();
		NumericalDate date = null;
		try {
			date = (NumericalDate) session.get(NumericalDate.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return date;
	}

	public List<NumericalDate> findAll() {
		Session session = factory.openSession();
		Transaction tx = null;
		List<NumericalDate> dates = null;
		try {
			tx = session.beginTransaction();
			dates = session.createQuery("FROM CalculatorInput").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return dates;
	}

}
