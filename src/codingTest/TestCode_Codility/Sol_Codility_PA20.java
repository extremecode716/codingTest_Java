package codingTest.TestCode_Codility;
import java.util.*;

//Lesson 5. Sorting
//Brackets
//https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/
public class Sol_Codility_PA20 {
	public int solution(String S) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < S.length(); ++i) {
			char c = S.charAt(i);

			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return 0;
				}
				char lastC = stack.pop();
				if (c == ')' && lastC != '(') {
					return 0;
				}
				if (c == '}' && lastC != '{') {
					return 0;
				}
				if (c == ']' && lastC != '[') {
					return 0;
				}
			}
		}

		if (!stack.isEmpty()) {
			return 0;
		}

		return 1;
	}

	public static void main(String[] args) throws Exception {
		Sol_Codility_PA20 sol = new Sol_Codility_PA20();
		System.out.println(sol.solution("{[()()]}"));
	}
}
