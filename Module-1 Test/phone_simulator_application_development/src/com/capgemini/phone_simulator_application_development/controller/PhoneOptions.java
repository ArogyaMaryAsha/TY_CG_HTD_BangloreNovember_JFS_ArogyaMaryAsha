package com.capgemini.phone_simulator_application_development.controller;

import java.util.Scanner;

public class PhoneOptions {
	public static void phoneOptionDetails()
	{
		Scanner sc  = new Scanner(System.in);
		while(true)
		{
		System.out.println("-----------PHONE OPTIONS------------");
		System.out.println("Press 1 to show all contacts.....");
		System.out.println("Press 2 to search for contact by using contact name.....");
		System.out.println("Press 3 to Operate on contact......");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("Enter your choice.....");

		int choice = sc.nextInt();
		switch(choice)
		{
		case 1:OperateContractInfo.showContact();
			   break;
		case 2:OperateContractInfo.searchContact();
			   break;
		case 3:OperateContractInfo.operateContract();
			   break;
		default:System.out.println("Enter correct choice....");

		}
		}
	}
}
