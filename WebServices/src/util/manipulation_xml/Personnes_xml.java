package util.manipulation_xml;

import util.JaxParser;
import models.personnes.*;

import java.util.Objects;

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
	
}
