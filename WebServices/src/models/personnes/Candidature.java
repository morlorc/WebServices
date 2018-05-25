package models.personnes;

import javax.xml.bind.annotation.XmlType;
@XmlType(propOrder= {"nom_event","date_debut","date_fin","etat"})

public class Candidature
{
    private String etat;

    private String date_debut;

    private String date_fin;

    private String nom_event;

    public String getEtat ()
    {
        return etat;
    }

    public void setEtat (String etat)
    {
        this.etat = etat;
    }

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

    public String getNom_event ()
    {
        return nom_event;
    }

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