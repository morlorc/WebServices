package models.personnes;

public class Personne
{
    private String age;

    private String mdp_pers;

    private String nom_pers;

    private String prenom_pers;

    private Candidatures candidatures;

    private String mail_pers;
    
    public Personne(String nom, String prenom, String _age, String email, String motDePasse) {
    	nom_pers = nom;
    	prenom_pers = prenom;
    	age = _age;
    	mail_pers = email;
    	mdp_pers = motDePasse;
    }
    
    public Personne() {
    	nom_pers = "";
    	prenom_pers = "";
    	age = "";
    	mail_pers = "";
    	mdp_pers = "";
    }

    public String getAge ()
    {
        return age;
    }

    public void setAge (String age)
    {
        this.age = age;
    }

    public String getMdp_pers ()
    {
        return mdp_pers;
    }

    public void setMdp_pers (String mdp_pers)
    {
        this.mdp_pers = mdp_pers;
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

    public Candidatures getCandidatures ()
    {
        return candidatures;
    }

    public void setCandidatures (Candidatures candidatures)
    {
        this.candidatures = candidatures;
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
        return "ClassPojo [age = "+age+", mdp_pers = "+mdp_pers+", nom_pers = "+nom_pers+", prenom_pers = "+prenom_pers+", candidatures = "+candidatures+", mail_pers = "+mail_pers+"]";
    }
}