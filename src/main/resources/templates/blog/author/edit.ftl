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


		<h2>${info}</h2>

		<form action="/author/create" method="POST">
		
			<div class="form-group">
				<label for="name">Name</label>
				 <input 
					 id="name"
					 name="name"
					 type="text" 
					 class="form-control" 
					 placeholder="Enter name">
			</div>
			
			<div class="form-group">
			
				<label for="surname">Surname</label>
				 <input 
					 type="text" 
					 id="surname"
					 name="surname"
					 class="form-control" 
					 placeholder="Enter surname">
			</div>
			
			<div class="form-group">
				<label for="email">Email</label>
				 <input 
					 id="email"
					 type="email" 
					 name="email"
					 class="form-control" 
					 placeholder="Enter email">
			</div>
			
			<div class="form-group">
			
				<label for="birth-date">Email</label>
				
				<input type="date" 
					id="birth-date" 
					class="form-control" 
					name="birthDate"
					value="2018-07-22">
			</div>
			
			<input type="submit" class="btn btn-secondary" value="Save" />
			
		</form>
	</div>
</body>
</html>