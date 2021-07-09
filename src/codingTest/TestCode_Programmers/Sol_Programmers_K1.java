package codingTest.TestCode_Programmers;

import java.util.*;

// KaKao 2021 1. 숫자 문자열과 영단어
public class Sol_Programmers_K1 {

    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder tempSb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                tempSb.setLength(0);
                sb.append(s.charAt(i));
            } else {
                tempSb.append(s.charAt(i));
            }
            switch (tempSb.toString()) {
                case "zero":
                    sb.append(0);
                    tempSb.setLength(0);
                    break;
                case "one":
                    sb.append(1);
                    tempSb.setLength(0);
                    break;
                case "two":
                    sb.append(2);
                    tempSb.setLength(0);
                    break;
                case "three":
                    sb.append(3);
                    tempSb.setLength(0);
                    break;
                case "four":
                    sb.append(4);
                    tempSb.setLength(0);
                    break;
                case "five":
                    sb.append(5);
                    tempSb.setLength(0);
                    break;
                case "six":
                    sb.append(6);
                    tempSb.setLength(0);
                    break;
                case "seven":
                    sb.append(7);
                    tempSb.setLength(0);
                    break;
                case "eight":
                    sb.append(8);
                    tempSb.setLength(0);
                    break;
                case "nine":
                    sb.append(9);
                    tempSb.setLength(0);
                    break;
            }
        }
        answer = Integer.parseInt(sb.toString());
        return answer;
    }

    public static void main(String[] args) {
        Sol_Programmers_K1 sol = new Sol_Programmers_K1();
        // 82000
        System.out.println(sol.solution("one4seveneight"));
        System.out.println(sol.solution("23four5six7"));
        System.out.println(sol.solution("2three45sixseven"));
        System.out.println(sol.solution("123"));
    }
}
