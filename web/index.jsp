<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 17-9-18
  Time: 下午6:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="css/bootstrap.min.css" rel="stylesheet"/>
<link href="css/bootstrap-theme.min.css" rel="stylesheet"/>

<html>
<head>
    <title>login</title>
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th>id</th>
        <th>username</th>
        <th>age</th>
        <th>description</th>
    </tr>
    </thead>
    <tbody id="body">
    <tr style="display:none" id="templateTr">
        <th  scope="row" class="_id"></th>
        <td class="_username"></td>
        <td class="_age"></td>
        <td class="_description"></td>
    </tr>
    </tbody>
</table>
<button class="btn btn-primary" id="search">查询</button>

<!-- Bootstrap core JavaScript
 ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<script>
    $("#search").click(function () {
        var tr = $("#templateTr");
        var body = $("#body");
        body.empty();
        $.post("/getUsers.do", "", function(result) {
            $.each(result, function(idx, row) {
                var a = tr.clone();
                a.attr("style", "display:block");
                $.each(row, function(name, element) {
                    a.find("._" + name).text(element);
                });
                body.append(a);
            });
        },"json");
        return false;
    });
</script>
</body>
</html>
