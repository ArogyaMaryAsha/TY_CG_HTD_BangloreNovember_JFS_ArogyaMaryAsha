package com.capgemini.phone_simulator_application_development.services;

import java.util.List;

import com.capgemini.phone_simulator_application_development.bean.Contact;

public interface OperateContactServices 
{
	boolean addContact(Contact bean);
	boolean deleteContact(String name);
	boolean editContact(String name,int number);
	List<Contact> showAllContact();
	List<Contact> searchContact();
}
