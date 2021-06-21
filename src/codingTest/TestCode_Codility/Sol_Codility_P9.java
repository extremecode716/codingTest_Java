package codingTest.TestCode_Codility;
import java.util.*;

// Lesson 4. counting Elements
// MaxCounters
// https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
public class Sol_Codility_P9 {

	public int[] solution(int N, int[] A) {
		int len = A.length;
		int[] counters = new int[N];
		
		int maxCount = 0;
		int tmpMaxCount = 0;
		for(int i = 0; i < len; ++i) {
			if(A[i] == N + 1) {
				maxCount = tmpMaxCount;
				continue;
			}else if(A[i] <= N && A[i] >= 1) {
				if(counters[A[i] - 1] < maxCount) {
					counters[A[i] - 1] = maxCount;
				}
				
				++counters[A[i] - 1];
				
				if(counters[A[i] - 1] > tmpMaxCount) {
					tmpMaxCount = counters[A[i] - 1];
				}
			}
		}
		
		for(int i = 0; i < N; ++i) {
			if(counters[i] < maxCount) {
				counters[i] = maxCount;
			}
		}

		return counters;
	}

	public static void main(String[] args) throws Exception {
		Sol_Codility_P9 sol = new Sol_Codility_P9();
		System.out.println(Arrays.toString(sol.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4})));
	}
}
