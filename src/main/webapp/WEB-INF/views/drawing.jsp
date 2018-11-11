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

<form:form method="post" modelAttribute="drawing">
    <div class="container">
        <h3>Dodawanie/Edycja Rysunku</h3>
        <div class="card">
            <div class="card-body">

                <div class="form-group">
                    <label for="dwgNumberId">Numer Rysunku</label>
                    <form:input type="text" path="dwgNumber" id="dwgNumberId" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="pipingSysId">System: </label>
                    <form:select path="pipingSys.id" id="pipingSysId" items="${pipingSys}" itemLabel="name"
                                 itemValue="id" selected="${drawing.pipingSys}" class="form-control"/>
                </div>


                <button type="submit" class="btn btn-primary">Zapisz</button>

            </div>
        </div>
        <br>
        <a href="/drawings/list/${system.id}" class="btn btn-primary">Lista Rysunków</a>
    </div>
</form:form>

</body>
</html>
