package codingTest.TestCode_Gooroomee.Lv2;
import java.io.*;
public class 문자열뒤집기_lv2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		StringBuilder strb = new StringBuilder();
		for(int i = input.length() - 1; i >= 0; --i) {
			strb.append(input.charAt(i));
		}
		
		System.out.println(strb.toString());
		br.close();
	}
}
