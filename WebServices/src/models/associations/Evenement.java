package models.associations;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder= {"id_event","nom_event","date_debut","date_fin", "description_event", "candidatures"})

public class Evenement
{
    private String date_debut;

    private String date_fin;

    private String id_event;

    private String nom_event;

    private String description_event;

    private Candidatures candidatures;

    /**
     * Renvoie la date de début de l'événement.
     * @return La date de début de l'événement.
     */
    public String getDate_debut ()
    {
        return date_debut;
    }

    /**
     * Définit la date de début de l'événement.
     * @param date_debut
     */
    public void setDate_debut (String date_debut)
    {
        this.date_debut = date_debut;
    }

    /**
     * Renvoie la date de fin de l'événement.
     * @return la date de fin de l'événement.
     */
    public String getDate_fin ()
    {
        return date_fin;
    }

    /**
     * Définit la date de fin de l'événement.
     * @param date_fin
     */
    public void setDate_fin (String date_fin)
    {
        this.date_fin = date_fin;
    }

    /**
     * Renvoie l'ID de l'événement.
     * @return l'ID de l'événement.
     */
    public String getId_event ()
    {
        return id_event;
    }

    /**
     * Définit l'ID de l'événement.
     * @param id_event
     */
    public void setId_event (String id_event)
    {
        this.id_event = id_event;
    }

    /**
     * Renvoie le nom de l'événement.
     * @return Le nom de l'événement.
     */
    public String getNom_event ()
    {
        return nom_event;
    }

    /**
     * Définit le nom de l'événement.
     * @param nom_event
     */
    public void setNom_event (String nom_event)
    {
        this.nom_event = nom_event;
    }

    /**
     * Renvoie la description de l'événement.
     * @return la description de l'événement.
     */
    public String getDescription_event ()
    {
        return description_event;
    }

    /**
     * Définit la description de l'événement.
     * @param description_event
     */
    public void setDescription_event (String description_event)
    {
        this.description_event = description_event;
    }

    /**
     * Renvoie la liste des candidatures de l'événement.
     * @return la liste des candidatures de l'événement.
     */
    public Candidatures getCandidatures ()
    {
        return candidatures;
    }

    /**
     * Définit la liste des candidatures de l'événement.
     * @param candidatures
     */
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