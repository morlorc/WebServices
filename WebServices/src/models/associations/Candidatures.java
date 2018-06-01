package models.associations;

public class Candidatures
{
    private Candidature[] candidature;

    /**
     * Renvoie la liste des candidatures.
     * @return la liste des candidatures.
     */
    public Candidature[] getCandidature ()
    {
        return candidature;
    }

    /**
     * Définit la liste des candidatures.
     * @param candidature
     */
    public void setCandidature (Candidature[] candidature)
    {
        this.candidature = candidature;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [candidature = "+candidature+"]";
    }
}