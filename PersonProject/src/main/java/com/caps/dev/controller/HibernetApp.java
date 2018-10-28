package com.caps.dev.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.caps.dev.DAO.DAOHibernet;
import com.caps.dev.personBeans.Person;



public class HibernetApp extends DAOHibernet {
	public static void main( String[] args ) throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		Scanner in = new Scanner(System.in);
		Person person = new Person();
		DAOHibernet a=new DAOHibernet();
		System.out.println("enter the opertion u want");
		System.out.println("----------------------------------");
		System.out.println("1)Create"
				+ "2)Search"
				+ "3)Delete"
				+ "4)Update");
		int o=sc.nextInt();

		if(o==1)
		{System.out.println("Enter person Details");
		System.out.println("-------------------");



		System.out.println("Enter person id: ");
		person.setId(Integer.parseInt(in.nextLine()));

		System.out.println("Enter person name: ");
		person.setName(in.nextLine());

		System.out.println("Enter person age: ");
		person.setAge(Integer.parseInt(in.nextLine()));

		System.out.println("Enter person email: ");
		person.setEmail(in.nextLine());

		System.out.println("Enter person address: ");
		person.setAddress(in.nextLine());


		a.create(person);
		}
		else if(o==2)
		{
			System.out.println("enter id of an perosn");
			person.setId(Integer.parseInt(in.nextLine()));
		 person=	a.search(person);
System.out.println(person);
		}
		else if(o==3)
		{	
			System.out.println("enter the person name that to be deleted");
			person.setName(in.nextLine());
			a.delete(person);
		}
		else if (o==4)
		{System.out.println("enter person id");
		person.setId(Integer.parseInt(in.nextLine()));
		System.out.println("enter updated age");
		person.setAge(Integer.parseInt(in.nextLine())); 
			a.update(person);
			
		}
	}       

}
