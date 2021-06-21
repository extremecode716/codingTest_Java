package codingTest.TestCode_Gooroomee.Test;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
//사2
public class Sol2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static List<Integer> resultlist = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		String input1 = br.readLine();
		int tn = Integer.parseInt(input1);

		for (int cn = 1; cn <= tn; ++cn) {
			testCase(cn);
		}

		for (int i = 0; i < resultlist.size(); ++i) {
			System.out.println(resultlist.get(i));
		}
		br.close();
	}

	public static void testCase(int cn) throws Exception {
		String input2 = br.readLine();
		int bn = Integer.parseInt(input2);

		int result = 0;
		List<ArrayList<Integer>> list2 = new ArrayList<>();

		for (int i = 0; i < 3; ++i) {
			String[] strBit = br.readLine().split("-");
			int[] iBit = Arrays.stream(strBit).mapToInt(Integer::parseInt).toArray();
			list2.add(new ArrayList<Integer>());
			for (int j = 0; j < iBit.length; ++j) {
				list2.get(i).add(iBit[j]);
			}
		}

		int maintainNum = 0;
		int tmpNum = 0;
		int tmpResult = 0;
		int cnt = 0;
		int len = list2.get(0).size();
		for (int i = 0; i < len; ++i) {
			tmpResult = 0;
			tmpNum = 0;
			maintainNum = list2.get(0).get(i);
			for (int j = 1; j < 3; ++j) {
				tmpNum |= maintainNum ^ list2.get(j).get(i);
				maintainNum &= list2.get(j).get(i);
			}
			tmpResult += cntBit(tmpNum);
			cnt += tmpResult;
		}

		resultlist.add(cnt);
	}

	public static int cntBit(int value) {
		int count = 0;
		while (value != 0) {

			count += (value & 1);

			value = value >>> 1;

		}
		return count;
	}

}
