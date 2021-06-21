package codingTest.TestCode_Codility;
import java.util.*;

// Lesson 4. counting Elements
// PermCheck
// https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/
public class Sol_Codility_PA11 {

	public int solution(int[] A) {
		int[] permutaitions = new int[A.length];

		for (int i = 0; i < permutaitions.length; ++i) {
			if (A[i] - 1 < permutaitions.length && A[i] - 1 > -1) {
				if (permutaitions[A[i] - 1] != 0) {
					return 0;
				} else {
					permutaitions[A[i] - 1] = A[i];
				}
			}
		}
		
		for (int i = 0; i < permutaitions.length; ++i) {
			if(permutaitions[i] == 0) {
				return 0;
			}
		}
		return 1;
	}

	public static void main(String[] args) throws Exception {
		Sol_Codility_PA11 sol = new Sol_Codility_PA11();
		System.out.println(sol.solution(new int[]{8, 1, 2}));
	}
}
