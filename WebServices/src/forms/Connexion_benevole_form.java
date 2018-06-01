package forms;

import util.manipulation_xml.Personnes_xml;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import models.personnes.Personne;
import util.Config;
import util.Util_Connexion;

public final class Connexion_benevole_form {

	private static final String CHAMP_EMAIL_BN = "mailC";
	private static final String CHAMP_PASS_BN = "mdpC";
	private Map<String, String> ATT_ERREURS = new HashMap<String, String>();
	private static String ATT_RESULTAT = "resultat";

	/**
	 * Renvoie le résultat de la reqûete.
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
	 * @return Un objet Personne correspondant à la personne connectée.
	 */
	public Personne connecterPersonne(HttpServletRequest request) {
		// Récupération des champs du formulaire
		String email = getValeurChamp(request, CHAMP_EMAIL_BN);
		String motDePasse = getValeurChamp(request, CHAMP_PASS_BN);

		Personne personne = new Personne();

		// Validation du mail
		try {
			Util_Connexion.mailVide(email);
		} catch (Exception e) {
			setErreur(CHAMP_EMAIL_BN, e.getMessage());
		}
		personne.setMail_pers(email);

		// Validation du mdp
		try {
			Util_Connexion.mdpVide(motDePasse);
		} catch (Exception e) {
			setErreur(CHAMP_PASS_BN, e.getMessage());
		}
		personne.setMdp_pers(motDePasse);

		//Connecte le bénévole si les autres informations sont valides
		if (ATT_ERREURS.isEmpty()) {
			try {
				File f = new File(Config.getChemin()+"personnes.xml");
				personne = Personnes_xml.authentification(email, motDePasse, f);

				ATT_RESULTAT = "SuccÃ©s de la connexion.";
				
			} catch (Exception e) {
				setErreur("wrongCredentials", e.getMessage());
				ATT_RESULTAT = "Echec de la connexion.";
			}
		} else {
			ATT_RESULTAT = "Echec de la connexion.";
		}
		
		System.out.println("Erreurs : " + ATT_ERREURS);
		
		return personne;
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