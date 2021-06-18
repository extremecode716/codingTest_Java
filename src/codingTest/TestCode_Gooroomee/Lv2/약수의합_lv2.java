package codingTest.TestCode_Gooroomee.Lv2;
import java.io.*;
public class 약수의합_lv2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int num = Integer.parseInt(input);

		int result = 0;
		for(int i = 1; i <= num; ++i) {
			if(num % i == 0) {
				result += i;
			}
		}
		
		System.out.println(result);
		br.close();
	}
}
