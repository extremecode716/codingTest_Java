package codingTest.TestCode_Codility;
import java.util.*;
// 네3
public class Sol_Codility_N3 {

	public int solution(int inner, int outer, int[] points_x, int[] points_y) {
		// 점과 점 사이 거리를 구하고
		// 반지름과 비교해서 판별
		// 테두리 포함 x
		int N = points_x.length;
		double d;
		int xd, yd;
		int result = 0;
		for (int i = 0; i < N; ++i) {
			xd = points_x[i] * points_x[i];
			yd = points_y[i] * points_y[i];
			d = Math.sqrt(xd + yd);
			if (d > inner && d < outer) {
				++result;
			}
		}

		return result;
	}

	public static void main(String[] args) throws Exception {
		Sol_Codility_N3 sol = new Sol_Codility_N3();
		System.out.println(sol.solution(0, 4, new int[]{1}, new int[]{3}));

	}
}
