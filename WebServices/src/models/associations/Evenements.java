package models.associations;

public class Evenements
{
    private Evenement evenement;

    /**
     * Renvoie un objet Evenement.
     * @return Un objet Evenement.
     */
    public Evenement getEvenement ()
    {
        return evenement;
    }

    /**
     * D�finit un objet �v�nement.
     * @param evenement
     */
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