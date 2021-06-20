package codingTest.TestCode_Gooroomee.Test;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

// odd_occurrences_in_array
// https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/start/
public class Sol_Codility_P5 {

	public int solution(int X, int Y, int D) {
		/*
		int result = 0;
		int sum = X;
		while(sum < Y) {
			sum += D;
			++result;
		}
		*/
		
		int val = Y - X;
		int solve = val/D;
		
		return val%D == 0 ? solve : solve + 1;
	}

	public static void main(String[] args) throws Exception {
		Sol_Codility_P5 sol = new Sol_Codility_P5();
		System.out.println(sol.solution(10, 85, 2));
	}
}
