package util.manipulation_xml;

import util.JaxParser;
import models.associations.*;

import java.io.File;
import java.util.Objects;

public class Associations_xml {
	
	/**
	 * Fonction utilitaire servant à unmarshall avec la classe Associations.
	 * @param src Fichier xml à lire
	 * @return Un objet Association provenant du fichier .xml.
	 */
	private static Associations unmarshal_associations(File src) {
		try {
			return JaxParser.unmarshal(Associations.class,src);
		}catch (Exception e) {
			System.out.println("Erreur asso unmarshal : " + src);
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Indique si une adresse mail existe déjà dans un fichier .xml
	 * @param src Fichier xml à lire
	 * @param mail Adresse mail
	 * @return Vrai si le mail existe déjà dans la base de données, Faux sinon.
	 */
	public static boolean existeDejaMail(File src, String mail){
		Associations p = unmarshal_associations(src);
        for (int i=0; i<p.getAssociation().size(); ++i) {
			if (Objects.equals(mail, p.getAssociation().get(i).getMail_asso())) {
				return true;
			}
		}
		System.out.println("Fin existeDejaMail");
		return false;
	}
	
	/**
	 * Ajoute un objet Association dans un fichier .xml.
	 * @param src Fichier xml à lire
	 * @param siren SIREN
	 * @param nom Nom
	 * @param email Adresse mail
	 * @param motDePasse Mot de passe
	 */
	public static void ajouterAssociation(File src, String siren, String nom, String email, String motDePasse) {
		try {
			Associations a = unmarshal_associations(src);
			a.getAssociation().add(new Association (siren, nom, email, motDePasse, new Evenements()));
			JaxParser.<Associations>marshal(a, src, "association");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Authentifie une Association en vérifiant la validité du login et du mot de passe.
	 * @param mail Adresse mail
	 * @param mdp Mot de passe
	 * @param src Fichier xml à lire
	 * @return Un objet Personne contenant les informations relatives au couple login/mdp.
	 * @throws Exception S'il est impossible d'authentifier l'association
	 */
	public static Association authentification(String mail, String mdp, File src) throws Exception{
		System.out.println("authentificationValide avec " + mail + " ; " + mdp + " " + src.getAbsolutePath());
		Associations p = JaxParser.unmarshal(Associations.class, src );
		for (int i=0; i<p.getAssociation().size(); ++i) {
			//System.out.println(p.getPersonne().get(i).getMail_pers());
			if (Objects.equals(mail, p.getAssociation().get(i).getMail_asso())) {
				if (Objects.equals(mdp, p.getAssociation().get(i).getMdp_asso())) {
					return p.getAssociation().get(i);
				} else {
					throw new Exception("Les informations ne permettent pas de vous identifier.<br/>");
				}
			}
		}
		throw new Exception("Les informations ne permettent pas de vous identifier.<br/>");
	}
	
}
