<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>WPS</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body class="body">

<form:form method="post" modelAttribute="wps">
    <div class="container">
        <h3>Dodawanie/Edycja WPSów</h3>
        <div class="card">
            <div class="card-body">

                <div class="form-group">
                    <label for="wpsNumberId">Numer WPS</label>
                    <form:input type="text" path="wpsNumber" id="wpsNumberId" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="materialId">Materiał</label>
                    <form:input type="text" path="material" id="materialId" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="materialGrId">Gr. Materiałowa</label>
                    <form:input type="text" path="materialGr" id="materialGrId" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="weldingTypeId">Met. Spawania</label>
                    <form:input type="text" path="weldingType" id="weldingTypeId" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="fillerMaterialId">Materiał Spaw.</label>
                    <form:input type="text" path="fillerMaterial" id="fillerMaterialId" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="weldTypeId">Typ Spoiny</label>
                    <form:input type="text" path="weldType" id="weldTypeId" class="form-control"/>
                </div>

                <div class="form-group">
                        <label>Zakres średnica:</label><br>
                    Min: <form:input type="number" path="minDiameter" id="minDiameterId"/>
                    Max: <form:input type="number" path="maxDiameter" id="maxDiameterId"/>
                </div>

                <div class="form-group">
                    <label>Zakres gr. ścianki:</label><br>
                    Min: <form:input type="number" path="minWallThickness" id="minWallThickness"/>
                    Max: <form:input type="number" path="maxWallThickness" id="maxWallThickness"/>
                </div>

                <button type="submit" class="btn btn-primary">Zapisz</button>

            </div>
        </div>
        <br>
        <a href="/wps/list" class="btn btn-primary">Lista WPSów</a>
    </div>

</form:form>

</body>
</html>
