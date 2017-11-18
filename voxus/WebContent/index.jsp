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
		<h1>Home</h1>
		<div class="g-signin2" data-onsuccess="onSignIn" 
			data-theme="light" data-longtitle="true">
		</div>
		
		<br>
		<br>
		
		<div id="logout" style="display:none">
			<button
				class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--raised"
				onclick="location.href='/voxus/dash'" type="button"> 
				<strong>Ir Para Dashboard</strong>
			</button>
			&emsp;
			<button
				class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--raised mdl-button--colored"
				onclick="signOut()" type="button"> 
				<strong>Sair</strong>
			</button>
		</div>
	</div>
    <script>
		function onSignIn(googleUser) {
			// Useful data for your client-side scripts:
			var profile = googleUser.getBasicProfile();
			console.log("ID: " + profile.getId()); // Don't send this directly to your server!
			console.log('Full Name: ' + profile.getName());
			console.log('Given Name: ' + profile.getGivenName());
			console.log('Family Name: ' + profile.getFamilyName());
			console.log("Image URL: " + profile.getImageUrl());
			console.log("Email: " + profile.getEmail());
			
			// The ID token you need to pass to your backend:
			var id_token = googleUser.getAuthResponse().id_token;
			console.log("ID Token: " + id_token);
			
			document.getElementById("logout").style.display = "";
		};
		
		function signOut() {
			var auth2 = gapi.auth2.getAuthInstance();
			auth2.signOut().then(function () {
			  console.log('User signed out.');
			  
			  document.getElementById("logout").style.display = "none";
			});
		}
    </script>
</body>
</html>