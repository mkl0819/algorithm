package com.ssafy.mo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_mo_5656_donghyun {
	static int Testcase, N, H, W, Answer;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static LinkedList<Integer> Q = new LinkedList<>();
	static int[][] map = new int[15][12];
	static int[][][] temp = new int[4][15][12];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		Testcase = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= Testcase; t++) {
			Answer = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			DropBrick(0);
			if (Answer == Integer.MAX_VALUE) {
				Answer = 0;
			}
			sb.append('#').append(t).append(' ').append(Answer).append('\n');
		}
		System.out.println(sb);
	}

	private static void DropBrick(int cnt) {
		if (cnt == N) {
			int calc = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (temp[cnt - 1][i][j] > 0) {
						calc++;
					}
				}
			}
			Answer = Math.min(calc, Answer);
			return;
		}
		for (int j = 0; j < W; j++) {
			for (int i = 0; i < H; i++) {
				if ((cnt == 0 && map[i][j] > 0) || (cnt > 0 && temp[cnt - 1][i][j] > 0)) {
					MapCopy(cnt);
					Break(cnt, i, j);
					DropBrick(cnt + 1);
					break;
				}
			}
		}

	}

	private static void MapCopy(int cnt) {
		if (cnt == 0) {
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					temp[0][i][j] = map[i][j];
				}
			}
		} else {
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					temp[cnt][i][j] = temp[cnt - 1][i][j];
				}
			}
		}

	}

	private static void Break(int cnt, int row, int col) {
		Q.clear();
		Q.offer(row * 100 + col);

		int pos, r, c, nr, nc, count;

		while (Q.size() > 0) {
			pos = Q.poll();
			r = pos / 100;
			c = pos % 100;
			count = temp[cnt][r][c];

			temp[cnt][r][c] = 0;

			for (int d = 0; d < 4; d++) {
				nr = r + dir[d][0];
				nc = c + dir[d][1];

				int Break = count - 1;
				while (nr >= 0 && nr < H && nc >= 0 && nc < W && Break > 0) {
					if (temp[cnt][nr][nc] > 0) {
						Q.offer(nr * 100 + nc);
					}
					Break--;
					nr += dir[d][0];
					nc += dir[d][1];
				}
			}
		}

		for (int j = 0; j < W; j++) {
			int idxTo = H - 1;
			for (int i = H - 1; i >= 0; i--) {
				if (temp[cnt][i][j] > 0) {
					temp[cnt][idxTo][j] = temp[cnt][i][j];
					if (idxTo != i) {
						temp[cnt][i][j] = 0;
					}
					idxTo--;
				}
			}
		}
	}

}