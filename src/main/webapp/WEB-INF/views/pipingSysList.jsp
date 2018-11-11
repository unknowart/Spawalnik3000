<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Lista Systemów</title>
    <%--<link href="../css/bootstrap.min.css" rel="stylesheet">--%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link href="../css/style.css" rel="stylesheet">
    <script>
        function confirmDelete(id, title) {
            if (confirm("Czy na pewno usunąć system \"" + title + "\"")) {
                window.location.href = "/system/delete/" + id;
            }
        }
    </script>
</head>
<body class="body">
<div class="container" >

    <h3 class="card-header">Lista Systemów</h3>
    <div class="card-header">
        <div class="card-body">
            <table class="table table-hover">
                <tr>
                    <th>Nazwa Systemu</th>
                    <th>Badania RT</th>
                    <th>Badania PT</th>
                    <th>Badania VT</th>
                    <th colspan="2">Akcja</th>
                </tr>

                <c:forEach var="system" items="${systems}">
                    <tr>
                        <td><a href="/drawings/list/${system.id}" class="btn btn-primary">${system.name}</a></td>
                        <td>${system.rtPercentage*100} %</td>
                        <td>${system.ptPercentage*100} %</td>
                        <td>${system.VTPercentage*100} %</td>

                        <td><a href="#" onclick="confirmDelete(${system.id}, '${system.name}')" class="btn btn-danger">Usuń</a></td>
                        <td><a href="/system/update/${system.id}" class="btn btn-success">Edytuj</a></td>

                    </tr>
                </c:forEach>
            </table>

            <a href="/system/add" class="btn btn-success">Dodaj System</a>
            <a href="/" class="btn btn-dark" style="margin-left: 50px">Home</a>
        </div>
    </div>
</div>

</body>
</html>
