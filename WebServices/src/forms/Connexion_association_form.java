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

	public String getResultat() {
		return ATT_RESULTAT;
	}

	public Map<String, String> getErreurs() {
		return ATT_ERREURS;
	}

	public Association connecterAssociation(HttpServletRequest request) {
		/* R�cup�ration des champs du formulaire */
		String email = getValeurChamp(request, CHAMP_EMAIL_BN);
		String motDePasse = getValeurChamp(request, CHAMP_PASS_BN);

		Association association = new Association();

		/* Validation du champ email. */
		try {
			Util_Connexion.mailVide(email);
		} catch (Exception e) {
			setErreur(CHAMP_EMAIL_BN, e.getMessage());
		}
		association.setMail(email);

		/* Validation du champ mot de passe. */
		try {
			Util_Connexion.mdpVide(motDePasse);
		} catch (Exception e) {
			setErreur(CHAMP_PASS_BN, e.getMessage());
		}
		association.setMdp(motDePasse);

		/* Initialisation du résultat global de la validation. */
		if (ATT_ERREURS.isEmpty()) {
			try {
				File f = new File(Config.getChemin()+"associations.xml");
				association = Associations_xml.authentification(email, motDePasse, f);
				ATT_RESULTAT = "Succ�s de la connexion.";
			} catch (Exception e) {
				setErreur("wrongCredentials", e.getMessage());
				ATT_RESULTAT = "Echec de la connexion.";
			}
		} else {
			ATT_RESULTAT = "Echec de la connexion.";
		}
		
		return association;
	}

	/*
	 * Ajoute un message correspondant au champ sp�cifi� � la map des erreurs.
	 */
	private void setErreur(String champ, String message) {
		ATT_ERREURS.put(champ, message);
	}

	/*
	 * M�thode utilitaire qui retourne null si un champ est vide, et son contenu
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