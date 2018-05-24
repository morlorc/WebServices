package controller;

import util.Util_Connexion;
import util.manipulation_xml.Personnes_xml;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.stream.StreamSource;

@WebServlet(urlPatterns = "/connexion_benevole")

public class Connexion_benevole extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static final String VUE = "/WEB-INF/ConnectionBenevole.jsp";
	public static final String XML = "personnes.xml";
    public static final String CHAMP_EMAIL_BN = "mailC";
    public static final String CHAMP_PASS_BN = "mdpC";
    public static final String ATT_ERREURS  = "erreurs";
    public static final String ATT_RESULTAT = "resultat";

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

    	String resultat;
        Map<String, String> erreurs = new HashMap<String, String>();

        String email = request.getParameter( CHAMP_EMAIL_BN );
        String motDePasse = request.getParameter( CHAMP_PASS_BN );
      	
        if (Personnes_xml.authentificationValide( email, motDePasse, new StreamSource( request.getServletContext().getResourceAsStream( XML ))) ) {
        	System.out.println("Connexion OK");
        	//Reste à compléter
        } else {
        	System.out.println("Echec connexion");
        	try {
        		Util_Connexion.mailVide(email);
        	} catch (Exception e) {
        		System.out.println("Mail vide");
        		erreurs.put(CHAMP_EMAIL_BN, e.getMessage());
        	}
        	
        	try {
        		Util_Connexion.mdpVide(motDePasse);
        	} catch (Exception e) {
        		System.out.println("Mdp vide");
        		erreurs.put(CHAMP_PASS_BN, e.getMessage());
        	}
        	
        	if (erreurs.isEmpty()) {
        		erreurs.put(CHAMP_EMAIL_BN, "Ce compte n'existe pas.");
        	}
        }

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de la connexion.";
        } else {
            resultat = "Échec de la connexion.";
        }
        
        request.setAttribute( ATT_ERREURS, erreurs );
        request.setAttribute( ATT_RESULTAT, resultat );
        
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}