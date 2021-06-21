package codingTest.TestCode_Codility;
import java.util.*;

// Lesson 4. counting Elements
// MissingInteger
// https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
public class Sol_Codility_PA10 {

	public int solution(int[] A) {
		boolean[] bMissing = new boolean[A.length];

		for (int i = 0; i < bMissing.length; ++i) {
			if (A[i] - 1 > -1 && bMissing.length > A[i] - 1) {
				bMissing[A[i] - 1] = true;
			}
		}

		for (int i = 0; i < bMissing.length; ++i) {
			if (!bMissing[i]) {
				return i + 1;
			}
		}

		return bMissing.length + 1;
	}

	public static void main(String[] args) throws Exception {
		Sol_Codility_PA10 sol = new Sol_Codility_PA10();
		System.out.println(sol.solution(new int[]{23, 105}));
	}
}
