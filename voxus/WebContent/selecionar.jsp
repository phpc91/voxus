<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
	<style>
		.centered {
			margin-right: auto;
			margin-left: auto;
			text-align: center;
		}
		
		.g-signin2 {
			width: 100%;
		}
		
		.g-signin2>div {
			margin: 0 auto;
		}
		
		.wrapper {
			text-align: center;
		}
		.wrapper ul {
			display: inline-block;
			zoom: 1;
			*display: inline;
			/*padding-left: 45px;*/
			margin-top: 0px;
		}
		.wrapper li {
			padding: 2px 5px;
		}
		.list-control {
			/*width: 255px;
			text-align: left;*/
		}
		.list-radio {
			display: inline;
		}

	</style>
	
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.blue-indigo.min.css">
	<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
	<link rel="stylesheet" href="/voxus/resources/getmdl-select.min.css" />
	<script defer src="/voxus/resources/getmdl-select.min.js"></script>
	<meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="824936642626-i3js3noabvj69nbt6eekp03n42kmi570.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
	<meta charset="UTF-8">
	<title>Voxus CRUD</title>
</head>
<body>
	<% String[] nomesTasks = (String[])request.getAttribute("nomesTasks"); %>
	<div class="centered wrapper">
		<h5>Escolha uma task para ser <strong>editada</strong></h5>
		<form method="post" action="${pageContext.request.contextPath}/selecionar">
			<ul class="list-control mdl-list">
				<%for (int i=0; i<nomesTasks.length; i++){ %>
	       		<li class="mdl-list__item">
					<label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="task<%=i%>">
						<input type="radio" id="task<%=i%>" class="mdl-radio__button" name="tasks" value=<%= i %>> 
						<span class="mdl-radio__label"><%= nomesTasks[i] %></span>
					</label><br>
				</li>
				<%}%>
			</ul>
			<br>
			<input class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--raised mdl-button--colored" 
				type="submit" value="Editar Task">
		</form>
	</div>
</body>
</html>