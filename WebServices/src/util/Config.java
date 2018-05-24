package util;

public class Config {

	private static  String chemin; 
	public Config() {
		super();
	}
	public static String getChemin() {
		return chemin;
	}
	public static void setChemin(String path) {
		chemin = path;
		System.err.println("Config "+Config.chemin);
	}
	
	
}
