package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import com.ssafy.library.printMing;

public class Main_17281_야구공2 {
	static int N, score[][], list[], MAX;
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
//		printMing.print(score);
		list = new int[9];
		list[3] = 0;
//		list = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8};
		MAX = -1;
//		game(list); 
		permu(0, 1);
		System.out.println(MAX);
	}

	private static void permu(int count, int flag) {
		if (count == 9) {
//			printMing.print(list);
			MAX = Math.max(MAX, game(list));

			return;
		}
		for (int i = 1; i < 9; i++) {
			if (count == 3) {
				permu(count + 1, flag);
//				continue;
			} else {
				if ((flag & (1 << i)) == 0) {
					list[count] = i;
					permu(count + 1, flag | (1 << i));
				}
			}
		}
	}

	private static int game(int[] tmplist) {
		int start = 0, point = 0;
//		int ground[] = new int[3];
		// 이닝
		for (int i = 0; i < N; i++) {
			Queue<Integer> ground = new LinkedList<Integer>();
			int out = 0;
			while (out < 3) {
				if (start == 9)
					start = 0;
				switch (score[i][tmplist[start]]) {
				case 0:
					out++;
					break;
				case 1:
					ground.offer(start);
					break;
				case 2:
					ground.offer(start);
					ground.offer(-1);
					break;
				case 3:
					ground.offer(start);
					ground.offer(-1);
					ground.offer(-1);
					break;
				case 4:
					ground.offer(start);
					ground.offer(-1);
					ground.offer(-1);
					ground.offer(-1);
//					while (!ground.isEmpty()) {
//						if (ground.poll() != -1) {
//							point++;
//						}
//					}
					break;
				}

				start++;
			}
			for (int j=0, size = ground.size()-3; j < size; j++) {
				if (ground.poll() != -1) {
					point++;
				}
			}
		}
//			System.out.println(point+"점");
		return point;
	}
}
