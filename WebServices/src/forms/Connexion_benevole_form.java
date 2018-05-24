package forms;

import util.manipulation_xml.Personnes_xml;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import models.personnes.Personne;
import util.Util_Connexion;

public final class Connexion_benevole_form {

	private static final String CHAMP_EMAIL_BN = "mailC";
	private static final String CHAMP_PASS_BN = "mdpC";
	private Map<String, String> ATT_ERREURS = new HashMap<String, String>();
	private static String ATT_RESULTAT = "resultat";

	public String getResultat() {
		return ATT_RESULTAT;
	}

	public Map<String, String> getErreurs() {
		return ATT_ERREURS;
	}

	public Personne connecterPersonne(HttpServletRequest request) {
		/* Récupération des champs du formulaire */
		String email = getValeurChamp(request, CHAMP_EMAIL_BN);
		String motDePasse = getValeurChamp(request, CHAMP_PASS_BN);

		Personne personne = new Personne();

		/* Validation du champ email. */
		try {
			Util_Connexion.mailVide(email);
		} catch (Exception e) {
			setErreur(CHAMP_EMAIL_BN, e.getMessage());
		}
		personne.setMail_pers(email);

		/* Validation du champ mot de passe. */
		try {
			Util_Connexion.mdpVide(motDePasse);
		} catch (Exception e) {
			setErreur(CHAMP_PASS_BN, e.getMessage());
		}
		personne.setMdp_pers(motDePasse);

		/* Initialisation du résultat global de la validation. */
		if (ATT_ERREURS.isEmpty()) {
			try {
				personne = Personnes_xml.authentification(email, motDePasse);
				ATT_RESULTAT = "Succès de la connexion.";
			} catch (Exception e) {
				setErreur("wrongCredentials", e.getMessage());
				ATT_RESULTAT = "Echec de la connexion.";
			}
		} else {
			ATT_RESULTAT = "Echec de la connexion.";
		}
		
		return personne;
	}

	/*
	 * Ajoute un message correspondant au champ spécifié à la map des erreurs.
	 */
	private void setErreur(String champ, String message) {
		ATT_ERREURS.put(champ, message);
	}

	/*
	 * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
	 * sinon.
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