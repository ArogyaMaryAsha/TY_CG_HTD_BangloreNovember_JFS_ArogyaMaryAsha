package com.capgemini.phone_simulator_application_development.services;

import java.util.List;

import com.capgemini.phone_simulator_application_development.bean.Contact;
import com.capgemini.phone_simulator_application_development.dao.OperateContactDAO;
import com.capgemini.phone_simulator_application_development.factory.ContactDAOFactory;

public class OperateContactServicesImpl implements OperateContactServices {

	OperateContactDAO dao = ContactDAOFactory.instanceofContactDAOImpl();
	
	@Override
	public boolean addContact(Contact bean) {
		return dao.addContact(bean);
	}

	@Override
	public boolean deleteContact(String name) {	
		return dao.deleteContact(name);
	}

	@Override
	public boolean editContact(String name, int number) {
		return dao.editContact(name, number);
	}

	@Override
	public List<Contact> showAllContact() {
		return dao.showAllContact();
	}

	@Override
	public List<Contact> searchContact() {
		return dao.searchContact();
	}

}
