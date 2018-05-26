package models.associations;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder= {"SIREN","nom_asso","mail_asso","mdp_asso","evenements"})

public class Association {

	private String nom_asso;
	private String mail_asso;
	private String SIREN;
	private String mdp_asso;

    private Evenements evenements;

	public String getNom() {
		return nom_asso;
	}
    public Association(String siren_asso, String nom, String email, String motDePasse, Evenements events) {
    	SIREN = siren_asso;
    	nom_asso = nom;
    	mail_asso = email;
    	mdp_asso = motDePasse;
    	evenements = events;
    }
    public Association() {
    	SIREN = "";
    	nom_asso = "";
    	mail_asso = "";
    	mdp_asso = "";
    }
	/**
	 * défini le nom de l'association
	 * @param nom
	 */
	public void setNom(String nom_asso) {
		this.nom_asso = nom_asso;
	}
	public String getMail() {
		return mail_asso;
	}
	public void setMail(String mail_asso) {
		this.mail_asso = mail_asso;
	}
	public String getSiren() {
		return SIREN;
	}
	public void setSiren(String SIREN) {
		this.SIREN = SIREN;
	}
	public String getMdp() {
		return mdp_asso;
	}
	public void setMdp(String mdp_asso) {
		this.mdp_asso = mdp_asso;
	}

    public Evenements getEvenements ()
    {
        return evenements;
    }

    public void setEvenements (Evenements evenements)
    {
        this.evenements = evenements;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [siren = "+SIREN+", nom = "+nom_asso+", mdp = "+mdp_asso+", evenements = "+evenements+", mail = "+mail_asso+"]";
    }
}
