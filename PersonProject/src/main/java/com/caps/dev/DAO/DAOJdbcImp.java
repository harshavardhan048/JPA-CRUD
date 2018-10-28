package com.caps.dev.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.caps.dev.personBeans.Person;

public class DAOJdbcImp implements DAOInterface{
	Person person = new Person();
	public  void create(Person person)
	{

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			/*
			 * 1. Load the Driver
			 */
			Class.forName("com.mysql.jdbc.Driver");

			/*
			 * 2. Get the DB Connection via Driver
			 */

			String dbUrl="jdbc:mysql://localhost:3306/capsv4_db";

			//3rd version of getConnnecton()
			con = DriverManager.getConnection(dbUrl,"root","9701952121"); //1st version of getConnection


			/*
			 * 3. Issue the SQL query via connection
			 */
			String sql = "insert into persons_info values(?,?,?,?,?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, person.getId());
			pstmt.setString(2,person.getName());
			pstmt.setInt(3, person.getAge());
			pstmt.setString(4, person.getEmail());
			pstmt.setString(5, person.getAddress());

			int count = pstmt.executeUpdate();

			/*
			 * 4. Process the results
			 */

			if(count > 0) {
				System.out.println(person.getName()+"  "+"has been stored successfully");
			}else {
				System.out.println("Failed!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			/*if(in!=null)
			{
				in.close();
			}*/
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public Person search(Person person)
	{
		Connection con = null;
		//Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		try {
			/*
			 * 1. Load the Driver
			 */
			Class.forName("com.mysql.jdbc.Driver");

			/*
			 * 2. Get the DB Connection via Driver
			 */
			String dbUrl="jdbc:mysql://localhost:3306/capsv4_db";
			//1st version of getConnection()
			//con = DriverManager.getConnection(dbUrl);

			Scanner in = new Scanner(System.in);

			con = DriverManager.getConnection(dbUrl,"root","9701952121"); //3rd version of getConnection

			System.out.println("Connected..."); 

			/*
			 * 3. Issue the SQL query via connection
			 */

			String sql = "select * from persons_info where person_id=?";


			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,person.getId());
			rs = pstmt.executeQuery();

			/*
			 * 4. Process the results
			 */

			while(rs.next()){
				int Pid = rs.getInt("person_id");
				String name = rs.getString("person_name");
				String email = rs.getString("person_email");
				int age = rs.getInt("person_age");
				String address = rs.getString("person_address");
				person.setAddress(address);
				person.setAge(age);
				person.setEmail(email);
				person.setAddress(name);
				person.setId(Pid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			/*	if(in!=null)
		{
			in.close();
		}*/
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return person;}
	public void delete(Person person)
	{
		Connection con = null;
		PreparedStatement pstmt = null;


		try {
			/*
			 * 1. Load the Driver
			 */
			Class.forName("com.mysql.jdbc.Driver");

			/*
			 * 2. Get the DB Connection via Driver
			 */

			String dbUrl="jdbc:mysql://localhost:3306/capsv4_db";

			//3rd version of getConnnecton()
			con = DriverManager.getConnection(dbUrl,"root","9701952121"); //1st version of getConnection

			System.out.println("Connected...");

			Scanner in = new Scanner(System.in);


			String sql = "delete from persons_info where person_id=?";
			System.out.println(sql);

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, person.getId());




			int count = pstmt.executeUpdate();



			/*
			 * 4. Process the results
			 */

			if(count > 0) {
				System.out.println("  Data  got deleted");
			}else {
				System.out.println("Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			/*	if(in!=null)
	{
		in.close();
	}
			 */	if(con != null) {
				 try {
					 con.close();
				 } catch (SQLException e) {
					 e.printStackTrace();
				 }
			 }
		}

	}
	public void update(Person person)
	{

		Connection con = null;
		PreparedStatement pstmt = null;


		try {
			/*
			 * 1. Load the Driver
			 */
			Class.forName("com.mysql.jdbc.Driver");

			/*
			 * 2. Get the DB Connection via Driver
			 */

			String dbUrl="jdbc:mysql://localhost:3306/capsv4_db";

			//3rd version of getConnnecton()
			con = DriverManager.getConnection(dbUrl,"root","9701952121"); //1st version of getConnection

			System.out.println("Connected...");

			String sql = "update persons_info set person_age=? where person_id=?";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, person.getAge());
			pstmt.setInt(2, person.getId());
			int count = pstmt.executeUpdate();
			/*
			 * 4. Process the results
			 */

			if(count > 0) {
				System.out.println("age of person got updated ");
			}else {
				System.out.println("Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			/*	if(in!=null)
	{
		in.close();
	}
			 */	if(con != null) {
				 try {
					 con.close();
				 } catch (SQLException e) {
					 e.printStackTrace();
				 }
			 }
		}


	}
}
