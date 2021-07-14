package codingTest.TestCode_Codility;
import java.util.*;
//  네1
public class Sol_Codility_N1 {

	public String solution(String T) {

		float fTemper = Float.parseFloat(T);

		String result = "";

		if (fTemper > 40.0f) {
			result = "hyperpyrexia";
		} else if (fTemper <= 40.0f && fTemper > 37.5f) {
			result = "fever";
		} else if (fTemper <= 37.5f && fTemper >= 35.0f) {
			result = "normal";
		} else if (fTemper < 35.0f) {
			result = "hypothermia";
		}

		return result;
	}

	public static void main(String[] args) throws Exception {
		Sol_Codility_N1 sol = new Sol_Codility_N1();
		System.out.println(sol.solution("35.0"));

	}
}
