package controller;

import util.Util_Inscription_Association;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Inscription_association extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public static final String VUE = "/WEB-INF/InscriptionAssociation.jsp";
    public static final String CHAMP_NOM_AS = "nomA";
    public static final String CHAMP_SIREN_AS = "SIREN";
    public static final String CHAMP_EMAIL_AS = "mailA";
    public static final String CHAMP_PASS_AS = "mdpA";
    public static final String ATT_ERREURS  = "erreurs";
    public static final String ATT_RESULTAT = "resultat";

	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
		String resultat;
        Map<String, String> erreurs = new HashMap<String, String>();
        
        String nom = request.getParameter(CHAMP_NOM_AS);
        String siren = request.getParameter(CHAMP_SIREN_AS);
        String email = request.getParameter(CHAMP_EMAIL_AS);
        String motDePasse = request.getParameter(CHAMP_PASS_AS);
        
        try {
        	Util_Inscription_Association.validationNom( nom );
        } catch(Exception e) {
        	erreurs.put(CHAMP_NOM_AS, e.getMessage());
        }
        
        try {
        	Util_Inscription_Association.validationSiren( siren );
        } catch(Exception e) {
        	erreurs.put(CHAMP_SIREN_AS, e.getMessage());
        }
        
        try {
        	Util_Inscription_Association.validationEmail( email );
        } catch(Exception e) {
        	erreurs.put(CHAMP_EMAIL_AS, e.getMessage());
        }
        
        try {
        	Util_Inscription_Association.validationMotsDePasse( motDePasse );
        } catch(Exception e) {
        	erreurs.put(CHAMP_PASS_AS, e.getMessage());
        }
        
        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'inscription.";
        } else {
            resultat = "Échec de l'inscription.";
        }
        
        request.setAttribute( ATT_ERREURS, erreurs );
        request.setAttribute( ATT_RESULTAT, resultat );
        
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
      	
	}
}
