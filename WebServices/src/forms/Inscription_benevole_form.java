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
	
	public String getResultat() {
		return ATT_RESULTAT;
	}

	public Map<String, String> getErreurs() {
		return ATT_ERREURS;
	}
	
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
        
	        try {
	        	Util_Inscription.validationNom( nom );
	        }catch (Exception e){
	        	setErreur(CHAMP_NOM_BN, e.getMessage());
	        	System.out.println(e.getMessage());
	        }
	        
	        try {
	        	Util_Inscription.validationPrenom( prenom );
	        }catch (Exception e){
	        	setErreur(CHAMP_PRENOM_BN, e.getMessage());
	        }
	        
	        try {
	        	Util_Inscription.validationAge( age );
	        }catch (Exception e){
	        	setErreur(CHAMP_AGE_BN, e.getMessage());
	        }
	        
	        try {
	        	Util_Inscription.validationEmail( email );
	        }catch (Exception e){
	        	setErreur(CHAMP_EMAIL_BN, e.getMessage());
	        }
	        
	        try {
	        	Util_Inscription.validationMotsDePasse( mdp );
	        }catch (Exception e){
	        	setErreur(CHAMP_PASS_BN, e.getMessage());
	        }
        }

        if ( ATT_ERREURS.isEmpty() ) {
        	Personnes_xml.ajouterPersonne(new File(Config.getChemin()+"personnes.xml"), nom, prenom, age, email, mdp);
        	ATT_RESULTAT = "Succ�s de l'inscription.";
        } else {
        	System.out.println("Echec");
        	System.out.println(ATT_ERREURS);
        	ATT_RESULTAT = "�chec de l'inscription.";
        }
		
		return personne;
		
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
