package com.ssafy.mo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/* 
 * 보물상자 비밀번호
 */
public class Solution_mo_5658_fin {
	static int T, N, K;
	static char num[][];
	static char[] tmp;
	static TreeSet<Integer> nums;

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_mo_5658.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			num = new char[N][N / 4];

			tmp = in.readLine().toCharArray();

			int start = 1;
			for (int i = 0; i < N; i++) {
				if (i % 4 == 0) {
					start--;
				}
				for (int j = 0, size = N / 4; j < size; j++) {
					num[i][j] = tmp[(start++) % N];
				}
			}
			nums = new TreeSet<>();
			for(int i=0; i<N; i++) {
				nums.add(getNum(num[i]));
			}
			System.out.println("#" + test_case + " " +nums.toArray()[nums.size()-K]);
		}
	}

	private static int getNum(char[] c) {
		int num = 0, key = 0;
		for (int i = c.length - 1, j = 0; i >= 0; i--, j++) {
			switch (Character.getType(c[i])) {
			case 9: // num
				key = c[i] - '0';
				break;
			case 1: // char
				key = c[i] - 'A' + 10;
				break;
			}
			num += Math.pow(16, j) * key;
		}
		return num;
	}

}
