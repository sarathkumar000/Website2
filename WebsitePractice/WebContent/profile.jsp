<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
div.generic {height:420px;width:200px;background:#30415D;border:1px dotted black;padding:4px;}
 div.gen1 {background:#75CE6F;color:white;border:1px dotted green;text-align:center;padding:6px;margin-left:50px;margin-right:50px;
border-radius: 50%;align:center;
}
.gen1
{
position;relative;
}
 div.gen2 {height:200px;width:60%;background:#75CE9F;color:white;border:1px dotted black;text-aligncenter;padding:5px;margin-top:50px;
margin-left:38px;margin-right:5px;margin-bottom:10px;
}
 p {
  text-align: center;
}
h3 {
  text-align: center;
}
h6 {
  text-align: center;
}
tr
{
margin-top:3px;
}

</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<div class="generic">

<div class="gen1">
<p>USER PHOTO</p>
</div>
<div class="gen2">
<table>
<tr margin-top:3px;>
<h3> <%out.println(getServletContext().getAttribute("name")); %></h3>
</tr>
<tr margin-top:3px;>
<h3> <%out.println(getServletContext().getAttribute("id")); %></h3>
</tr>
<tr>
<h3> <%out.println(getServletContext().getAttribute("company")); %></h3>
</tr>
<tr>
<h3> <%out.println(getServletContext().getAttribute("contact")); %></h3>
</tr>
</table>
</div>
<div>


</div>
</div>

</body>
</html>