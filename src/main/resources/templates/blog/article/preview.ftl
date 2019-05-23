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

			<a class="navbar-brand" href="/article/">Hipster-WebApp Authors</a>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">

				<ul class="navbar-nav mr-auto">

					<li class="nav-item"><a class="nav-link" href="/article/create">Create article</a></li>
					<li class="nav-item"><a class="nav-link"href="/article/get-all">Article list</a></li>
				</ul>

			</div>
		</nav>


		<h2>Add new author</h2>

		<form action="/article/create" method="POST">
		
			<div class="form-group">
				<label for="authors-id">Author</label>
				<select id="authors-id" name="authors-id" class="form-control">
				
					<#list authors as item>
						<option value="${item.articleAuthorId}"> ${item.name} + ${item.surname} </option>
					</#list>
					
				</select>
			</div>
			
			<div class="form-group">
				<label for="title">Title</label>
				 <input 
					 id="title"
					 name="title"
					 type="text" 
					 class="form-control" 
					 placeholder="Enter name">
			</div>
			
			
			<div class="form-group">
				<label for="content">Content</label>
				<textarea 
				 	class="form-control" 
					id="content" 
					name="content" 
					rows="20" 
					placeholder="Content"
					cols="50"></textarea>
			</div>

			
			<input type="submit" class="btn btn-secondary" value="Save" />
			
		</form>
	</div>
</body>
</html>