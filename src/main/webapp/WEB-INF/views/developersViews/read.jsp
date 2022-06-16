<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Developer page</title>
    <meta charset="UTF-8">
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


<div class="container">
    <div class="row">
        <h2>Developers page</h2>
    </div>

    <div class="row">
        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group me-2" role="group" aria-label="Second group">
                <a href="developers/createDeveloper" type="button" class="btn btn-primary">Add developer</a>
            </div>
        </div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Name</th>
                <th scope="col">First_name</th>
                <th scope="col">last_name</th>
                <th scope="col">Age</th>
                <th scope="col">Birthday</th>
                <th scope="col">Sex</th>
                <th scope="col">State_code</th>
                <th scope="col">Country</th>
                <th scope="col">Address</th>
                <th scope="col">Status</th>
                <th scope="col">Salary</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="developers" items="${developers}" varStatus="session">
                <tr>
                    <td><c:out value = "${developers.id}"/></td>
                    <td><c:out value = "${developers.name}"/></td>
                    <td><c:out value = "${developers.first_name}"/></td>
                    <td><c:out value = "${developers.last_name}"/></td>
                    <td><c:out value = "${developers.age}"/></td>
                     <td><c:out value = "${developers.birthday}"/></td>
                    <td><c:out value = "${developers.sex}"/></td>
                    <td><c:out value = "${developers.state_code}"/></td>
                    <td><c:out value = "${developers.country}"/></td>
                    <td><c:out value = "${developers.address}"/></td>
                    <td><c:out value = "${developers.status}"/></td>
                    <td><c:out value = "${developers.salary}"/></td>
                    <td>
                        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                            <div class="btn-group me-2" role="group" aria-label="Second group">
                                <a href="developers/updateDeveloper?updateId=<c:out value = '${developers.id}'/>" type="button" class="btn btn-warning">Edit</a>
                                <a href="developers/developers?deleteId=<c:out value = '${developers.id}'/>" type="button" class="btn btn-danger">Remove</a>
                            </div>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


</body>
</html>
