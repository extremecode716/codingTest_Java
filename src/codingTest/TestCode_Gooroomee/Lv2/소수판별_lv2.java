package codingTest.TestCode_Gooroomee.Lv2;
import java.io.*;
public class 소수판별_lv2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int num = Integer.parseInt(input);

		boolean b = false;
		for(int i = 2; i < num; ++i) {
			if(num % i == 0) {
				b = true;
				break;
			}
		}
		
		if(b) {
			System.out.println("False");
		}else {
			System.out.println("True");
		}
		br.close();
	}
}
