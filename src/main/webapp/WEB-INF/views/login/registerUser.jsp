<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register User</title>
</head>
<body>
<pre>
	<form action="/registerUser" method="POST">
		FIRST NAME		:<input type="text" name="firstName"/>
		LAST NAME		:<input type="text" name="lastName"/>
		EMAIL			:<input type="email" name="email"/>
		PASSWORD		:<input type="password" name="password"/>
		<input type="submit" value="Register"/>
	</form>
</pre>

</body>
</html>