package codingTest.T_카카오2021_02_메뉴리뉴얼;
// HashMap, 완전 탐색(Exhaustive Search, Brute Force), 조합
import java.util.*;

class Solution {
	List<Map<String, Integer>> FoodMaps = new ArrayList<>();
	int[] MaxCnt = new int[11];

	void comb(char[] str, int pos, StringBuilder candi) {
		if (pos >= str.length) {
			int len = candi.length();
			if (len >= 2) {
				int cnt = FoodMaps.get(len).getOrDefault(candi.toString(), 0) + 1;
				FoodMaps.get(len).put(candi.toString(), cnt);
				MaxCnt[len] = Math.max(MaxCnt[len], cnt);
			}
			return;
		}

		comb(str, pos + 1, candi.append(str[pos])); // 선택
		candi.setLength(candi.length() - 1);
		comb(str, pos + 1, candi); // 선택 안함
	}

	public String[] solution(String[] orders, int[] course) {
		for (int i = 0; i < 11; ++i) {
			FoodMaps.add(new HashMap<String, Integer>());
		}

		for (String str : orders) {
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			comb(arr, 0, new StringBuilder());
		}

		List<String> list = new ArrayList<>();
		for (int len : course) {
			for (Map.Entry<String, Integer> entry : FoodMaps.get(len).entrySet()) {
				if (entry.getValue() >= 2 && entry.getValue() == MaxCnt[len]) {
					list.add(entry.getKey());
				}
			}
		}
		Collections.sort(list);

		String[] answer = new String[list.size()];
		for (int i = 0; i < list.size(); ++i) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}

public class T_카카오2021_02_메뉴리뉴얼 {
	public static void main(String[] args) {
		Solution sol = new Solution();

		System.out.println(Arrays.toString(sol.solution(new String[]{"ACD", "CDE", "ACDE"}, new int[]{2, 3, 4})));

	}

}
