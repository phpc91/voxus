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
	<%String nomeTask = (String) request.getAttribute("nomeTask"); %>
	<div class="centered">
		<h4>Criar Task</h4>
		<form method="post" action="${pageContext.request.contextPath}/editar" enctype="multipart/form-data">
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input class="mdl-textfield__input" type="text" id="titulo" name="titulo"
					value=<%= nomeTask %> > 
				<label class="mdl-textfield__label" for="titulo">Título</label>
			</div><br>
			
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input class="mdl-textfield__input" type="text" id="descricao" name="descricao"
					value=""> 
				<label class="mdl-textfield__label" for="descricao">Descrição</label>
			</div><br>
			
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<input title="Insira um número de 1 a 5" 
					class="mdl-textfield__input" type="text" pattern="[1-5]" id="prioridade" name="prioridade"
					value=""> 
				<label class="mdl-textfield__label" for="prioridade">Prioridade</label>
			</div><br>
			
			<div class="mdl-textfield mdl-js-textfield">
				<input type="file" name="upload" multiple>
  			</div>
			<br><br>
			<input class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--raised mdl-button--colored" 
				type="submit" value="Salvar Task">
		</form>
	</div>
</body>
</html>