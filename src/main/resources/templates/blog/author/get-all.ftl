<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="container">

		<nav class="navbar navbar-expand-lg navbar-light bg-light">

			<a class="navbar-brand" href="/author/">Hipster-WebApp</a>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">

				<ul class="navbar-nav mr-auto">

					<li class="nav-item"><a class="nav-link" href="/author/create">Create author</a></li>
					<li class="nav-item"><a class="nav-link"href="/author/get-all">Author list</a></li>
				</ul>

			</div>
		</nav>


		<h3>${info}</h3>

		<table class="table">

			<thead>
				<tr>
					<th scope="col">Author ID</th>
					<th scope="col">Name</th>
					<th scope="col">Surname</th>
					<th scope="col">E-mail</th>
					<th scope="col">Birth date</th>
					<th scope="col"></th>
					<th scope="col"></th>
				</tr>
			</thead>

			<tbody>
				<#list authors as author>

				<tr>
					<td>${author.authorId}</td>
					<td>${author.name}</td>
					<td>${author.surname}</td>
					<td>${author.email}</td>+
					<td>${author.birthDate}</td>
					<td><a href="/author/edit/${author.authorId}" class="btn btn-secondary">Edit</a></td>
					<td><a href="/author/delete/${author.authorId}" class="btn btn-danger">Delete</a></td>
				</tr>
				</#list>

			</tbody>
		</table>
	</div>
</body>
</html>