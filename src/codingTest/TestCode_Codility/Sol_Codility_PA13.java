package codingTest.TestCode_Codility;
import java.util.*;

//Lesson 5. Prefix Sums
//GenomicRangeQuery
//https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
public class Sol_Codility_PA13 {
	
	public int[] solution(String S, int[] P, int[] Q) {
		final int len = P.length;
		int[] results = new int[len];

		char[] cValue = S.toCharArray();
		int[][] cumAns = new int[4][cValue.length + 1];

		for (int i = 0; i < cValue.length; ++i) {
			if (i > 0) {
				for (int j = 0; j < 4; ++j) {
					cumAns[j][i + 1] = cumAns[j][i];
				}
			}
			switch (cValue[i]) {
				case 'A' :
					++cumAns[0][i + 1];
					break;
				case 'C' :
					++cumAns[1][i + 1];
					break;
				case 'G' :
					++cumAns[2][i + 1];
					break;
				case 'T' :
					++cumAns[3][i + 1];
					break;
				default :
					break;
			}
		}

		for (int i = 0; i < len; ++i) {
			for (int j = 0; j < 4; ++j) {
				if ((cumAns[j][Q[i] + 1] - cumAns[j][P[i]]) > 0) {
					results[i] = j + 1;
					break;
				}
			}
		}
		return results;
	}

	public static void main(String[] args) throws Exception {
		Sol_Codility_PA13 sol = new Sol_Codility_PA13();
		System.out.println(Arrays.toString(sol.solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6})));
	}
}
