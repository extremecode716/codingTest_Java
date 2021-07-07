package codingTest.TestCode_Codility;
import java.util.*;
// 네1
public class Sol_Codility_N2 {

	public int solution(int[] A, int X) {
		int N = A.length;
		if (N == 0) {
			return -1;
		}
		int l = 0;
		int r = N - 1;
		while (l < r) {
            int m = (l + r) / 2;
            if (A[m] > X) {
                r = m - 1;
            } else if(A[m] < X) {
            	l = m + 1;
            } else {
                l = m;
                break;
            }
        }
        if (A[l] == X) {
            return l;
        } 
		
		return -1;
	}

	public static void main(String[] args) throws Exception {
		Sol_Codility_N2 sol = new Sol_Codility_N2();
		System.out.println(sol.solution(new int[]{1, 2, 5, 9, 15}, 15));

	}
}
