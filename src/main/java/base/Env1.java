package base;


public class Env1 {
	private static String filepath = "/src/main/resources/Environment.properties";
	public static String URL;
	public static String Browser;
	// public static String appUser1;
	static {
		Util prop = new Util();
		String baseDir = System.getProperty("user.dir");
		URL = prop.getValue(baseDir + filepath, "app_url");

	}
}

