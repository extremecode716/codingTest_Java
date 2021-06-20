package codingTest.TestCode_Gooroomee.Test;
import java.io.*;
public class 두부자르기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		long N = Long.parseLong(input);
		
		long result = 1;
		for(int i = 0; i < N / 2; ++i) {
			result += 1;
		}
		System.out.println(result);
	}
}
