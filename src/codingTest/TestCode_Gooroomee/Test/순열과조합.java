package codingTest.TestCode_Gooroomee.Test;

import java.io.*;
import java.util.*;
public class 순열과조합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int r = sc.nextInt();

		int arr[] = new int[n];
		for (int i = 1; i <= n; i++)
			arr[i - 1] = i;

		LinkedList<Integer> list = new LinkedList<>();

		// 순열
		// 4C3 (3! : 6가지)

		int check[] = new int[n];
		System.out.println("****순  열****");
		permutation(list, check, n, r);
		list.clear();

		// 중복순열
		System.out.println("****중복순열****");
		rePermutation(list, n, r);
		list.clear();

		// 조합
		System.out.println("****조  합****");
		combination(list, n, r, 0);
		list.clear();

		// 중복조합
		System.out.println("****중복조합****");
		reCombination(list, n, r, 0);

	}

	// 중복조합
	private static void reCombination(LinkedList<Integer> list, int n, int r, int index) {
		if (r == 0) {
			for (int i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		if (index == n)
			return;

		list.add(index);
		reCombination(list, n, r - 1, index);
		list.removeLast();
		reCombination(list, n, r, index + 1);
	}

	// 조합
	private static void combination(LinkedList<Integer> list, int n, int r, int index) {
		if (r == 0) {// r이 0이면 다 뽑았다는 뜻
			for (int i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		if (index == n)
			return; // 다 탐색했으면 종료..

		list.add(index);
		combination(list, n, r - 1, index + 1);// 뽑았으니 ,r-1
		list.removeLast();
		combination(list, n, r, index + 1);// 안뽑았으니, r
	}

	// 중복순열
	private static void rePermutation(LinkedList<Integer> list, int n, int r) {
		if (list.size() == r) {
			for (int i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < n; i++) {
			list.add(i);
			rePermutation(list, n, r);
			list.removeLast();// 해당 넘버를 다시 제거 (즉,뽑지 않고 다음 번호 뽑기위함)

		}

	}

	// 순열
	private static void permutation(LinkedList<Integer> list, int[] check, int n, int r) {
		if (list.size() == r) {
			for (int i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < n; i++) {// **중복 순열과 다른 점
			if (check[i] == 0) {// 자기자신을 못뽑게 해야지 중복이 안됨(이미 뽑은 것은 뽑지 않도록 체크)
				check[i] = 1;// 자기자신을 못뽑게 해야지 중복이 안됨
				list.add(i);
				permutation(list, check, n, r);
				list.removeLast();// 해당 넘버를 다시 제거 (즉,뽑지 않고 다음 번호 뽑기위함)
				check[i] = 0;
			}
		}

	}

}
