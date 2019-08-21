package com.ssafy;
/*
 * 무선 충전
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_모의_무선충전_이민경 {
	static int T, M, BC, BCS[], A[], B[], map[][][], ANS, ar, ac, br, bc, alist[], blist[];
	static Queue<Integer> BCQ;
	static int dir[][] = { { 0, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_mo_5644.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine());
//		T = 1;
		for (int test_case = 1; test_case <= T; test_case++) {
			// time and BC input
			st = new StringTokenizer(in.readLine());
			M = Integer.parseInt(st.nextToken());
			BC = Integer.parseInt(st.nextToken());

			// map init
			map = new int[BC][11][11];
//			print();
			// A, B init and input
			A = new int[M + 1];
			B = new int[M + 1];
			st = new StringTokenizer(in.readLine());
			for (int i = 1; i <= M; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine());
			for (int i = 1; i <= M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}

			// BC input
			BCQ = new LinkedList<Integer>();
			BCS = new int[BC];
			for (int i = 0; i < BC; i++) {
				st = new StringTokenizer(in.readLine());
				set(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
//			print();

			// ANS init and getANS
			ANS = 0;
			ar = ac = 1;
			br = bc = 10;
			alist = new int[BC];
			blist = new int[BC];
			for (int i = 0; i <= M; i++) {
				ANS += move(i);
			}
			System.out.println("#" + test_case + " " + ANS);
		}
	}

	private static int move(int time) {
		int max = 0, sum = 0;
		int acnt = 0, bcnt = 0;
		ar += dir[A[time]][0];
		ac += dir[A[time]][1];
		br += dir[B[time]][0];
		bc += dir[B[time]][1];

		Arrays.fill(alist, 0);
		Arrays.fill(blist, 0);

		for (int k = 0, check = 0; k < BC; k++) {
			if (map[k][ar][ac] > 0) {
				alist[acnt++] = k;
				check++;
			}
			if (map[k][br][bc] > 0) {
				blist[bcnt++] = k;
				check++;
			}
		}

//		System.out.println();

		if (acnt + bcnt == 0) {
			return 0;
		}

		if (bcnt == 0) {
			for (int i = 0; i < acnt; i++) {
				max = Math.max(max, BCS[alist[i]]);
			}
		} else if (acnt == 0) {
			for (int i = 0; i < bcnt; i++) {
				max = Math.max(max, BCS[blist[i]]);
			}
		} else {
			for (int i = 0; i < acnt; i++) {
				for (int j = 0; j < bcnt; j++) {
					if (alist[i] == blist[j]) {
//						System.out.println("겹침");
//						System.out.println("a : " + acnt + " -> " + Arrays.toString(alist));
//						System.out.println("b : " + bcnt + " -> " + Arrays.toString(blist));
						sum = BCS[alist[i]];
//						System.out.println(sum);
					} else {
						sum = BCS[alist[i]] + BCS[blist[j]];
					}
//					System.out.println(sum);
					max = Math.max(max, sum);
				}
			}

		}
//		System.out.println("==> " + max);
		return max;
	}

	private static void print() {
		for (int k = 0; k < BC; k++) {
			for (int i = 1; i < 11; i++) {
				for (int j = 1; j < 11; j++) {
					System.out.printf("%4d ", map[k][i][j]);
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void set(int index, int r, int c, int dis, int capacity) {
//		System.out.println(r + ", " + c + ", " + dis + ", " + capacity);
		BCS[index] = capacity;
		BCQ.offer(r);
		BCQ.offer(c);
		int cr, cc, dr, dc;
		while (dis-- >= 0) {
//			System.out.println(BCQ);
			for (int i = 0, size = BCQ.size() / 2; i < size; i++) {
				cr = BCQ.poll();
				cc = BCQ.poll();
				map[index][cr][cc] = capacity;
				for (int d = 1; d < 5; d++) {
					dr = cr + dir[d][0];
					dc = cc + dir[d][1];
					if (!check(dr, dc)) {
						continue;
					}
					BCQ.offer(dr);
					BCQ.offer(dc);
				}
			}
		}
		BCQ.clear();
//		System.out.println();
	}

	private static boolean check(int r, int c) {
		if (r == 0 || c == 0)
			return false;
		if (r == 11 || c == 11)
			return false;
		return true;
	}
}
