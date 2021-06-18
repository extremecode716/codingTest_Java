package codingTest.T_카카오2021_03_순위검색;
// HashMap, Bit를 이용한 부분집합, 이진탐색(Binary Search)
import java.util.*;

class Solution {
	Map<String, Integer> wordMap = new HashMap<>();
	List<List<Integer>> scoreList = new ArrayList<>();

	public int[] solution(String[] info, String[] query) {
		wordMap.put("-", 0);
		wordMap.put("cpp", 1);
		wordMap.put("java", 2);
		wordMap.put("python", 3);
		wordMap.put("backend", 1);
		wordMap.put("frontend", 2);
		wordMap.put("junior", 1);
		wordMap.put("senior", 2);
		wordMap.put("chicken", 1);
		wordMap.put("pizza", 2);

		for (int i = 0; i < 4 * 3 * 3 * 3; ++i) {
			scoreList.add(new ArrayList<>());
		}

		for (String str : info) {
			String[] word = str.split(" ");
			int[] arr = {wordMap.get(word[0]) * 3 * 3 * 3, wordMap.get(word[1]) * 3 * 3, wordMap.get(word[2]) * 3, wordMap.get(word[3])};
			int score = Integer.parseInt(word[4]);

			for (int i = 0; i < (1 << 4); ++i) {
				int idx = 0;
				for (int j = 0; j < 4; ++j) {
					if ((i & (1 << j)) != 0) {
						idx += arr[j];
					}
				}
				scoreList.get(idx).add(score);
			}
		}
		for (int i = 0; i < 4 * 3 * 3 * 3; ++i) {
			Collections.sort(scoreList.get(i));
		}

		int[] answer = new int[query.length];

		for (int i = 0; i < query.length; ++i) {
			String[] word = query[i].split(" ");
			int idx = wordMap.get(word[0]) * 3 * 3 * 3 + wordMap.get(word[2]) * 3 * 3 + wordMap.get(word[4]) * 3 + wordMap.get(word[6]);
			int score = Integer.parseInt(word[7]);
			// binarySearch는 중복일때 작은 인덱스를 찾지 않을 수 있음.
			// 값이 없다면 인덱스 값이 하나 뺸 음수값이 됨.
			int ret = Collections.binarySearch(scoreList.get(idx), score);
			if (ret < 0) {
				ret = -(ret + 1);
			} else {
				// 중복일때 인덱스 줄이기
				for (int j = ret - 1; j >= 0; --j) {
					if (scoreList.get(idx).get(j) == score) {
						ret = j;
					} else {
						break;
					}
				}
			}
			answer[i] = scoreList.get(idx).size() - ret;
		}

		return answer;
	}
}

public class T_카카오2021_03_순위검색 {

	public static void main(String[] args) {
		Solution sol = new Solution();

		System.out.println(Arrays.toString(sol.solution(
				new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150",
						"cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
				new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200",
						"cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100",
						"- and - and - and - 150"})));

	}

}
