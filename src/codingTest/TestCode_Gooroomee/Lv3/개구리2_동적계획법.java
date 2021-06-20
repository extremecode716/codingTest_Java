package codingTest.TestCode_Gooroomee.Lv3;
import java.io.*;
import java.util.*;

public class 개구리2_동적계획법 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int N = Integer.parseInt(input);
		String[] inputs = br.readLine().split(" ");
		int[] nums = Arrays.stream(inputs).mapToInt(Integer::parseInt).toArray();

		int power_max = 0;
		int power_need = 0;
		int max = 0;
		for (int i = 0; i < N - 1; ++i) {
			power_need = nums[i + 1] - nums[i];
			max = Math.max(max, power_need);
		}

		power_max = max;
		for (int i = 0; i < N - 1; ++i) {
			power_need = nums[i + 1] - nums[i];
			if (power_max < power_need) {
				++max;
				++power_max;
				--i;
				continue;
			} else {
				--power_max;
			}
		}
		++max;
		System.out.println(max);
	}
}
