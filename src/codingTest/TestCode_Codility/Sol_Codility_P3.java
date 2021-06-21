package codingTest.TestCode_Codility;

import java.util.*;

// Lesson 2. Arrays
// odd_occurrences_in_array
// https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/start/
public class Sol_Codility_P3 {

	public int solution(int[] A) {
		int result = 0;
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < A.length; ++i) {
			int cnt = map.getOrDefault(A[i], 0) + 1;
			map.put(A[i], cnt);
		}
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() % 2 == 1) {
				result = entry.getKey();
				return result;
			}
		}
		
		return result;
	}


	public static void main(String[] args) throws Exception {
		Sol_Codility_P3 sol = new Sol_Codility_P3();
		System.out.println(sol.solution(new int[]{9,3,9,3,9,7,9}));
	}
}
