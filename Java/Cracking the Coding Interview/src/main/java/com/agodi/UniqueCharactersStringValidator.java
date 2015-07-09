package com.agodi;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to determine if a string has all unique characters
 * @author Arturo
 *
 */
public class UniqueCharactersStringValidator {

	private Map<Character, Character> map = new HashMap<Character, Character>();

	public boolean isUnique(String str) {
		for (char c : str.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, c);
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		UniqueCharactersStringValidator validator = new UniqueCharactersStringValidator();
		System.out.println(validator.isUnique("abcdef"));
	}

}
