package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Inscription_benevole extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static final String VUE = "/WEB-INF/Accueil.jsp";
    public static final String CHAMP_NOM = "nom";
    public static final String CHAMP_PRENOM = "prenom";
    public static final String CHAMP_AGE = "age";
    public static final String CHAMP_EMAIL = "email";
    public static final String CHAMP_PASS = "motdepasse";

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
    	System.out.println("test");	
        /* Récupération des champs du formulaire. */
        String nom = request.getParameter( CHAMP_NOM );
        String prenom = request.getParameter( CHAMP_PRENOM );
        int age = Integer.parseInt(request.getParameter( CHAMP_AGE ));
        String mail = request.getParameter( CHAMP_EMAIL );
        String mdp = request.getParameter( CHAMP_PASS );

        try {
            validationNom( nom );
            validationPrenom( prenom );
            validationAge( age );
            validationEmail( mail );
            validationMotsDePasse( mdp );
        } catch (Exception e) {
            /* Gérer les erreurs de validation ici. */
        }
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
    	
        private void validationAge( int age ) throws Exception{
    	    if ( age < 16) {
    	    	throw new Exception( "Vous devez avoir au moins 16 ans." );
    	    }
    	    else if (age > 130) {
    	    	throw new Exception( "Vous avez saisi un age trop grand" );
    	    }
        }
        
        private void validationEmail( String mail ) throws Exception{
            if ( mail != null && mail.trim().length() != 0 ) {
                if ( !mail.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                    throw new Exception( "Merci de saisir une adresse mail valide." );
                }
            } else {
                throw new Exception( "Merci de saisir une adresse mail." );
            }
            if ( mail.trim().length() > 100 ) {
                throw new Exception( "L'addresse mail est trop longue" ); 
            }
        }
        
        private void validationMotsDePasse( String mdp ) throws Exception{
        	if (mdp != null && mdp.trim().length() != 0) {
        		if (mdp.trim().length() < 3) {
                    throw new Exception("Le mot de passe doit contenir au moins 3 caractères.");
                }
            } else {
                throw new Exception("Merci de saisir votre mot de passe.");
            }
    	    if (mdp.trim().length() > 100 ) {
    	        throw new Exception( "Le mot de passe ne peut dépasser 100 caaractères" );
    	    }
        }
}