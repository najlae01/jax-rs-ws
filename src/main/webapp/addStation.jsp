<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="station/save" method="post">

		<label>Name :</label> <input type="text" name="name"> <br />

		<label>Address :</label> <input type="text" name="address"> <br />
		<label>City :</label> <input type="text" name="city"> <br />
		<input type="submit" name="save" value="Add"> <br />
	</form>
</body>
</html>