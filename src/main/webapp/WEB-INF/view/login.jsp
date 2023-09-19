<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
  </head>
  <body>
    <h1>Login</h1>
    <form:form action="/login" modelAttribute="checkUser" method="POST">
        Email <form:input path="email"/>
        <br><br>
        Password <form:password path="password"/>
        <br><br>
        <input type="submit" value="Login"/>
    </form:form>
  </body>
</html>