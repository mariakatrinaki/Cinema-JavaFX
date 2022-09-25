package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import application.Users;

public class Users {
	public enum Person {
		Employee, Visitor
	}
	
	Products  food;
	

	public Products getFood() {
		return food;
	}

	public void setFood(Products food) {
		this.food = food;
	}

	private String userName;

	private String password;
	
	private static ArrayList<Users> usersDetails;

	private Person user;
	
	private ArrayList<Orders> numberOfOrder;

	public Users(Person user, String userName, String password) {

		this.user = user;
		this.userName = userName;
		this.password = password;

	}
	
	public Users(Person user, String userName, String password,ArrayList<Orders> orders) {

		this.user = user;
		this.userName = userName;
		this.password = password;
		
		 numberOfOrder= orders;

	}
	

	public ArrayList<Orders> getNumberOfOrder() {
		return numberOfOrder;
	}

	


	public Person getPerson() {
		return user;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
