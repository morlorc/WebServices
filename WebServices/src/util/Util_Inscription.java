package util;

public class Util_Inscription {
	public static void validationNom( String nom ) throws Exception{
		System.out.println(nom);
	    if ( nom == null || nom.trim().length() < 3 ) {
	        throw new Exception( "Le nom doit contenir au moins 3 caractères.<br />" );
	    }
	    else if (nom.trim().length() > 29 ) {
	        throw new Exception( "Le nom doit contenir moins de 30 caractères.<br />" );
	    }
	}
		
    public static void validationEmail( String email ) throws Exception{
    	//System.out.println(email);
        if ( email != null && email.trim().length() != 0 ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide.<br />" );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail.<br />" );
        }
        if ( email.trim().length() > 100 ) {
            throw new Exception( "L'addresse mail est trop longue.<br />" ); 
        }
    }
    
    public static void validationMotsDePasse( String motDePasse ) throws Exception{
    	//System.out.println(motDePasse);
    	if (motDePasse != null && motDePasse.trim().length() != 0) {
    		if (motDePasse.trim().length() < 8) {
                throw new Exception("Le mot de passe doit contenir au moins 8 caractères.<br />");
            }
        } else {
            throw new Exception("Merci de saisir votre mot de passe.<br />");
        }
	    if (motDePasse.trim().length() > 100 ) {
	        throw new Exception( "Le mot de passe ne peut dépasser 100 caractères.<br />" );
	    }
	    /* A rajouter la condition d'avoir un caractère spécial, un chiffre et une lettre*/
    }
    
    public static void validationSiren(String siren) throws Exception {
    	//System.out.println(siren);
    	if ( siren.length() != 9 || siren != null || siren.isEmpty()) {
    		throw new Exception("Le fomat du SIREN est invalide.<br />");
    	} 
    }

	public static void validationPrenom( String prenom ) throws Exception{
		//System.out.println(prenom);
	    if ( prenom == null || prenom.trim().length() < 3 ) {
	        throw new Exception( "Le prénom doit contenir au moins 3 caractères.<br />" );
	    	}
	    else if (prenom.trim().length() > 29 ) {
	        throw new Exception( "Le prénom doit contenir moins de 30 caractères.<br />" );
	    }
	}
	
	public static void validationAge( String age ) throws Exception{
		//System.out.println(age);
    	if (age != "") {
    		int age_i = Integer.parseInt(age);
		    if ( age_i < 16) {
		    	throw new Exception( "Vous devez avoir au moins 16 ans.<br />" );
		    }
		    else if (age_i > 130) {
		    	throw new Exception( "Vous avez saisi un age trop grand.<br />" );
		    }
    	}else {
    		throw new Exception("Veuillez saisir un âge.<br />");
    	}
    }
}
