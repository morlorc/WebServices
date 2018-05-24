package controller;

import util.Util_Inscription;
import util.manipulation_xml.Personnes_xml;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.stream.StreamSource;

@WebServlet(urlPatterns = "/inscription_benevole")

public class Inscription_benevole extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static final String VUE = "/WEB-INF/InscriptionBenevole.jsp";
	public static final String XML = "D:\\Users\\Pierre\\Desktop\\WebsGit\\WebServices\\WebServices\\WebContent\\personnes.xml";
    public static final String CHAMP_NOM_BN = "nomB";
    public static final String CHAMP_PRENOM_BN = "prenomB";
    public static final String CHAMP_AGE_BN = "ageB";
    public static final String CHAMP_EMAIL_BN = "mailB";
    public static final String CHAMP_PASS_BN = "mdpB";
    public static final String ATT_ERREURS  = "erreurs";
    public static final String ATT_RESULTAT = "resultat";

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

    	String resultat;
        Map<String, String> erreurs = new HashMap<String, String>();
    	
        String nom = request.getParameter( CHAMP_NOM_BN );
        String prenom = request.getParameter( CHAMP_PRENOM_BN );
        String age = request.getParameter( CHAMP_AGE_BN );
        String email = request.getParameter( CHAMP_EMAIL_BN );
        String motDePasse = request.getParameter( CHAMP_PASS_BN );
        
        if (Personnes_xml.existeDejaMail( email, new File (XML)) ) {
        //if (Personnes_xml.existeDejaMail( email, new StreamSource( request.getServletContext().getResourceAsStream( XML ))) ) {
        	erreurs.put(CHAMP_EMAIL_BN, "Un compte existe d�j� avec cette adresse.");
        } else {
        
	        try {
	        	Util_Inscription.validationNom( nom );
	        }catch (Exception e){
	        	erreurs.put(CHAMP_NOM_BN, e.getMessage());
	        }
	        
	        try {
	        	Util_Inscription.validationPrenom( prenom );
	        }catch (Exception e){
	        	erreurs.put(CHAMP_PRENOM_BN, e.getMessage());
	        }
	        
	        try {
	        	Util_Inscription.validationAge( age );
	        }catch (Exception e){
	        	erreurs.put(CHAMP_AGE_BN, e.getMessage());
	        }
	        
	        try {
	        	Util_Inscription.validationEmail( email );
	        }catch (Exception e){
	        	erreurs.put(CHAMP_EMAIL_BN, e.getMessage());
	        }
	        
	        try {
	        	Util_Inscription.validationMotsDePasse( motDePasse );
	        }catch (Exception e){
	        	erreurs.put(CHAMP_PASS_BN, e.getMessage());
	        }
        }

        if ( erreurs.isEmpty() ) {
        	Personnes_xml.ajouterPersonne(
        			new File( XML ),
        			nom, prenom, age, email, motDePasse
        	);
            resultat = "Succ�s de l'inscription.";
        } else {
            resultat = "�chec de l'inscription.";
        }
        
        request.setAttribute( ATT_ERREURS, erreurs );
        request.setAttribute( ATT_RESULTAT, resultat );
        
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}