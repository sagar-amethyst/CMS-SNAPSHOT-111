<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- contain script-->
<%--  <%@ include file = "script.jsp" %> --%> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register User</title>
</head>
<body>
<a href="showregistration">Register</a>
<a href="showlogin">Login</a>

<pre>
	<form action="login" method="POST">
		EMAIL	:<input type="email" name="email"/>
		PASSWORD:<input type="password" name="password"/>
	
		<input type="submit" value="login"/>
		${invalidMsg}
		
	</form>
</pre>

</body>
</html>