package codingTest.TestCode_Gooroomee.Lv3;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
//https://level.goorm.io/exam/43250/%EB%B0%B0%EC%97%B4-%ED%95%A9%EC%B9%98%EA%B8%B0/quiz/1
public class 배열합치기_lv3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input1 = br.readLine().split(" ");
		String[] input2 = br.readLine().split(" ");
		String[] input3 = br.readLine().split(" ");

		List<String> list1 = new ArrayList<>(Arrays.asList(input2));
		List<String> list2 = new ArrayList<>(Arrays.asList(input3));

		List<String> mergedList = new ArrayList<>(list1);

		// 한쪽 중복제거
		//mergedList.removeAll(list2);
		// 합치기
		mergedList.addAll(list2);

		// 정렬
		List<Integer> mergedIntList = mergedList.stream().map(Integer::parseInt).collect(Collectors.toList());
		
		Collections.sort(mergedIntList);

		System.out.println(mergedIntList.stream().map(s -> s.toString()).collect(Collectors.joining(" ", "", " ")));
		br.close();
	}
}
