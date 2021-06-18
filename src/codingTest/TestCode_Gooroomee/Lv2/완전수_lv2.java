package codingTest.TestCode_Gooroomee.Lv2;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class 완전수_lv2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int num1 = Integer.parseInt(inputs[0]);
		int num2 = Integer.parseInt(inputs[1]);

		List<Integer> list = new ArrayList<>();
		for(int i = num1; i <= num2; ++i) {
			int result = 0;
			for(int j = 1; j < i; ++j) {
				if(i % j == 0) {
					result += j;
				}
			}
			if(result == i) {
				list.add(result);
			}
		}
		
		System.out.println(list.stream().map(s->s.toString()).collect(Collectors.joining(" ",""," ")));
		br.close();
	}
}
