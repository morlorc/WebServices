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

    public String getEtat ()
    {
        return etat;
    }

    public void setEtat (String etat)
    {
        this.etat = etat;
    }

    public String getMotivation ()
    {
        return motivation;
    }

    public void setMotivation (String motivation)
    {
        this.motivation = motivation;
    }

    public String getNom_pers ()
    {
        return nom_pers;
    }

    public void setNom_pers (String nom_pers)
    {
        this.nom_pers = nom_pers;
    }

    public String getPrenom_pers ()
    {
        return prenom_pers;
    }

    public void setPrenom_pers (String prenom_pers)
    {
        this.prenom_pers = prenom_pers;
    }

    public String getMail_pers ()
    {
        return mail_pers;
    }

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