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

        ${category}

        <jsp:include page="utils/header.jsp"></jsp:include>

        <div class="category">
            <form action="./home">
                <label for="category_type">Choose a category:</label>
                <select name="category_type" id="category_type">
                    <option value="laptop">Laptop</option>
                    <option value="TV">TV</option>
                    <option value="phone">Phone</option>
                </select>
                <input class="cart_button" type="submit" value="Sort by category">
            </form>
        </div


        <div style="overflow-x: auto;">
            <table>
                <tr>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th>Quantity</th>
                    <th></th>
                </tr>
                <c:forEach var="product" items="${productList }">
                    <tr>
                        <td>${product.name}</td>
                        <td>${product.price}</td>
                        <td>${product.description}</td>
                        <td>
                            <form action="./add_product_to_chart" style="padding:0px; margin:0px;" class="add_cart_form" method="POST">
                                <input type="hidden" name="product_id" value="${product.product_id}">
                                <div class="add_form_content">
                                    <div class="">
                                        <input class="quantity_input" type="text" name="quantity_value" value="0">
                                    </div>
                                    <div class="">
                                        <input class="cart_button" type="submit" name="add_product", value="Add to Cart" >
                                    </div>
                                </div>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>


    </body>
</html>

