package util;

public class Config {

	private static  String chemin; 
	public Config() {
		super();
	}
	
	/**
	 * Renvoie le chemin d'accès au fichier.
	 * @return Le chemin d'accès au fichier.
	 */
	public static String getChemin() {
		return chemin;
	}
	
	/**
	 * Définit le chemin d'un fichier.
	 * @param path Chemin du fichier
	 */
	public static void setChemin(String path) {
		chemin = path;
	}
	
	
}
