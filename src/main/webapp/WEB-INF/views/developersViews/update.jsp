<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>UPDATE DEVELOPER</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>

<body>
<h2 class="btn-success">UPDATE DEVELOPER</h2>
<br/>
<br/>
<form class="row g-3" method="POST" action="developers/updateDeveloper">
    <input type="hidden" name="updateId" value="${updateId}">
 <div class="col-md-6">
        <label class="form-label" for="name"><strong>Enter name</strong></label>
        <input class="form-control" type="text" name="name" id="name" placeholder="developer/name">
        <div style="color: green" if="${fields.hasErrors('name')}" errors="${name}">Name must not be decimal</div>

    </div>
    <br/>
    <br/>
        <div class="col-md-6">
            <label class="form-label" for="first_name"><strong>Enter first_name</strong></label>
            <input class="form-control" type="text" first_name="first_name" id="first_name" placeholder="developer/first_name">
            <div style="color: green" if="${fields.hasErrors('first_name')}" errors="${first_name}">First_name must not be decimal</div>

     </div>
     <br/>
      <br/>
        <div class="col-md-6">
            <label class="form-label" for="last_name"><strong>Enter last_name</strong></label>
            <input class="form-control" type="text" last_name="last_name" id="last_name" placeholder="developer/last_name">
            <div style="color: green" if="${fields.hasErrors('last_name')}" errors="${last_name}">Last_name must not be decimal</div>

        </div>
        <br/>
        <br/>
    <div class="col-md-6">
        <label class="form-label" for="age"><strong>Enter age</strong></label>
        <input class="form-control" type="text" name="age" id="age" placeholder="developer/age">
        <div style="color: green" if="${fields.hasErrors('age')}" errors="${age}">Age must be positive decimal</div>

         </div>
        <br/>
        <br/>
      <div class="col-md-6">
            <label class="form-label" for="birthday"><strong>Enter birthday</strong></label>
            <input class="form-control" type="text" name="birthday" id="birthday" placeholder="developer/birthday">
            <div style="color: green" if="${fields.hasErrors('birthday')}" errors="${birthday}">Birthday must be positive decimal</div>

        </div>
        <br/>
        <br/>

    <div class="col-md-6">
        <label class="form-label" for="sex"><strong>Enter sex</strong></label>
        <input class="form-control" type="text" name="sex" id="sex" placeholder="developer/sex">
        <div style="color: green" if="${fields.hasErrors('sex')}" errors="${sex}">Sex must be (male) or (female)</div>

    </div>
    <br/>
    <br/>

     <div class="col-md-6">
         <label class="form-label" for="state_code"><strong>Enter state_code</strong></label>
         <input class="form-control" type="text" name="state_code" id="state_code" placeholder="developer/state_code">
         <div style="color: green" if="${fields.hasErrors('state_code')}" errors="${state_code}">State_code must be positive decimal</div>

     </div>
     <br/>
     <br/>

    <div class="col-md-6">
        <label class="form-label" for="country"><strong>Enter country</strong></label>
        <input class="form-control" type="text" name="country" id="country" placeholder="developer/country">
        <div style="color: green" if="${fields.hasErrors('country')}" errors="${country}">Country must not be decimal</div>

    </div>
    <br/>
    <br/>

    <div class="col-md-6">
        <label class="form-label" for="address"><strong>Enter address</strong></label>
        <input class="form-control" type="text" name="address" id="address" placeholder="developer/address">
        <div style="color: green" if="${fields.hasErrors('address')}" errors="${address}">Address must not be decimal</div>

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
        <label class="form-label" for="salary"><strong>Enter salary</strong></label>
        <input class="form-control" type="text" name="salary" id="salary" placeholder="developer/salary">
        <div style="color: green" if="${fields.hasErrors('salary')}" errors="${salary}">Salary must be decimal and between 1 decimal and 6</div>

    </div>
    <br/>
    <br/>
    <h4 style="color: blue">If you write wrong field, page will refresh</h4>
    <input class="btn btn-success" type="submit"  value="Update"/>
</form>
</body>
</html>