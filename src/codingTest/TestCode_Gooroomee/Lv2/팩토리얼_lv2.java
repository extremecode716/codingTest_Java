package codingTest.TestCode_Gooroomee.Lv2;
import java.io.*;
import java.math.BigInteger;
public class 팩토리얼_lv2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		BigInteger bigN = null;
		bigN = new BigInteger(input);
		BigInteger bigFactorialResult = BigInteger.ONE;
		for (BigInteger i = bigN; i.compareTo(BigInteger.ONE) > 0; i = i.subtract(BigInteger.ONE)) {
			bigFactorialResult = bigFactorialResult.multiply(i);
		}

		System.out.println(bigFactorialResult);
		br.close();
	}
}
