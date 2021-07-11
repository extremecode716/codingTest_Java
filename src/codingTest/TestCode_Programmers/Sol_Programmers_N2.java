package codingTest.TestCode_Programmers;
import java.util.*;
// 네w2
public class Sol_Programmers_N2 {

	public String[] solution(String s) {
		List<String> listResult = new ArrayList<>();
		List<String> listLeft = new ArrayList<>();
		List<String> listRight = new ArrayList<>();
		boolean isEquals = false;
		String strMid = s;
		String strLeft = "";
		String strRight = "";
		while (true) {
			isEquals = false;
			for (int i = 1; i < (strMid.length() / 2 + 1); ++i) {
				strLeft = strMid.substring(0, i);
				strRight = strMid.substring(strMid.length() - i);
				if (strLeft.equals(strRight)) {
					isEquals = true;
					strMid = strMid.substring(i, strMid.length() - i);
					listLeft.add(strLeft);
					listRight.add(strRight); // reverse
					break;
				}
			}
			if (isEquals == false && strMid.length() > 0) {
				listResult.addAll(listLeft);
				listResult.add(strMid);
				Collections.reverse(listRight);
				listResult.addAll(listRight);
				break;
			} else if (isEquals == false) {
				listResult.addAll(listLeft);
				Collections.reverse(listRight);
				listResult.addAll(listRight);
				break;
			}
		}
		return listResult.stream().toArray(String[]::new);
	}
	
	// 다른 분의 풀이.
    public String[] solution2(String s) {
    	List<String> list = new ArrayList<String>();
    	
    	String temp1 = "";
    	String temp2 = "";
    	
    	int reverse = s.length() - 1;
    	
    	for (int i = 0; i < s.length(); i++) {
			
    		temp1 = temp1 + s.charAt(i);
    		temp2 = s.charAt(reverse) + temp2;
    		
    		if (temp1.equals(temp2)) {
    			list.add(temp1);
    			
    			temp1 = "";
    			temp2 = "";
    		}
    		
    		reverse--;
		}
    	
    	String[] answer = new String [list.size()];
    	for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
    	  
        return answer;
    }


	public static void main(String[] args) throws Exception {
		Sol_Programmers_N2 sol = new Sol_Programmers_N2();
		System.out.println(Arrays.toString(sol.solution("llttaattll")));
	}
}
