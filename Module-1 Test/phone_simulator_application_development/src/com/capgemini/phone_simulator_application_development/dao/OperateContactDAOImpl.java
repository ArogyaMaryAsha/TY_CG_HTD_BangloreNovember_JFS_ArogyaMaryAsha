package com.capgemini.phone_simulator_application_development.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.phone_simulator_application_development.bean.Contact;
import com.capgemini.phone_simulator_application_development.dao.OperateContactDAO;

public class OperateContactDAOImpl implements OperateContactDAO 
{
	FileReader reader;
	Properties prop;
	Contact bean;

	public OperateContactDAOImpl()
	{
		try {
			reader = new FileReader("db.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public boolean addContact(Contact bean)
	{
		try
		(java.sql.Connection con = DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));

				java.sql.PreparedStatement pstmt = con.prepareStatement(prop.getProperty("addContactQuery"));//dynamic query
				)
		{

			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getNumber());
			pstmt.setString(3, bean.getGroupName());


			int count = pstmt.executeUpdate();

			if(count > 0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return false;

	}

	@Override
	public boolean deleteContact(String name) 
	{
		try
		(Connection con = DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));

				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("deleteContactQuery"));//dynamic query
				)
		{
			pstmt.setString(1, name);

			int count = pstmt.executeUpdate();

			if(count > 0)
			{
				return true;
			}
		}
		catch (Exception e)
		{

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean editContact(String name, int number)
	{
		try
		(Connection con = DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));

				PreparedStatement pstmt = con.prepareStatement(prop.getProperty("editContactQuery"));//dynamic query
				)
		{
			pstmt.setInt(1, number);
			pstmt.setString(2, name);

			int count = pstmt.executeUpdate();

			if(count > 0)
			{
				return true;
			}
		}
		catch (Exception e)
		{

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Contact> showAllContact()
	{
		List<Contact> list = new ArrayList<Contact>();
		try
		(Connection con = DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				Statement stmt = con.createStatement();//static query
				ResultSet rs = stmt.executeQuery(prop.getProperty("showContactQuery"));                                             
				)
		{
			while(rs.next())
			{
				bean = new Contact();
				bean.setName(rs.getString(1));
				bean.setNumber(rs.getInt(2));
				bean.setGroupName(rs.getString(3));

				list.add(bean);
			}
			return list;

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}


	@Override
	public List<Contact> searchContact() {
		Scanner sc=new Scanner(System.in);

		System.out.println("Enter the name you want to search......");
		String name=sc.next();


		List<Contact> list = new ArrayList<Contact>();

		try
		(Connection con = DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				Statement stmt = con.createStatement();//static query
				ResultSet rs = stmt.executeQuery(prop.getProperty("showContactQuery"));                                             
				)
		{
			while(rs.next())
			{
				bean = new Contact();
				bean.setName(rs.getString(1));
				bean.setNumber(rs.getInt(2));
				bean.setGroupName(rs.getString(3));

				list.add(bean);
			}
			return list;

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
