package models.associations;

import java.util.ArrayList;

//import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@XmlTransient

public class Associations
{
    private ArrayList<Association> association;

    /**
     * Renvoie la liste des associations.
     * @return La liste des associations.
     */
    public ArrayList<Association> getAssociation ()
    {
        return association;
    }

    /**
     * Définit la liste des associations.
     * @param association
     */
    public void setAssociation (ArrayList<Association> association)
    {
        this.association = association;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [association = "+association+"]";
    }
}