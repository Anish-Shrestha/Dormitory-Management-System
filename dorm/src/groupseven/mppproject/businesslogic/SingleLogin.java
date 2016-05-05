package groupseven.mppproject.businesslogic;

public class SingleLogin {
	private static String userId;
	private static String password;
	private static boolean isAdmin;
	private static SingleLogin instance = new SingleLogin();

	// make the constructor private so that this class cannot be
	// instantiated
	private SingleLogin() {

	}
	public static void setIsAdmin(String isAdmn){
		if(isAdmn.contains("1")){
			isAdmin = true;
			System.out.println("Is admin");
			}
		else
			isAdmin = false;
	}

	public static void setLoginParam(String urId, String pwd) {
		userId = urId;
		password = pwd;
	}

	public static SingleLogin getInstance() {
		return instance;
	}

	public static String getUserId() {
		return userId;
	}
	public static boolean isAdmin() {
		return isAdmin;
	}

}
