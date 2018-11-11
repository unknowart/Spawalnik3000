<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Weld</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body class="body">

<form:form method="post" modelAttribute="weld">
    <div class="container">
        <h3>Dodawanie/Edycja Spoiny</h3>

                weldno<form:input type="text" path="weldNo" id="weldNoId"/>
                type joint<form:input type="text" path="typeJoint" id="typeJointId"/>
                typeweld<form:input type="text" path="typeWelding" id="typeWeldingId"/>
                diameter<form:input type="number" step="1" path="diameter" id="diameterId"/>
                wall<form:input type="number" step="1" path="wallThickness" id="wallThicknessId"/>
                material<form:input type="text" path="material" id="materialId"/>
                welder<form:select path="welder.id" id="welderId" items="${welders}" itemLabel="welderNo"
                             itemValue="id"/>

                <button type="submit" class="btn btn-primary">Zapisz</button>



        <br>
        <a href="/welds/list" class="btn btn-primary">Lista Rysunków</a>
    </div>

</form:form>

</body>
</html>
