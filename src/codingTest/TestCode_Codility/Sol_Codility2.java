package codingTest.TestCode_Codility;
import java.util.*;
//요2
public class Sol_Codility2 {
	public String solution(String S) {
		int MAX_LEN = 256;
		int result = MAX_LEN;

		String[] arrSplit = S.split("[\\n]");

		for (int i = 0; i < arrSplit.length; ++i) {
			String[] arrSpace = arrSplit[i].trim().split(" ");
			int len = arrSpace.length;
			int correctCnt = 0;
			int maxCorrectCnt = 3;
			if (len >= 3) {
				// owner
				if (arrSpace[0].equals("root")) {
					++correctCnt;
				}
				// perm
				if (arrSpace[1].equals("r--") || arrSpace[1].equals("r-x")) {
					++correctCnt;
				}
				// name
				String[] arrName = arrSpace[2].split("\\.");
				if (arrName.length > 1) {
					String strExtension = arrName[arrName.length - 1];
					if (strExtension.equals("doc") || strExtension.equals("xls") || strExtension.equals("pdf")) {
						++correctCnt;
					}
				}

				if (correctCnt >= maxCorrectCnt) {
					if (result > arrSpace[2].length()) {
						result = arrSpace[2].length();
					}
				}
			}

		}

		if (result != MAX_LEN) {
			return Integer.toString(result);
		}

		return "NO FILES";
	}
	
	public static void main(String[] args) throws Exception {
		Sol_Codility2 sol = new Sol_Codility2();
		System.out.println(sol.solution("  root r-x delete-this.xls\n" + "  root r-- bug-report.pdf\n" + "  root r-- doc.xls\n" + "  root r-- podcast.flac\n"
				+ " alice r-- system.xls\n" + "  root --x invoices.pdf\n" + " admin rwx SETUP.PY"));
	}
}
