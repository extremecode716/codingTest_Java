package codingTest.TestCode_Programmers;
import java.util.*;
// 네w3
public class Sol_Programmers_N3 {

	public int solution(String s, String t) {
		int result = 0;
		if(s.isEmpty() || t.isEmpty()) {
			return result;
		}
		
		int prevLength = s.length();
		int currLength = prevLength;
		while (s.contains(t)) {
			s = s.replace(t, "");
			currLength = s.length();
			result += (prevLength - currLength) / t.length();
			prevLength = currLength;
		}

		return result;
	}

	public static void main(String[] args) throws Exception {
		Sol_Programmers_N3 sol = new Sol_Programmers_N3();
		System.out.println(sol.solution("aaaaaaaaaa","aaaaaa"));
	}
}
