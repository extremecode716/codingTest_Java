package codingTest.TestCode_Gooroomee.Test;
import java.io.*;
public class 정사각형의개수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		long N = Long.parseLong(input);
		
		long result = 0;
		for(int i = 0; i < N; ++i) {
			result += (N - i) * (N - i);
		}
		System.out.println(result);
	}
}
