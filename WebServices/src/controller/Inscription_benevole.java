package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/inscription_benevole")

public class Inscription_benevole extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static final String VUE = "/WEB-INF/InscriptionBenevole.jsp";
    public static final String CHAMP_NOM_BN = "nomB";
    public static final String CHAMP_PRENOM_BN = "prenomB";
    public static final String CHAMP_AGE_BN = "ageB";
    public static final String CHAMP_EMAIL_BN = "mailB";
    public static final String CHAMP_PASS_BN = "mdpB";
    public static final String ATT_ERREURS  = "erreurs";
    public static final String ATT_RESULTAT = "resultat";

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

    	String resultat;
        Map<String, String> erreurs = new HashMap<String, String>();
    	
    	/*System.out.println("Paramètres :");
    	System.out.println(request.getParameter( CHAMP_NOM_BN ));
    	System.out.println(request.getParameter( CHAMP_PRENOM_BN ));
    	System.out.println(request.getParameter( CHAMP_AGE_BN ));
    	System.out.println(request.getParameter( CHAMP_EMAIL_BN ));
    	System.out.println(request.getParameter( CHAMP_PASS_BN ));*/
        // Récupération des champs du formulaire
    	
        String nom = request.getParameter( CHAMP_NOM_BN );
        String prenom = request.getParameter( CHAMP_PRENOM_BN );
        String age = request.getParameter( CHAMP_AGE_BN );
        String email = request.getParameter( CHAMP_EMAIL_BN );
        String motDePasse = request.getParameter( CHAMP_PASS_BN );
      	
        try {
        	validationNom( nom );
        }catch (Exception e){
        	erreurs.put(CHAMP_NOM_BN, e.getMessage());
        }
        
        try {
        	validationPrenom( prenom );
        }catch (Exception e){
        	erreurs.put(CHAMP_PRENOM_BN, e.getMessage());
        }
        
        try {
        	validationAge( age );
        }catch (Exception e){
        	erreurs.put(CHAMP_AGE_BN, e.getMessage());
        }
        
        try {
        	validationEmail( email );
        }catch (Exception e){
        	erreurs.put(CHAMP_EMAIL_BN, e.getMessage());
        }
        
        try {
        	validationMotsDePasse( motDePasse );
        }catch (Exception e){
        	erreurs.put(CHAMP_PASS_BN, e.getMessage());
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
	
	private void validationPrenom( String prenom ) throws Exception{
	    if ( prenom == null || prenom.trim().length() < 3 ) {
	        throw new Exception( "Le prénom doit contenir au moins 3 caractères." );
	    	}
	    else if (prenom.trim().length() > 29 ) {
	        throw new Exception( "Le prénom doit contenir moins de 30 caractères." );
	    }
	}
	
    private void validationAge( String age ) throws Exception{
    	if (age != "") {
    		int age_i = Integer.parseInt(age);
		    if ( age_i < 16) {
		    	throw new Exception( "Vous devez avoir au moins 16 ans." );
		    }
		    else if (age_i > 130) {
		    	throw new Exception( "Vous avez saisi un age trop grand" );
		    }
    	}else {
    		throw new Exception("Veuillez saisir un âge.");
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
    }
}