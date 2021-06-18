package codingTest.TestCode_Gooroomee.Lv1;
import java.io.*;
public class 홀짝판별_lv1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int num = Integer.parseInt(input);

		if (num % 2 == 0) {
			System.out.println("even");
		} else {
			System.out.println("odd");
		}
		br.close();
	}
}
