package codingTest.TestCode_Codility;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

// Lesson 4. counting Elements
// FrogRiverOne
// https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
public class Sol_Codility_P8 {

	public int solution(int X, int[] A) {
		int len = A.length;
		boolean[] bLeaps = new boolean[X];
		int cnt = 0;
		for (int i = 0; i < len; ++i) {
			if (A[i] - 1 < X) {
				if(!bLeaps[A[i] - 1]) {
					++cnt;
				}
				
				bLeaps[A[i] - 1] = true;
			}

			if (cnt == X) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) throws Exception {
		Sol_Codility_P8 sol = new Sol_Codility_P8();
		System.out.println(sol.solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}));
	}
}
