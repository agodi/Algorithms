package util;

import java.util.Stack;

public class WaterTrapCalculator {

	public static int calculate(int[] heights) {
		int count = 0;
		int max = 0;
		Stack<Integer> s = new Stack<Integer>();
		
		if (heights.length == 0) return 0;
		
		for(int i = 0; i < heights.length; i++) {
			if (s.empty() || heights[i] < max) {
				if (s.empty()) max = heights[i];
				s.push(heights[i]);
			} else {
				while (!s.empty()) {count += max - s.pop();}
				s.clear();
				max = heights[i];
				s.push(max);
			}
		}
		
		max = s.pop();
		while (!s.empty()) {
			if (s.peek() <= max) {count += max - s.pop();}
			else {max = s.pop();}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
//		int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
		int[] heights = {1,0,2};
		System.out.println(calculate(heights));
	}

}
