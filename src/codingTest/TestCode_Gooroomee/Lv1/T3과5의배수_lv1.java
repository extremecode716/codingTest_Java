package codingTest.TestCode_Gooroomee.Lv1;
import java.io.*;
public class T3과5의배수_lv1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int num = Integer.parseInt(input);
		int result = 0;
		for (int i = 1; i <= num; ++i) {
			if (i % 3 == 0 || i % 5 == 0) {
				result += i;
			}
		}

		System.out.println(result);
		br.close();
	}
}
