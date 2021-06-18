package codingTest.TestCode_Gooroomee.Lv1;
import java.io.*;

public class 약수구하기_lv1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1 = br.readLine();
		char input2 = br.readLine().charAt(0);
		System.out.println(cntChar(input1,input2));
		br.close();
	}
	
	public static int cntChar(String str, char ch) {
		int cnt = 0;
		
		for(int i = 0; i < str.length(); ++i) {
			if(str.charAt(i) == ch) {
				++cnt; 
			}
		}
		return cnt;
	}
}
