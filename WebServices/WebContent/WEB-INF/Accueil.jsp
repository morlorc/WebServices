<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" %>
<html>
	<head>
		<title>Accueil</title>
		<link rel="icon" href="group.png" type="image/x-icon" />
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="Style.css" type="text/css" media="screen" >
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
		<script src="fonction.js"></script>
	</head>
	<body id="connexion">

		<header class="container-fluid">
			<a href="Accueil.html"><h1>Volunteam</h1></a>
		</header>
		<p>
            <% 
            String attribut = (String) request.getAttribute("test");
            out.println( attribut );
            %>
        </p>

		<div id="choix">
			<section id="benevole">
				<div class="rightarrow">
				</div>
				<div class="contenu">
					<h1>Vous êtes bénévole</h1>
					<div class="base">
						<span class="glyphicon glyphicon-envelope"></span>
						<div class="btn-group-vertical">
							<button type="button" class="btn btn-primary btn-default" onClick="BenevoleInscription()">Inscription bénévole</button>
							<button type="button" class="btn btn-primary btn-default" onClick="BenevoleConnexion()">Connexion bénévole</button> 
						</div>
					</div>
					<div class="inscription">
						<h2>Inscription</h2>
						<form method="post" action="inscription_benevole">
							<div class="input-container">
								<label for="nom">
									<i class="fa fa-user icon"></i>
									<input class="input-field" type="text" id="nom" placeholder="Saisir nom"/>
								</label>
							</div>
							<div class="input-container">
								<label for="prenom">
									<i class="fa fa fa-user-o icon"></i>
									<input class="input-field" type="text" id="prenom" placeholder="Saisir prénom"/>
								</label>
							</div>
							<div class="input-container">
								<label for="age">
									<i class="fa fa-calendar icon"></i>
									<input class="input-field" type="number" id="age" placeholder="Saisir age"/>
								</label>
							<br />
							</div>
							<div class="input-container">
								<label for="mail">
									<i class="fa fa-envelope icon"></i>
									<input class="input-field" type="email" id="mail" placeholder="Saisir email"/>
								</label>
							<br />
							</div>
							<div class="input-container">
								<label for="mdp">
									<i class="fa fa-lock icon"></i>
									<input class="input-field" type="password" id="mdp" placeholder="Saisir mot de passe"/>
								</label>
							<br />
							</div>

							<input type="submit" value="S'inscrire" />
						</form>
							<br />
						<input type="button" class="btn btn-default" value="Déjà inscrit ?" onClick="BenevoleConnexion()">
					</div>
					<div class="connexion">
						<h2>Connexion</h2>
						
						<form method="post" action="connexion_benevole">
							<div class="input-container">
								<label for="mail">
									<i class="fa fa-envelope icon"></i>
									<input class="input-field" type="email" id="mail" placeholder="Saisir mail"/>
								</label>
							<br />
							</div>
							<div class="input-container">
								<label for="mdp">
									<i class="fa fa-lock icon"></i>
									<input class="input-field" type="password" id="mdp" placeholder="Saisir mot de passe"/>
								</label>
							<br />
							</div>

							<input type="submit" value="Se connecter" />
						</form>
							<br />
						<input type="button" class="btn btn-default" value="Pas encore inscrit ?" onClick="BenevoleInscription()"></br>
					</div>
				</div>
			</section>
			<section id="association">
				<div class="leftarrow">
				</div>
				<div class="contenu">
					<h1>Vous êtes une association</h1>
					<div class="base">
						<div class="btn-group-vertical">
							<button type="button" class="btn btn-primary btn-default" onClick="AssociationInscription()">Inscription association</button> 
							<button type="button" class="btn btn-primary btn-default" onClick="AssociationConnexion()"> Connexion association </button> 
						</div>
					</div>
					<div class="inscription">
						<h2>Inscription</h2>
						<form method="post" action="inscription_association">
							<div class="input-container">
								<label for="nom">
									<i class="fa fa-tag icon"></i>
									<input class="input-field" type="text" id="nom" placeholder="Saisir nom d'association"/>
								</label>
							<br />
							</div>

							<div class="input-container">
								<label for="SIREN">
									<i class="fa fa-hashtag icon"></i>
									<input class="input-field" type="number" id="SIREN" placeholder="Saisir numéro SIREN"/>
								</label>
								<br />
							</div>

							<div class="input-container">
								<label for="mail">
									<i class="fa fa-envelope icon"></i>
									<input class="input-field" type="email" id="mail" placeholder="Saisir email"/>
								</label>
								<br />
							</div>

							<div class="input-container">
								<label for="mdp">
									<i class="fa fa-lock icon"></i>
									<input class="input-field" type="password" id="mdp" placeholder="Saisir mot de passe" />
								</label>
								<br />
							</div>


							<input type="submit" value="S'inscrire" />
						</form>
							<br />
						<input type="button" class="btn btn-default" value="Déjà inscrit ?" onClick="AssociationConnexion()">
					</div>
					<div class="connexion">
						<h2>Connexion</h2>

						<form method="post" action="connexion_association">
							<div class="input-container">
								<label for="mail">
									<i class="fa fa-envelope icon"></i>
									<input class="input-field" type="email" id="mail"  placeholder="Saisir mail"/>
									<br />
								</label>
							</div>
							<div class="input-container">
								<label for="mdp">
									<i class="fa fa-lock icon"></i>
									<input class="input-field" type="password" id="mdp"  placeholder="Saisir mot de passe"/>
									<br />
								</label>
							</div>

							<input type="submit" value="Se connecter" />
						</form>
							<br />
						<input type="button" class="btn btn-default" value="Pas encore inscrit ?" onClick="AssociationInscription()">
						</br>
					</div>
				</div>
			</section>
		</div>
	</body>
</html>