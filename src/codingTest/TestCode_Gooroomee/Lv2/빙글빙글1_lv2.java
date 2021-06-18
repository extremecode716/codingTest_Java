package codingTest.TestCode_Gooroomee.Lv2;
import java.io.*;

public class 빙글빙글1_lv2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		int[][] arr = new int[input][input];
		int start = 0;
		int end = input;
		
		while (!(start > input)) {

			for (int i = start; i < end; i++) {
				arr[start][i] = 1; // 오른쪽으로 이동
				arr[i][end - 1] = 1; // 아래쪽으로 이동
				arr[end - 1][i] = 1; // 왼쪽으로 이동
				arr[i][start] = 1; // 위쪽으로 이동
			}

			if (start + 1 < input) {
				arr[start + 1][start] = 0;
			}
			if (start + 2 < input) {
				arr[start + 2][start + 1] = 1;
			}
			start += 2;
			end -= 2;
		}
		for (int[] a : arr) {
			for (int val : a) {
				if (val == 1) {
					System.out.print("# ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println("");
		}
	}
}
