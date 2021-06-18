package codingTest.TestCode_Gooroomee.Lv2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
public class 계산기_lv2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int num1 = Integer.parseInt(inputs[0]);
		char ch = inputs[1].charAt(0);
		int num2 = Integer.parseInt(inputs[2]);
		
		DecimalFormat form = new DecimalFormat("#,##0.00");
		double result = 0;
		switch (ch) {
			case '+' :
				result = num1 + num2;
				System.out.println((int)result);
				break;
			case '-' :
				result = num1 - num2;
				System.out.println((int)result);
				break;
			case '*' :
				result = num1 * num2;
				System.out.println((int)result);
				break;
			case '/' :
				result = num1 / (double) num2;
				System.out.println(form.format(result));
				break;
			default :
				break;
		}
		br.close();
	}
}
