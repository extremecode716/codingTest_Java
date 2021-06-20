package codingTest.TestCode_Gooroomee.Test;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Sol_Test {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1 = br.readLine();
		String[] input2 = br.readLine().split(" ");
		int N = Integer.parseInt(input1);
		int[] nums = Arrays.stream(input2).mapToInt(Integer::parseInt).toArray();

		
		br.close();
	}
}
