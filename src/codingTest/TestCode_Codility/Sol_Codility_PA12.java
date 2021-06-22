package codingTest.TestCode_Codility;
import java.util.*;

//Lesson 5. Prefix Sums
//CountDiv
//https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/
public class Sol_Codility_PA12 {

	public int solution(int A, int B, int K) {
		if (A % K == 0) {
			return B / K - A / K + 1;
		}
		return B / K - A / K;
	}

	public static void main(String[] args) throws Exception {
		Sol_Codility_PA12 sol = new Sol_Codility_PA12();
		System.out.println(sol.solution(6, 11, 2));
	}
}
