package models.personnes;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@XmlTransient

public class Personnes {

	private List<Personne> personne;

	/**
	 * Renvoie la liste des personnes.
	 * @return la liste des personnes.
	 */
    public List<Personne> getPersonne ()
    {
        return personne;
    }

    /**
     * Définit un objet Personne.
     * @param personne
     */
    public void setPersonne (List<Personne> personne)
    {
        this.personne = personne;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [personne = "+personne+"]";
    }
	
}
