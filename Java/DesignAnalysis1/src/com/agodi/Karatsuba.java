package com.agodi;

import java.util.Arrays;

public class Karatsuba {

	public static void main(String[] args) {
		try {
			long[] a = {2,2,2,2};
			long[] b = {2,2,2,2};
//			multiply(getDigits(args[0].toCharArray()),
//					getDigits(args[1].toCharArray()));
			System.out.println(multiply(a, b));
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}

	private static long multiply(long[] x, long[] y) {
		if(x.length<=2) {
			long a = x.length==2?x[0]:0;
			long b = x.length==2?x[1]:x[0];
			long c = x.length==2?y[0]:0;
			long d = x.length==2?y[1]:y[0];
			long step1 = a * c;
			long step3 = b * d;
			long step2 = ((a+b)*(c+d)) - step1 - step3;
			return (long) Math.pow(10, x.length) * step1 + (long) Math.pow(10, x.length/2) * step2 + step3;
		} else {
			long[] a = Arrays.copyOfRange(x, 0, x.length/2);
			long[] b = Arrays.copyOfRange(x, x.length/2, x.length);
			long[] c = Arrays.copyOfRange(y, 0, y.length/2);
			long[] d = Arrays.copyOfRange(y, y.length/2, y.length);
			return (long) Math.pow(10, x.length) * multiply(a, c) + 
					(long) Math.pow(10, x.length/2) * (multiply(a,d) + multiply(b,c)) +
					multiply(b, d);
		}
	}
	
	private static long[] getDigits(char[] array) throws IllegalArgumentException {
		long[] digits = new long[array.length];
		for(int i=0; i<array.length; i++) {
			digits[i] = array[i] - 48;
			if(digits[i]<0 || digits[i]>9) throw new IllegalArgumentException();
		}
		return digits;
	}

}
