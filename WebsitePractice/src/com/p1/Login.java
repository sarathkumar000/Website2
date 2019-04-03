package com.p1;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

//import com.sun.corba.se.pept.transport.Connection;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	int j=0;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession ses = request.getSession(true);
		String pname=request.getParameter("pname");
		String pcategory=request.getParameter("pcategory");
		String brand=request.getParameter("pbrand");
		int price=Integer.parseInt(request.getParameter("pprice"));
		int pqty=Integer.parseInt(request.getParameter("pqty"));
		Product p = new Product();
		p.setPname(pname);
		p.setPcategory(pcategory);
		p.setPprice(price);
		p.setPbrand(brand);
		p.setPqty(pqty);
		String s1 = getServletContext().getAttribute("1").toString();
		int l=s1.indexOf('@');
		String s = s1.substring(0, l);
		System.out.println(s);
		
		
		try {
			int n = SignUpDao.saveProduct(p,s);
			if(n>0)
			{
				out.println("<h1>PRODUCT ADDED SUCCESSFULLY<h1><br>");
				out.println("<form action='index2.html' ><input type='submit' value='ADD PRODUCTS'></form>");
				out.println("<form action='Second' method ='post'><input type='submit' value='VIEW PRODUCTS'></form>");
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	//setting content type to deal with server	  
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		// getting user name and pasword from form
		String em = request.getParameter("email");
		String pwd=request.getParameter("password");
		
		// using prepared stament to send query
		PreparedStatement ps = null;
		SignUpDao d = new SignUpDao();
		
		// establishing connection with database
		Connection con = d.getConnection();
		
		// Establishing session to remember email for further usage
	    HttpSession ses = request.getSession(true);
	    
	    // comparing session wheteher it is new or not
	    if(ses.isNew())
	    {
	    	out.println("WELCOME");
	    	out.println("YOUR SESSION ID id "+ ses.getId());
	    }
	    
	    
	    
	    
	   // here we are interacting with database to get password stored in database to comare with the one user enterd  
	    String here;
		try {
			ps = con.prepareStatement("select password from signup where email=?");
			ps.setString(1, em);
		    ResultSet rs = ps.executeQuery();
		    out.println("WELCOME");
			if(rs.next())
			{
				
		   here = rs.getString(1);
		   if(here.equals(pwd))
			{
				
			// here storing email data in servlet to remember that email further 
			   getServletContext().setAttribute("1",em);  
			   
			  // here we are creating object for signup details to fetch customer data from database
			   SignUpDao d1 = new SignUpDao();
				Details p1=null;
				try {
					p1 = d1.getCustomerDetails(em);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// here we are setting the customer details to known datatype
				int i = p1.getId();
				 String name = p1.getName();
				 String company = p1.getCompany();
				 String email= p1.getEmail();
				 int contact = p1.getContact();
				 //getServletContext().setAttribute("2",id);
				 System.out.println(i);
				 System.out.println(name);
				 System.out.println(company);
				 System.out.println(contact);
				 
				 
				// here we are storing customer details to remeber further
				getServletContext().setAttribute("id",i);
				getServletContext().setAttribute("name",name);
				getServletContext().setAttribute("contact",contact);
				getServletContext().setAttribute("company",company);
				
				// After all the process succesfully completed  we now froward the page to action page 
				request.getRequestDispatcher("NEW.jsp").forward(request,response);
			   
				
			}
		   else
		   {
			   out.println("YOU ENTERED UISERNAME OR PASSWORD WRONG");
			   j++;
			  // out.println("User or password incorrect");
			   if(j<3)
			   {
				   
			   request.getRequestDispatcher("index.html").forward(request,response);
			   }
			   else
			   {
				   out.println("accOunt blOked");
				  
				  
			   }
		   }
          ses.invalidate();
         
			}
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		
	}

}
