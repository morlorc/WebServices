package util;

public class Util_Inscription_Association {
	public static void validationNom( String nom ) throws Exception{
	    if ( nom == null || nom.trim().length() < 3 ) {
	        throw new Exception( "Le nom doit contenir au moins 3 caractères." );
	    }
	    else if (nom.trim().length() > 29 ) {
	        throw new Exception( "Le nom doit contenir moins de 30 caractères." );
	    }
	}
		
    public static void validationEmail( String email ) throws Exception{
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
    
    public static void validationMotsDePasse( String motDePasse ) throws Exception{
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
    
    public static void validationSiren(String siren) throws Exception {
    	if ( siren.length() != 9 || siren != null || siren.isEmpty()) {
    		throw new Exception("Le fomat du SIREN est invalide");
    	} 
    		
    }
}
