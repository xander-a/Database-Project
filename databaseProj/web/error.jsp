<%-- 
    Document   : error.jsp
    Created on : May 8, 2024, 8:11:52 PM
    Author     : Xander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
        <title>JSP Page</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/Javascript/javascript.js"></script>
     
    <link rel="stylesheet" href="CSS/style.css"/>
    </head>
    <body>
         <div class="accountInformation">
      <div class="icon">
        <i class="fas fa-user-circle"></i>
      </div>
             <div class="info usernameInfo">
                 <p> <c:out value="${username}"/>   
            </div>
             <div class="info emailInfo">
              <c:out value="${email}"/>      
            </div>
             <div class="info passwordInfo">
             <c:out value="${password}"/>     
            </div>   
             <button class="showButton" onclick="showInfo()">Show Info</button>
      </div>
    </body>
</html>
