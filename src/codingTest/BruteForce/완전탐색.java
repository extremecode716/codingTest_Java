package codingTest.BruteForce;
// 완전 탐색
// Exhaustive search, Brute force
// 상대적으로 구현이 간단하고, 해가 존재한다면 항상 찾게 된다.
// 경우의 수에 따라 실행 시간이 비례하기 때문에 입력 값의 범위가 작은 경우에 유용하다.

public class 완전탐색 {

	// 순차 탐색 (Sequential search)
	// : for
	// 정렬이 되어있으면 이진탐색을 할 것.
	static int sequentialSearch(int[] arr, int n, int x) {
		for (int i = 0; i < n; ++i) {
			if (arr[i] == x) {
				return i;
			}
		}

		return -1;
	}

	// 경우의 수
	// 1. 순열(Permutation) : 선택 순서가 결과에 영향을 미치는 경우
	// 예제: {1, 2, 3, 4} 숫자가 주어진 경우
	// * 만들 수 있는 가장 큰 두 자리 수를 구하라.

	// 2. 조합(Combination) : 선택 순서가 결과에 영향을 주지 않는 경우
	// 예제: {1, 2, 3, 4} 숫자가 주어진 경우
	// * 두 수를 더했을 때 가장 큰 합을 구하라.

	// 1. 순열
	// * 만들 수 있는 가장 큰 두 자리 수를 구하라.
	static class Permutation {
		static int N = 4;
		static int[] Nums = {1, 2, 3, 4};

		// 선택된 숫자의 개수, 사용된 숫자(비트), 중간 계산 결과
		static int solve(int cnt, int used, int val) {
			if (cnt == 2)
				return val;

			int ret = 0;
			for (int i = 0; i < N; ++i) {
				if ((used & 1 << i) != 0) // 사용한 숫자 검사
					continue;
				ret = Math.max(ret, solve(cnt + 1, used | 1 << i, val * 10 + Nums[i]));
			}
			return ret;
		}

		static void main() {
			System.out.println(solve(0, 0, 0));
		}
	}

	// 2. 조합
	// * 두 수를 더했을 때 가장 큰 합을 구하라.
	static class Combination {
		static int N = 4;
		static int[] Nums = {1, 2, 3, 4};

		//              현재 위치,  선택된 개수, 중간 계산 결과   
		static int solve(int pos, int cnt, int val) {
			if (cnt == 2)
				return val;
			if (pos == N)
				return -1;

			int ret = 0;
			ret = Math.max(ret, solve(pos + 1, cnt + 1, val + Nums[pos]));
			ret = Math.max(ret, solve(pos + 1, cnt, val));

			return ret;
		}

		static void main() {
			System.out.println(solve(0, 0, 0));
		}
	}

}
