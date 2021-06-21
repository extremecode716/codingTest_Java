package codingTest.TestCode_Codility;
import java.util.*;

// Lesson 1. iterations
// binary gap
// https://app.codility.com/programmers/lessons/1-iterations/binary_gap/start/
public class Sol_Codility_P1 {
	public int solution(int N) {
		int gap = 0;
		String binaryString = Integer.toBinaryString(N);
		char[] binarys = binaryString.toCharArray();
		List<Integer> positions = new ArrayList<>();
		for (int i = 0; i < binarys.length; ++i) {
			char binary = binarys[i];
			if (binary == '1') {
				positions.add(i);
			}
		}

		if (positions.size() > 1) {
			for (int i = 0; i < positions.size() - 1; ++i) {
				int tmpGap = positions.get(i + 1) - positions.get(i) - 1;
				if (gap < tmpGap) {
					gap = tmpGap;
				}
			}
		}
		return gap;
	}
	
	public static void main(String[] args) throws Exception {
		Sol_Codility_P1 sol = new Sol_Codility_P1();
		System.out.println(sol.solution(529));
		
	}
}
