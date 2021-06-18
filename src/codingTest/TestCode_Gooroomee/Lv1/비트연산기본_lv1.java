package codingTest.TestCode_Gooroomee.Lv1;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class 비트연산기본_lv1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int num = Integer.parseInt(input);
		int result = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= num; ++i) {
			if (num % i == 0) {
				list.add(i);
			}
		}
		
		System.out.println(list.stream().map(s->s.toString()).collect(Collectors.joining(" ",""," ")));
		br.close();
	}
}
