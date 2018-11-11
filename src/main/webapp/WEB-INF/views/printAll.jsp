<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Lista spoin</title>
    <%--<link href="../css/bootstrap.min.css" rel="stylesheet">--%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link href="../css/style.css" rel="stylesheet">
    <script>
        function confirmDelete(id, title) {
            if (confirm("Czy na pewno usunąć rysunek \"" + title + "\"")) {
                window.location.href = "/drawings/delete/" + id;
            }
        }
    </script>
</head>
<body class="body">
<div class="card-header">
    <h2>System: ${drawing.pipingSys.name}</h2>
    <div class="card-header">
        <a href="/drawings/sheet/${system.id}/${drawing.id}" class="btn btn-dark" id="float-right"
           style="margin: 10px">Powrót</a>
        <a href="/" class="btn btn-dark" style="margin: 10px">Home</a>
        <div class="card-body">

            <div>
                <table border="1">

                    <tr>
                        <th>Nr. Rysunku</th>
                        <th>Nr spoiny</th>
                        <th>Typ spoiny</th>
                        <th>Met. Spawania</th>
                        <th>Średnica</th>
                        <th>Gr.Ścianki</th>
                        <th>Materiał</th>
                        <th>Gr. Mat.</th>
                        <th>Mat. Dod.</th>
                        <th>Spawacz</th>
                        <th>WPS</th>
                        <th style="width: 100px">RT</th>
                        <th style="width: 100px">PT</th>
                    </tr>

                    <c:forEach var="weld" items="${welds}" varStatus="i">
                        <form:form method="post" modelAttribute="weld">

                            <tr >

                                <td>${drawing.dwgNumber}</td>
                                <td>${weld.weldNo}</td>
                                <td>${weld.typeJoint}</td>
                                <td>${weld.typeWelding}</td>
                                <td>${weld.diameter}</td>
                                <td>${weld.wallThickness}</td>
                                <td>${weld.material}</td>
                                <td>${weld.wps.materialGr}</td>
                                <td>${weld.wps.fillerMaterial}</td>
                                <td>${weld.welder.welderNo}</td>
                                <td>${weld.wps.wpsNumber}</td>
                                <td>${weld.rtNdt}</td>
                                <td>${weld.ptNdt}</td>

                            </tr>
                        </form:form>

                    </c:forEach>
                </table>

            </div>
        </div>
    </div>
</div>
</body>
</html>
