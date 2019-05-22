<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<script type="text/javascript">

function deletePerson(id) {
	alert("delete person: " + id);
}

function editPerson(id) {
	alert("Edit person: " + id);
}

</script>
<body>

	<div class="container">

		<nav class="navbar navbar-expand-lg navbar-light bg-light">

			<a class="navbar-brand" href="/person">Hipster-WebApp</a>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">

				<ul class="navbar-nav mr-auto">

					<li class="nav-item"><a class="nav-link" href="/person">Home
							<span class="sr-only">(current)</span>
					</a></li>

					<li class="nav-item"><a class="nav-link" href="/person/create">Create</a>
					</li>

					<li class="nav-item"><a class="nav-link"
						href="/person/get-all">Get All</a></li>
				</ul>

			</div>
		</nav>

		<h3>${info}</h3>

		<table class="table">

			<thead>
				<tr>
					<th scope="col">Person ID</th>
					<th scope="col">Name</th>
					<th scope="col">Surname</th>
					<th scope="col">E-mail</th>
					<th scope="col"></th>
					<th scope="col"></th>
				</tr>
			</thead>

			<tbody>
				<#list persons as person>

				<tr>
					<td>${person.personId}</td>
					<td>${person.name}</td>
					<td>${person.surname}</td>
					<td>${person.email}</td>
					<td><a href="" onclick="editPerson(${person.personId})" class="btn btn-primary">Edit</a></td>
					<td><a href="" onclick="deletePerson(${person.personId})"  class="btn btn-danger">Delete</a></td>
				</tr>
				</#list>



			</tbody>
		</table>
	</div>

</body>
</html>