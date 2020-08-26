package com.sapient.datetimecalculator.dbms;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HistoryDao {
	private SessionFactory factory;

	public HistoryDao() {
		factory = new Configuration().configure().buildSessionFactory();
	}

	public Integer insert(History history) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer id = null;

		try {
			tx = session.beginTransaction();
			id = (Integer) session.save(history);
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

	public History findOne(Integer id) {
		Session session = factory.openSession();
		History history = null;
		try {
			history = (History) session.get(History.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return history;
	}

	public List<History> findOneSession(LocalDateTime date) {
		Session session = factory.openSession();
		Transaction tx = null;
		List<History> historyOneSession = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM History WHERE date = :session_date");
			query.setParameter("session_date", date);
			historyOneSession = query.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return historyOneSession;
	}

	public List<History> find100Sessions() {
		Session session = factory.openSession();
		Transaction tx = null;
		List<History> history100Session = null;
		try {
			tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(
					"SELECT * FROM history H1 WHERE H1.date in (SELECT H.date FROM history H GROUP BY H.date ORDER BY H.date DESC LIMIT 100)");
			query.addEntity(History.class);
			history100Session = query.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return history100Session;
	}

	public List<History> findAll() {
		Session session = factory.openSession();
		Transaction tx = null;
		List<History> historyAll = null;
		try {
			tx = session.beginTransaction();
			historyAll = session.createQuery("FROM History").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return historyAll;
	}

}
