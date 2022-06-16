<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>UPDATE PROJECT</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>

<body>
<h2 class="btn-success">UPDATE PROJECT</h2>
<br/>
<br/>
<form class="row g-3" method="POST" action="projects/updateProject">
    <input type="hidden" name="updateId" value="${updateId}">
    <div class="col-md-6">
        <label class="form-label" for="name"><strong>Enter new name</strong></label>
        <input class="form-control" type="text" name="name" id="name" placeholder="project/name">
        <div style="color: green" if="${fields.hasErrors('name')}" errors="${name}">Name must not be decimal</div>
    </div>
    <br/>
    <br/>
        <div class="col-md-6">
            <label class="form-label" for="info"><strong>Enter info</strong></label>
            <input class="form-control" type="text" name="info" id="info" placeholder="project/info">
            <div style="color: green" if="${fields.hasErrors('info')}" errors="${info}">Info must not be decimal</div>

        </div>
        <br/>
        <br/>
        <div class="col-md-6">
             <label class="form-label" for="status"><strong>Enter status</strong></label>
             <input class="form-control" type="text" name="status" id="status" placeholder="developer/status">
             <div style="color: green" if="${fields.hasErrors('status')}" errors="${status}">Status must be positive decimal</div>

        </div>
        <br/>
        <br/>
    <div class="col-md-6">
        <label class="form-label" for="cost"><strong>Enter cost</strong></label>
        <input class="form-control" type="text" name="cost" id="cost" placeholder="project/cost">
        <div style="color: green" if="${fields.hasErrors('cost')}" errors="${cost}">Cost must be decimal and between 1 decimal and 8</div>

    <div class="col-md-6">
        <label class="form-label" for="date_creation"><strong>Enter date_creation</strong></label>
        <input class="form-control" type="text" name="date_creation" id="date_creation" placeholder="project/date_creation">
        <div style="color: green" if="${fields.hasErrors('date_creation')}" errors="${date_creation}">Date_creation must be decimal. Example 2021-03-03</div>
    </div>
    <br/>
    <br/>
    <h4 style="color: blue">If you write wrong field, page will refresh</h4>
    <input class="btn btn-success" type="submit" value="Update"/>
</form>
</body>
</html>

