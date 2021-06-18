package codingTest.Array_IO;

import java.util.*;

// 배열
// 동일한 타입의 변수 모임
// 인덱스 (Index)
// 각각의 변수 위치를 가리키는 숫자
// 요소(Element)
// 각 위치의 변수 값

// 1차원 배열
// int[] score = new int[5];
// int[] score = {90, 70, 80, 60, 50};
// 2차원 배열
// int[][] board = new int[4][5]; // 4행(row),5열(col) // int일떄 다 0으로 초기화
// int[][] board = {{1,0},{2,2},{3,3},{4,4}};
public class 배열과입출력_십자가마킹 {
	// 2차원 배열 연습 : 십자가 출력
	static int Row, Col, Sr, Sc;
	static int[][] Board = new int[100][100];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Row = sc.nextInt();
		Col = sc.nextInt();
		for (int i = 0; i < Row; ++i) {
			for (int j = 0; j < Col; ++j) {
				Board[i][j] = sc.nextInt();
			}
		}

		Sr = sc.nextInt();
		Sc = sc.nextInt();
		cross();

		// 출력
		for (int i = 0; i < Row; ++i) {
			for (int j = 0; j < Col; ++j) {
				System.out.println(Board[i][j] + " ");
			}
			System.out.println();
		}
	}
	static void cross() {
		if (Board[Sr][Sc] != 0)
			return; // 비어 있지 않다면 바로 리턴
		Board[Sr][Sc] = 1; // 마킹

		// 위로 올라가면서 마킹
		for (int i = Sr - 1; i >= 0; --i) {
			if (Board[i][Sc] != 0)
				break;
			Board[i][Sc] = 1;
		}

		// 아래로 내려가면서 마킹
		for (int i = Sr + 1; i < Row; ++i) {
			if (Board[i][Sc] != 0)
				break;
			Board[i][Sc] = 1;
		}

		// 왼쪽으로 이동하면서 마킹
		for (int j = Sc - 1; j >= 0; --j) {
			if (Board[Sr][j] != 0)
				break;
			Board[Sr][j] = 1;
		}

		// 오른쪽으로 이동하면서 마킹
		for (int j = Sc + 1; j < Col; ++j) {
			if (Board[Sr][j] != 0)
				break;
			Board[Sr][j] = 1;
		}
	}
}
