package com.agodi;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class to decide if one string is a permutation of the other
 * @author Arturo
 *
 */
public class StringPermutationValidator {

	private Map<Character, AtomicInteger> map = new HashMap<Character, AtomicInteger>();

	public boolean isPermutation(String originalStr, String testingStr) {
		for (char c : originalStr.toCharArray()) {
			if (map.containsKey(c)) {
				map.get(c).incrementAndGet();
			} else {
				map.put(c, new AtomicInteger(1));
			}
		}

		for (char c : testingStr.toCharArray()) {
			AtomicInteger integer = map.get(c);
			if (integer != null && integer.get() > 0) {
				integer.decrementAndGet();
			} else {
				return false;
			}
		}

		for (AtomicInteger integer : map.values()) {
			if (integer.get() != 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		StringPermutationValidator validator = new StringPermutationValidator();
		System.out.println(validator.isPermutation("qwerty", "ytrewq"));
	}

}
