package com.capgemini.phone_simulator_application_development.bean;

public class Contact 
{
	private String name;
	private int number;
	private String groupName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	@Override
	public String toString() {
		return "[name=" + name + "\n number=" + number + "\n groupName=" + groupName + "]\n\n";
	}
	
	

}
