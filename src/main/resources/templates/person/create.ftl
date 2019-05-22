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



		<form action="/person/create" method="POST">
		
			<div class="form-group">
				<label for="name">Name</label>
				 <input 
					 type="text" 
					 class="form-control" 
					 id="name"
					 name="name"
					 placeholder="Enter name">
			</div>
			
			<div class="form-group">
			
				<label for="surname">Surname</label>
				 <input 
					 type="text" 
					 class="form-control" 
					 id="surname"
					 name="surname"
					 placeholder="Enter surname">
			</div>
			
			<div class="form-group">
				<label for="email">Email</label>
				 <input 
					 type="email" 
					 class="form-control" 
					 id="email"
					 name="email"
					 placeholder="Enter email">
			</div>
			
			<input type="submit" class="btn btn-primary" value="Send" />
			<input type="reset" class="btn btn-danger" value="Reset" />
			
		</form>

	</div>
</body>
</html>