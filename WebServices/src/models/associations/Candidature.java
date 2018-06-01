package models.associations;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder= {"nom_pers","prenom_pers","motivation","mail_pers","etat"})

public class Candidature
{
    private String etat;

    private String motivation;

    private String nom_pers;

    private String prenom_pers;

    private String mail_pers;

    /**
     * Renvoie l'�tat de la candidature.
     * @return L'�tat de la candidature.
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
     * Renvoie la motivation renseing�e pour une candidature.
     * @return La motivation d'une candidature candidature.
     */
    public String getMotivation ()
    {
        return motivation;
    }

    /**
     * D�finit la motivation pour une candidature.
     * @param motivation
     */
    public void setMotivation (String motivation)
    {
        this.motivation = motivation;
    }

    /**
     * Renvoie le nom de la personne ayant candidat�.
     * @return Le nom de la personne ayant candidat�.
     */
    public String getNom_pers ()
    {
        return nom_pers;
    }

    /**
     * D�finit le nom de la personne ayant candidat�.
     * @param nom_pers
     */
    public void setNom_pers (String nom_pers)
    {
        this.nom_pers = nom_pers;
    }

    /**
     * Renvoie le pr�nom de la personne ayant candidat�.
     * @return le pr�nom de la personne ayant candidat�.
     */
    public String getPrenom_pers ()
    {
        return prenom_pers;
    }

    /**
     * D�finit le nom de la personne ayant candidat�.
     * @param prenom_pers
     */
    public void setPrenom_pers (String prenom_pers)
    {
        this.prenom_pers = prenom_pers;
    }

    /**
     * Renvoie l'adresse mail de la personne ayant candidat�.
     * @return l'adresse mail de la personne ayant candidat�.
     */
    public String getMail_pers ()
    {
        return mail_pers;
    }

    /**
     * D�finit l'adressse mail de la personne ayant candidat�.
     * @param mail_pers
     */
    public void setMail_pers (String mail_pers)
    {
        this.mail_pers = mail_pers;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [etat = "+etat+", motivation = "+motivation+", nom_pers = "+nom_pers+", prenom_pers = "+prenom_pers+", mail_pers = "+mail_pers+"]";
    }
}