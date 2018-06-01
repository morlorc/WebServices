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
     * Renvoie l'état de la candidature.
     * @return L'état de la candidature.
     */
    public String getEtat ()
    {
        return etat;
    }

    /**
     * Définit l'état d'une candidature.
     * @param etat
     */
    public void setEtat (String etat)
    {
        this.etat = etat;
    }

    /**
     * Renvoie la motivation renseingée pour une candidature.
     * @return La motivation d'une candidature candidature.
     */
    public String getMotivation ()
    {
        return motivation;
    }

    /**
     * Définit la motivation pour une candidature.
     * @param motivation
     */
    public void setMotivation (String motivation)
    {
        this.motivation = motivation;
    }

    /**
     * Renvoie le nom de la personne ayant candidaté.
     * @return Le nom de la personne ayant candidaté.
     */
    public String getNom_pers ()
    {
        return nom_pers;
    }

    /**
     * Définit le nom de la personne ayant candidaté.
     * @param nom_pers
     */
    public void setNom_pers (String nom_pers)
    {
        this.nom_pers = nom_pers;
    }

    /**
     * Renvoie le prénom de la personne ayant candidaté.
     * @return le prénom de la personne ayant candidaté.
     */
    public String getPrenom_pers ()
    {
        return prenom_pers;
    }

    /**
     * Définit le nom de la personne ayant candidaté.
     * @param prenom_pers
     */
    public void setPrenom_pers (String prenom_pers)
    {
        this.prenom_pers = prenom_pers;
    }

    /**
     * Renvoie l'adresse mail de la personne ayant candidaté.
     * @return l'adresse mail de la personne ayant candidaté.
     */
    public String getMail_pers ()
    {
        return mail_pers;
    }

    /**
     * Définit l'adressse mail de la personne ayant candidaté.
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