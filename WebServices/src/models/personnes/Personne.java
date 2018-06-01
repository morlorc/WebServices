package models.personnes;

import javax.xml.bind.annotation.XmlType;
@XmlType(propOrder= {"nom_pers","prenom_pers","mail_pers","age","mdp_pers","candidatures"})

public class Personne
{
    private String age;

    private String mdp_pers;

    private String nom_pers;

    private String prenom_pers;

    private Candidatures candidatures;

    private String mail_pers;
    
    /**
     * Constructeur de Personne
     * @param nom
     * @param prenom
     * @param _age
     * @param email
     * @param motDePasse
     * @param cand
     */
    public Personne(String nom, String prenom, String _age, String email, String motDePasse, Candidatures cand) {
    	nom_pers = nom;
    	prenom_pers = prenom;
    	age = _age;
    	mail_pers = email;
    	mdp_pers = motDePasse;
    	candidatures = cand;
    }
    
    /**
     * Construteur par défaut de Personne
     */
    public Personne() {
    	nom_pers = "";
    	prenom_pers = "";
    	age = "";
    	mail_pers = "";
    	mdp_pers = "";
    }

    /**
     * Renvoie l'âge de la personne.
     * @return L'âge de la personne.
     */
    public String getAge ()
    {
        return age;
    }

    /**
     * Définit l'âge de la personne.
     * @param age
     */
    public void setAge (String age)
    {
        this.age = age;
    }

    /**
     * Renvoie le mot de passe de la personne.
     * @return Le mot de passe de la personne.
     */
    public String getMdp_pers ()
    {
        return mdp_pers;
    }

    /**
     * Définit le mot de passe de la personne.
     * @param mdp_pers
     */
    public void setMdp_pers (String mdp_pers)
    {
        this.mdp_pers = mdp_pers;
    }

    /**
     * Renvoie le nom de la personne.
     * @return Le nom de la personne.
     */
    public String getNom_pers ()
    {
        return nom_pers;
    }

    /**
     * Définit le nom de la personne.
     * @param nom_pers
     */
    public void setNom_pers (String nom_pers)
    {
        this.nom_pers = nom_pers;
    }

    /**
     * Renvoie le prénom de la personne.
     * @return Le prénom de la personne.
     */
    public String getPrenom_pers ()
    {
        return prenom_pers;
    }

    /**
     * Définit le prénom de la personne.
     * @param prenom_pers
     */
    public void setPrenom_pers (String prenom_pers)
    {
        this.prenom_pers = prenom_pers;
    }

    /**
     * Renvoie la liste des candidatures de la personne.
     * @return le liste des candidatures de la personne.
     */
    public Candidatures getCandidatures ()
    {
        return candidatures;
    }

    /**
     * Définit la liste des candidatures de la personne.
     * @param candidatures
     */
    public void setCandidatures (Candidatures candidatures)
    {
        this.candidatures = candidatures;
    }

    /**
     * Renvoie l'adresse mail de la personne.
     * @return l'adresse mail de la personne.
     */
    public String getMail_pers ()
    {
        return mail_pers;
    }

    /**
     * Définit l'adresse mail de la personne.
     * @param mail_pers
     */
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