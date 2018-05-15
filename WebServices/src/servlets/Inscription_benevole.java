package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Inscription_benevole extends HttpServlet {
    public static final String VUE = "/WEB-INF/Accueil.jsp";
    public static final String CHAMP_NOM = "nom";
    public static final String CHAMP_PRENOM = "prenom";
    public static final String CHAMP_AGE = "age";
    public static final String CHAMP_EMAIL = "email";
    public static final String CHAMP_PASS = "motdepasse";

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

        /* Récupération des champs du formulaire. */
        String nom = request.getParameter( CHAMP_NOM );
        String prenom = request.getParameter( CHAMP_PRENOM );
        int age = Integer.parseInt(request.getParameter( CHAMP_AGE ));
        String email = request.getParameter( CHAMP_EMAIL );
        String motDePasse = request.getParameter( CHAMP_PASS );

        try {
            validationNom( nom );
            validationPrenom( prenom );
            validationAge( age );
            validationEmail( email );
            validationMotsDePasse( motDePasse );
        } catch (Exception e) {
            /* Gérer les erreurs de validation ici. */
        }
    }

    	private void validationNom( String nom ) throws Exception{
    	    if ( nom == null || nom.trim().length() < 3 ) {
    	        throw new Exception( "Le nom doit contenir au moins 3 caractères." );
    	    }
    	}
    	
    	private void validationPrenom( String prenom ) throws Exception{
    	    if ( prenom == null || prenom.trim().length() < 3 ) {
    	        throw new Exception( "Le prénom doit contenir au moins 3 caractères." );
    	    }
    	}
    	
        private void validationAge( int age ) throws Exception{
    	    if ( age == null || age < 16) {
    	    	throw new Exception( "Vous devez avoir au moins 16 ans." );
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
        }
        
        private void validationMotsDePasse( String motDePasse ) throws Exception{
        	if (motDePasse != null && motDePasse.trim().length() != 0) {
        		if (motDePasse.trim().length() < 3) {
                    throw new Exception("Le mot de passe doit contenir au moins 3 caractères.");
                }
            } else {
                throw new Exception("Merci de saisir votre mot de passe.");
            }
        }
}