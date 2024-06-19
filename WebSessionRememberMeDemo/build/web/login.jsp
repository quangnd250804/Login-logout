<%-- 
    Document   : login.jsp
    Created on : Jun 11, 2024, 4:42:53 PM
    Author     : ADM
--%>

<%@page import="utils.CookieUtils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Login Page</title>
    </head>
    <body>
        <%
            String userName = CookieUtils.get("cookuser",request);
            String password = CookieUtils.get("cookpass", request);
            String rememberVal = CookieUtils.get("cookrem", request);
        %>
        
        <div class="offset-3 col-6">
            </br></br></br>
            <p class="h3">Login Form</p>
            <form action="LoginServlet" method="POST">
                <%=request.getAttribute("msg")!=null?request.getAttribute("msg") : ""%>
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="text" class="form-control" name="username" autocomplete="off" value="<%=userName%>" aria-describedby="emailHelp"/>
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small> 
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1" >Password</label>
                    <input type="password" class="form-control" name="password" size="50" autocomplete="off" value="<%=password%>" />
                </div>
                <div class="form-group form-check">
                    <input type="checkbox" class name="remember" value="1"
                    <%= "1".equals(rememberVal.trim()) ?"checked=\"checked\"" : ""%> />
                    <label class="form-check-label" for="exampleCheck1">Check me out</label>
                </div>
                <button type="submit" class="btn btn-primary">Login</button>
            </form>
        </div>
    </body>
</html>
