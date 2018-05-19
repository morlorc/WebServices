package models.personnes;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Personnes {

	private Personne[] personne;

    public Personne[] getPersonne ()
    {
        return personne;
    }

    public void setPersonne (Personne[] personne)
    {
        this.personne = personne;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [personne = "+personne+"]";
    }
	
}
