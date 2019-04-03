package com.p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
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
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("pwd");
		int contact=Integer.parseInt(request.getParameter("contact"));
		String company=request.getParameter("company");
		ses.setAttribute("email",email);
		Details d=new Details();
		d.setName(name);
		
		d.setEmail(email);
		d.setPassword(password);
		d.setContact(contact);
		d.setCompany(company);
		System.out.println(email);
		System.out.println(password);
		System.out.println(contact);
		System.out.println(company);
		System.out.println(name);
		out.println("executing here1");
		int i=0;
		try {
			out.println("hereit is executiong");
			 i= SignUpDao.createTable(d);
			 request.getRequestDispatcher("check.html").forward(request,response);
			 out.println("executing here2");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
						e.printStackTrace();
		}
		if(i>0)
		{
			out.println("ACCOUNT CREATED SUCCESSFULLY");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
	
	
	}

}
