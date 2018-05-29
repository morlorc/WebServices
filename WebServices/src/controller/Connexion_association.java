package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forms.Connexion_association_form;
import models.associations.Association;
import util.Config;

@WebServlet(urlPatterns = "/connexion_association")

public class Connexion_association extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
    public static final String ATT_ASSOCIATION = "association";
    public static final String ATT_FORM = "form";
	public static final String VUE = "/WEB-INF/ConnectionAssociation.jsp";
	
	
    @Override
	public void init() throws ServletException {
		super.init();
		System.err.println(getServletContext().getInitParameter("localDirectoryPath"));
		Config.setChemin(getServletContext().getInitParameter("localDirectoryPath"));
	}

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
	
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Préparation de l'objet formulaire */
        Connexion_association_form form = new Connexion_association_form();
		
        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        Association association = form.connecterAssociation( request );
        
    	Map<String, String> ATT_ERREURS = form.getErreurs();
		
        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, ATT_ERREURS );
        request.setAttribute( ATT_ASSOCIATION, association );
		
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}