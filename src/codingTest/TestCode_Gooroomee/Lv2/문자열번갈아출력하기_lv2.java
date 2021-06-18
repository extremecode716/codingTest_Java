package codingTest.TestCode_Gooroomee.Lv2;
import java.io.*;
// https://level.goorm.io/exam/43110/%EB%AC%B8%EC%9E%90%EC%97%B4-%EB%B2%88%EA%B0%88%EC%95%84-%EC%B6%9C%EB%A0%A5%ED%95%98%EA%B8%B0/quiz/1
public class 문자열번갈아출력하기_lv2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		StringBuilder strb = new StringBuilder();
		int maxCnt = input.length();
		int cnt = 1;
		int tmp = maxCnt - 1;
		
		int idx = 0;
		strb.append(input.charAt(idx));
		while(cnt < maxCnt) {
			if(cnt % 2 == 1) {
				idx += tmp;
				strb.append(input.charAt(idx));
			}else {
				idx -= tmp;
				strb.append(input.charAt(idx));
			}
	
			--tmp;
			++cnt;
		}
		
		System.out.println(strb.toString());
		br.close();
	}
}
