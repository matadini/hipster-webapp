<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
</head>

<script>
jQuery(document).ready(function($){
  op = function(obj) {
    $(obj).stop().slideToggle();
    };
});


</script>

<body>

	<div class="container">

		<nav class="navbar navbar-expand-lg navbar-light bg-light">

			<a class="navbar-brand" href="/author/">Hipster-WebApp Authors</a>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">

				<ul class="navbar-nav mr-auto">

					<li class="nav-item"><a class="nav-link" href="/author/create">Create author</a></li>
					<li class="nav-item"><a class="nav-link"href="/author/get-all">Author list</a></li>
				</ul>

			</div>
		</nav>


		<h3>${info}</h3>

		<div class="form-group">
		
			<ul>
				<#list authors as author>
				

					<li class="navbar-nav">
					
						<a href="#" onClick="op('#${author.articleAuthorId}');">${author.name}</a>
						<div id="${author.articleAuthorId}" style="display: none;">
						
						<ul>
							<#list author.articles as article>
								
								<li class="navbar-nav">
								
									<a href="#" onClick="op('#${article.viewUUID}');">${article.title}</a>
							
									<div id="${article.viewUUID}" style="display: none;">
										${article.content}
									</div>
									
								</li>
								
							</#list>
						</ul>
							
						</div>
					</li>
					
				</#list>
			</ul>
			
		</div>


	</div>
</body>
</html>