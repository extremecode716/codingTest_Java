package codingTest.TestCode_Gooroomee.Lv1;
import java.io.*;
public class 태민이의취미_lv1 {
	static int MOD = 1000000007;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		long num = Long.parseLong(input);
		
		long sum = num * (num + 1) / 2 % MOD;
		long result = sum * sum % MOD;
		
		System.out.println(result);
		br.close();
	}
}
