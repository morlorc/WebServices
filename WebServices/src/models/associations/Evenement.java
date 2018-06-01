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
     * Renvoie la date de d�but de l'�v�nement.
     * @return La date de d�but de l'�v�nement.
     */
    public String getDate_debut ()
    {
        return date_debut;
    }

    /**
     * D�finit la date de d�but de l'�v�nement.
     * @param date_debut
     */
    public void setDate_debut (String date_debut)
    {
        this.date_debut = date_debut;
    }

    /**
     * Renvoie la date de fin de l'�v�nement.
     * @return la date de fin de l'�v�nement.
     */
    public String getDate_fin ()
    {
        return date_fin;
    }

    /**
     * D�finit la date de fin de l'�v�nement.
     * @param date_fin
     */
    public void setDate_fin (String date_fin)
    {
        this.date_fin = date_fin;
    }

    /**
     * Renvoie l'ID de l'�v�nement.
     * @return l'ID de l'�v�nement.
     */
    public String getId_event ()
    {
        return id_event;
    }

    /**
     * D�finit l'ID de l'�v�nement.
     * @param id_event
     */
    public void setId_event (String id_event)
    {
        this.id_event = id_event;
    }

    /**
     * Renvoie le nom de l'�v�nement.
     * @return Le nom de l'�v�nement.
     */
    public String getNom_event ()
    {
        return nom_event;
    }

    /**
     * D�finit le nom de l'�v�nement.
     * @param nom_event
     */
    public void setNom_event (String nom_event)
    {
        this.nom_event = nom_event;
    }

    /**
     * Renvoie la description de l'�v�nement.
     * @return la description de l'�v�nement.
     */
    public String getDescription_event ()
    {
        return description_event;
    }

    /**
     * D�finit la description de l'�v�nement.
     * @param description_event
     */
    public void setDescription_event (String description_event)
    {
        this.description_event = description_event;
    }

    /**
     * Renvoie la liste des candidatures de l'�v�nement.
     * @return la liste des candidatures de l'�v�nement.
     */
    public Candidatures getCandidatures ()
    {
        return candidatures;
    }

    /**
     * D�finit la liste des candidatures de l'�v�nement.
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