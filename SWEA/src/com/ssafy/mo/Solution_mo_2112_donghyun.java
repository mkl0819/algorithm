package com.ssafy.mo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_mo_2112_donghyun {
	static boolean isAnswer;
	static boolean[] Select;
	static int Testcase, W, D, K, C, Answer;
	static int[] layer;
	static int[][] Film = new int[13][20];

	static int[][][] temp = new int[13][13][20];

	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/보호필름.txt"));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		Testcase = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= Testcase; t++) {
			sb.append('#').append(t).append(' ');
			isAnswer = true;

			st = new StringTokenizer(br.readLine().trim());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			for (int r = 0; r < D; r++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int c = 0; c < W; c++) {
					Film[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			int val, count, temp_count;
			
			for (int c = 0; c < W; c++) {
				val = Film[0][c];
				count = 1;
				temp_count = 1;
				for (int r = 1; r < D; r++) {
					if (val == Film[r][c]) {
						temp_count++;
					} else {
						count = Math.max(temp_count, count);
						temp_count = 1;
						val = Film[r][c];
					}
				}
				count = Math.max(temp_count, count);
				if (count < K){
					isAnswer = false;
					break;
				}
			}
			if(isAnswer) {
				sb.append('0').append('\n');
//				System.out.println("#" + t + " 0");
				continue;
			}

			for (int cnt = 1; cnt <= D; cnt++) {
				Select = new boolean[D];
				C = cnt;
				layer = new int[C];
				InsertMedicine(0, 0);
				if (isAnswer) {
					sb.append(C).append('\n');
//					System.out.println("#" + t + " " + C);
					break;
				}
			}

		}
		System.out.print(sb);
	}

	private static void InsertMedicine(int cnt, int idx) {
		if (isAnswer)
			return;
		if (cnt == C) {
			Insert(0);
			return;
		}

		for (int i = idx; i < D; i++) {
			if (!Select[i]) {
				Select[i] = true;
				layer[cnt] = i;
				InsertMedicine(cnt + 1, i);
				if (isAnswer)
					return;
				Select[i] = false;
			}
		}
	}

	private static void Insert(int cnt) {
		if (isAnswer)
			return;
		if (cnt == C) {
			isAnswer = SeqCount();
			return;
		}

		for (int i = 0; i < 2; i++) {
			CopyMap(cnt);
			for (int j = 0; j < W; j++) {
				temp[cnt][layer[cnt]][j] = i;
			}
			Insert(cnt + 1);
		}

	}

	private static void CopyMap(int cnt) {
		if (cnt == 0) {
			for (int r = 0; r < D; r++) {
				for (int c = 0; c < W; c++) {
					temp[cnt][r][c] = Film[r][c];
				}
			}
		} else {
			for (int r = 0; r < D; r++) {
				for (int c = 0; c < W; c++) {
					temp[cnt][r][c] = temp[cnt - 1][r][c];
				}
			}
		}

	}

	private static boolean SeqCount() {
		int val, count, temp_count;
		for (int c = 0; c < W; c++) {
			val = temp[C - 1][0][c];
			count = 1;
			temp_count = 1;
			for (int r = 1; r < D; r++) {
				if (val == temp[C - 1][r][c]) {
					temp_count++;
				} else {
					count = Math.max(temp_count, count);
					temp_count = 1;
					val = temp[C - 1][r][c];
				}
			}
			count = Math.max(temp_count, count);
			if (count < K)
				return false;
		}
		return true;
	}

}