package codingTest.TestCode_Codility;
import java.util.*;

//Lesson 5. Prefix Sums
//MinAvgTwoSlice
//https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/
public class Sol_Codility_PA14 {

	public int solution(int[] A) {
		float minAvg = (A[0] + A[1]) / 2.f;
		int minIndex = 0;
		for (int i = 1; i < A.length; ++i) {
			try {
				if (minAvg > (A[i - 1] + A[i]) / 2.f) {
					minAvg = (A[i - 1] + A[i]) / 2.f;
					minIndex = i - 1;
				}

				if (minAvg > (A[i - 1] + A[i] + A[i + 1]) / 3.f) {
					minAvg = (A[i - 1] + A[i] + A[i + 1]) / 3.f;
					minIndex = i - 1;
				}
			} catch (Exception e) {
				break;
			}
		}
		return minIndex;
	}

	public static void main(String[] args) throws Exception {
		Sol_Codility_PA14 sol = new Sol_Codility_PA14();
		System.out.println(sol.solution(new int[]{4, 2, 2, 5, 1, 5, 8}));
	}
}
