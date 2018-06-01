package util;

public class Config {

	private static  String chemin; 
	public Config() {
		super();
	}
	
	/**
	 * Renvoie le chemin d'acc�s au fichier.
	 * @return Le chemin d'acc�s au fichier.
	 */
	public static String getChemin() {
		return chemin;
	}
	
	/**
	 * D�finit le chemin d'un fichier.
	 * @param path Chemin du fichier
	 */
	public static void setChemin(String path) {
		chemin = path;
	}
	
	
}
