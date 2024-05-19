<%-- 
    Document   : newjsp
    Created on : May 8, 2024, 4:44:18 PM
    Author     : Xander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>Simple Sign up from</title>
  <head>
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
    <link rel="stylesheet" href="CSS/style.css"/>
  </head>
  <body>
    <%-- ${pageContext.request.contextPath} --%>
    <form id="form" method="post" action="${pageContext.request.contextPath}/form/create">
        
      <div class="icon">
        <i class="fas fa-user-circle"></i>
      </div>
      <div class="formcontainer">
      <div class="container">
<label for="username"><strong>Username</strong></label>
<input type="text" placeholder="Enter Username" name="username" id="username" pattern="[a-zA-Z0-9]+" title="Username must be alphanumeric" required>

        <label for="email"><strong>E-mail</strong></label>
        <input type="email" placeholder="Enter E-mail" name="email" id="email" required>
        <label for="password"><strong>Password</strong></label>
        <input type="password" placeholder="Enter Password" name="password" id="password" required>
      </div>
      <button type="#"><strong>SIGN UP</strong></button>
      <div class="container" style="background-color: #eee">
        <label style="padding-left: 15px">
        <input type="checkbox"  checked="checked" name="remember"> Remember me
        </label>
        <span class="psw"><a href="#">Forgot password?</a></span>
      </div>
    </form>
    
    
  </body>
</html>
