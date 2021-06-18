package codingTest.TestCode_Gooroomee.Lv3;
import java.io.*;
//https://level.goorm.io/exam/43218/%EC%8A%A4%ED%83%9D-stack/quiz/1
// 오류 있음. 찾아야됨.
public class 스택_lv3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1 = br.readLine();
		int N = Integer.parseInt(input1);

		String[] arr = new String[10];
		int curIdx = 0;
		for (int i = 0; i < N; ++i) {
			String inputB = br.readLine();

			boolean b = true;
			String inputData;
			switch (inputB) {
				case "0" : // push
					if (curIdx >= 10) {
						System.out.println("overflow");
					} else {
						inputData = br.readLine();
						arr[curIdx] = inputData;
						++curIdx;
					}
					break;
				case "1" : // pop
					if (curIdx <= 0) {
						System.out.println("underflow");
					} else {
						inputData = br.readLine();
						arr[curIdx] = null;
						--curIdx;
					}
					break;
				default :
					b = false;
					break;
			}
			if (!b) {
				break;
			}
		}

		for (String str : arr) {
			if (str == null)
				break;
			System.out.print(str + " ");
		}

		br.close();
	}
}
