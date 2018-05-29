package util.manipulation_xml;

import util.JaxParser;
import models.associations.*;

import java.io.File;
import java.util.Objects;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;


public class Associations_xml {
	
	private static Associations unmarshal_associations(File src) {
		try {
			return (Associations) JaxParser.<Associations>unmarshal(
					models.associations.Associations.class,
					src
			);
		}catch (Exception e) {
			System.out.println("Erreur asso unmarshal : " + src);
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean existeDejaMail(File src, String mail){
		//Associations p = unmarshal_associations(src);
		try {
			System.out.println("existeDejaMail 1");
			JAXBContext ctx;
			System.out.println("existeDejaMail 2");
			ctx = JAXBContext.newInstance(models.associations.Associations.class);
			System.out.println("existeDejaMail 3");
			Unmarshaller u = ctx.createUnmarshaller();
			System.out.println("existeDejaMail 4");
	        Associations p = u.unmarshal(new StreamSource(src), models.associations.Associations.class).getValue();
	        System.out.println("existeDejaMail 5");
	        for (int i=0; i<p.getAssociation().size(); ++i) {
				if (Objects.equals(mail, p.getAssociation().get(i).getMail())) {
					return true;
				}
			}
		} catch (JAXBException e) {
			System.out.println("Erreur existeDejaMail !");
			e.printStackTrace();
		}
		System.out.println("Fin existeDejaMail");
		return false;
	}
	
	public static void ajouterAssociation(File src, String siren, String nom, String email, String motDePasse) {
		try {
			Associations a = unmarshal_associations(src);
			a.getAssociation().add(new Association (siren, nom, email, motDePasse, new Evenements()));
			JaxParser.<Associations>marshal(a, src, "association");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Association authentification(String mail, String mdp, File src) throws Exception{
		System.out.println("authentificationValide avec " + mail + " ; " + mdp + " " + src.getAbsolutePath());
		Associations p = JaxParser.unmarshal(Associations.class, src );
		for (int i=0; i<p.getAssociation().size(); ++i) {
			//System.out.println(p.getPersonne().get(i).getMail_pers());
			if (Objects.equals(mail, p.getAssociation().get(i).getMail())) {
				if (Objects.equals(mdp, p.getAssociation().get(i).getMdp())) {
					return p.getAssociation().get(i);
				} else {
					throw new Exception("Les informations ne permettent pas de vous identifier.<br/>");
				}
			}
		}
		throw new Exception("Les informations ne permettent pas de vous identifier.<br/>");
	}
	
}
