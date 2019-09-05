package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import com.ssafy.library.printMing;

public class Main_17391_무한부스터2 {
	static int N, M, map[][], MIN;
	static int dir[][] = { { 0, 1 }, { 1, 0 } };
	static int visited[][];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 2][M + 2];
		visited = new int[N + 2][M + 2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		printMing.print(map);
		MIN = Integer.MAX_VALUE - 1;
		visited[1][1] = -1;

//		dfs(1, 1, 0);
		bfs();

		System.out.println(MIN);

	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();

		q.offer(1);
		q.offer(1);

		int r, c, dr, dc, dis, count = 0;

		while (!q.isEmpty()) {
			for (int i = 0, size = q.size() / 2; i < size; i++) {
				r = q.poll();
				c = q.poll();
				dis = map[r][c] + 1;
				for (int d = 0; d < 2; d++) {
					dr = r + (dir[d][0] * dis);
					dc = c + (dir[d][1] * dis);
					for (int j = 0; j < dis; j++) {
						dr -= dir[d][0];
						dc -= dir[d][1];
//						printMing.print(dr, dc);
						if (check(dr, dc) && (visited[dr][dc] == 0 || count <= visited[dr][dc])) {
							visited[dr][dc] = count + 1;
							if(dr==N&&dc==M) {
								MIN = visited[N][M];
								return;
							}
							q.offer(dr);
							q.offer(dc);
						}
					}
				}
			}
			count++;
//			printMing.print(visited);

		}
	}

	private static void dfs(int r, int c, int count) {
		if (r == N && c == M) {
			MIN = Math.min(count, MIN);
			return;
		}
		if (MIN <= count) {
			return;
		}
		int dr, dc, dis = map[r][c];
		for (int d = 0; d < 4; d++) {
			dr = r;
			dc = c;
			for (int j = 1; j <= dis; j++) {
				dr += dir[d][0];
				dc += dir[d][1];
//				if (check(dr, dc) && !visited[dr][dc]) {
//					visited[dr][dc] = true;
//					dfs(dr, dc, count + 1);
//				} else {
//					break;
//				}
			}
		}
	}

	private static boolean check(int r, int c) {
		if (r <= 0 || c <= 0 || r >= N + 1 || c >= M + 1)
			return false;
		else
			return true;
	}
}
