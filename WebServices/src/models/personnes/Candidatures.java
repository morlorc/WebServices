package models.personnes;

public class Candidatures
{
    private Candidature candidature;

    /**
     * Renvoie la liste des candidatures.
     * @return la liste des candidatures.
     */
    public Candidature getCandidature ()
    {
        return candidature;
    }

    /**
     * D�finit la liste des candidatures.
     * @param candidature
     */
    public void setCandidature (Candidature candidature)
    {
        this.candidature = candidature;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [candidature = "+candidature+"]";
    }
}