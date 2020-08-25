package com.sapient.datetimecalculator.dbms;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CalculatorInputDao {
	private SessionFactory factory;

	public CalculatorInputDao() {
		factory = new Configuration().configure().buildSessionFactory();
	}

	public Integer insert(int choice, LocalDateTime date1, LocalDateTime date2, NumericalDate date3) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer inputID = null;

		try {
			tx = session.beginTransaction();
			CalculatorInput input = new CalculatorInput(choice, date1, date2, date3);
			inputID = (Integer) session.save(input);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return inputID;
	}

	public CalculatorInput findOne(Integer id) {
		Session session = factory.openSession();
		CalculatorInput input = null;
		try {
			input = (CalculatorInput) session.get(CalculatorInput.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return input;
	}

	public List<CalculatorInput> findAll() {
		Session session = factory.openSession();
		Transaction tx = null;
		List<CalculatorInput> inputs = null;
		try {
			tx = session.beginTransaction();
			inputs = session.createQuery("FROM CalculatorInput").list();
//			for (Iterator iterator = inputs.iterator(); iterator.hasNext();) {
//				CalculatorInput input = (CalculatorInput) iterator.next();
//				System.out.println("Choice: " + input.getChoice());
//				System.out.println("Date1: " + input.getDate1());
//				System.out.println("Date2: " + input.getDate2());
//				NumericalDate date3 = input.getDate3();
//				System.out.println("NDays: " + date3.getNumberOfDays());
//				System.out.println("NWeeks: " + date3.getNumberOfWeeks());
//				System.out.println("NMonths: " + date3.getNumberOfMonths());
//				System.out.println("NYears: " + date3.getNumberOfYears());
//			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return inputs;
	}

	public void delete(Integer id) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			CalculatorInput input = (CalculatorInput) session.get(CalculatorInput.class, id);
			session.delete(input);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
