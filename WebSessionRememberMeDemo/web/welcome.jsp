<%-- 
    Document   : welcome
    Created on : Jun 11, 2024, 4:56:16 PM
    Author     : ADM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Welcome page</title>
    </head>
    <body>
        <h1>Welcome to my Page!</h1>
        <p>
            Welcome,
            <%=session.getAttribute("sessuser")%>
            ! You have successfully logged in. Thank you. &nbsp; &nbsp;
            <hr>
            <a href="LogoutServlet">Logout</a>
        </p>
    </body>
</html>
