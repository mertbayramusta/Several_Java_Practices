<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add New User</h1>
	<form action="SaveServlet" method="post">
		<table>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" /></td>
			</tr>
			<tr>
				<td>Birthday:</td>
				<td><input type="text" name="birthday" /></td>
			</tr>
			<tr>
				<td>Sex:</td>
				<td><input type="text" name="sex" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>ID number:</td>
				<td><input type="text" name="id" /></td>
			</tr>
			
			<tr>
				
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add User" /></td>
			</tr>
		</table>
	</form>

	<br />
	<a href="ViewServlet">Click Here to View Users</a>
</body>
</html>