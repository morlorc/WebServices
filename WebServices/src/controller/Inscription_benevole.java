package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Inscription_benevole extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static final String VUE = "/WEB-INF/Accueil.jsp";
    public static final String CHAMP_NOM_BN = "nomB";
    public static final String CHAMP_PRENOM_BN = "prenomB";
    public static final String CHAMP_AGE_BN = "ageB";
    public static final String CHAMP_EMAIL_BN = "mailB";
    public static final String CHAMP_PASS_BN = "mdpB";

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

    	System.out.println("Paramètres :");
    	System.out.println(request.getParameter( CHAMP_NOM_BN ));
    	System.out.println(request.getParameter( CHAMP_PRENOM_BN ));
    	System.out.println(request.getParameter( CHAMP_AGE_BN ));
    	System.out.println(request.getParameter( CHAMP_EMAIL_BN ));
    	System.out.println(request.getParameter( CHAMP_PASS_BN ));
        /* Récupération des champs du formulaire. */
    	
        String nom = request.getParameter( CHAMP_NOM_BN );
        String prenom = request.getParameter( CHAMP_PRENOM_BN );
        int age = Integer.parseInt(request.getParameter( CHAMP_AGE_BN ));
        String email = request.getParameter( CHAMP_EMAIL_BN );
        String motDePasse = request.getParameter( CHAMP_PASS_BN );
      	
        /*System.out.println("nom: " + nom);
        System.out.println("prenom: " + prenom);
        System.out.println("age: " + age);
        System.out.println("email: " + email);
        System.out.println("motDePasse: " + motDePasse); */
        try {
            validationNom( nom );
            validationPrenom( prenom );
            validationAge( age );
            validationEmail( email );
            validationMotsDePasse( motDePasse );
        } catch (Exception e) {
             //Gérer les erreurs de validation ici.
        	System.out.println("Problème dans les paramètres !");
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
}