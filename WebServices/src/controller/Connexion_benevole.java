package controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forms.Connexion_benevole_form;
import models.personnes.Personne;

@WebServlet(urlPatterns = "/connexion_benevole")

public class Connexion_benevole extends HttpServlet {

	private static final long serialVersionUID = 1L;
	

    public static final String ATT_PERSONNE = "personne";
    public static final String ATT_FORM = "form";
	public static final String VUE = "/WEB-INF/ConnectionBenevole.jsp";
	
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
	
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Préparation de l'objet formulaire */
        Connexion_benevole_form form = new Connexion_benevole_form();
		
        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        Personne personne = form.connecterPersonne( request );
		
        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_PERSONNE, personne );
		
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}