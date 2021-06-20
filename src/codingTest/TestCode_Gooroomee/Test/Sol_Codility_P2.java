package codingTest.TestCode_Gooroomee.Test;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
// cyclicRotation
// https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/start/
public class Sol_Codility_P2 {

	public int[] solution(int[] A, int K) {
		if (A.length == 0)
			return new int[0];
		int len = A.length;
		int[] result = new int[len];
		
		int rotationCnt = K % len;

		int nextIdx = 0;
		for (int i = 0; i < len; ++i) {
			nextIdx = (i + rotationCnt) % len;
			result[nextIdx] = A[i];
		}

		return result;
	}

	public static void main(String[] args) throws Exception {
		Sol_Codility_P2 sol = new Sol_Codility_P2();
		System.out.println(Arrays.toString(sol.solution(new int[]{3, 8, 9, 7, 6}, 3)));
	}
}
