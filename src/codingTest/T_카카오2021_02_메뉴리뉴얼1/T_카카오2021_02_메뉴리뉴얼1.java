package codingTest.T_카카오2021_02_메뉴리뉴얼1;

import java.util.*;

class FoodCandi {
	private int index;
	private Map<String, Integer> map;
	private int MaxCnt;

	{
		index = 0;
		map = new HashMap<>();
		MaxCnt = 0;
	}

	public FoodCandi(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public Integer put(String str) {
		int cnt = (int) map.getOrDefault(str, 0) + 1;
		MaxCnt = Math.max(MaxCnt, cnt);
		return map.put(str, cnt);
	}

	public int getMaxCnt() {
		return MaxCnt;
	}
}

class Solution {
	List<FoodCandi> listFoods = new ArrayList<>();

	private void comb(char[] str, int pos, StringBuilder candi) {
		if (pos >= str.length) {
			int len = candi.length();
			if (len >= 2) {
				listFoods.get(len).put(candi.toString());	
			}
			return;
		}

		comb(str, pos + 1, candi.append(str[pos])); // 선택
		candi.setLength(candi.length() - 1);
		comb(str, pos + 1, candi); // 선택안함
	}

	public String[] solution(String[] orders, int[] course) {
		for (int i = 0; i < 11; ++i) {
			listFoods.add(new FoodCandi(i));
		}

		for (String str : orders) {
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			comb(arr, 0, new StringBuilder());
		}
		
		List<String> listAnswer = new ArrayList<>();
		for(int len : course) {
			for(Map.Entry<String, Integer> entry : listFoods.get(len).getMap().entrySet()) {
				if(entry.getValue() >= 2 && entry.getValue() == listFoods.get(len).getMaxCnt()) {
					listAnswer.add(entry.getKey());
				}
			}
		}
		
		Collections.sort(listAnswer);
		
		String[] answer = new String[listAnswer.size()];
		for(int i = 0; i < listAnswer.size(); ++i) {
			answer[i] = listAnswer.get(i);
		}

		return answer;
	}
}

public class T_카카오2021_02_메뉴리뉴얼1 {
	public static void main(String[] args) {
		Solution sol = new Solution();

		System.out.println(Arrays.toString(sol.solution(new String[]{"ACD", "CDE", "ACDE"}, new int[]{2, 3, 4})));

	}
}
