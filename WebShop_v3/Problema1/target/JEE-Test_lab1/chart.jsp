<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html >
    <head>
        <link href="assets/css/style.css" rel="stylesheet"  type="text/css" />
    </head>

    <title>
        WebShop-in_work
    </title>

    <body>

        <jsp:include page="utils/header.jsp"></jsp:include>

        <jsp:include page="table_products.jsp">
            <jsp:param name="param1" value="${nume}"/>
            <jsp:param name="param2" value="${productList}"/>
        </jsp:include>



    </body>
</html>

