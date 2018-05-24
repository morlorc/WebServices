package models.associations;

public class Association {

	private String nom;
	private String mail;
	private String id_asso;
	private String siren;
	private String mdp;

    private Evenements evenements;

	public String getNom() {
		return nom;
	}
    public Association(String siren_asso, String nom_asso, String email, String motDePasse) {
    	siren = siren_asso;
    	nom = nom_asso;
    	mail = email;
    	mdp = motDePasse;
    }
    public Association() {
    	siren = "";
    	nom = "";
    	mail = "";
    	mdp = "";
    }
	/**
	 * défini le nom de l'association
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getId_asso() {
		return id_asso;
	}
	public void setId_asso(String id_asso) {
		this.id_asso = id_asso;
	}
	public String getSiren() {
		return siren;
	}
	public void setSiren(String siren) {
		this.siren = siren;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
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
        return "ClassPojo [siren = "+siren+", nom = "+nom+", mdp = "+mdp+", evenements = "+evenements+", mail = "+mail+"]";
    }
}
