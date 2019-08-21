package com.ssafy.mo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_mo_5656_fin {
	static int T, N, W, H;
	static int map[][];
	static int firstmap[][];
	static int firsttop[];
	static int top[];
	static int block;
	static int result;
	static int MIN;
	static Queue<Integer> q;
	static int[] bombcase;

	static int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_ts_5656.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());

			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			firstmap = new int[H + 2][W + 2];
			map = new int[H + 2][W + 2];
			firsttop = new int[W + 1];
			top = new int[W + 1];
			block = 0;

			Arrays.fill(firsttop, H + 1);

			for (int i = 1; i <= H; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 1; j <= W; j++) {
					firstmap[i][j] = Integer.parseInt(st.nextToken());
					if (firstmap[i][j] > 0) {

						firsttop[j]--;
						block++;
					}
				}
			}
			q = new LinkedList<Integer>();
			MIN = Integer.MAX_VALUE;
			bombcase = new int[N];
			permu(0);
			if (MIN == Integer.MAX_VALUE)
				MIN = 0;
			System.out.println("#" + test_case + " " + MIN);
		}
	}

	static int c = 0;

	private static void permu(int cnt) {
		if (cnt == N) {
			copymap();
			copytop();
			result = block;
			for (int i = 0; i < N; i++) {
				if (bombcase[i] == H + 1) {
					return;
				}
				result -= bomb(bombcase[i]);
				drop();
			}
			MIN = Math.min(MIN, result);
			return;
		}
		for (int i = 1; i <= W; i++) {
			bombcase[cnt] = i;
			permu(cnt + 1);

		}
	}

	private static void copymap() {
		for (int i = 1; i <= W; i++) {
			top[i] = firsttop[i];
		}
	}

	private static void copytop() {
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= W; j++) {
				map[i][j] = firstmap[i][j];
			}
		}
	}

	private static void drop() {
		int cur;
		for (int j = 1; j <= W; j++) {
			cur = H;
			for (int i = H; i > 0; i--) {
				if (map[i][j] == 0) {
					continue;
				}
				if (cur == i) {
					cur--;
					continue;
				}

				map[cur--][j] = map[i][j];
				map[i][j] = 0;
			}
		}
	}

	private static int bomb(int w) {
		q.offer(top[w]);
		q.offer(w);

		int r, c, dis, dr, dc, deleted = 0;

		while (!q.isEmpty()) {
			for (int i = 0, size = q.size() / 2; i < size; i++) {
				r = q.poll();
				c = q.poll();

				if (map[r][c] == 0) {
					continue;
				}

				dis = map[r][c];
				map[r][c] = 0;
				top[c]++;
				deleted++;
				for (int d = 0; d < 4; d++) {
					dr = r;
					dc = c;
					for (int j = 1; j < dis; j++) {
						dr += dir[d][0];
						dc += dir[d][1];
						if (!check(dr, dc)) {
							break;
						}
						if (map[dr][dc] != 0) {
							q.offer(dr);
							q.offer(dc);
						}
					}
				}
			}
		}
		return deleted;
	}

	private static boolean check(int dr, int dc) {
		if (dr == 0 || dc == 0)
			return false;
		if (dr == H + 1 || dc == W + 1)
			return false;

		return true;
	}

	private static void print() {
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= W; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
