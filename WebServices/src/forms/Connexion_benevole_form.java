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
				File f = new File(Config.getChemin()+"personnes.xml");
				personne = Personnes_xml.authentification(email, motDePasse, f);
				ATT_RESULTAT = "Succ�s de la connexion.";
			} catch (Exception e) {
				setErreur("wrongCredentials", e.getMessage());
				ATT_RESULTAT = "Echec de la connexion.";
			}
		} else {
			ATT_RESULTAT = "Echec de la connexion.";
		}
		
		return personne;
	}

	/*private Personne verifierLogins(String email, String motDePasse, HttpServletRequest request) throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(Personnes.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Personnes listPersonnes = (Personnes) jaxbUnmarshaller
				.unmarshal(new File(request.getServletContext().getRealPath(USERS_PATH)));
		for (Personne u : listPersonnes.getPersonne()) {
			if (u.getMail_pers().equals(email) && u.getMdp_pers().equals(motDePasse))
				return u;
		}
		throw new Exception("Aucun bénévole n'est enregistré avec cet email et ce mot de passe");
	}*/
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