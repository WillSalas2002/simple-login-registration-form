<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration</title>
  </head>
  <body>
  <h1>Register</h1>
    <form:form action="/registration" modelAttribute="newUser" method="POST">
        First Name <form:input path="firstName"/>
        <br><br>
        Last Name <form:input path="lastName"/>
        <br><br>
        Email <form:input path="email"/>
        <br><br>
        Password <form:password path="password"/>
        <br><br>
        <input type="submit" value="Submit"/>
    </form:form>
  </body>
</html>