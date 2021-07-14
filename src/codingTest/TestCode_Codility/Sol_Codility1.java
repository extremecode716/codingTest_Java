package codingTest.TestCode_Codility;
import java.util.*;
//  요1
public class Sol_Codility1 {

	public String solution(String S, String C) {
		// 소문자로 변환
		String toLowerS = S.toLowerCase();
		String toLowerC = C.toLowerCase();

		// split : ;
		String[] arrSemi = toLowerS.split("; ");
		
		Map<String, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		StringBuilder tmpSb = new StringBuilder();
		for (int i = 0; i < arrSemi.length; ++i) {
			String[] arrName = arrSemi[i].split(" ");

			int len = arrName.length;
			// 이름
			if (len > 0) {
				sb.append(arrName[0]);
				tmpSb.append(arrName[0]);

				// 성(8자 이하, - 앞부분)
				if (len > 1) {
					sb.append(".");
					tmpSb.append(".");
					String strNoHipen = arrName[len - 1].replaceAll("-", "");
					int len1 = strNoHipen.length();
					if (len1 >= 8) {
						sb.append(strNoHipen.substring(0, 8)); // 8글자 자르기 해야함.
						tmpSb.append(strNoHipen.substring(0, 8)); 
					} else {
						sb.append(strNoHipen);
						tmpSb.append(strNoHipen);
					}
				}
				int cnt = map.getOrDefault(tmpSb.toString(), 0) + 1;
				map.put(tmpSb.toString(), cnt);
				if(cnt > 1) {
					sb.append(cnt);
				}
				tmpSb.setLength(0);
				sb.append("@");
				sb.append(toLowerC);
				sb.append(".com");
			}
			if (i != arrSemi.length - 1) {
				sb.append("; ");
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) throws Exception {
		Sol_Codility1 sol = new Sol_Codility1();
		System.out.println(sol.solution("John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker",
				"Example"));

	}
}
