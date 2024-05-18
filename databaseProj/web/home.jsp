<%-- 
    Document   : home
    Created on : May 8, 2024, 6:48:36 PM
    Author     : Xander
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/Javascript/javascript.js"></script>
    <title>Home Page</title>
</head>
<body>
    <!-- Using JSTL and EL to display username -->
 
    <p class="greetings"> Welcome, <c:out value="${username}"/> </p>
    <div class="container text-center">
        <div class="row">
            <div class="col firstColumn" onclick="handleClick('firstColumn')">
                <p class="centerSpan"><span>SELECTION 1</span></p><br>
<!--                <p class="paragraphFirstColumn">GO TO EDIT FORM</p>-->
                 <a class="paragraphFirstColumn" href="${pageContext.request.contextPath}/form/update/form?username=${form.username}" class="btn btn-sm btn-link">Edit Product</a>
            </div>
            <div class="col secondColumn" onclick="handleClick('secondColumn')">
                <p class="centerSpan"><span>SELECTION 2</span></p><br>
                <p class="paragraphFirstColumn">GO TO YOUR ACCOUNT</p>
            </div>
            <div class="col thirdColumn" onclick="handleClick('thirdColumn')">
                <p class="centerSpan"><span>SELECTION 3</span></p><br>
                <p class="paragraphFirstColumn">GO BACK TO FORM</p>
            </div>
        </div>
            <p class="greetings"><c:out value="${message}"/> </p>
    </div>
</body>
</html>
