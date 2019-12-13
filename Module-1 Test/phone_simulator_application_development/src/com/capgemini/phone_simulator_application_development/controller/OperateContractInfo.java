package com.capgemini.phone_simulator_application_development.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.phone_simulator_application_development.bean.Contact;
import com.capgemini.phone_simulator_application_development.factory.ContactDAOFactory;
import com.capgemini.phone_simulator_application_development.services.OperateContactServices;

public class OperateContractInfo
{
	static OperateContactServices services = ContactDAOFactory.instanceOfContactServices();
	public static void operateContract()
	{

		Scanner sc = new Scanner(System.in);
		System.out.println("--------------USER OPTIONS-----------------");
		System.out.println("Press 1 to add contact.......");
		System.out.println("Press 2 to delete contact.......");
		System.out.println("Press 3 to edit contact.......");
		System.out.println("Press 4 for goback to the phone options...");
		System.out.println("---------------------------------------------------------");
		System.out.println("Enter your choice........");
		int choice = sc.nextInt();

		switch(choice)
		{
		case 1:
			Contact bean = new Contact();
			System.out.println("Enter name");
			bean.setName(sc.next());
			System.out.println("Enter number");
			bean.setNumber(sc.nextInt());
			System.out.println("Enter groupname");
			bean.setGroupName(sc.next());

			boolean check = services.addContact(bean);
			if(check)
			{
				System.out.println("Contact added successfully...");
				System.out.println("----------------------------------------");
			}
			else
			{
				System.err.println("Something went wrong");
			}
			break;

		case 2:
			System.out.println("Enter the contact name to delete");
			String name=sc.next();

			boolean check1 = services.deleteContact(name);
			if(check1)
			{
				System.out.println("Contact deleted successfully....");
				System.out.println("----------------------------------------");
			}
			else
			{
				System.err.println("Something went wrong");
				System.out.println("----------------------------------------");

			}
			break;

		case 3:
			System.out.println("Enter the name to update the details");
			String name1=sc.next();

			System.out.println("Enter number to update");
			int number=sc.nextInt();

			Contact bean1 =new Contact();

			bean1.setName(name1);
			bean1.setNumber(number);



			boolean check2 = services.editContact(name1, number);
			if(check2)
			{

				System.out.println("Contact edited successfully...");
				System.out.println("----------------------------------------");
			}
			else
			{
				System.err.println("Something went wrong");
			}
			break; 



		case 4:PhoneOptions.phoneOptionDetails();

		break;
		default: System.out.println("Enter correct choice....");
		}

	}
	public static void showContact()
	{
		System.out.println("Contact details");
		System.out.println("----------------------------------");

		List<Contact> c = services.showAllContact();

		System.out.println(c);

	}

	public static void searchContact()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Contact details....");
		System.out.println("-----------------------------");

		List<Contact> c1 = services.searchContact();
		System.out.println((c1));
        while(true)
        {
		System.out.println("Enter 1 to call...");
		System.out.println("Enter 2 to message...");
		System.out.println("Enter your choice....");
		int choice4=sc.nextInt();
		switch(choice4)
		{
		case 1:System.out.println("Calling.....");
		       System.out.println("Enter any character to end call...");
		       String call=sc.next();
		       System.out.println("Call ended....");
		       break;

		case 2:System.out.println("Calling.....");
		       System.out.println("Enter any character to end call...");
		       String msg=sc.next();
		       System.out.println("Message sent....");
		  
		      break;
		}
	}
	}

}
