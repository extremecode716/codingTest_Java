package codingTest.TestCode_Gooroomee.Lv2;
//https://level.goorm.io/exam/49090/%EC%83%88%EB%A1%9C%EC%9A%B4-%EC%95%94%ED%98%B8%ED%99%94/quiz/1

/*
XOR 연산은 동일한 숫자를 XOR하면 0이 나온다 -> A^A = 0
XOR 연산은 1부터 연속된 N까지 숫자를 모두 xor 연산하면 특정한 규칙을 가진다 ***/
import java.io.*;
import java.util.*;

public class 새로운암호화_lv2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		// xor은 둘이 같으면 0 다르면 1

		long start = Long.parseLong(input[0]);
		long end = Long.parseLong(input[1]);
		long role;

		// X^Y^X = Y

		long tmp = 0;
		role = start % 4;
		switch ((int) role) {
			case 0 : {
				tmp = start;
				break;
			}
			case 1 : {
				tmp = 1;
				break;
			}
			case 2 : {
				tmp = (start + 1);
				break;
			}
			case 3 : {
				tmp = 0;
				break;
			}
		}
		role = end % 4;

		switch ((int) role) {
			case 0 : {
				tmp ^= end;
				break;
			}
			case 1 : {
				tmp ^= 1;
				break;
			}
			case 2 : {
				tmp ^= (end + 1);
				break;
			}
			case 3 : {
				tmp ^= 0;
				break;
			}
		}
		System.out.println(tmp ^ start);
	}
}
