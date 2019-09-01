package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import com.ssafy.library.printMing;

public class Main_17281_야구공 {
	static int N, score[][], list[];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine().trim());
		score = new int[N][9];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 9; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		printMing.print(score);
		list = new int[9];
		permu(0, 0);
	}

	private static void permu(int count, int flag) {
		if (count == 9) {
			printMing.print(list);
			return;
		}
		for (int i = 0; i < 9; i++) {
			if ((flag & (1 << i)) == 0) {
				list[count] = i;
				permu(count + 1, flag | (1 << i));
			}
		}
	}
}
