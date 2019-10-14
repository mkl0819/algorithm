package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

import com.ssafy.library.printMing;

public class Main_17140_이차원배열과연산3 {
	static StringTokenizer st;
	static int r, c, k, matrix[][], R, C, check[];
	static int tmp[][];
	static ArrayList<int[][]> rlist, clist;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		matrix = new int[101][101];
		rlist = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			tmp = new int[101][2];
			
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 3; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				tmp[matrix[i][j]][0] = matrix[i][j];
				tmp[matrix[i][j]][1]++;
			}
			Arrays.sort(tmp, new comp());
			printMing.print(tmp);
			rlist.add(tmp);
			getR();
		}
		R = C = 3;
//		printMing.print(matrix);

		run();
	}

	private static void getR() {
		C = rlist.size();
		int max = 0, cnt;
		for (int[][] tmp : rlist) {
			cnt = 0;
			for (int i = 100; i > 0; i--) {
				if (tmp[i][0] != 0) {
					cnt++;
				} else {
					break;
				}
			}
			max = Math.max(max, cnt);
		}
		R = max * 2;
		printMing.print(R, C);
	}

	private static void run() {
		while (!check()) {
			if (C <= R) {
			} else {
			}
		}
	}

	
	private static boolean check() {
		
		return false;
	}
}

class comp implements Comparator<int[]> {
	@Override
	public int compare(int[] o1, int[] o2) {
		if (o1[1] == o2[1])
			return o1[0] - o2[0];
		return o1[1] - o2[1];
	}
}
