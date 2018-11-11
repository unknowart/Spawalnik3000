<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>WPS List</title>
    <%--<link href="../css/bootstrap.min.css" rel="stylesheet">--%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link href="../css/main.css" rel="stylesheet">
    <script>
        function confirmDelete(id, title) {
            if (confirm("Czy na pewno usunąć WPS \"" + title + "\"")) {
                window.location.href = "/wps/delete/" + id;
            }
        }
    </script>
</head>
<body class="body">
<div class="container">
    <h3 class="card-header">Lista WPSów</h3>
    <div class="card-header">
        <div class="card-body">
            <table class="table table-hover">
                <tr>
                    <th>Numer WPS</th>
                    <th>Materiał</th>
                    <th>Gr. Materiałowa</th>
                    <th>Metoda Spaw.</th>
                    <th>Mat. Spawalniczy</th>
                    <th>Typ spoiny</th>
                    <th>Zakres - Średnica</th>
                    <th>Zakres - gr.Ścianki</th>
                    <th colspan="2">Akcja</th>
                </tr>

                <c:forEach var="wps" items="${wpses}">
                    <tr>
                        <td>${wps.wpsNumber}</td>
                        <td>${wps.material}</td>
                        <td>${wps.materialGr}</td>
                        <td>${wps.weldingType}</td>
                        <td>${wps.fillerMaterial}</td>
                        <td>${wps.weldType}</td>
                        <td>${wps.minDiameter} - ${wps.maxDiameter}</td>
                        <td>${wps.minWallThickness} - ${wps.maxWallThickness}</td>

                        <td><a href="#" onclick="confirmDelete(${wps.id}, '${wps.wpsNumber}')" class="btn btn-danger">Usuń</a></td>
                        <td><a href="/wps/update/${wps.id}" class="btn btn-success">Edytuj</a></td>

                    </tr>
                </c:forEach>
            </table>

            <a href="/wps/add" class="btn btn-success">Dodaj WPS</a>
            <a href="/" class="btn btn-dark" style="margin-left: 50px">Home</a>
        </div>
    </div>
    <br>

</div>
</body>
</html>
