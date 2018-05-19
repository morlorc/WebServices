package util.manipulation_xml;

import util.JaxParser;
import models.personnes.*;

import java.io.File;
import java.util.List;

public class Personnes_xml {

	public static void main(String[] args) {
		try { //Le code suivant ne fonctionne pas sans bloc try/catch
			
			Personnes personnes = (Personnes) JaxParser.<Personnes>unmarshal(
					models.personnes.Personnes.class, //Personnes.class ou Associations.class uniquement !
					new File("WebContent\\personnes.xml")
			);

			List<Personne> personne_list = personnes.getPersonne();
			for (int i=0; i < personne_list.size(); ++i) {
				Personne p = personne_list.get(i);
				System.out.println(p.getNom_pers());
				System.out.println(p.getPrenom_pers());
				System.out.println(p.getAge());
				System.out.println(p.getMail_pers());
				System.out.println(p.getMdp_pers());
				System.out.println();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
