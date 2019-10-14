package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13460_구슬탈출2 {
	static int N, M, map[][], Rr, Rc, Br, Bc, Or, Oc, CNT;
	static int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static boolean bGoal, rGoal, pass;
	static boolean visited[][][][];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[11][4][N][M];
		map_init(in);
		CNT = 0;
//		moveR(0, Rr, Rc);
//		moveR(1, Rr, Rc);
//		moveR(2, Rr, Rc);
//		moveR(3, Rr, Rc);
		bfs();
//		printMing.print(map);
		System.out.println(10 < CNT ? -1 : CNT);
	}

	private static void bfs() {
		int point[];
		int rr, rc, br, bc;
		int drr, drc, dbr, dbc;

		Queue<Integer> ball = new LinkedList<Integer>();
		ball.offer(Rr);
		ball.offer(Rc);
		ball.offer(Br);
		ball.offer(Bc);

		CNT = 0;

		while (!ball.isEmpty() && CNT++ < 10) {
			for (int i = 0, size = ball.size() / 4; i < size; i++) {
				rr = ball.poll();
				rc = ball.poll();
				br = ball.poll();
				bc = ball.poll();
				pass = false;
				for (int d = 0; d < 4; d++) {
					bGoal = true;
					rGoal = false;
					if (whoisFirst(d, rr, rc, br, bc) == 'R') {
						point = moveR(d, rr, rc);
						drr = point[0];
						drc = point[1];
						if (drr != Or || drc != Oc)
							visited[CNT][d][drr][drc] = true;
						point = moveB(d, br, bc);
						dbr = point[0];
						dbc = point[1];
						if (dbr != Or || dbc != Oc)
							visited[CNT][d][dbr][dbc] = true;
					} else {
						point = moveB(d, br, bc);
						dbr = point[0];
						dbc = point[1];
						if (dbr != Or || dbc != Oc)
							visited[CNT][d][dbr][dbc] = true;
						point = moveR(d, rr, rc);
						drr = point[0];
						drc = point[1];
						if (drr != Or || drc != Oc)
							visited[CNT][d][drr][drc] = true;
					}
//					printMing.print(drr, drc);
//					printMing.print(dbr, dbc);
					if (dbr != Or || dbc != Oc) {
						bGoal = false;
						pass = true;
					}
					if (drr == Or && drc == Oc)
						rGoal = true;
					ball.offer(drr);
					ball.offer(drc);
					ball.offer(dbr);
					ball.offer(dbc);
					if (!bGoal && rGoal) {
//						System.out.println("goal");
						return;
					}
				}
//				System.out.println(bGoal + " / "+rGoal);
				if (!pass) {
//					System.out.println("?"+CNT);
					CNT = -1;
					return;
				}
			}
		}
		return;
	}

	private static int[] moveB(int d, int br, int bc) {
		int dbr = br, dbc = bc;
		boolean flag = true;
		while (flag) {
			dbr += dir[d][0];
			dbc += dir[d][1];
//			printMing.print(dbr, dbc);
			if (!visited[CNT][d][dbr][dbc]) {
				switch (map[dbr][dbc]) {
				case 5:
					flag = false;
					break;
				case 9:
					dbr -= dir[d][0];
					dbc -= dir[d][1];
					flag = false;
					break;
				}
			} else {
				dbr -= dir[d][0];
				dbc -= dir[d][1];
				flag = false;
				break;
			}
		}
//		printMing.print(dbr, dbc);

		return new int[] { dbr, dbc };
	}

	private static int[] moveR(int d, int rr, int rc) {
		int drr = rr, drc = rc;
		boolean flag = true;

		while (flag) {
			drr += dir[d][0];
			drc += dir[d][1];
			if (!visited[CNT][d][drr][drc]) {
				switch (map[drr][drc]) {
				case 5:
					flag = false;
					break;
				case 9:
					drr -= dir[d][0];
					drc -= dir[d][1];
					flag = false;
					break;
				}
			} else {
				drr -= dir[d][0];
				drc -= dir[d][1];
				flag = false;
				break;
			}
		}

		return new int[] { drr, drc };
	}

	private static char whoisFirst(int d, int rr, int rc, int br, int bc) {
		if (d % 2 == 0) {
			if (((d == 0) && (rr < br)) || ((d == 2) && (br < rr)))
				return 'R';
			else
				return 'B';
		} else {
			if (((d == 1) && (bc < rc)) || ((d == 3) && (rc < bc)))
				return 'R';
			else
				return 'B';
		}

	}

	private static void map_init(BufferedReader in) throws IOException {
		for (int i = 0, j = 0, key = 0; i < N; i++) {
			j = 0;
			for (char c : in.readLine().toCharArray()) {
				switch (c) {
				case '#':
					key = 9;
					break;
				case '.':
					key = 0;
					break;
				case 'R':
					Rr = i;
					Rc = j;
					key = 0;
					break;
				case 'B':
					Br = i;
					Bc = j;
					key = 0;
					break;
				case 'O':
					Or = i;
					Oc = j;
					key = 5;
					break;
				}
				map[i][j++] = key;
			}
		}
	}
}
