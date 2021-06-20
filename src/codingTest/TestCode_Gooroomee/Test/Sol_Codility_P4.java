package codingTest.TestCode_Gooroomee.Test;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

// PermMissingElem
// Sol_Codility_P4.java
public class Sol_Codility_P4 {

	public int solution(int[] A) {
		Arrays.sort(A);
		for(int i = 0; i < A.length; ++i) {
			if(A[i] != i + 1)
				return i + 1;
		}
		return A.length + 1;
	}

	public static void main(String[] args) throws Exception {
		Sol_Codility_P4 sol = new Sol_Codility_P4();
		System.out.println(sol.solution(new int[]{5}));
	}
}
