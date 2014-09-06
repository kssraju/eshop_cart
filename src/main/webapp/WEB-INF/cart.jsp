<%--
  Created by IntelliJ IDEA.
  User: trierra
  Date: 9/4/14
  Time: 12:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Shop</title>
    <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</head>
<body>

<div class="container" id="container">

    <div class="page-header">
        <h1>Your cart</h1>
    </div>

    <p class="lead">Edit cart:</p>

    <c:forEach items="${productList}" var="item">
        <div class="row">
            <div class="col-xs-4">
                <div class="input-group">
                    <input type="text" name="item" value="${item}" class="form-control">
                      <span class="input-group-btn">
                        <button class="btn btn-info" type="button" onclick="$.ajax({url: '/example/cart/remove',
                                context: document.body ,
                                type:'get',
                                data: {'name':'${item}'}
                                }).done(function() {
                                alert('${item} removed!');
                                $('#container').load(document.URL +  '#container');}
                                );">
                            remove
                        </button>
                      </span>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

<script src="http://code.jquery.com/jquery.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
