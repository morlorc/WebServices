package models.associations;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder= {"SIREN","nom_asso","mail_asso","mdp_asso","evenements"})

public class Association
{
    private String nom_asso;

    private String SIREN;

    private String mail_asso;

    private String mdp_asso;

    private Evenements evenements;

    /**
     * Constructeur de Association.
     * @param siren
     * @param nom
     * @param email
     * @param motDePasse
     * @param events
     * @return Un objet Association
     */
    public Association(String siren, String nom, String email, String motDePasse, Evenements events) {
    	nom_asso = nom;
    	SIREN = siren;
    	mail_asso = email;
    	mdp_asso = motDePasse;
    	evenements = events;
	}
    
    /**
     * Constructeur par défaut d'Association.
     * @return Un objet Association
     */
    public Association() {
    	
    }

    /**
     * Renvoie le nom de l'association
     * @return Le nom de l'association
     */
	public String getNom_asso ()
    {
        return nom_asso;
    }

	/**
	 * Définit le nom de l'association
	 * @param nom_asso
	 */
    public void setNom_asso (String nom_asso)
    {
        this.nom_asso = nom_asso;
    }

    /**
     * Renvoie le SIREN de l'association.
     * @return Le SIREN de l'association
     */
    public String getSIREN ()
    {
        return SIREN;
    }

    /**
     * Définit le SIREN de l'association.
     * @param SIREN
     */
    public void setSIREN (String SIREN)
    {
        this.SIREN = SIREN;
    }

    /**
     * Renvoie l'adresse mail de l'association.
     * @return l'adresse mail de l'association.
     */
    public String getMail_asso ()
    {
        return mail_asso;
    }

    /**
     * Définit l'adresse mail de l'association.
     * @param mail_asso
     */
    public void setMail_asso (String mail_asso)
    {
        this.mail_asso = mail_asso;
    }

    /**
     * Renvoie le mot de passe de l'association.
     * @return Le mot de passe de l'association.
     */
    public String getMdp_asso ()
    {
        return mdp_asso;
    }

    /**
     * Définit le mot de passe de l'association.
     * @param mdp_asso
     */
    public void setMdp_asso (String mdp_asso)
    {
        this.mdp_asso = mdp_asso;
    }

    /**
     * Renvoie les événements de l'association.
     * @return les événements de l'association.
     */
    public Evenements getEvenements ()
    {
        return evenements;
    }

    /**
     * Définit les événements de l'association.
     * @param evenements
     */
    public void setEvenements (Evenements evenements)
    {
        this.evenements = evenements;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [nom_asso = "+nom_asso+", SIREN = "+SIREN+", mail_asso = "+mail_asso+", mdp_asso = "+mdp_asso+", evenements = "+evenements+"]";
    }
}