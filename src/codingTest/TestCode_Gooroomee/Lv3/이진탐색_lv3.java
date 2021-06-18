package codingTest.TestCode_Gooroomee.Lv3;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
//https://level.goorm.io/exam/43064/binary-search/quiz/1
public class 이진탐색_lv3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1 = br.readLine();
		String[] input2 = br.readLine().split(" ");
		String input3 = br.readLine();
		int searchNum = Integer.parseInt(input3);

		// List<Integer> list =
		// Arrays.asList(input2).stream().map(Integer::parseInt).collect(Collectors.toList());
		// int idx = Collections.binarySearch(list, searchNum); //
		// Arrays.binarySearch();

		int idx = Arrays.binarySearch(input2, input3);

		if (idx >= 0) {
			System.out.println(idx + 1);
		} else {
			System.out.println("X");
		}
		br.close();
	}

	public static int binarySearch1(final int[] array, final int searchValue) {
		int mid;
		int min = 0; // 맨 왼쪽 Index
		int max = array.length - 1; // 맨 오른쪽 Index
		while (min <= max) {
			mid = (min + max) / 2; // 중간 Index를 구하여 검색한다.
			if (array[mid] < searchValue) { // 1. 찾는값이 더 큰 경우 우측에서 찾는다.
				min = mid + 1;
			} else if (array[mid] > searchValue) { // 2. 찾는값이 더 작은 경우 좌측에서 찾는다.
				max = mid - 1;
			} else { // 3. 찾는값을 발견한 경우
				return mid;
			}
		}
		return -1; // 탐색 실패
	}

	static int binarySearch2(final int[] array, final int searchValue) {
		int mid;
		int min = 0; // 맨 왼쪽 Index
		int max = array.length - 1; // 맨 오른쪽 Index

		if (min <= max) {
			mid = (min + max) / 2;

			if (searchValue == array[mid]) { // 탐색 성공
				return mid;
			} else if (searchValue < array[mid]) {
				// 왼쪽 부분 탐색
				return binarySearch2_tmp(array, searchValue, min, mid - 1);
			} else {
				// 오른쪽 부분 탐색
				return binarySearch2_tmp(array, searchValue, mid + 1, max);
			}
		}

		return -1; // 탐색 실패
	}

	static int binarySearch2_tmp(final int[] array, final int searchValue, int low, int high) {
		int mid;
		int min = low; // 맨 왼쪽 Index
		int max = high; // 맨 오른쪽 Index

		if (min <= max) {
			mid = (min + max) / 2;

			if (searchValue == array[mid]) { // 탐색 성공
				return mid;
			} else if (searchValue < array[mid]) {
				return binarySearch2_tmp(array, searchValue, min, mid - 1); // 왼쪽 부분 탐색
			} else {
				return binarySearch2_tmp(array, searchValue, mid + 1, max); // 오른쪽 부분 탐색
			}
		}

		return -1; // 탐색 실패
	}

}
