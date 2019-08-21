package com.ssafy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구슬 탈출 2
 *
 */
public class Main13460 {
	static int N, M, BLUE, RED, HOLE, MIN;
	static char map[][];
	static int visited[][];
	static char order[];

	static int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Main13460.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new int[N][M];
		for (int i = 0, j = 0; i < N; i++, j = 0) {
			for (char c : map[i] = in.readLine().toCharArray()) {
				if (c == 'B') {
					BLUE = i * 100 + j;
					visited[i][j] = 10;
				} else if (c == 'R') {
					RED = i * 100 + j;
					visited[i][j] = 1;
				} else if (c == 'O') {
					HOLE = i * 100 + j;
				}
				j++;
			}
		}
		print();
		MIN = Integer.MAX_VALUE;
		order = new char[2];
//		for (int d = 0; d < 4; d++) {
		dfs(RED / 100, RED % 100, BLUE / 100, BLUE % 100, -1, 1);
//		}
		print();
		System.out.println(MIN + "!!");
	}

	private static void dfs(int rr, int rc, int br, int bc, int pred, int cnt) {
		int drr, drc, dbr, dbc;
		int prr, prc, pbr, pbc;
		int rmove, bmove;
		boolean check;

		for (int d = 0; d < 4; d++) {
			if (d == pred)
				continue;
			if (Math.abs(pred - d) == 2)
				continue;
			System.out.println("dir : " + d);
//			if (map[drr][drc] != '#' || map[dbr][dbc] != '#') {
//			if (visited[drr][drc] % 10 != 1) {
			switch (d) {
			case 0:
				if (rc < bc) {
					order[0] = 'b';
					order[1] = 'r';
				} else {
					order[0] = 'r';
					order[1] = 'b';
				}
				break;
			case 1:
				if (rr < br) {
					order[0] = 'b';
					order[1] = 'r';
				} else {
					order[0] = 'r';
					order[1] = 'b';
				}
				break;
			case 2:
				if (rc > bc) {
					order[0] = 'b';
					order[1] = 'r';
				} else {
					order[0] = 'r';
					order[1] = 'b';
				}
				break;
			case 3:
				if (rr > br) {
					order[0] = 'b';
					order[1] = 'r';
				} else {
					order[0] = 'r';
					order[1] = 'b';
				}
				break;
			}
//				drr = rr + dir[d][0];
//				drc = rc + dir[d][1];
//				dbr = br + dir[d][0];
//				dbc = bc + dir[d][1];
			System.out.println(order);
			prr = rr;
			prc = rc;
			pbr = br;
			pbc = bc;
			for (int i = 0; i < 2; i++) {
				System.out.println(order[i]+" search");
				switch (order[i]) {
				case 'r':
					System.out.println("red");
					map[prr][prc] = '.';
					check = true;
					while (check) {
						drr = prr + dir[d][0];
						drc = prc + dir[d][1];
						switch (map[drr][drc]) {
						case 'O':
							System.out.println("hole");
							MIN = Math.min(MIN, cnt);
							return;
						case '.':
							prr = drr;
							prc = drc;
							break;
						default:
							rmove = RED;
							RED = prr * 100 + prc;
							rmove-=RED;
							map[prr][prc] = 'R';
							check = false;
							break;
						}

					}
					break;
				case 'b':
					System.out.println("blue");
					map[pbr][pbc] = '.';
					check = true;
					while (check) {
						dbr = pbr + dir[d][0];
						dbc = pbc + dir[d][1];
						switch (map[dbr][dbc]) {
						case 'O':
							System.out.println("hole");
							MIN = Math.min(MIN, cnt);
							return;
						case '.':
							System.out.println('.');
							pbr = dbr;
							pbc = dbc;
							break;
						default:
							System.out.println("not dot");
							BLUE = pbr * 100 + pbc;
							map[pbr][pbc] = 'B';
							check = false;
							break;
						}

					}
				}
			}
			System.out.println("===end");
//			}
//			}
//			go(order[0]);
//			go(ord)
//			while (true) {
//				drr += dir[d][0];
//				drc += dir[d][1];
//				if (visited[drr][drc] % 10 != 1) {
//					visited[drr][drc] += 1;
//					if (map[drr][drc] != '.')
//						break;
//				}
//			}
//
//			while (true) {
//				dbr += dir[d][0];
//				dbc += dir[d][1];
//				if (visited[dbr][dbc] / 10 != 1) {
//					visited[dbr][dbc] += 10;
//					if (map[dbr][dbc] != '.')
//						break;
//				}
//			}
//			System.out.println("B : " + dbr + ", " + dbc);
//			System.out.println("R : " + drr + ", " + drc);
			print();
			System.out.println();
		}
	}

//	private static void dfs(int r, int c, int cnt) {
//		int dr, dc;
//		for(int dd=0; dd<4; dd++) {
//			dr = r;
//			dc = c;
//			while(true) {
//				dr += dir[dd][0];
//				dc += dir[dd][0];
//				if(visited[dr][dc]==0) {
//					visited[dr][dc] = true;
//					switch(map[dr][dc]) {
//					case'.':
//						break;
//					case'#':
//						break;
//					case 'O':
//						break;
//					}
//				}
//				
//			}
//		}
//	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			System.out.println(map[i]);
		}
		System.out.println("B : " + BLUE / 100 + ", " + BLUE % 100);
		System.out.println("R : " + RED / 100 + ", " + RED % 100);
		System.out.println("H : " + HOLE / 100 + ", " + HOLE % 100);
		System.out.println();
	}

}
