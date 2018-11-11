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

<form:form method="post" modelAttribute="system">
    <div class="container">
        <h3>Dodawanie/Edycja Systemu</h3>
        <div class="card">
            <div class="card-body">

                <div class="form-group">
                    <label for="nameId">Nazwa Systemu</label>
                    <form:input type="text" path="name" id="nameId" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="rtPercentageId">Badania RT</label>
                    <form:input type="number" step="0.01" path="rtPercentage" id="rtPercentageId" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="ptPercentageId">Badania PT</label>
                    <form:input type="number" step="0.01" path="ptPercentage" id="ptPercentageId" class="form-control"/>
                </div>



                <button type="submit" class="btn btn-primary">Zapisz</button>

            </div>
        </div>
        <br>
        <a href="/system/list" class="btn btn-primary">Lista Systemów</a>
    </div>

</form:form>

</body>
</html>
