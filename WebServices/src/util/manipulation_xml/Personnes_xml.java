package util.manipulation_xml;

import util.JaxParser;
import models.personnes.*;

import java.io.File;
import java.util.Objects;


public class Personnes_xml {
	
	/**
	 * Fonction utilitaire servant à unmarshall avec la classe Personnes.
	 * @param src Fichier xml à lire
	 * @return Un objet Personne provenant du fichier .xml.
	 */
	private static Personnes unmarshal_personnes(File src) {
		try {
			return (Personnes) JaxParser.<Personnes>unmarshal(
					models.personnes.Personnes.class,
					src
			);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Indique si une adresse mail existe déjà.
	 * @param src Fichier xml à lire
	 * @param mail Adresse mail
	 * @return Vrai si le mail existe déjà dans la base de données, Faux sinon.
	 */
	public static boolean existeDejaMail(File src, String mail){
		Personnes p = unmarshal_personnes(src);
		for (int i=0; i<p.getPersonne().size(); ++i) {
			if (Objects.equals(mail, p.getPersonne().get(i).getMail_pers())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Ajoute un objet Personne dans un fichier .xml.
	 * @param src Fichier xml à lire
	 * @param nom Nom
	 * @param prenom Prénom
	 * @param age Age
	 * @param email Adresse mail
	 * @param motDePasse Mot de passe
	 */
	public static void ajouterPersonne(File src, String nom, String prenom, String age, String email, String motDePasse) {
		try {
			Personnes p = unmarshal_personnes(src);
			p.getPersonne().add(new Personne (nom, prenom, age, email, motDePasse, new Candidatures() ));
			JaxParser.<Personnes>marshal(p, src, "personnes");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Authentifie une personne en vérifiant la validité du login et du mot de passe.
	 * @param mail Adresse mail
	 * @param mdp Mot de passe
	 * @param src Fichier xml à lire
	 * @return Un objet Association contenant les informations relatives au couple login/mdp.
	 * @throws Exception S'il est impossible d'identifier la personne
	 */
	public static Personne authentification(String mail, String mdp, File src) throws Exception{
		System.out.println("authentificationValide avec " + mail + " ; " + mdp + " " + src.getAbsolutePath());
		Personnes p = JaxParser.unmarshal(Personnes.class, src );
		for (int i=0; i<p.getPersonne().size(); ++i) {
			//System.out.println(p.getPersonne().get(i).getMail_pers());
			if (Objects.equals(mail, p.getPersonne().get(i).getMail_pers())) {
				if (Objects.equals(mdp, p.getPersonne().get(i).getMdp_pers())) {
					return p.getPersonne().get(i);
				} else {
					throw new Exception("Les informations ne permettent pas de vous identifier.<br/>");
				}
			}
		}
		throw new Exception("Les informations ne permettent pas de vous identifier.<br/>");
	}
	
}
