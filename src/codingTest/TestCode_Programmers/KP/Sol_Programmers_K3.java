package codingTest.TestCode_Programmers.KP;

import java.util.regex.*;

// KP3
public class Sol_Programmers_K3 {

    public int solution(String line1, String line2) {
        String joinLine = line2;
        String[] arrLine2 = line2.split("");
        int count = 0;
        StringBuilder sb = new StringBuilder();
        int curLength = joinLine.length();
        int prevLength = curLength;

        while (joinLine.length() <= line1.length()) {
            prevLength = curLength;
            Pattern pattern = Pattern.compile(joinLine);
            Matcher matcher = pattern.matcher(line1);

            int i = 0;
            while (matcher.find(i)) {
                ++count;
                i = matcher.start() + 1;
            }

            sb.append(".");
            joinLine = String.join(sb.toString(), arrLine2);
            curLength = joinLine.length();
            if(prevLength == curLength){
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Sol_Programmers_K3 sol = new Sol_Programmers_K3();
        System.out.println(sol.solution("abbbcbbb", "bbb"));
        System.out.println(sol.solution("abcabcabc", "abc"));
        System.out.println(sol.solution("abacaba", "acb"));
        System.out.println(sol.solution("abacaba", "a"));
    }
}
