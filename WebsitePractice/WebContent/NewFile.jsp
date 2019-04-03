<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>

function myfun()
{
	window.location.href="NewFile.jsp";
	
	}


</script>
</head>
<% int a=10;

out.println(a);
%>
<body>
<form method="get">
Enter id:<input type="text" name="t1"><br>
Enter name:<input type="text" name="t2"><br>

<input type="submit" value="click" name="bt1"onclick="myfun()">

</form>

</body>
<%! public static void display()
{
	
System.out.println("hi");	
	
}

%>


<% out.println("<input type='submit' value='click' onclick='display()'>");%>
<% String str=request.getParameter("t1");

out.println(str);
%>
<a href="jsp2.jsp?id='<%=a %>'">click</a>

</html>