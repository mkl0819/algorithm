package com.ssafy.mo;
/* 
 * 홈 방범 서비스
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import com.ssafy.library.printMing;

public class Solution_mo_2117_홈방범서비스 {
	static int T, N, M, K, map[][], homecnt, cost[], MAX;
	static int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static Queue<Integer> q;
	static boolean visited[][];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_mo_2117.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		cost_init();

		T = Integer.parseInt(in.readLine().trim());
//		T = 1;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			homecnt = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					switch (map[i][j] = Integer.parseInt(st.nextToken())) {
					case 1:
						homecnt++;
						break;
					}
				}
			}

			for (int i = 0, maxCost = homecnt * M; i < 41; i++) {
				if (maxCost <= cost[i]) {
					K = i - 1;
					break;
				}
			}

			MAX = -1;
			run();
			System.out.println("#" + test_case + " " + MAX);
		}
	}

	private static void run() {
//		move(0, 0, c, 1);
		while (MAX == -1) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					MAX = Math.max(MAX, getCnt(i, j));
				}
			}
			K--;
		}
	}

//	private static void move(int r, int c, int cnt, int d) {
//		int dr1, dc1, dr2, dc2;
//		for (int i = 1; i < K; i++) {
////			dr1 = (r+i);
////			dc1 = (c+i);
//			dr1 = (r + i) + dir[d][0];
//			dc1 = (c + i) + dir[d][1];
//			printMing.print(dr1, dc1);
//			dr1 = (r - i) + dir[d][0];
//			dc1 = (c - i) + dir[d][1];
//			printMing.print(dr1, dc1);
//		}
//	}

	private static int getCnt(int r, int c) {
		visited = new boolean[N][N];
		visited[r][c] = true;
		q = new LinkedList<Integer>();
		q.offer(r);
		q.offer(c);
		int dr, dc, cnt = map[r][c];
		

		for (int k = 1; k < K; k++) {
			for (int i = 0, size = q.size() / 2; i < size; i++) {
				r = q.poll();
				c = q.poll();
				for (int d = 0; d < 4; d++) {
					dr = r + dir[d][0];
					dc = c + dir[d][1];
					if (check(dr, dc) && !visited[dr][dc]) {
						cnt += map[dr][dc];
						visited[dr][dc] = true;
						q.offer(dr);
						q.offer(dc);
					}
				}
			}
		}
//		printMing.print(visited);
//		System.out.println(cnt + " 채 / " + (cnt * M) + "원");
		return cost[K] <= cnt * M ? cnt : -1;
	}

	private static boolean check(int r, int c) {
		if (r == -1 || c == -1 || r == N || c == N)
			return false;
		else
			return true;
	}

	private static void cost_init() {
		cost = new int[41];
		cost[1] = 1;
		for (int i = 1; i < 40; i++) {
			cost[i + 1] = cost[i] + (4 * i);
		}
	}
}
