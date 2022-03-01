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

        <div style="overflow-x: auto;">
            <table>
                <tr>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th></th>
                </tr>
                <c:forEach var="product" items="${cart_list }">
                    <tr>
                        <td>${product["name"]}</td>
                        <td>${product["price"]}</td>
                        <td>${product["quantity"]}</td>
                        <td>
                            <form action="./delete_product" style="padding:0px; margin:0px;" class="add_cart_form" method="POST">
                                <input type="hidden" name="product_id" value="${product["product_id"]}">
                                <div class="add_form_content">
                                    <div class="">
                                        <input class="cart_button" type="submit" name="delete_product", value="Delete from Cart" >
                                    </div>
                                </div>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <p><h4>Total price: ${total_price} </h4></p>

        <jsp:include page="utils/footer.jsp"></jsp:include>
    </body>
</html>

