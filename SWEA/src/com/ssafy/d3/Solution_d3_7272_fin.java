package com.ssafy.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 안경
 */
public class Solution_d3_7272_fin{
	static int T;
	static int A, B;

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d3_7272.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());

			A = getNum(st.nextToken().toCharArray());
			B = getNum(st.nextToken().toCharArray());
			
			System.out.println("#"+test_case+" "+ (A==B ? "SAME":"DIFF"));
		}
	}

	private static int getNum(char[] chars) {
		int result = 0;
		for (char c : chars) {
			switch (c) {
			case 'B':
				result = result * 10 + 3;
				break;
			case 'A':
			case 'D':
			case 'O':
			case 'P':
			case 'Q':
			case 'R':
				result = result * 10 + 2;
				break;
			default:
				result = result * 10 + 1;
				break;
			}
		}
		return result;
	}
}
