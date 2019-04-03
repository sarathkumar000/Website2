package com.p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SignUpDao {
	public static   Connection getConnection()
	{
	Connection con=null;
	
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");  
			 con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/website","root","root"); 
		}
		catch(Exception e)
		{ 
			System.out.println(e);
	    }
		return con;
	}
	public static int createTable(Details p) throws SQLException
	{
		int id1=0;
		
		Connection con = getConnection();
		PreparedStatement ps=null;
				ps=con.prepareStatement("insert into signup(name,email,password,company,contact) values(?,?,?,?,?)");
		
		ps.setString(1, p.getName());
		ps.setString(2, p.getEmail());
		ps.setString(3, p.getPassword());
		ps.setString(4, p.getCompany());
		ps.setInt(5, p.getContact());
		ps.executeUpdate();
	    ps = con.prepareStatement("select id from signup where email=?");
		ps.setString(1, p.getEmail());
		ResultSet re = ps.executeQuery();
		
		String s1 = p.getEmail();
		int l=s1.indexOf('@');
		String s = s1.substring(0, l);
		System.out.println(s);
		
		createProductTable(s);
		
		return id1;
	}
	public Details getCustomerDetails(String s) throws SQLException
	{
		Connection con=getConnection();
		PreparedStatement ps = con.prepareStatement("select * from signup where email=?");
		ps.setString(1, s);
		ResultSet re = ps.executeQuery();
		
		Details  a= new Details();
		while(re.next())
		{
			int id = re.getInt(1);
			String  name = re.getString(2);
			String email = re.getString(3);
			String company=re.getString(5);
			int contact = re.getInt(6);
			
			String office=re.getString(4);
			
			
			   a.setId(id);
			   a.setName(name);
			   a.setEmail(email);
			   a.setCompany(company);
			   a.setContact(contact);
			   
			   
		}
		return a;
	}
	public static void createProductTable(String s) throws SQLException
	{
		Connection con=getConnection();
		String query = "create table  "+s+"(id int unique not null auto_increment ,name varchar(30),brand varchar(30),category varchar(30),quantity int,price int)";
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.executeUpdate();
		
	}
	public static int saveProduct(Product p,String s) throws SQLException
	{
		int id1=0;
		//Dao d=new Dao();
		Connection con=getConnection();
		String query = "insert into "+s+"(name,brand,category,quantity,price)values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		//ps.setString(1,Integer.toString(id));
		
		ps.setString(1, p.getPname());
		ps.setString(2, p.getPbrand());
		ps.setString(3, p.getPcategory());
		ps.setInt(4, p.getPqty());
		ps.setInt(5, p.getPprice());
		
		
		id1=ps.executeUpdate();
		
		return id1;
		
		
		
		
	}
	public  ArrayList<Product> getProducts(String s) throws SQLException
	{
		Connection con=getConnection();
		String query = "select * from "+s;
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet re = ps.executeQuery();
		ArrayList<Product> al = new ArrayList();
		while(re.next())
		{
			int pid = re.getInt(1);	
			String pname = re.getString(2);
			String pbrand = re.getString(3);
			String pcat = re.getString(4);
			int pqty = re.getInt(5);
			int price = re.getInt(6);
			Product p = new Product();
			
			   p.setPid(pid);
			   p.setPname(pname);
			   p.setPcategory(pcat);
			   p.setPbrand(pbrand);
			   p.setPqty(pqty);
			   p.setPprice(price);
			   
			   al.add(p);
			   
		}
		return al;
	}
	public static int deleteProduct(int id,String s) throws SQLException
	{
		Connection con=getConnection();
		String query = "delete from "+s+" where id="+Integer.toString(id);
		PreparedStatement ps=con.prepareStatement(query);
		//ps.setString(1, Integer.toString(id));
		return ps.executeUpdate();
	}

}
