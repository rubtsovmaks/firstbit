package com.firstbit.contacts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class DataServiceImpl implements DataService {

	@Autowired
	DataDAO dataDao;

	@Override
	public int insertRow(User employee) {
		return dataDao.insertRow(employee);
	}

	@Override
	public List<User> getList() {
		return dataDao.getList();
	}

	@Override
	public User getRowById(int id) {
		return dataDao.getRowById(id);
	}

	@Override
	public int updateRow(User employee) {
		return dataDao.updateRow(employee);
	}

	@Override
	public int deleteRow(int id) {
		return dataDao.deleteRow(id);
	}

	@Override
	public int insertContact(Contact contact) {
		return dataDao.insertContact(contact);
	}

	@Override
	public List<Contact> getContactList(int id) {
		return dataDao.getContactList(id);
	}
	
	@Override
	public int deleteContact(int id){
		return dataDao.deleteContactRow(id);
	}

	@Override
	public Contact getContact(int id) {
		// TODO Auto-generated method stub
		return dataDao.getRowContact(id);
	}

	@Override
	public int updateContact(Contact employee) {
		// TODO Auto-generated method stub
		return dataDao.updateContact(employee);
	}

}
