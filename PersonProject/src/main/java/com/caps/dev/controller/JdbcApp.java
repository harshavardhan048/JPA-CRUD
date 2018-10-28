package com.caps.dev.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.caps.dev.DAO.DAOJdbcImp;
import com.caps.dev.personBeans.Person;



public class JdbcApp extends DAOJdbcImp {
	public static void main( String[] args ) throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		DAOJdbcImp a=new DAOJdbcImp();
		System.out.println("enter the opertion u want");
		System.out.println("----------------------------------");
		System.out.println("1)Create"
				+ "2)Search"
				+ "3)Delete"
				+ "4)Update");
		int o=sc.nextInt();
Person person=new Person();
		if(o==1)
		{

			System.out.println("Enter person Details");
			System.out.println("-------------------");
			
			Scanner in = new Scanner(System.in);

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
		{System.out.println("enter id of an perosn");
		int a1=sc.nextInt();
		person.setId(a1);
	 person=a.search(person);
	 System.out.println(person);
		

		}
		else if(o==3)
		{	System.out.println("enter the person id that to be deleted");
		int s=sc.nextInt();
		person.setId(s);
			a.delete(person);
		}
		else if (o==4)
		{System.out.println("enter person id");
		int b=sc.nextInt();
		person.setId(b);
		System.out.println("enter updated age");
		int c=sc.nextInt();
		person.setAge(c); 
			a.update(person);}
	}       

}
