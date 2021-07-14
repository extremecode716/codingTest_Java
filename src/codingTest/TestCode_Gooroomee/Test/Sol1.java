package codingTest.TestCode_Gooroomee.Test;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
//  사1
public class Sol1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1 = br.readLine();
		long N = Long.parseLong(input1);
		boolean b = false;
		
		long result = N;
		long nextResult = 0;
		long tmp = 0;
		for(long i = 0L; i < N; ++i) {
			if(result == 1) {
				b = true;
				break;
			}
			while(true) {
				// 밑에서 부터 자르면서
				if(result == 0) {
					result = nextResult;
					nextResult = 0;
					break;
				}
				tmp = result % 10;
				nextResult += tmp * tmp;
				result /= 10;
			}
		}
		
		if(b) {
			System.out.println(N + " is Happy Number.");
		}else {
			System.out.println(N + " is Unhappy Number.");
		}

		br.close();
	}
}
