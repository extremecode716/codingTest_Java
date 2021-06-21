package codingTest.TestCode_Codility;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

//Lesson 3. Time Complexity
// TapeEquilibrium
// https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
public class Sol_Codility_P7 {

	public int solution(int[] A) {	
		int len = A.length;
		
		int allTapeSum = 0;
		int leftTapeSum = 0;
		int rightTapeSum = 0;
		
		int minAbsolute;
		
		// 모든 테이프의 합계
		for(int i = 0; i < len; ++i) {
			allTapeSum += A[i];
		}
		minAbsolute = Integer.MAX_VALUE;
		
		for(int i = 0; i < len - 1; ++i) {
			leftTapeSum += A[i];
			rightTapeSum = allTapeSum - leftTapeSum;
			minAbsolute = Math.min(minAbsolute, Math.abs(leftTapeSum - rightTapeSum));
		}

		return minAbsolute;
	}

	public static void main(String[] args) throws Exception {
		Sol_Codility_P7 sol = new Sol_Codility_P7();
		System.out.println(sol.solution(new int[]{3, 1, 2, 4, 3}));
	}
}
