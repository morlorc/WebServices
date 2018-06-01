package forms;

import util.manipulation_xml.Associations_xml;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import models.associations.Association;
import util.Config;
import util.Util_Connexion;

public final class Connexion_association_form {

	private static final String CHAMP_EMAIL_BN = "mailD";
	private static final String CHAMP_PASS_BN = "mdpD";
	private Map<String, String> ATT_ERREURS = new HashMap<String, String>();
	private static String ATT_RESULTAT = "resultat";

	/**
	 * Renvoie le résultat.
	 * @return Renvoie la variable contenant le résultat de la requête.
	 */
	public String getResultat() {
		return ATT_RESULTAT;
	}

	/**
	 * Renvoie la pile d'erreurs.
	 * @return Renvoie la variable contenant la pile d'erreur.
	 */
	public Map<String, String> getErreurs() {
		return ATT_ERREURS;
	}

	/**
	 * Gère la vérification des informations lors de la connexion.
	 * @param request
	 * @return Un objet Association correspondant à l'association connectée.
	 */
	public Association connecterAssociation(HttpServletRequest request) {
		// Récupération des champs du formulaire
		String email = getValeurChamp(request, CHAMP_EMAIL_BN);
		String motDePasse = getValeurChamp(request, CHAMP_PASS_BN);

		Association association = new Association();

		// Validation du mail
		try {
			Util_Connexion.mailVide(email);
		} catch (Exception e) {
			setErreur(CHAMP_EMAIL_BN, e.getMessage());
		}
		association.setMail_asso(email);

		// Validation du mdp
		try {
			Util_Connexion.mdpVide(motDePasse);
		} catch (Exception e) {
			setErreur(CHAMP_PASS_BN, e.getMessage());
		}
		association.setMdp_asso(motDePasse);

		//Connecte l'association si les autres informations sont valides
		if (ATT_ERREURS.isEmpty()) {
			try {
				File f = new File(Config.getChemin()+"associations.xml");
				association = Associations_xml.authentification(email, motDePasse, f);
				ATT_RESULTAT = "Succès de la connexion.";
			} catch (Exception e) {
				setErreur("wrongCredentials", e.getMessage());
				ATT_RESULTAT = "Echec de la connexion.";
			}
		} else {
			ATT_RESULTAT = "Echec de la connexion.";
		}
		
		return association;
	}

	/**
	 * Ajoute un message correspondant au champ spécifié à la map des erreurs.
	 * @param champ
	 * @param message
	 */
	private void setErreur(String champ, String message) {
		ATT_ERREURS.put(champ, message);
	}

	/**
	 * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
	 * @param request
	 * @param nomChamp Le champ à vérifier
	 * @return Valeur du champ, Null si vide
	 */
	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur;
		}
	}

}