package com.firstbit.contacts;

import java.util.List;

public interface DataService {
	public int insertRow(User employee);

	public List<User> getList();

	public User getRowById(int id);

	public int updateRow(User employee);

	public int deleteRow(int id);

	// The same for Contact
	public int insertContact(Contact contact);

	public List<Contact> getContactList(int id);
	
	public int deleteContact(int id);
	
	public Contact getContact(int id);

	public int updateContact(Contact employee);

}