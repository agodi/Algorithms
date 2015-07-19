package chapter1;

/**
 * Class to check if two strings are just zero or
 * one edits away
 * @author Arturo
 *
 */
public class OneAwayEditValidator {

	/**
	 * Compares character by character both string to check how many edits
	 * away is one to the other, if str2 is larger than str1 they are swapped
	 * @param str1
	 * @param str2
	 * @return true if strings are one or zero edits away
	 * 		   false otherwise
	 */
	public static boolean checkNumberOfEdits(String str1, String str2) {
		int str1Length = str1.length();
		int str2Length = str2.length();
		if(Math.abs(str1Length - str2Length) > 1) return false;
		if (str1Length < str2Length) {
			String aux = str1;
			str1 = str2;
			str2 = aux;
		}
		int editsCount = 0;
		for (int i = 0, j = 0; i < str1Length && j < str2Length; ) {
			if (str1Length == str2Length && str2.charAt(j) != str1.charAt(i)) {
				i++;
				j++;
				editsCount++;
			} else if (str2.charAt(j) != str1.charAt(i)) {
				i++;
				editsCount++;
			} else {
				i++;
				j++;
			}
		}
		return editsCount < 2;
	}

	public static void main(String[] args) {
		System.out.println(checkNumberOfEdits("pale", "ple"));
		System.out.println(checkNumberOfEdits("pales", "pale"));
		System.out.println(checkNumberOfEdits("pale", "bale"));
		System.out.println(checkNumberOfEdits("pale", "bake"));
		System.out.println(checkNumberOfEdits("pael", "pale"));
		System.out.println(checkNumberOfEdits("paleos", "pale"));
		System.out.println(checkNumberOfEdits("ae", "bake"));
	}

}
