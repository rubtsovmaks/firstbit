package com.firstbit.contacts;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class DataDaoImpl implements DataDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public int insertRow(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		Serializable id = session.getIdentifier(user);
		session.close();
		return (Integer) id;
	}

	@Override
	public List<User> getList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")

		List<User> result = (List<User>) session.createQuery("from User").list();
		session.close();
		return result;
	}

	@Override
	public User getRowById(int id) {
		Session session = sessionFactory.openSession();
		User employee = (User) session.load(User.class, id);
		return employee;
	}

	@Override
	public int updateRow(User user) {
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("update User set name = '" + user.getName() + "'," + "lastname = '"
				+ user.getLastname() + "' " + " where id = '" + user.getId() + "'");
		int result = query.executeUpdate();
		session.close();
		return result;
		/*
		 * Transaction tx = session.beginTransaction(); session.save(employee);
		 * tx.commit(); Serializable id = session.getIdentifier(employee);
		 * session.close(); return (Integer) id;
		 */
	}

	@Override
	public int deleteRow(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User employee = (User) session.load(User.class, id);
		session.delete(employee);

		List<Contact> result = (List<Contact>) session.createQuery("from Contact where user_id = '" + id + "' ").list();

		for (Contact contact : result) {
			session.delete(contact);
		}

		tx.commit();
		Serializable ids = session.getIdentifier(employee);
		session.close();
		return (Integer) ids;
	}

	@Override
	@Transactional
	public int insertContact(Contact contact) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(contact);
		tx.commit();
		Serializable id = session.getIdentifier(contact);
		session.close();
		return (Integer) id;
	}

	@Override
	public List<Contact> getContactList(int id) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Contact> result = (List<Contact>) session.createQuery("from Contact where user_id = '" + id + "' ").list();
		session.close();
		return result;
	}

	@Override
	public int deleteContactRow(int id) {
		System.out.println("adadad "+ id);
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("delete Contact where id = '" + id + "'");
		int result = query.executeUpdate();
		session.close();
		return result;
	}
	
	
	

	@Override
	public Contact getRowContact(int id) {
		Session session = sessionFactory.openSession();
		Contact employee = (Contact) session.load(Contact.class, id);
		return employee;
	}

	@Override
	public int updateContact(Contact contact) {
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("update Contact set phone = '" + contact.getPhone() + "' " 
		+ " where id = '" + contact.getId() + "'");
		int result = query.executeUpdate();
		session.close();
		return result;
	}

}