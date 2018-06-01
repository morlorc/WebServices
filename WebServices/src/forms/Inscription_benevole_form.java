package forms;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import models.personnes.Personne;
import util.Config;
import util.Util_Inscription;
import util.manipulation_xml.Personnes_xml;

public class Inscription_benevole_form {
	
	public static final String CHAMP_NOM_BN = "nomB";
    public static final String CHAMP_PRENOM_BN = "prenomB";
    public static final String CHAMP_AGE_BN = "ageB";
    public static final String CHAMP_EMAIL_BN = "mailB";
    public static final String CHAMP_PASS_BN = "mdpB";
    private Map<String, String> ATT_ERREURS = new HashMap<String, String>();
	private static String ATT_RESULTAT = "resultat";
	
	/**
	 * Renvoie le r�sultat de la req�ete.
	 * @return Renvoie la variable contenant le r�sultat de la requ�te.
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
	 * G�re la validit� des informations lors de l'inscription d'un b�n�vole.
	 * @param request
	 * @return Un objet Personne correspondant � la personne s'inscrivant.
	 */
	public Personne inscrirePersonne(HttpServletRequest request) {
		//R�ucp�ration des champs du formulaire
		String nom = getValeurChamp(request, CHAMP_NOM_BN);
		String prenom = getValeurChamp(request, CHAMP_PRENOM_BN);
		String age = getValeurChamp(request, CHAMP_AGE_BN);
		String email = getValeurChamp(request, CHAMP_EMAIL_BN);
		String mdp = getValeurChamp(request, CHAMP_PASS_BN);

		Personne personne = new Personne();
		
		if (Personnes_xml.existeDejaMail(new File(Config.getChemin()+"personnes.xml"), email ) ) {
			setErreur(CHAMP_EMAIL_BN, "Un compte existe d�j� avec cette adresse.");
		} else {
			System.out.println("Personne avec l'adresse : " + email);
        
			// Validation du nom
	        try {
	        	Util_Inscription.validationNom( nom );
	        }catch (Exception e){
	        	setErreur(CHAMP_NOM_BN, e.getMessage());
	        }
			personne.setNom_pers(nom);
	        
			// Validation du pr�nom
	        try {
	        	Util_Inscription.validationPrenom( prenom );
	        }catch (Exception e){
	        	setErreur(CHAMP_PRENOM_BN, e.getMessage());
	        }
			personne.setPrenom_pers(prenom);
	        
			// Validation de l'�ge
	        try {
	        	Util_Inscription.validationAge( age );
	        }catch (Exception e){
	        	setErreur(CHAMP_AGE_BN, e.getMessage());
	        }
			personne.setAge(age);
	        
			// Validation du mail
	        try {
	        	Util_Inscription.validationEmail( email );
	        }catch (Exception e){
	        	setErreur(CHAMP_EMAIL_BN, e.getMessage());
	        }
			personne.setMail_pers(email);
	        
			// Validation du mdp
	        try {
	        	Util_Inscription.validationMotsDePasse( mdp );
	        }catch (Exception e){
	        	setErreur(CHAMP_PASS_BN, e.getMessage());
	        }
			personne.setMail_pers(email);
        }
		
		// Inscrit le b�n�vole si les informations sont valides
        if ( ATT_ERREURS.isEmpty() ) {
        	Personnes_xml.ajouterPersonne(new File(Config.getChemin()+"personnes.xml"), nom, prenom, age, email, mdp);
			File f = new File(Config.getChemin()+"personnes.xml");
			try {
				personne = Personnes_xml.authentification(email, mdp, f);
			} catch (Exception e) {
	        	ATT_RESULTAT = "Probl�me de connexion";
				e.printStackTrace();
			}
        	ATT_RESULTAT = "Succ�s de l'inscription.";
        } else {
        	System.out.println(ATT_ERREURS);
        	ATT_RESULTAT = "�chec de l'inscription.";
        }
		
		return personne;
		
	}
	
	/**
	 * Ajoute un message correspondant au champ sp�cifi� � la map des erreurs.
	 * @param champ
	 * @param message
	 */
	private void setErreur(String champ, String message) {
		ATT_ERREURS.put(champ, message);
	}
	
	/**
	 * M�thode utilitaire qui retourne null si un champ est vide, et son contenu
	 * @param request
	 * @param nomChamp Le champ � v�rifier
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
