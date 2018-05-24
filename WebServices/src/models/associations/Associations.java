package models.associations;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Associations
{
    private Association association;

    public Association getAssociation ()
    {
        return association;
    }

    public void setAssociation (Association association)
    {
        this.association = association;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [association = "+association+"]";
    }
}
		