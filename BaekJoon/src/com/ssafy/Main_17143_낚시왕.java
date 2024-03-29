package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import com.ssafy.library.printMing;

public class Main_17143_낚시왕 {
	static int T, R, C, M, map[][], copiedmap[][], r, c, s, d, z, angler, SUM;
	static final int UP = 1, DOWN = 2, RIGHT = 3, LEFT = 4;
	static int dir[][] = { {}, { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static int shark[][];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/Main_17143.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[R + 2][C + 2];
		shark = new int[M + 1][5];
		SUM = 0;

		// 1. 정보 입력
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(in.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());

			map[r][c] = i;

			shark[i][0] = r;
			shark[i][1] = c;
			shark[i][2] = s;
			shark[i][3] = d;
			shark[i][4] = z;

		}
//		printMing.print(map);
//		printMing.print(shark);
		
		// 2. 낚시왕이 이동
		AnglerMove();

		System.out.println(SUM);
	}

	private static void AnglerMove() {
		for (angler = 1; angler <= C; angler++) {
			copiedmap = new int[R + 2][C + 2];
			// 3. 상어 잡기
			fishing();
			// 4. 상어 이동
			SharkMove();
			
			mapCopy();
//			printMing.print(copiedmap);
//			printMing.print(map);
//			printMing.print(shark);
		}
	}

	private static void mapCopy() {
		for(int i=1; i<=R; i++) {
			for(int j=1; j<=C; j++) {
				map[i][j] = copiedmap[i][j];
			}
		}
	}

	private static void fishing() {
		for (int r = 1; r <= R; r++) {
			if (map[r][angler] != 0) {
//				System.out.println("잡음");
				int sharkIdx = map[r][angler];
				SUM += shark[sharkIdx][4];
				Arrays.fill(shark[sharkIdx], 0);
				map[r][angler] = 0;
				break;
			}
		}
	}

	private static void SharkMove() {
		int dr, dc, r, c, s, d, z;
		for (int m = 1; m <= M; m++) {
			if (shark[m][3] != 0) {
				r = shark[m][0];
				c = shark[m][1];
				s = shark[m][2];
				d = shark[m][3];
				z = shark[m][4];
				dr = r;
				dc = c;
//				System.out.printf("%d 번 상어 ( %d, %d ) %d 방향 %d 칸\n", m, r, c, d, s);
				for (int i = 0; i < s; i++) {
					dr += dir[d][0];
					dc += dir[d][1];
					if(dr==0) {
						dr = 1;
						d = dirChange(d);
						i--;
					} if(dr==R+1) {
						dr = R;
						d = dirChange(d);
						i--;
					}
					if(dc==0) {
						dc = 1;
						d = dirChange(d);
						i--;
					}
					if(dc==C+1) {
						dc = C;
						d = dirChange(d);
						i--;
					}
				}
				if (copiedmap[dr][dc] != 0) {
					int target[] = shark[copiedmap[dr][dc]];
					if (z < target[4]) {
//						System.out.println("먹음");
						Arrays.fill(shark[m], 0);
					} else {
						Arrays.fill(shark[copiedmap[dr][dc]], 0);
						shark[m][0] = dr;
						shark[m][1] = dc;
						shark[m][3] = d;
						copiedmap[dr][dc] = m;
					}
				} else {
					shark[m][0] = dr;
					shark[m][1] = dc;
					shark[m][3] = d;
					copiedmap[dr][dc] = m;
				}
			}
		}
	}

	private static int dirChange(int d) {
		switch (d) {
		case 1:
			return 2;
		case 2:
			return 1;
		case 3:
			return 4;
		case 4:
			return 3;
		}
		return 0;
	}

}
