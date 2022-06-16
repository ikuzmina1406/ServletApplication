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
<h2 class="btn-success">UPDATE CUSTOMER</h2>
<br/>
<br/>
<form class="row g-3" method="POST" action="customers/updateCustomer">
    <input type="hidden" name="updateId" value="${updateId}">
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
    <input class="btn btn-success" type="submit"  value="Update"/>
</form>
</body>
</html>