<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>UPDATE CUSTOMER</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Main page</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/companies">Companies</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/customers">Customers</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/developers">Developers</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/projects">Projects</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/skills">Skills</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<h2 class="btn-success">CREATE NEW CUSTOMER</h2>
<br/>
<br/>
<form class="row g-3" method="POST" action="customers/createCustomer">
    <div class="col-md-6">
        <label class="form-label" for="id"><strong>Enter id</strong></label>
        <input class="form-control" type="text" name="id" id="id" placeholder="customers/id">
        <div style="color: green"  errors="${id}">Id must be decimal</div>
    </div>
    <br/>
    <br/>
    <div class="col-md-6">
        <label class="form-label" for="name"><strong>Enter name</strong></label>
        <input class="form-control" type="text" name="name" id="name" placeholder="customers/name">
        <div style="color: green" if="${fields.hasErrors('name')}" errors="${name}">Name must not be decimal</div>
    </div>
    <br/>
    <br/>
        <div class="col-md-6">
            <label class="form-label" for="state_code"><strong>Enter state_code</strong></label>
            <input class="form-control" type="text" name="state_code" id="state_code" placeholder="customers/state_code">
            <div style="color: green" if="${fields.hasErrors('state_code')}" errors="${state_code}">State_code must be positive decimal</div>
        </div>
        <br/>
        <br/>
    <div class="col-md-6">
        <label class="form-label" for="country"><strong>Enter country</strong></label>
        <input class="form-control" type="text" name="country" id="country" placeholder="customers/country">
        <div style="color: green" if="${fields.hasErrors('country')}" errors="${country}">Country must not be decimal</div>
    </div>
    <br/>
    <br/>
      <div class="col-md-6">
            <label class="form-label" for="birthday"><strong>Enter birthday</strong></label>
            <input class="form-control" type="text" name="birthday" id="birthday" placeholder="customers/birthday">
            <div style="color: green" if="${fields.hasErrors('birthday')}" errors="${birthday}">Birthday must be  decimal. Example 2021-03-03</div>

        </div>
        <br/>
        <br/>

    <div class="col-md-6">
        <label class="form-label" for="sex"><strong>Enter sex</strong></label>
        <input class="form-control" type="text" name="sex" id="sex" placeholder="customers/sex">
        <div style="color: green" if="${fields.hasErrors('sex')}" errors="${sex}">Sex must be (man) or (woman)</div>
    </div>
    <br/>
    <br/>
        <div class="col-md-6">
            <label class="form-label" for="info"><strong>Enter info</strong></label>
            <input class="form-control" type="text" name="info" id="info" placeholder="customers/info">
            <div style="color: green" if="${fields.hasErrors('info')}" errors="${info}">Info must not be decimal</div>
        </div>
        <br/>
        <br/>

    <h4 style="color: blue">If you write wrong field, page will refresh</h4>
    <input class="btn btn-success" type="submit"  value="Create"/>
</form>
</body>
</html>