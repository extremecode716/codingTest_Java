package codingTest.TestCode_Codility;
import java.util.*;

//Lesson 5. Prefix Sums
//PassingCars
//https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/
public class Sol_Codility_PA15 {

	public int solution(int[] A) {
		int sum = 0;
		int countOne = 0;
		for (int i = 0; i < A.length; i++) {
			countOne += A[i];
		}
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				sum += countOne;
				if (1000000000 < sum) {
					return -1;
				}
			} else {
				countOne--;
			}
		}
		return sum;
	}

	public static void main(String[] args) throws Exception {
		Sol_Codility_PA15 sol = new Sol_Codility_PA15();
		System.out.println(sol.solution(new int[]{0, 1, 0, 1, 1}));
	}
}
