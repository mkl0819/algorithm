package com.ssafy.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class place {
	char type;
	int time;
	int point;

	public place(char type) {
		super();
		this.type = type;
	}

	public place(char type, int time, int point) {
		super();
		this.type = type;
		this.time = time;
		this.point = point;
	}

}

public class Solution_d5_1798 {
	static int T, N, M, val, A;
	static int map[][];
	static int tmp[][];
	static char t;
	static place P[];
	static ArrayList<Integer> H;
	static int TIME = 60 * 9;

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d5_1798.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		T = 1;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			P = new place[N];
			H = new ArrayList<>();
			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = i + 1; j < N; j++) {
					val = Integer.parseInt(st.nextToken());
					map[i][j] = val;
					map[j][i] = val;
				}
			}
			print();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				t = st.nextToken().charAt(0);
				switch (t) {
				case 'P':
					P[i] = new place(t, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
					break;
				case 'A':
					P[i] = new place(t);
					A = i;
					break;
				case 'H':
					P[i] = new place(t);
					H.add(i);
					break;
				}
			}
			makeMap();
			print();
			getTmp();
		}
	}

	private static void getTmp() {
		for(int i=0; i<N; i++) {
			for(int j=1; j<N; j++) {
				
			}
		}
	}

	private static void makeMap() {
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if (k == i)
					continue;
				for (int j = 0; j < N; j++) {
					if (k == j || i == j) {
						continue;
					}
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.printf("%3d  ", map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
