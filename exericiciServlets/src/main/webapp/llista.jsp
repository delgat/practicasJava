<%-- 
    Document   : llista
    Created on : 14-jun-2017, 16:49:54
    Author     : jdcaparros
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:forEach items="${llista}" var="persona">
            El missatge  es ${persona.missatge}<br>
        </c:forEach>        
    </body>
</html>