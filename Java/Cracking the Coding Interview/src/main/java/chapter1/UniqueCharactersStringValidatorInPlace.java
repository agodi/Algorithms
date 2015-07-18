package chapter1;

import java.util.Arrays;

/**
 * Class to determine if a string has all unique characters
 * without using additional data structures
 * @author Arturo
 *
 */
public class UniqueCharactersStringValidatorInPlace {

	public boolean isUnique(char[] chars) {
		Arrays.sort(chars);
		int i = 0;
		boolean isUnique = true;
		while (i < chars.length - 1) {
			if (chars[i] == chars[i+1]) {
				isUnique = false;
			}
			i++;
		}
		return isUnique;
	}

	public static void main(String[] args) {
		UniqueCharactersStringValidatorInPlace validator = new UniqueCharactersStringValidatorInPlace();
		System.out.println(validator.isUnique("abcdef".toCharArray()));
	}

}
