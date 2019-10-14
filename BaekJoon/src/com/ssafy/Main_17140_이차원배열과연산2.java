package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

import com.ssafy.library.printMing;

public class Main_17140_이차원배열과연산2 {
	static StringTokenizer st;
	static int r, c, k, matrix[][], R, C, check[];
	static ArrayList<TreeMap<Integer, Integer>> rlist, clist;
	static TreeMap<Integer, Integer> rtmp;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		matrix = new int[3][3];
		rlist = new ArrayList<>();
		clist = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(in.readLine());
			rtmp = new TreeMap<>();
			for (int j = 0; j < 3; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				if (!rtmp.containsKey(matrix[i][j])) {
					System.out.println(matrix[i][j] + "putput");
					rtmp.put(matrix[i][j], 0);
				}
				System.out.println(rtmp);
				rtmp.put(matrix[i][j], rtmp.get(matrix[i][j]) + 1);
			}
			rlist.add(rtmp);
		}
		R = C = 3;
		printMing.print(matrix);

		System.out.println(rlist);

//		run();
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


