package com.capgemini.phone_simulator_application_development.factory;

import com.capgemini.phone_simulator_application_development.dao.OperateContactDAO;
import com.capgemini.phone_simulator_application_development.dao.OperateContactDAOImpl;
import com.capgemini.phone_simulator_application_development.services.OperateContactServices;
import com.capgemini.phone_simulator_application_development.services.OperateContactServicesImpl;

public class ContactDAOFactory 
{
	public ContactDAOFactory()
	{
		
	}
	
	public static OperateContactDAO instanceofContactDAOImpl()
	{
		OperateContactDAO dao = new OperateContactDAOImpl();
		return dao;
	}
	
	public static OperateContactServices instanceOfContactServices() 
	{
		OperateContactServices services = new OperateContactServicesImpl();
		return services;
	}

}
