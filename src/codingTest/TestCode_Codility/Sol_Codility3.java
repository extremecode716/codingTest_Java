package codingTest.TestCode_Codility;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
//요3
public class Sol_Codility3 {
	public int solution(int N) {
		N += 1;
		outer : do {
			String str = Integer.toString(N);
			char[] arrChar = str.toCharArray();
			int len = arrChar.length;
			if (len < 2) {
				return N;
			}
			char prevChar = arrChar[0];
			for (int i = 1; i < len; ++i) {
				char curChar = arrChar[i];

				if (curChar == prevChar) {
					int num = (len - i - 1) * 10;
					num = (num == 0) ? 1 : num;
					
					N = N - N % num;
					N += num;
					continue outer;
				}

				prevChar = curChar;
			}
			break;
		} while (true);

		return N;
	}
	public static void main(String[] args) throws Exception {
		Sol_Codility3 sol = new Sol_Codility3();
		System.out.println(sol.solution(101));

	}
}
