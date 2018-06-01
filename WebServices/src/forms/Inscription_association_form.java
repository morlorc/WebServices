package forms;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import models.associations.Association;
import util.Config;
import util.Util_Inscription;
import util.manipulation_xml.Associations_xml;
import util.manipulation_xml.Personnes_xml;

public class Inscription_association_form {
	
	public static final String CHAMP_NOM_ASSO = "nomA";
    public static final String CHAMP_SIREN = "SIREN";
    public static final String CHAMP_EMAIL_ASSO = "mailA";
    public static final String CHAMP_PASS_ASSO = "mdpA";
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
	 * Gère la validité des informations lors de l'inscription d'une association.
	 * @param request
	 * @return Un objet Personne correspondant à la personne s'inscrivant.
	 */
	public Association inscrireAssociation(HttpServletRequest request) {
		// Récupération des champs du formulaire
		String nom = getValeurChamp(request, CHAMP_NOM_ASSO);
		String siren = getValeurChamp(request, CHAMP_SIREN);
		String email = getValeurChamp(request, CHAMP_EMAIL_ASSO);
		String mdp = getValeurChamp(request, CHAMP_PASS_ASSO);

		Association association = new Association();
		
		if (Associations_xml.existeDejaMail(new File(Config.getChemin()+"associations.xml"), email ) || Personnes_xml.existeDejaMail(new File(Config.getChemin()+"personnes.xml"), email ) ) {
			setErreur(CHAMP_EMAIL_ASSO, "Un compte existe déjà avec cette adresse.");
		} else {
			System.out.println("Association avec l'adresse : " + email);
        
			// Validation du nom
	        try {
	        	Util_Inscription.validationNom( nom );
	        }catch (Exception e){
	        	setErreur(CHAMP_NOM_ASSO, e.getMessage());
	        }
			association.setNom_asso(nom);
	        
			// Validation su SIREN
	        try {
	        	Util_Inscription.validationSiren( siren );
	        }catch (Exception e){
	        	setErreur(CHAMP_SIREN, e.getMessage());
	        }
			association.setSIREN(siren);
	        
			// Validation du mail
	        try {
	        	Util_Inscription.validationEmail( email );
	        }catch (Exception e){
	        	setErreur(CHAMP_EMAIL_ASSO, e.getMessage());
	        }
			association.setMail_asso(email);
	        
			// Validation du mdp
	        try {
	        	Util_Inscription.validationMotsDePasse( mdp );
	        }catch (Exception e){
	        	setErreur(CHAMP_PASS_ASSO, e.getMessage());
	        }
			association.setMail_asso(email);
        }
		
		// Inscrit l'association si les informations sont valides
        if ( ATT_ERREURS.isEmpty() ) {
        	Associations_xml.ajouterAssociation(new File(Config.getChemin()+"associations.xml"), nom, siren, email, mdp);
			File f = new File(Config.getChemin()+"associations.xml");
			try {
				association = Associations_xml.authentification(email, mdp, f);
			} catch (Exception e) {
	        	ATT_RESULTAT = "Problème de connexion";
				e.printStackTrace();
			}
        	ATT_RESULTAT = "Succès de l'inscription.";
        } else {
        	System.out.println(ATT_ERREURS);
        	ATT_RESULTAT = "Échec de l'inscription.";
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
