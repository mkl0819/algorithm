package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17142_연구소3 {
	static int N, M, map[][], virus_index[], virus_cnt, empty, MIN;
	static boolean visited[][];
	static ArrayList<int[]> virus;
	static Queue<Integer> vQ;
	static int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		virus = new ArrayList<>();
		virus_cnt = 0;

		empty = 0;

		MIN = Integer.MAX_VALUE - 1;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				switch (map[i][j] = Integer.parseInt(st.nextToken())) {
				case 0:
					empty++;
					break;
				case 1:
					break;
				case 2:
					virus.add(new int[] { i, j });
					virus_cnt++;
					break;
				}
			}
		}

//		System.out.println(empty + "칸");
		virus_index = new int[M];

		combi(0, 0);

		System.out.println((MIN == Integer.MAX_VALUE - 1) ? -1 : MIN);
	}

	private static void combi(int count, int start) {
		if (count == M) {
//			printMing.print(virus_index);
			spread();
			return;
		}
		for (int i = start; i < virus_cnt; i++) {
			virus_index[count] = i;
			combi(count + 1, i + 1);
		}
	}

	private static void spread() {
//		System.out.println("============================");
		int r, c, dr, dc, time = -1, cnt = 0;
		vQ = new LinkedList<Integer>();
		visited = new boolean[N][N];

		for (int point : virus_index) {
			r = virus.get(point)[0];
			c = virus.get(point)[1];
			vQ.offer(r);
			vQ.offer(c);
			visited[r][c] = true;
		}

//		System.out.println(vQ);
//		printMing.print(visited);

		while (!vQ.isEmpty()) {
//			System.out.println(vQ);
			time++;

			for (int i = 0, size = vQ.size() / 2; i < size; i++) {
				r = vQ.poll();
				c = vQ.poll();
				for (int d = 0; d < 4; d++) {
					dr = r + dir[d][0];
					dc = c + dir[d][1];
					if (check(dr, dc) && !visited[dr][dc]) {
						if (map[dr][dc] == 0) {
							vQ.offer(dr);
							vQ.offer(dc);
							cnt++;
						}
						if(map[dr][dc] == 2) {
							visited[dr][dc] = true;
							for(int td=0; td<4; td++) {
								int tdr = dr + dir[td][0];
								int tdc = dc + dir[td][1];
								if(check(tdr, tdc) && !visited[tdr][tdc]) {
									
								}
							}
						}
					}
				}

			}
//			if (empty == cnt) {
//				System.out.println(empty + " 다 채움 " + cnt);
//				printMing.print(virus_index);
//				System.out.println(MIN);
//				return;
////			}

			if (MIN <= time) {
				return;
			}
//			time++;
		}
//		printMing.print(visited);
//		System.out.println(empty + " 다 채움?? " + cnt + " 몇 초?? " +time);
		if(empty==cnt)
			MIN = Math.min(MIN, time);


	}

	private static boolean check(int r, int c) {
		if (r == -1 || c == -1 || r == N || c == N)
			return false;
		else
			return true;
	}
}
