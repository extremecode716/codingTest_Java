package codingTest.TestCode_Gooroomee.Test;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

// MaxNonoverlappingSegments
// https://app.codility.com/programmers/lessons/16-greedy_algorithms/max_nonoverlapping_segments/
public class Sol_Codility_P6 {

	public int solution(int[] A, int[] B) {
		int N = A.length;
		if (N <= 1) {
			return N;
		}

		int cnt = 1;
		int prev_end = B[0];

		int curr;
		for (curr = 1; curr < N; curr++) {
			if (A[curr] > prev_end) {
				cnt++;
				prev_end = B[curr];
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		Sol_Codility_P6 sol = new Sol_Codility_P6();
		System.out.println(sol.solution(new int[]{1, 3, 7, 9, 9}, new int[]{5, 6, 8, 9, 10}));
	}
}
