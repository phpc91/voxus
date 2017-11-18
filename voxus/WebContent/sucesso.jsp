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
	<meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="824936642626-i3js3noabvj69nbt6eekp03n42kmi570.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
	<meta charset="UTF-8">
	<title>Voxus CRUD</title>
</head>
<body>
	<div class="centered">
		<h4>Operação realizada com sucesso</h4>
		<button
				class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--raised mdl-button--colored"
				onclick="location.href='/voxus/dash'" type="button">
				<i class="mdl-icon-toggle__label material-icons" style="color:white">arrow_back</i>
				<strong>Voltar Para Dashboard &ensp;</strong>
		</button>
	</div>
</body>
</html>