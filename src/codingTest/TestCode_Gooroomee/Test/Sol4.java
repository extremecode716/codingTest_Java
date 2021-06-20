package codingTest.TestCode_Gooroomee.Test;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Sol4 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1 = br.readLine();

		StringBuilder sb = new StringBuilder();

		// 순서보장
		Set<String> set = new LinkedHashSet<>();
		String[] splitStr = input1.split("[\\[\\]]");

		// 짝수가 제목
		for (int i = 0; i < splitStr.length; ++i) {
			if (i % 2 == 1) {
				String[] tmp = splitStr[i].split(",");
				for (int j = 0; j < tmp.length; ++j) {
					set.add(tmp[j].trim());
				}

			}
		}

		Map<String, Integer> map = new HashMap<>();
		Iterator<String> iter = set.iterator();
		int idx = 0;
		while (iter.hasNext()) {
			++idx;
			map.put(iter.next(), idx);
		}

		// 짝수가 제목
		List<Integer> sortList = new ArrayList<>();
		for (int i = 0; i < splitStr.length; ++i) {
			if (i % 2 == 1) {
				sb.append("[ ");
				String[] tmp = splitStr[i].split(",");
				for (int j = 0; j < tmp.length; ++j) {
					sortList.add(map.get(tmp[j].trim()));
				}
				Collections.sort(sortList);
				for(int a = 0; a < sortList.size(); ++a) {
					sb.append(sortList.get(a));
					if(a != sortList.size() - 1) {
						sb.append(", ");
					}
				}
				sortList.clear();
				sb.append(" ]");
			} else {
				sb.append(splitStr[i]);
			}
		}
		sb.append("\n");
		
		idx = 0;
		iter = set.iterator();
		while (iter.hasNext()) {
			++idx;
			sb.append("["+idx+"] " + iter.next() + "\n");
		}

		System.out.println(sb.toString());

		br.close();
	}
}
