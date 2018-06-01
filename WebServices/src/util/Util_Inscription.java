package util;

public class Util_Inscription {
	
	/**
	 * V�rifie si le nom renseign� est valide (entre 3 et 30 caract�res).
	 * @param nom Nom
	 * @throws Exception Si le nom n'est pas valide
	 */
	public static void validationNom( String nom ) throws Exception{
		System.out.println(nom);
	    if ( nom == null || nom.trim().length() < 3 ) {
	        throw new Exception( "Le nom doit contenir au moins 3 caract�res.<br />" );
	    }
	    else if (nom.trim().length() > 29 ) {
	        throw new Exception( "Le nom doit contenir moins de 30 caract�res.<br />" );
	    }
	}
		
	/**
	 * V�rifie si l'adresse mail pass�e en param�tre est valide.
	 * @param email Adresse mail
	 * @throws Exception Si l'adresse mail n'est pas valide
	 */
    public static void validationEmail( String email ) throws Exception{
    	//System.out.println(email);5
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
    
    /**
     * V�rifie si le mot de passe en param�tre est correct (entre 8 et 100 caract�res).
     * @param motDePasse Mot de passe
     * @throws Exception Si le mot de passe n'est pas valide
     */
    public static void validationMotsDePasse( String motDePasse ) throws Exception{
    	//System.out.println(motDePasse);
    	if (motDePasse != null && motDePasse.trim().length() != 0) {
    		if (motDePasse.trim().length() < 8) {
                throw new Exception("Le mot de passe doit contenir au moins 8 caract�res.<br />");
            }
        } else {
            throw new Exception("Merci de saisir votre mot de passe.<br />");
        }
	    if (motDePasse.trim().length() > 100 ) {
	        throw new Exception( "Le mot de passe ne peut d�passer 100 caract�res.<br />" );
	    }
	    /* A rajouter la condition d'avoir un caract�re sp�cial, un chiffre et une lettre*/
    }
    
    /**
     * V�rifie si le SIREN est correct (9 caract�res).
     * @param siren SIREN
     * @throws Exception Si le SIREN n'est pas valide.
     */
    public static void validationSiren(String siren) throws Exception {
    	//System.out.println(siren);
    	if ( siren.length() != 9 || siren != null || siren.isEmpty() || !siren.matches("[0-9]{9}")) {
    		throw new Exception("Le fomat du SIREN est invalide.<br />");
    		}
    }

    /**
     * V�rifie si le pr�nom est correct (entre 3 et 30 caract�res).
     * @param prenom Pr�nom
     * @throws Exception Si le pr�nom n'est pas valide
     */
	public static void validationPrenom( String prenom ) throws Exception{
		//System.out.println(prenom);
	    if ( prenom == null || prenom.trim().length() < 3 ) {
	        throw new Exception( "Le pr�nom doit contenir au moins 3 caract�res.<br />" );
	    	}
	    else if (prenom.trim().length() > 29 ) {
	        throw new Exception( "Le pr�nom doit contenir moins de 30 caract�res.<br />" );
	    }
	}
	
	/**
	 * V�rifie si l'�ge est valide (entre 16 et 130 ans).
	 * @param age Age
	 * @throws Exception Si l'�ge n'est pas valide
	 */
	public static void validationAge( String age ) throws Exception{
		//System.out.println(age);
    	if (age != "" && age != null) {
    		int age_i = Integer.parseInt(age);
		    if ( age_i < 16) {
		    	throw new Exception( "Vous devez avoir au moins 16 ans.<br />" );
		    }
		    else if (age_i > 130) {
		    	throw new Exception( "Vous avez saisi un age trop grand.<br />" );
		    }
    	}else {
    		throw new Exception("Veuillez saisir un �ge.<br />");
    	}
    }
}
