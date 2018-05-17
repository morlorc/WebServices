<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<body id="connexion"  onload="AssociationConnexion()">

		<div id="choix">
			<section id="benevole" class="noselect">
				<div class="rightarrow">
				</div>
				<div class="contenu">
					<h1>Vous �tes b�n�vole</h1>
					<div class="base">
						<span class="glyphicon glyphicon-envelope"></span>
						<div class="btn-group-vertical">
							<button type="button" class="btn btn-primary btn-default" onClick="BenevoleInscription()">Inscription b�n�vole</button>
							<button type="button" class="btn btn-primary btn-default" onClick="BenevoleConnexion()">Connexion b�n�vole</button> 
						</div>
					</div>
					<div class="inscription">
						<h2>Inscription</h2>
						<form method="post" action="inscription_benevole">
							<div class="input-container" data-toggle="tooltip" data-placement="right" title="Entre 3 et 30 caract�res">
								<label for="nom">
									<i class="fa fa-user icon"></i>
									<input class="input-field" type="text" id="nomB" name="nomB" placeholder="Saisir nom"/>
								</label>
							</div>
							<div class="input-container" data-toggle="tooltip" data-placement="right" title="Entre 3 et 30 caract�res">
								<label for="prenom">
									<i class="fa fa fa-user-o icon"></i>
									<input class="input-field" type="text" id="prenomB" name="prenomB" placeholder="Saisir pr�nom"/>
								</label>
							</div>
							<div class="input-container">
								<label for="age">
									<i class="fa fa-calendar icon"></i>
									<input class="input-field" type="number" id="ageB" name="ageB" placeholder="Saisir age"/>
								</label>
							<br />
							</div>
							<div class="input-container" data-toggle="tooltip" data-placement="right" title="exemple@web.fr">
								<label for="mail">
									<i class="fa fa-envelope icon"></i>
									<input class="input-field" type="email" id="mailB" name="mailB"placeholder="Saisir email"/>
								</label>
							<br />
							</div>
							<div class="input-container" data-toggle="tooltip" data-placement="right" title="Au moins 8 caract�res">
								<label for="mdp">
									<i class="fa fa-lock icon"></i>
									<input class="input-field" type="password" id="mdpB" name="mdpB" placeholder="Saisir mot de passe"/>
								</label>
							<br />
							</div>

							<input type="submit" value="S'inscrire" />
						</form>
							<br />
						<input type="button" class="btn btn-default" value="D�j� inscrit ?" onClick="BenevoleConnexion()">
					</div>
					<div class="connexion">
						<h2>Connexion</h2>
						
						<form method="post" action="connexion_benevole">
							<div class="input-container">
								<label for="mail">
									<i class="fa fa-envelope icon"></i>
									<input class="input-field" type="email" id="mailC" name="mailC" placeholder="Saisir mail"/>
								</label>
							<br />
							</div>
							<div class="input-container">
								<label for="mdp">
									<i class="fa fa-lock icon"></i>
									<input class="input-field" type="password" id="mdpC" name="mdpC" placeholder="Saisir mot de passe"/>
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
			<section id="association" class="select">
				<div class="leftarrow">
				</div>
				<div class="contenu">
					<h1>Vous �tes une association</h1>
					<div class="base">
						<div class="btn-group-vertical">
							<button type="button" class="btn btn-primary btn-default" onClick="AssociationInscription()">Inscription association</button> 
							<button type="button" class="btn btn-primary btn-default" onClick="AssociationConnexion()"> Connexion association </button> 
						</div>
					</div>
					<div class="inscription">
						<h2>Inscription</h2>
						<form method="post" action="inscription_association">
							<div class="input-container" data-toggle="tooltip" data-placement="right" title="Entre 3 et 30 caract�res">
								<label for="nom">
									<i class="fa fa-tag icon"></i>
									<input class="input-field" type="text" id="nomA" name="nomA" placeholder="Saisir nom d'association"/>
								</label>
							<br />
							</div>

							<div class="input-container" data-toggle="tooltip" data-placement="right" title="9 chiffres">
								<label for="SIREN">
									<i class="fa fa-hashtag icon"></i>
									<input class="input-field" type="number" id="SIREN" name="SIREN" placeholder="Saisir num�ro SIREN"/>
								</label>
								<br />
							</div>

							<div class="input-container">
								<label for="mail"  data-toggle="tooltip" data-placement="right" title="exemple@web.fr">
									<i class="fa fa-envelope icon"></i>
									<input class="input-field" type="email" id="mailA" name="mailA" placeholder="Saisir email"/>
								</label>
								<br />
							</div>

							<div class="input-container"  data-toggle="tooltip" data-placement="right" title="Au moins 8 caract�res">
								<label for="mdp">
									<i class="fa fa-lock icon"></i>
									<input class="input-field" type="password" id="mdpA" name="mdpA" placeholder="Saisir mot de passe" />
								</label>
								<br />
							</div>


							<input type="submit" value="S'inscrire" />
						</form>
							<br />
						<input type="button" class="btn btn-default" value="D�j� inscrit ?" onClick="AssociationConnexion()">
					</div>
					<div class="connexion">
						<h2>Connexion</h2>

						<form method="post" action="connexion_association">
							<div class="input-container">
								<label for="mail">
									<i class="fa fa-envelope icon"></i>
									<input class="input-field" type="email" id="mailD" name="mailD"  placeholder="Saisir mail"/>
									<br />
								</label>
							</div>
							<div class="input-container">
								<label for="mdp">
									<i class="fa fa-lock icon"></i>
									<input class="input-field" type="password" id="mdpD" name="mdpD"  placeholder="Saisir mot de passe"/>
									<br />
								</label>
							</div>

							<input type="submit" value="Se connecter" />
						</form>
							<div class="alert alert-danger alert-dismissible fade show">
								<button type="button" class="close" data-dismiss="alert">&times;</button>
								This alert box could indicate a dangerous or potentially negative action.
							</div>
							<br />
						<input type="button" class="btn btn-default" value="Pas encore inscrit ?" onClick="AssociationInscription()">
						</br>
					</div>
				</div>
			</section>
		</div>
	</body>
</html>