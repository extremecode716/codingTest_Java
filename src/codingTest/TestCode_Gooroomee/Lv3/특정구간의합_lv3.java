package codingTest.TestCode_Gooroomee.Lv3;
import java.io.*;
//https://level.goorm.io/exam/43263/%ED%8A%B9%EC%A0%95-%EA%B5%AC%EA%B0%84%EC%9D%98-%ED%95%A9/quiz/1
public class 특정구간의합_lv3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1 = br.readLine();
		String[] input2 = br.readLine().split(" ");
		String[] input3 = br.readLine().split(" ");
		
		int startIdx = Integer.parseInt(input3[0]);
		int endIdx = Integer.parseInt(input3[1]);
		
		int result = 0;
		for(int i=startIdx - 1; i < endIdx; ++i) {
			result += Integer.parseInt(input2[i]);
		}
		
		System.out.println(result);
		
		br.close();
	}
}
