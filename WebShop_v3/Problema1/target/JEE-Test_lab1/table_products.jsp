
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div style="overflow-x: auto;">

  inainte
        <c:out value="${nume}"/>
        dupa

    <c:out value="This is JSTL"/>

    ${param1}

    sau
    <%= request.getParameter("param2") %>

    <c:forEach var="product" items="${productList }">
        ${product }
    </c:forEach>

    <c:set var="total" value="0"></c:set>

    <table>
        <tr>
            <th>Product Name</th>
            <th>Price</th>
            <th>Description</th>
            <th>Quantity</th>
            <th></th>
        </tr>
        <tr>
            <td>Ideapad</td>
            <td>3000 lei</td>
            <td>foarte bun ${total } </td>
            <td>
                <form action="./add_to_chart" style="padding:0px; margin:0px;" class="add_chart_form" method="POST">
                    <input type="hidden" name="id_produs" value="20">
                    <div class="add_form_content">
                    <div class="">
                        <input class="quantity_input" type="text" name="cantitate_val" value="0">
                    </div>
                    <div class="">
                        <input class="add_chart_button" type="submit" name="adauga_produs", value="Add to Chart" >
                    </div>
                    </div>
                </form>
            </td>
        </tr>
    </table>


</div>