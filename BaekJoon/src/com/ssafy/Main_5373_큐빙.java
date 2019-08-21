package com.ssafy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import com.ssafy.library.printMing;

public class Main_5373_큐빙 {
	static int T, N, time, side, dir;
	static final int red = 'r', blue = 'b', orange = 'o', green = 'g', white = 'w', yellow = 'y';
	static final int UP = 0, DOWN = 1, FRONT = 2, BACK = 3, LEFT = 4, RIGHT = 5;
	static final int point[][] = { { 0, 1, 2, 2, 2, 1, 0, 0 }, { 0, 0, 0, 1, 2, 2, 2, 1 } };
	static char cube[][][];
	static String str;

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Main_5373.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			// 1. 큐브 초기화
			cubeInit();

			// 2. 돌린 횟수와 방법 입력
			time = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < time; i++) {
				str = st.nextToken();
				side = str.charAt(0);
				dir = str.charAt(1);
				// 3. 돌리기
				rotate(side, dir);
			}

		}
	}

	private static void rotate(int side, int dir) {
		// 4. 본인 돌리기
		selfRotate(side, dir);
		// 5. 주변 돌리기

	}

	private static void selfRotate(int side, int dir) {
		int start = -1;
		switch (dir) {
		case '+':
			start = 0;
			break;
		case '-':
			start = 1;
			break;
		}

		char tmp = cube[side][0][0];
		for (int i = 0; i < 7; i++) {
			cube[side][point[start][i]][point[1 - start][i]] = cube[side][point[start][i + 1]][point[1 - start][i + 1]];
		}
		cube[side][point[start][7]][point[1 - start][7]] = tmp;
	}

	private static void cubeInit() {
		cube = new char[6][3][3];
		char key = ' ';
		for (int i = 0; i < 6; i++) {
			switch (i) {
			case UP:
				key = white;
				break;
			case DOWN:
				key = yellow;
				break;
			case FRONT:
				key = red;
				break;
			case BACK:
				key = orange;
				break;
			case LEFT:
				key = green;
				break;
			case RIGHT:
				key = blue;
				break;
			}
			for (int j = 0; j < 3; j++) {
				Arrays.fill(cube[i][j], key);
			}
		}
		printMing.print(cube);
	}
}
