package util.manipulation_xml;

import util.JaxParser;
import models.personnes.*;

import java.io.File;
import java.util.Objects;

public class Personnes_xml {
	
	private static final String XML = "D:\\Users\\Pierre\\Desktop\\WebsGit\\WebServices\\WebServices\\WebContent\\personnes.xml";

	private static Personnes unmarshal_personnes() {
		try {
			return (Personnes) JaxParser.<Personnes>unmarshal(
					models.personnes.Personnes.class,
					new File(XML)
			);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean existeDejaMail(String mail){
		Personnes p = unmarshal_personnes();
		for (int i=0; i<p.getPersonne().size(); ++i) {
			if (Objects.equals(mail, p.getPersonne().get(i).getMail_pers())) {
				return true;
			}
		}
		return false;
	}
	
	public static void ajouterPersonne(String nom, String prenom, String age, String email, String motDePasse) {
		try {
			Personnes p = unmarshal_personnes();
			p.getPersonne().add(new Personne (nom, prenom, age, email, motDePasse));
			JaxParser.<Personnes>marshal(p, new File(XML));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Personne authentification(String mail, String mdp) throws Exception{
		Personnes p = unmarshal_personnes();
		//System.out.println("authentificationValide avec " + mail + " ; " + mdp);
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
