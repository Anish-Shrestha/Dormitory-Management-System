package groupseven.mppproject.utils;

public class Helper {

	public static boolean isNullorEmpty(String s){
		if(s==null||s.isEmpty())
			return true;
		return false;
	}
	public static String ForumTypeCast(int typeId) {
		switch (typeId) {
		case 1:
			return ForumType.Suggestion.toString();
		case 2:
			return ForumType.Complain.toString();
		default:
			return ForumType.Maintainance.toString();

		}
	}

	public static int ForumTypeCast(String type) {
		switch (type) {
		case "Suggestion":
			return 1;
		case "Complain":
			return 2;
		default:
			return 3;
		}
	}
}
