jQuery(document).ready(function($) {
   // Votre code ici avec les appels à la fonction $() test test

	$(document).ready(function() {
		//slide on click
	    $('[data-toggle="tooltip"]').tooltip();  
	 
	    
		var zoomBenevole = function() {
	 		$("#association").off("click");
			$("#association").addClass("noselect").delay(1500).on("click");
			$("#benevole").addClass("select").delay(1500).on("click");
			$("#association .base, #association .connexion, #association .inscription").fadeOut(200);
			$(".rightarrow").delay(1500).fadeIn();
		}
			
		var zoomAssociation = function() {
	 		$("#benevole").off("click");
			$("#benevole").addClass("noselect").delay(1500).on("click");
			$("#association").addClass("select").delay(1500).on("click");
			$("#benevole .base, #benevole .connexion, #benevole .inscription").fadeOut(200);
			$(".leftarrow").delay(1500).fadeIn();
		}
	
		$("#benevole").click(function() {
			zoomBenevole();
		});
		
		$("#association").click(function() {
			zoomAssociation();
		});
	
		$(".leftarrow").click(function() {
			$("#benevole").removeClass("noselect");
			$("#association").removeClass("select");
			$("#benevole .base").delay(500).fadeIn(800);
			zoomBenevole();
		});
		
		$(".rightarrow").click(function() {
			$("#association").removeClass("noselect");
			$("#benevole").removeClass("select");
			$("#association .base").delay(500).fadeIn(800);
			zoomAssociation();
		});

			
	});	
});
	//afficher inscription bénévole
	function BenevoleInscription(){
			$("#benevole .base").hide();
			$("#benevole .connexion").hide();
			$("#benevole .inscription").show();
	}

	//afficher connexion bénévole
	function BenevoleConnexion(){
			$("#benevole .base").hide();
			$("#benevole .inscription").hide();
			$("#benevole .connexion").show();
	}
	//afficher inscription association
	function AssociationInscription(){
			$("#association .base").hide();
			$("#association .connexion").hide();
			$("#association .inscription").show();
	}

	//afficher connexion association
	function AssociationConnexion(){
			$("#association .base").hide();
			$("#association .inscription").hide();
			$("#association .connexion").show();
	}