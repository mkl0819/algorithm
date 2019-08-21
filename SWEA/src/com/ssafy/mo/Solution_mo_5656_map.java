package com.ssafy.mo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 벽돌 깨기
 */
public class Solution_mo_5656_map {
	static int T, N, W, H;
	static int map[][];
	static int tmp[][];
	static int top[];
	static int block;
	static Queue<Integer> q;
	static int[] num ;
	static int[] priority;

	static int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_ts_5656.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		T = 1;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());

			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[H + 2][W + 2];
			top = new int[W + 1];

			Arrays.fill(top, H + 1);

			for (int i = 1; i <= H; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 1; j <= W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > 0) {
						top[j]--;
						block++;
					}
				}
			}
			print();
			System.out.println(Arrays.toString(top));
			System.out.println(block);

			q = new LinkedList<Integer>();
			bomb(3);
			bomb(3);

			print();

			drop();
			print();

			bomb(7);
			drop();
			print();

			System.out.println(Arrays.toString(top));
			System.out.println(block);
			num = new int[N];
			permu(0);
		}
	}


	private static void permu(int cnt) {
		if (cnt == N) {
			System.out.println(Arrays.toString(num));
			return;
		}
		for (int i = 1; i <= W; i++) {
			if(cnt ==0) {
				
			}
			if(top[i]==W) {
				continue;
			}
			num[cnt] = i;
			permu(cnt + 1);
			
		}
	}

	private static void drop() {
		int curtop, cur;
		for (int j = 1; j <= H; j++) {
			curtop = top[j];
			cur = H;
			for (int i = W; i > 0; i--) {
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

	private static void bomb(int w) {
		q.offer(top[w]);
		q.offer(w);

		int r, c, dis, dr, dc;

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
				block--;
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
