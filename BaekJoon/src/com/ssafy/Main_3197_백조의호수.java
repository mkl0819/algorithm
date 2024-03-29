package com.ssafy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

import com.ssafy.library.printMing;

public class Main_3197_백조의호수 {
	static int R, C, lake[][], swan[][], day;
	static int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static Queue<Integer> melt;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Main_3197.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		lake = new int[R][C];
		swan = new int[2][2];

		day = 0;

		for (int i = 0, k = 0; i < R; i++) {
			int j = 0;
			for (char c : in.readLine().toCharArray()) {
				switch (c) {
				case '.':
					break;
				case 'X':
					lake[i][j] = 1;
					break;
				case 'L':
//					lake[i][j] = 2;
					swan[k][0] = i;
					swan[k++][1] = j;
					break;
				}
				j++;
			}
		}

		for (int i = 0; i < 2; i++) {
			check(swan[i][0], swan[i][1], 5 + i);
		}

		
		bfs();
		
		printMing.print(lake);
		printMing.print(swan[0][0], swan[0][1]);
		printMing.print(swan[1][0], swan[1][1]);
	}

	private static void bfs() {
		
	}

	private static void check(int r, int c, int k) {
		int dr, dc;
		for (int i = 0; i < 4; i++) {
			dr = r + dir[i][0];
			dc = c + dir[i][1];
			if (dr < 0 || R <= dr || dc < 0 || C <= dc) {
				break;
			}
			if (lake[dr][dc] == 0) {
				lake[dr][dc] = k;
				check(dr, dc, k);
			}
		}
	}
}
