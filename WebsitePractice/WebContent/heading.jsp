Best practice project
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" type="text/css" href="mystyle.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.button {
  background-color: #49274A;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
</style>
</head>
<body>

<div style = "position:relative;top:20px;">
         <h3 style= "float:right;"> WELCOME <%out.println(getServletContext().getAttribute("1")); %></h3>
                   <a href="home.html" class="button">LOGOUT</a>
         			
         
</div>


</body>
</html>
