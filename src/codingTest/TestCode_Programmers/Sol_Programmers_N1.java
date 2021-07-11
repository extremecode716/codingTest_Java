package codingTest.TestCode_Programmers;
import java.util.*;
// 네w1
public class Sol_Programmers_N1 {

	public int solution(int[] prices, int[] discounts) {
		int answer = 0;
		// 제일 비싼 가격일 수 록 제일 높은 할인율을 적용하면 되는 문제
		// 정렬 내림차순
		Integer[] arr1 = Arrays.stream(prices).boxed().toArray(Integer[]::new);
		Integer[] arr2 = Arrays.stream(discounts).boxed().toArray(Integer[]::new);
		Arrays.sort(arr1, Collections.reverseOrder());
		Arrays.sort(arr2, Collections.reverseOrder());

		int arr2MaxLength = arr2.length;
		for (int i = 0; i < arr1.length; ++i) {
			if (i >= arr2MaxLength) {
				answer += arr1[i];
			} else {
				answer += arr1[i] - arr1[i] * (arr2[i] / 100.0f);
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		Sol_Programmers_N1 sol = new Sol_Programmers_N1();
		// 82000
		System.out.println(sol.solution(new int[]{32000, 300}, new int[]{100, 50}));
	}
}
