package models;

public class Identifiants
{
    private String nom_asso;

    private String SIREN;

    private String mail_asso;

    private String mdp_asso;

    public String getNom_asso ()
    {
        return nom_asso;
    }

    public void setNom_asso (String nom_asso)
    {
        this.nom_asso = nom_asso;
    }

    public String getSIREN ()
    {
        return SIREN;
    }

    public void setSIREN (String SIREN)
    {
        this.SIREN = SIREN;
    }

    public String getMail_asso ()
    {
        return mail_asso;
    }

    public void setMail_asso (String mail_asso)
    {
        this.mail_asso = mail_asso;
    }

    public String getMdp_asso ()
    {
        return mdp_asso;
    }

    public void setMdp_asso (String mdp_asso)
    {
        this.mdp_asso = mdp_asso;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [nom_asso = "+nom_asso+", SIREN = "+SIREN+", mail_asso = "+mail_asso+", mdp_asso = "+mdp_asso+"]";
    }
}