package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Inscription_association extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public static final String VUE = "/WEB-INF/InscriptionAssociation.jsp";
    public static final String CHAMP_NOM_AS = "nomA";
    public static final String CHAMP_SIREN_AS = "SIREN";
    public static final String CHAMP_EMAIL_AS = "mailA";
    public static final String CHAMP_PASS_AS = "mdpA";
    public static final String ATT_ERREURS  = "erreurs";
    public static final String ATT_RESULTAT = "resultat";

	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
		String resultat;
        Map<String, String> erreurs = new HashMap<String, String>();
        
        String nom = request.getParameter(CHAMP_NOM_AS);
        String siren = request.getParameter(CHAMP_SIREN_AS);
        String email = request.getParameter(CHAMP_EMAIL_AS);
        String motDePasse = request.getParameter(CHAMP_PASS_AS);
        
        try {
        	validationNom( nom );
            
        } catch(Exception e) {
        	erreurs.put(CHAMP_NOM_AS, e.getMessage());
        	
        }
        
        try {
            validationSiren( siren );
          
        } catch(Exception e) {
        	erreurs.put(CHAMP_SIREN_AS, e.getMessage());
        	
        }
        
        try {

            validationEmail( email );
        } catch(Exception e) {

        	erreurs.put(CHAMP_EMAIL_AS, e.getMessage());
        }
        
        try {
 
            validationMotsDePasse( motDePasse );
        } catch(Exception e) {

        	erreurs.put(CHAMP_PASS_AS, e.getMessage());
        }
        
        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'inscription.";
        } else {
            resultat = "Échec de l'inscription.";
        }
        
        request.setAttribute( ATT_ERREURS, erreurs );
        request.setAttribute( ATT_RESULTAT, resultat );
        
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
      	
	}
	
	private void validationNom( String nom ) throws Exception{
	    if ( nom == null || nom.trim().length() < 3 ) {
	        throw new Exception( "Le nom doit contenir au moins 3 caractères." );
	    }
	    else if (nom.trim().length() > 29 ) {
	        throw new Exception( "Le nom doit contenir moins de 30 caractères." );
	    }
	}
		
    private void validationEmail( String email ) throws Exception{
        if ( email != null && email.trim().length() != 0 ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
        if ( email.trim().length() > 100 ) {
            throw new Exception( "L'addresse mail est trop longue" ); 
        }
    }
    
    private void validationMotsDePasse( String motDePasse ) throws Exception{
    	if (motDePasse != null && motDePasse.trim().length() != 0) {
    		if (motDePasse.trim().length() < 8) {
                throw new Exception("Le mot de passe doit contenir au moins 8 caractères.");
            }
        } else {
            throw new Exception("Merci de saisir votre mot de passe.");
        }
	    if (motDePasse.trim().length() > 100 ) {
	        throw new Exception( "Le mot de passe ne peut dépasser 100 caractères" );
	    }
	    /* A rajouter la condition d'avoir un caractère spécial, un chiffre et une lettre*/
    }
    
    private void validationSiren(String siren) throws Exception {
    	if ( siren.length() != 9 || siren != null || siren.isEmpty()) {
    		throw new Exception("Le fomat du SIREN est invalide");
    	} 
    		
    }
}
