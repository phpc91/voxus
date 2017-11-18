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
	.wrapper {
		text-align: center;
	}
	.wrapper ul {
		display: inline-block;
		/* For IE, the outcast */
		zoom: 1;
		*display: inline;
		padding-left: 45px;
		margin-top: 0px;
	}
	.wrapper li {
		padding: 2px 5px;
	}
	.list-control {
		width: 255px;
		text-align: left;
	}
	.list-radio {
		display: inline;
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
	<% String[] nomesTasks = (String[]) request.getAttribute("nomesTasks"); %>
	
	<div class="centered">
		<h1>Dashboard</h1>
		<table style="width:90%; margin:auto" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
			<thead>
				<tr>
					<th class="mdl-data-table__cell--non-numeric">Título</th>
					<th class="mdl-data-table__cell--non-numeric">Descrição</th>
					<th class="mdl-data-table__cell--non-numeric">Anexos</th>
					<th class="mdl-data-table__cell--non-numeric">Usuário Responsável</th>
					<th>Prioridade</th>
				</tr>
			</thead>
			<tbody>
		<% for(int i=0; i< nomesTasks.length; i++){ %>
			<tr>
				<td class="mdl-data-table__cell--non-numeric"><%= nomesTasks[i] %></td>
				<td class="mdl-data-table__cell--non-numeric"></td>
				<td class="mdl-data-table__cell--non-numeric"></td>
				<td class="mdl-data-table__cell--non-numeric"></td>
				<td></td>
			</tr>
		<% } %>
		</tbody>
		</table>
		
		<br>
		
		<div id="botoes">
			<h4>Operações sobre tasks</h4>
			<button
				class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--raised"
				onclick="location.href='/voxus/criar'" type="button">
				<strong>Criar</strong>
			</button>
			&emsp;
			<button
				class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--raised"
				onclick="location.href='/voxus/selecionar'" type="button">
				<strong>Editar</strong>
			</button>
			&emsp;
			<button
				class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--raised"
				onclick="location.href='/voxus/apagar'" type="button">
				<strong>Apagar</strong>
			</button>
		</div>
		
		<br>
		<br>
		<br>
		<button
			class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--raised mdl-button--colored"
			onclick="location.href='/voxus'" type="button">
			<i class="mdl-icon-toggle__label material-icons" style="color:white">arrow_back</i>
			<strong>Voltar</strong>
		</button>
	</div>
</body>
</html>