package models.personnes;

import javax.xml.bind.annotation.XmlType;
@XmlType(propOrder= {"nom_event","date_debut","date_fin","etat"})

public class Candidature
{
    private String etat;

    private String date_debut;

    private String date_fin;

    private String nom_event;

    /**
     * Renvoie l'�tat d'une candidature.
     * @return l'�tat d'une candidature.
     */
    public String getEtat ()
    {
        return etat;
    }

    /**
     * D�finit l'�tat d'une candidature.
     * @param etat
     */
    public void setEtat (String etat)
    {
        this.etat = etat;
    }

    /**
     * Renvoie la date de d�but de l'�v�nement associ� � une candidature.
     * @return la date de d�but de l'�v�nement associ� � une candidature.
     */
    public String getDate_debut ()
    {
        return date_debut;
    }

    /**
     * D�finit la date de d�but de l'�v�nement associ� � une candidature.
     * @param date_debut
     */
    public void setDate_debut (String date_debut)
    {
        this.date_debut = date_debut;
    }

    /**
     * Renvoie la date de fin de l'�v�nement associ� � une candidature.
     * @return la date de fin de l'�v�nement associ� � une candidature.
     */
    public String getDate_fin ()
    {
        return date_fin;
    }

    /**
     * D�finit la date de fin de l'�v�nement associ� � une candidature.
     * @param date_fin
     */
    public void setDate_fin (String date_fin)
    {
        this.date_fin = date_fin;
    }

    /**
     * Renvoie le nom de l'�v�nement associ� � une candidature.
     * @return le nom de l'�v�nement associ� � une candidature.
     */
    public String getNom_event ()
    {
        return nom_event;
    }

    /**
     * D�finit le nom de l'�v�nement associ� � une candidature.
     * @param nom_event
     */
    public void setNom_event (String nom_event)
    {
        this.nom_event = nom_event;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [etat = "+etat+", date_debut = "+date_debut+", date_fin = "+date_fin+", nom_event = "+nom_event+"]";
    }
}