package com.firstbit.contacts;

import java.util.List;

public interface DataDAO {
	
	public int insertRow(User user);

	public List<User> getList();

	public User getRowById(int id);

	public int updateRow(User employee);

	public int deleteRow(int id);
	
	// The same for Contact
	public int insertContact(Contact contact);
	
	public List<Contact> getContactList(int id);
	
	public int deleteContactRow(int id);
	
	public Contact getRowContact(int id);
	
	public int updateContact(Contact contact);
	
	
}