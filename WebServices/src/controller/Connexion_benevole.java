package controller;

import util.Util_Connexion_Benevole;
import util.Util_Inscription_Benevole;
import util.manipulation_xml.Personnes_xml;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/connexion_benevole")

public class Connexion_benevole extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static final String VUE = "/WEB-INF/ConnectionBenevole.jsp";
	public static final String XML = "D:\\Users\\Pierre\\Desktop\\WebsGit\\WebServices\\WebServices\\WebContent\\personnes.xml";
    public static final String CHAMP_EMAIL_BN = "mailC";
    public static final String CHAMP_PASS_BN = "mdpC";
    public static final String ATT_ERREURS  = "erreurs";
    public static final String ATT_RESULTAT = "resultat";

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

    	String resultat;
        Map<String, String> erreurs = new HashMap<String, String>();

        String email = request.getParameter( CHAMP_EMAIL_BN );
        String motDePasse = request.getParameter( CHAMP_PASS_BN );
      	
        if (Personnes_xml.authentificationValide( email, motDePasse, new File (XML)) ) {
        	System.out.println("Connexion OK");
        	//Reste � compl�ter
        } else {
        	System.out.println("Echec connexion");
        	try {
        		Util_Connexion_Benevole.mailVide(email);
        	} catch (Exception e) {
        		System.out.println("Mail vide");
        		erreurs.put(CHAMP_EMAIL_BN, e.getMessage());
        	}
        	
        	try {
        		Util_Connexion_Benevole.mdpVide(motDePasse);
        	} catch (Exception e) {
        		System.out.println("Mdp vide");
        		erreurs.put(CHAMP_PASS_BN, e.getMessage());
        	}
        	
        	if (erreurs.isEmpty()) {
        		erreurs.put(CHAMP_EMAIL_BN, "Ce compte n'existe pas.");
        	}
        }

        if ( erreurs.isEmpty() ) {
            resultat = "Succ�s de la connexion.";
        } else {
            resultat = "�chec de la connexion.";
        }
        
        request.setAttribute( ATT_ERREURS, erreurs );
        request.setAttribute( ATT_RESULTAT, resultat );
        
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}