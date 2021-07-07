package codingTest.TestCode_Codility;
import java.util.*;

//Lesson 5. Sorting
//MaxProductOfThree
//https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/
public class Sol_Codility_PA17 {
	public int solution(int[] A) {
		Arrays.sort(A);

		int i = A.length - 1;
		int answer = A[i] * A[i - 1] * A[i - 2];

		if (A[0] <= 0 && A[1] <= 0 && A[i] >= 0) {
			int answer2 = A[0] * A[1] * A[i];

			if (answer2 > answer)
				answer = answer2;
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		Sol_Codility_PA17 sol = new Sol_Codility_PA17();
		System.out.println(sol.solution(new int[]{-3, 1, 2, -2, 5, 6}));
	}
}
