package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forms.Inscription_benevole_form;
import models.personnes.Personne;
import util.Config;

@WebServlet(urlPatterns = "/inscription_benevole")

public class Inscription_benevole extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public static final String ATT_PERSONNE = "personne";
    public static final String ATT_FORM = "form";
	public static final String VUE = "/WEB-INF/InscriptionBenevole.jsp";

    @Override
	public void init() throws ServletException {
		super.init();
		System.err.println(getServletContext().getInitParameter("localDirectoryPath"));
		Config.setChemin(getServletContext().getInitParameter("localDirectoryPath"));
		System.err.println("chemin="+Config.getChemin());
	}
    
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
    	/* Pr�paration de l'objet formulaire */
        Inscription_benevole_form form = new Inscription_benevole_form();
		
        /* Appel au traitement et � la validation de la requ�te, et r�cup�ration du bean en r�sultant */
        Personne personne = form.inscrirePersonne( request );

    	Map<String, String> ATT_ERREURS = form.Get_AttErreur();
        
        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, ATT_ERREURS );
        request.setAttribute( ATT_PERSONNE, personne );
        
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}