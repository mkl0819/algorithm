package com.ssafy.mo;
/*
 * 보호 필름
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_mo_2112 {
	static int T, D, W, K, film[][];

	static StringTokenizer st;
	static int com[];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_mo_2112.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		T = 1;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			film = new int[D][W];

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			print();
			if (OK()) {
				System.out.println("#" + test_case + " 0");
				continue;
			}
			com = new int[D];
			permu(0);
		}

	}
	static int COUNT = 0;
	private static void permu(int cnt) {
		if (cnt == D) {
//			System.out.println(Arrays.toString(com));
			return;
		}
		for (int i = 0; i < 3; i++) {
			com[cnt] = i;
			if(i!=0)
				COUNT++;
			System.out.println(COUNT +" : "+Arrays.toString(com));
			change(cnt, i);
			permu(cnt + 1);
			if(i!=0)
				COUNT--;
		}
	}

	private static void change(int cnt, int i) {
		if(i==0) {
			return;
		}
		
	}

	private static boolean OK() {
		int pre, cur, cnt;
		boolean check;
		for (int j = 0; j < W; j++) {
			cnt = 0;
			pre = film[0][j];
			check = false;
			for (int i = 1; i < D; i++) {
				cur = film[i][j];
				if (pre == cur) {
					cnt++;
					if (cnt == K) {
						check = true;
						break;
					}
				} else {
					pre = cur;
					cnt = 0;
				}
			}
			if (!check) {
				System.out.println(j);
				return false;
			}
		}
		return true;
	}

	private static void print() {
		for (int i = 0; i < D; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(film[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
