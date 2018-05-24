package models.associations;

public class Evenement
{
    private String date_debut;

    private String date_fin;

    private String id_event;

    private String nom_event;

    private String description_event;

    private Candidatures candidatures;

    public String getDate_debut ()
    {
        return date_debut;
    }

    public void setDate_debut (String date_debut)
    {
        this.date_debut = date_debut;
    }

    public String getDate_fin ()
    {
        return date_fin;
    }

    public void setDate_fin (String date_fin)
    {
        this.date_fin = date_fin;
    }

    public String getId_event ()
    {
        return id_event;
    }

    public void setId_event (String id_event)
    {
        this.id_event = id_event;
    }

    public String getNom_event ()
    {
        return nom_event;
    }

    public void setNom_event (String nom_event)
    {
        this.nom_event = nom_event;
    }

    public String getDescription_event ()
    {
        return description_event;
    }

    public void setDescription_event (String description_event)
    {
        this.description_event = description_event;
    }

    public Candidatures getCandidatures ()
    {
        return candidatures;
    }

    public void setCandidatures (Candidatures candidatures)
    {
        this.candidatures = candidatures;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [date_debut = "+date_debut+", date_fin = "+date_fin+", id_event = "+id_event+", nom_event = "+nom_event+", description_event = "+description_event+", candidatures = "+candidatures+"]";
    }
}