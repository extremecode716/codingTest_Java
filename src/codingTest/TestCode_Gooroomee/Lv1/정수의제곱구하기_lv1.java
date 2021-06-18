package codingTest.TestCode_Gooroomee.Lv1;
import java.io.*;
public class 정수의제곱구하기_lv1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int num = Integer.parseInt(input);
		
		int result = (int)Math.pow(num, 2);
		
		System.out.println(result);
		br.close();
	}
}
