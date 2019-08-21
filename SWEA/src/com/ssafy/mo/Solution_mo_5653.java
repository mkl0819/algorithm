package com.ssafy.mo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_mo_5653 {
	static class sepo implements Comparable<sepo> {
		int r, c, life, cnt;

		public sepo(int r, int c, int life) {
			super();
			this.r = r;
			this.c = c;
			this.life = life;
			this.cnt = life;
			map[r][c] = 1;
		}
		@Override
		public int compareTo(sepo o) {
			return o.life - this.life;
		}
	}

	static int T, N, M, K;
	static int sizeN, sizeM;
	static int map[][];
	static int dir[][] = { {}, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static LinkedList<sepo> sepos;
	static LinkedList<sepo> seposwilldie;

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_mo_5653.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());

			N = Integer.parseInt(st.nextToken()); // 세로
			M = Integer.parseInt(st.nextToken()); // 가로
			K = Integer.parseInt(st.nextToken()); // 시간

			sizeN = N + 2 * K;
			sizeM = M + 2 * K;

			map = new int[sizeN][sizeM];

			sepos = new LinkedList<sepo>();
			seposwilldie = new LinkedList<sepo>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < M; j++) {
					int life = Integer.parseInt(st.nextToken());
					switch (life) {
					case 0:
						break;
					default:
						sepos.add(new sepo(K + i, K + j, life));
						break;
					}
				}
			}
			System.out.println("#" + test_case + " " + beayang());
		}
	}

	private static int beayang() {
		sepo tmp;
		int dr, dc;
		int size, dize;
		for (int k = 0; k < K; k++) {
			size = sepos.size();
			dize = seposwilldie.size();
			for (int i = 0; dize-- > 0; i++) {
				tmp = seposwilldie.get(i);
				if (tmp.cnt == tmp.life) {
					for (int d = 1; d < 5; d++) {
						dr = tmp.r + dir[d][0];
						dc = tmp.c + dir[d][1];
						if (map[dr][dc] != 1) {
							sepos.add(new sepo(dr, dc, tmp.life));
						}
					}
				}
				tmp.cnt--;
				if (tmp.cnt == 0) {
					seposwilldie.remove(i--);
				}
			}
			for (int i = 0; size-- > 0; i++) {
				tmp = sepos.get(i);
				tmp.cnt--;
				if (tmp.cnt == 0) {
					sepos.remove(i--);
					tmp.cnt = tmp.life;
					seposwilldie.offer(tmp);
				}
			}
			Collections.sort(seposwilldie);
			System.out.println(sepos.size()+" / "+seposwilldie.size());
		}
		return sepos.size() + seposwilldie.size();
	}
}
