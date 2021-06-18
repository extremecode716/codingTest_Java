package codingTest.TestCode_Gooroomee.Lv1;
import java.io.*;
public class 피라미드2_lv1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int num = Integer.parseInt(input);

		if (num <= 0 || 100 <= num) {
			System.out.println("?");
		} else {
			for (int i = 0; i < num; ++i) {
				// 공백_왼
				for (int j = 0; j < num - 1 - i; ++j) {
					System.out.print(" ");
				}
				// 별
				for (int j = 0; j < i * 2 + 1; ++j) {
					System.out.print("*");
				}
				// 공백_우
				for (int j = 0; j < num - 1 - i; ++j) {
					System.out.print(" ");
				}
				if (i != num - 1) {
					System.out.println();
				}
			}
		}
		br.close();
	}
}
