<%-- 
    Document   : newjsp
    Created on : May 8, 2024, 4:44:18 PM
    Author     : Xander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
      <title>Simple Sign up from</title>
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css"/>
  </head>
  <body>
    <%-- ${pageContext.request.contextPath} --%>
    <form method="post" action="${pageContext.request.contextPath}/form/update">
      <h1>SIGN UP</h1>
      <div class="icon">
        <i class="fas fa-user-circle"></i>
      </div>
      <div class="formcontainer">
...
<div class="container">
    <label for="username"><strong>Username</strong></label>
    <input type="text" placeholder="Enter Username" name="username" id="username" value="<c:out value='${formDetails.username}'/>" required>
    <label for="email"><strong>E-mail</strong></label>      
    <input type="text" placeholder="Enter E-mail" name="email" id="email" value="<c:out value='${formDetails.email}'/>" required>
           
    <label for="password"><strong>Password</strong></label>
    <input type="text" placeholder="Enter Password" name="password" id="password" value="<c:out value='${formDetails.password}'/>"  required>
</div>
...

      <button type="submit"><strong>SAVE CHANGES</strong></button>
      <div class="container" style="background-color: #eee">
        <label style="padding-left: 15px">
        <input type="checkbox"  checked="checked" name="remember"> Remember me
        </label>
        <span class="psw"><a href="${pageContext.request.contextPath}/form/create/form">Forgot password?</a></span>
      </div>
    </form>
  </body>
</html>
