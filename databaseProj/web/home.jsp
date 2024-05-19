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
 
    <p class="greetings"> Welcome, <c:out value="${username}"/> </p>
    <div class="container text-center">
        <div class="row">
            <div class="col firstColumn" onclick="handleClick('firstColumn')">
                <p class="centerSpan"><span>SELECTION 1</span></p><br>
                <p class="paragraphFirstColumn">GO TO EDIT FORM</p>
                <a href="${pageContext.request.contextPath}/form/update/form?username=${username}" class="paragraphFirstColumn btn btn-sm btn-link"></a>
                
            </div>
            <div class="col secondColumn" onclick="openModal()">
                <p class="centerSpan"><span>SELECTION 2</span></p><br>
                <p class="paragraphFirstColumn">GO TO YOUR ACCOUNT</p>
            </div>
            <div class="col thirdColumn" onclick="handleClick('thirdColumn')">
                <p class="centerSpan"><span>SELECTION 3</span></p><br>
                <p class="paragraphFirstColumn">GO BACK TO FORM</p>
            </div>
        </div>
    </div>
             <div id="myModal" class="modal">
        <!-- Modal content -->
<div class="modal-content">
    <span class="close" onclick="closeModal()">&times;</span>
    <div class="modal-header">
        <h2>Personal Information</h2>
    </div>
    <div class="modal-body">
        <div class="info">
            <strong>Username:</strong>
                <p><span class="underline"><c:out value="${username}"/></span></p>
        </div>
        <div class="info">
            <strong>Email:</strong>
            <p><span class="underline"><c:out value="${email}"/></span></p>
        </div>
        <div class="info">
            <strong>Password:</strong>
            <p><span class="underline"><c:out value="${password}"/></span></p>
        </div>
    </div>
</div>


        
     <script type="text/javascript" src="${pageContext.request.contextPath}/Javascript/modal.js"></script>
    </div>
</body>
</html>
