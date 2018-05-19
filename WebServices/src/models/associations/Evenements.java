package models.associations;

public class Evenements
{
    private Evenement evenement;

    public Evenement getEvenement ()
    {
        return evenement;
    }

    public void setEvenement (Evenement evenement)
    {
        this.evenement = evenement;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [evenement = "+evenement+"]";
    }
}