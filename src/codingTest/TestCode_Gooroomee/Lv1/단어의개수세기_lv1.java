package codingTest.TestCode_Gooroomee.Lv1;
import java.io.*;
public class 단어의개수세기_lv1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split("\\s+");
		
		int result = 0;
		for(String str : inputs) {
			if(str.length() > 0) {
				++result;
			}
		}
		System.out.println(result);
		br.close();
	}
}
