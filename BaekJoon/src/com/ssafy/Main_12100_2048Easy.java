package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12100_2048Easy {
	static int N, map[][], dirSet[], copymap[][][], MAX;
	static int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine().trim());
		map = new int[N][N];
		MAX = -1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		copymap = new int[6][N][N];
		copy(0, map);

		dirSet = new int[6];
		combi(1, 0);

		System.out.println(MAX);

	}

	private static void copy(int layer, int[][] preMap) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copymap[layer][i][j] = preMap[i][j];
			}
		}
	}

	private static void combi(int count, int start) {
		boolean check;
		if (count == 6) {
			return;
		}
		for (int i = start; i < 5; i++) {
			dirSet[count] = i;
			if (count != 0) {
				init(count);
				copyAndMove(count - 1, count, dirSet[count]);
			}
			combi(count + 1, start);
		}
	}

	private static void init(int count) {
		for(int i=0; i<N; i++) {
			Arrays.fill(copymap[count][i], 0);
		}
	}

	private static boolean copyAndMove(int pre, int cur, int d) {
		boolean merge[], isChanged = false;

		switch (d) {
		case 0:
			for (int c = 0, r = 0, k = 0, key = 0; c < N; c++) {
				merge = new boolean[N];
				for (r = 0, k = 0; r < N; r++) {
					key = copymap[pre][r][c];
					if (key != 0) {
						if (k != 0 && !merge[k - 1] && key == copymap[cur][k - 1][c]) {
							merge[k - 1] = true;
							copymap[cur][k - 1][c] = key * 2;
							isChanged = true;
							MAX = Math.max(MAX, key * 2);
						} else {
							if (!isChanged && r != k) {
								isChanged = true;
							}
							copymap[cur][k++][c] = key;
							MAX = Math.max(MAX, key);
						}
					}
				}
			}
			break;
		case 2:
			for (int c = 0, r = 0, k = 0, key = 0; c < N; c++) {
				merge = new boolean[N];
				for (r = N - 1, k = N - 1; r >= 0; r--) {
					key = copymap[pre][r][c];
					if (key != 0) {
						if (k != N - 1 && !merge[k + 1] && key == copymap[cur][k + 1][c]) {
							merge[k + 1] = true;
							copymap[cur][k + 1][c] = key * 2;
							isChanged = true;
							MAX = Math.max(MAX, key * 2);
						} else {
							if (!isChanged && r != k) {
								isChanged = true;
							}
							copymap[cur][k--][c] = key;
							MAX = Math.max(MAX, key);
						}
					}
				}
			}
			break;
		case 1:
			for (int r = 0, c = 0, k = 0, key = 0; r < N; r++) {
				merge = new boolean[N];
				for (c = 0, k = 0; c < N; c++) {
					key = copymap[pre][r][c];
					if (key != 0) {
						if (k != 0 && !merge[k - 1] && key == copymap[cur][r][k - 1]) {
							merge[k - 1] = true;
							copymap[cur][r][k - 1] = key * 2;
							isChanged = true;
							MAX = Math.max(MAX, key * 2);
						} else {
							if (!isChanged && c != k) {
								isChanged = true;
							}
							copymap[cur][r][k++] = key;
							MAX = Math.max(MAX, key);
						}
					}
				}
			}
			break;
		case 3:
			for (int r = 0, c = 0, k = 0, key = 0; r < N; r++) {
				merge = new boolean[N];
				for (c = N - 1, k = N - 1; c >= 0; c--) {
					key = copymap[pre][r][c];
					if (key != 0) {
						if (k != N - 1 && !merge[k + 1] && key == copymap[cur][r][k + 1]) {
							merge[k + 1] = true;
							copymap[cur][r][k + 1] = key * 2;
							isChanged = true;
							MAX = Math.max(MAX, key * 2);
						} else {
							if (!isChanged && c != k) {
								isChanged = true;
							}
							copymap[cur][r][k--] = key;
							MAX = Math.max(MAX, key);
						}
					}
				}
			}
			break;
		}

		return isChanged;
	}
}
