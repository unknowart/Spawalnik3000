<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Lista Spawaczy</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link href="../css/main.css" rel="stylesheet">
    <script>
        function confirmDelete(id, title) {
            if (confirm("Czy na pewno usunąć spawacza \"" + title + "\"")) {
                window.location.href = "/welders/delete/" + id;
            }
        }
    </script>
</head>
<body class="body">

<div class="container">
    <h3 class="card-header">Lista Spawaczy</h3>
    <div class="card-header">
        <div class="card-body">
            <table class="table table-hover">
                <tr>
                    <th>Imię</th>
                    <th>Nazwisko</th>
                    <th>Nr Spawacz</th>
                    <th>Cert No.</th>
                    <th>Zakres Upr. Średnica</th>
                    <th>Zakres Upr. gr.Ścianki</th>
                    <th>Il. Spoin</th>
                    <th colspan="2">Akcja</th>
                </tr>

                <c:forEach var="welder" items="${welders}">
                    <c:set var="total" value="${0}"/>
                    <tr>
                        <td>${welder.firstName}</td>
                        <td>${welder.lastName}</td>
                        <td>${welder.welderNo}</td>
                        <td>${welder.certificateNo}</td>
                        <td>${welder.minDiameter} - ${welder.maxDiameter}</td>
                        <td>${welder.minWallThickness} - ${welder.maxWallThickness}</td>
                        <c:forEach var="weld" items="${welds}">
                            <c:if test="${weld.welder.id == welder.id}"><c:set var="total" value="${total+1}"></c:set></c:if>
                        </c:forEach>
                        <td>${total}</td>

                        <td><a href="#" onclick="confirmDelete(${welder.id}, '${welder.firstName}')" class="btn btn-danger">Usuń</a></td>
                        <td><a href="/welders/update/${welder.id}" class="btn btn-success">Edytuj</a></td>

                    </tr>
                </c:forEach>
            </table>

            <a href="/welders/add" class="btn btn-success">Dodaj Spawacza</a>
            <a href="/" class="btn btn-dark" style="margin-left: 50px">Home</a>
        </div>
    </div>


</div>
</body>
</html>
