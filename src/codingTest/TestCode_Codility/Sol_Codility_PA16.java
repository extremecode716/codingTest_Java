package codingTest.TestCode_Codility;
import java.util.*;

//Lesson 5. Sorting
//Distinct
//https://app.codility.com/programmers/lessons/6-sorting/distinct/
public class Sol_Codility_PA16 {

	/*
	 * public int solution(int[] A) { Set<Integer> set = new HashSet<>();
	 * 
	 * for (int i = 0; i < A.length; ++i) { set.add(A[i]); } return set.size();
	 * }
	 */

	public int solution(int[] A) {
		int N = A.length;
		if (0 == N)
			return 0;

		//Arrays.sort(A);
		quickSort(A, 0, N - 1);
		int distinctNum = 1;
		for (int i = 1; i < N; i++) {
			if (0 != (A[i - 1] ^ A[i]))
				distinctNum++;
		}
		return distinctNum;
	}

	public static void main(String[] args) throws Exception {
		Sol_Codility_PA16 sol = new Sol_Codility_PA16();
		System.out.println(sol.solution(new int[]{2, 1, 1, 2, 3, 1}));
	}

	public static void quickSort(int[] arr, int begin, int end) {
		int middle = (begin + end) / 2;
		int pivot = arr[middle];
		int left = begin;
		int right = end;
		int temp;

		while (left < right) { // left와 right가 만나면 루프 종료
			while (arr[left] < pivot)
				left++; // left : pivot 값 보다 큰 값을 찾기 위해 이동
			while (arr[right] > pivot)
				right--; // right : pivot 값 보다 작은 값을 찾기 위해 이동

			if (left <= right) { // left가 right보다 같거나 작으면 서로 값 교환해줌
				temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		// 부분 분할 실행
		if (begin < right)
			quickSort(arr, begin, right);
		if (end > left)
			quickSort(arr, left, end);
	}
}
