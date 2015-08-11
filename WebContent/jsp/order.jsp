<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Order Processing Page</title>
</head>
<body>
<h2>Process Order</h2>
<form:form method="post" commandName="orderForm" action="processorder.do">
 
    <table>
    <tr>
        <td><form:label path="itemCount">Item Count</form:label></td>
        <td><form:input path="itemCount" /></td> 
    </tr>
    <tr>
        <td><form:label path="orderTotal">Order Total</form:label></td>
        <td><form:input path="orderTotal" /></td>
    </tr>
    <tr>
        <td><form:label path="card">Card</form:label></td>
        <td><form:input path="card" /></td>
    </tr>
    <tr>
        <td><form:label path="personName">Person Name</form:label></td>
        <td><form:input path="personName" /></td>
    </tr>
    <tr>
        <td><form:label path="shippingAddress">Shipping Address</form:label></td>
        <td><form:input path="shippingAddress" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Add Contact"/>
        </td>
    </tr>
</table>  
     
</form:form>
</body>
</html>