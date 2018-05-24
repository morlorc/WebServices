package util.manipulation_xml;

import util.JaxParser;
import models.associations.*;

import java.io.File;
import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlType(propOrder= {"SIREN","nom_asso","mail_asso","mdp_asso","id_event","nom_event","date_debut","date_fin","description_event","id_pers","nom_pers","prenom_pers","motivation","mail_pers","etat"})
@XmlRootElement

public class Associations_xml {
	
	private static Associations unmarshal_associations(File src) {
		try {
			return (Associations) JaxParser.<Associations>unmarshal(
					models.associations.Associations.class,
					src
			);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean existeDejaMail(File src, String mail){
		Associations p = unmarshal_associations(src);
		for (int i=0; i<p.getAssociation().size(); ++i) {
			if (Objects.equals(mail, p.getAssociation().get(i).getMail())) {
				return true;
			}
		}
		return false;
	}
	
	public static void ajouterAssociations(File src, String siren, String nom, String email, String motDePasse) {
		try {
			Associations a = unmarshal_associations(src);
			a.getAssociation().add(new Association (siren, nom, email, motDePasse));
			JaxParser.<Associations>marshal(a, src);
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
