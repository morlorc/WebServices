package models.personnes;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Personnes {

	private List<Personne> personne;

    public List<Personne> getPersonne ()
    {
        return personne;
    }

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
