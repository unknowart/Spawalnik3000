<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Lista spoin</title>
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
    <h3>Rysunek: ${drawing.dwgNumber} </h3>
    <div class="card-header">
        <a href="/" class="btn btn-dark" style="margin: 10px">Home</a>
        <a href="/drawings/list/${system.id}" class="btn btn-dark" id="float-right"
           style="margin: 10px">Powrót</a>
        <a href="/drawings/sheet/full/${system.id}/${drawing.id}" class="btn btn-dark" style="margin: 10px">Podgląd</a>
        <div class="card-body">

            <div>
                <table border="1">

                    <tr>
                        <th>Nr spoiny</th>
                        <th>Typ spoiny</th>
                        <th>Met. Spawania</th>
                        <th>Średnica</th>
                        <th>Gr.Ścianki</th>
                        <th>Materiał</th>
                        <th>Spawacz</th>
                        <th>RT</th>
                        <th>PT</th>
                        <th colspan="2">Akcja</th>
                    </tr>

                    <c:forEach var="weld" items="${dwgW.weldList}" varStatus="i">
                        <form:form method="post" modelAttribute="weld">

                            <tr>


                                <td><form:input type="text" path="weldNo" id="weldNoId" value="${weld.weldNo}"
                                                size="7"/></td>
                                <td><form:input type="text" path="typeJoint" id="typeJointId" value="${weld.typeJoint}"
                                                size="8"/></td>
                                <td><form:input type="text" path="typeWelding" id="typeWeldingId"
                                                value="${weld.typeWelding}" size="10"/></td>
                                <td><form:input type="number" step="1" path="diameter" id="diameterId"
                                                value="${weld.diameter}" style="width: 7em"/></td>
                                <td><form:input type="number" step="1" path="wallThickness" id="wallThicknessId"
                                                value="${weld.wallThickness}" style="width: 7em"/></td>
                                <td><form:input type="text" path="material" id="materialId" value="${weld.material}"
                                                size="10"/></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${empty weld.welder.id}">
                                            <form:select path="welder.id" id="welderId" items="${welders}"
                                                         itemLabel="welderNo"
                                                         itemValue="id" value="${weld.welder.id}"/>
                                        </c:when>
                                        <c:when test="${not empty weld.welder.id}">
                                            <form:input path="welder.id" id="welderId" itemLabel="welderNo"
                                                        itemValue="id" value="${weld.welder.id}" style="width: 5em"/>
                                        </c:when>
                                    </c:choose>
                                </td>
                                <td><form:input type="text" path="rtNdt" value="${weld.rtNdt}" size="10"/></td>
                                <td><form:input type="text" path="ptNdt" value="${weld.ptNdt}" size="10"/></td>
                                <td>
                                    <c:if test="${not empty weld.weldNo}">
                                        <a href="../../sheet/delete/${weld.drawing.pipingSys.id}/${weld.drawing.id}/${weld.id}"
                                           class="btn btn-danger">Usuń</a>
                                    </c:if>
                                </td>

                                <td>
                                    <c:if test="${empty weld.weldNo}">
                                        <button type="submit" class="btn btn-success">Zapisz</button>
                                    </c:if>
                                </td>
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


