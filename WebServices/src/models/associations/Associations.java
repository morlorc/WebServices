package models.associations;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Associations
{
    private List<Association> association;

    public List<Association> getAssociation ()
    {
        return association;
    }

    public void setAssociation (List<Association> association)
    {
        this.association = association;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [association = "+association+"]";
    }
}
		