package util;

import java.util.Objects;

public class Util_Connexion_Benevole {
	public static void mailVide(String mail) throws Exception{
		System.out.println("Util_Connexion_Benevole.mailVide : " + mail);
		if (Objects.equals(mail, null) || mail.isEmpty()) {
			throw new Exception ("Veuillez renseigner une adresse mail.<br />");
		}
	}
	
	public static void mdpVide(String mdp) throws Exception{
		System.out.println("Util_Connexion_Benevole.mdpVide : " + mdp);
		if (Objects.equals(mdp, null) || mdp.isEmpty()) {
			throw new Exception ("Veuillez renseigner un mot de passe.<br />");
		}
	}
}
