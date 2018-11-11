<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Welder</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body class="body">

<form:form method="post" modelAttribute="welder">
    <div class="container">
        <h3>Dodawanie/Edycja Spawacza</h3>
        <div class="card">
            <div class="card-body">

                <div class="form-group">
                    <label for="firstNameId">Imię</label>
                    <form:input type="text" path="firstName" id="firstNameId" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="lastNameId">Nazwisko</label>
                    <form:input type="text" path="lastName" id="lastNameId" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="welderNoId">Numer Spawacza</label>
                    <form:input type="text" path="welderNo" id="welderNoId" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="certificateNoId">Numer Certyfikatu</label>
                    <form:input type="text" path="certificateNo" id="certificateNoId" class="form-control"/>
                </div>

                <div class="form-group">
                        <label>Zakres uprawnień średnica:</label><br>
                    Min: <form:input type="number" step="1" path="minDiameter" id="minDiameterId"/>
                    Max: <form:input type="number" step="1" path="maxDiameter" id="maxDiameterId"/>
                </div>

                <div class="form-group">
                    <label>Zakres uprawnień gr. ścianki:</label><br>
                    Min: <form:input type="number" step="0.1" path="minWallThickness" id="minWallThickness"/>
                    Max: <form:input type="number" step="0.1" path="maxWallThickness" id="maxWallThickness"/>
                </div>

                <button type="submit" class="btn btn-primary">Zapisz</button>

            </div>
        </div>
        <br>
        <a href="/welders/list" class="btn btn-primary">Lista Spawaczy</a>
    </div>

</form:form>

</body>
</html>
