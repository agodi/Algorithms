package com.agodi;

/**
 * Class to replace spaces in a string
 * for "%20" as in a URL
 * @author Arturo
 *
 */
public class URLify {

	/*
	 * Array containing the replacement characters
	 * for a whitespace in reverse order
	 */
	private static final char[] REPLACE_CHARS = {'0','2','%'};

	/**
	 * Loops over the array to determine if the actual
	 * position is a whitespace or another character
	 * @param chars
	 * @param lastCharPos
	 * @return the same array object without white spaces
	 */
	public static char[] urlifyString(char[] chars, int lastCharPos) {
		for (int i = chars.length - 1, j = lastCharPos - 1; j >= 0; i--, j--) {
			if (chars[j] == ' ') {
				replaceWhiteSpaces(chars, i);
				i -= 2;
			} else {
				chars[i] = chars[j];
			}
		}
		return chars;
	}

	/**
	 * Inserts the replacement characters backwards in the
	 * array starting at the given position
	 * @param chars
	 * @param startIndex
	 */
	private static void replaceWhiteSpaces(char[] chars, int startIndex) {
		for (int i = 0; i < REPLACE_CHARS.length; i++) {
			chars[startIndex--] = REPLACE_CHARS[i];
		}
	}

	public static void main(String[] args) {
//		char[] string = {'M','r',' ','J','o','h','n',' ','S','m','i','t','h',' ',' ',' ',' '};
		char[] string = {'a',' ','e',' ','i',' ','o',' ','u',' ',' ',' ',' ',' ',' ',' ',' '};
		urlifyString(string, 9);
		System.out.println(string);
	}

}
