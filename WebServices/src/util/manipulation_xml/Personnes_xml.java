package util.manipulation_xml;

import util.JaxParser;
import models.personnes.*;

import java.util.Objects;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamSource;
//import java.util.List;

public class Personnes_xml {

	private static Personnes unmarshal_personnes(StreamSource src) {
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
	
	public static boolean existeDejaMail(String mail, StreamSource src){
		Personnes p = unmarshal_personnes(src);
		System.out.println("existeMail avec " + mail);
		for (int i=0; i<p.getPersonne().size(); ++i) {
			System.out.println(p.getPersonne().get(i).getMail_pers());
			if (Objects.equals(mail, p.getPersonne().get(i).getMail_pers())) {
				return true;
			}
		}
		return false;
	}
	
	public static void ajouterPersonne(StreamSource src, String nom, String prenom, String age, String email, String motDePasse) {
		try {
			Personnes p = unmarshal_personnes(src);
			JAXBContext ctx;
			ctx = JAXBContext.newInstance(models.personnes.Personnes.class);
	        Marshaller m = ctx.createMarshaller();
	        m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	        //Personnes p = new Personne (nom, prenom, age, email, motDePasse);
	        p.getPersonne().add(new Personne (nom, prenom, age, email, motDePasse));
	        m.marshal(p,  System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		//(Personnes) JaxParser.<Personnes>marshal( models.personnes.Personnes.class, src);
	}
	
	public static boolean authentificationValide(String mail, String mdp, StreamSource src) {
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
