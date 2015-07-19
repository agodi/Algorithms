package chapter1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class to check if a string is a permutation
 * of a palindrome
 * @author Arturo
 *
 */
public class PalindromePermutation {

	/**
	 * Determines if a string is a permutation of a
	 * palindrome
	 * @param str
	 * @return true if the string has all characters to
	 * create a palindrome (none or one character repeated
	 * an odd number of times)
	 * false otherwise
	 */
	public static boolean isPermutation(String str) {
		Map<Character, AtomicInteger> map = new HashMap<Character, AtomicInteger>();
		int oddCount = 0;
		str = str.toLowerCase();
		for (int i = 0; i < str.length(); i++) {
			char character = str.charAt(i);
			if(character == ' ') continue;
			if (!map.containsKey(character)) {
				map.put(character, new AtomicInteger(1));
			} else {
				map.get(character).incrementAndGet();
			}
		}

		for (AtomicInteger integer : map.values()) {
			if (integer.get() % 2 != 0) oddCount++;
		}
		return !(oddCount > 1);
	}

	public static void main(String[] args) {
		String str = "Tact Coa";
		System.out.println(isPermutation(str));
	}

}
