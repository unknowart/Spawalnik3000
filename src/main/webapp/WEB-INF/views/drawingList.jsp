<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Lista Rysunków</title>
    <link href="../../css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <script>
        function confirmDelete(id, title) {
            if (confirm("Czy na pewno usunąć rysunek \"" + title + "\"")) {
                window.location.href = "/drawings/delete/" + id;
            }
        }
    </script>
</head>
<body class="body">


<div class="container">

    <h2 class="card-header">${system.name}</h2>
    <div class="card-header">
        <div class="first"> Wszystkich spoin:${allWelds}</div>
        <div class="first">Przebadano RT: ${rtTested}</div>
        <div class="first">Przebadano PT: ${ptTested}</div><br>

        <p style="margin: 10px">Badania RT: ${percRt} % / ${system.rtPercentage*100} %</p>
        <p style="margin: 10px">Badania PT: ${percPt} % / ${system.ptPercentage*100} %</p>
        <div class="card-body">
            <table class="table table-hover">
                <tr>
                    <th>Nr. Rysunku</th>
                    <th colspan="2">Akcja</th>
                </tr>

                <c:forEach var="drawing" items="${drawings}">
                    <tr>
                        <td><a href="/drawings/sheet/${drawing.pipingSys.id}/${drawing.id}" class="btn btn-primary">${drawing.dwgNumber}</a></td>

                        <td><a href="#" onclick="confirmDelete(${drawing.id}, '${drawing.dwgNumber}')" class="btn btn-danger">Usuń</a></td>
                        <td><a href="/drawings/update/${drawing.id}" class="btn btn-success">Edytuj</a></td>

                    </tr>
                </c:forEach>
            </table>

            <a href="/drawings/add/${system.id}" class="btn btn-success">Dodaj Rysunek</a>
            <a href="/system/list" class="btn btn-dark" style="margin-left: 50px">Powrót</a>
            <a href="/" class="btn btn-dark" style="margin-left: 50px">Home</a>

        </div>
    </div>
</div>
</body>
</html>
