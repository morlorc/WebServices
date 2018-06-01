package util;

import java.util.Objects;

public class Util_Connexion {
	
	/**
	 * Vérifie si le mail est vide.
	 * @param mail Adresse mail
	 * @throws Exception Si le mail est vide
	 */
	public static void mailVide(String mail) throws Exception{
		//System.out.println("Util_Connexion_Benevole.mailVide : " + mail);
		if (Objects.equals(mail, null) || mail.isEmpty()) {
			throw new Exception ("Veuillez renseigner une adresse mail.<br />");
		}
	}
	
	/**
	 * Vérifie si le mot de passe est vide
	 * @param mdp Mot de passe
	 * @throws Exception Si le mot de passe est vide
	 */
	public static void mdpVide(String mdp) throws Exception{
		//System.out.println("Util_Connexion_Benevole.mdpVide : " + mdp);
		if (Objects.equals(mdp, null) || mdp.isEmpty()) {
			throw new Exception ("Veuillez renseigner un mot de passe.<br />");
		}
	}
}
