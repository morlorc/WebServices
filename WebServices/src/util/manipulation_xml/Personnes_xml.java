package util.manipulation_xml;

import util.JaxParser;
import models.personnes.*;

import java.io.File;
import java.util.Objects;

public class Personnes_xml {

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
	
	public static boolean existeDejaMail(String mail, File src){
		Personnes p = unmarshal_personnes(src);
		for (int i=0; i<p.getPersonne().size(); ++i) {
			if (Objects.equals(mail, p.getPersonne().get(i).getMail_pers())) {
				return true;
			}
		}
		return false;
	}
	
	public static void ajouterPersonne(File src, String nom, String prenom, String age, String email, String motDePasse) {
		try {
			Personnes p = unmarshal_personnes(src);
			p.getPersonne().add(new Personne (nom, prenom, age, email, motDePasse));
			JaxParser.<Personnes>marshal(p, src);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean authentificationValide(String mail, String mdp, File src) {
		Personnes p = unmarshal_personnes(src);
		System.out.println("authentificationValide avec " + mail + " ; " + mdp);
		for (int i=0; i<p.getPersonne().size(); ++i) {
			System.out.println(p.getPersonne().get(i).getMail_pers());
			if (Objects.equals(mail, p.getPersonne().get(i).getMail_pers())) {
				if (Objects.equals(mdp, p.getPersonne().get(i).getMdp_pers())) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}
	
}
