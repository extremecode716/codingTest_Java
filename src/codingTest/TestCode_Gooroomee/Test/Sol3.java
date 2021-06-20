package codingTest.TestCode_Gooroomee.Test;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
// 수정할 것
public class Sol3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input1 = br.readLine().split(" ");
		int[] nums = Arrays.stream(input1).mapToInt(Integer::parseInt).toArray();
		int N = nums[0]; // 수열의 길이
		int a = nums[1]; // a
		int b = nums[2]; // b

		long[] medians = new long[N];
		long[] autoNums = new long[N];
		List<Long> sortNums = new ArrayList<>();
		autoNums[0] = 1983;
		sortNums.add(autoNums[0]);
		medians[0] = autoNums[0];

		for (int i = 1; i < N; ++i) {
			autoNums[i] = autoNums[i - 1] * (a + b) % 20090711L;
			sortNums.add(autoNums[i]);
			Collections.sort(sortNums);
			if (sortNums.size() % 2 == 1) {
				medians[i] = sortNums.get(sortNums.size() / 2);
			} else {
				medians[i] = sortNums.get(sortNums.size() / 2 - 1);
			}
		}

		long result = 0;
		for (int i = 0; i < N; ++i) {
			result += medians[i];
			result %= 20090711L;
		}

		System.out.println(result);
		br.close();
	}
}
