package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17471_게리맨더링 {
	static int N, people[], map[][], min;
	static boolean check[];

	static int parent[];

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		people = new int[N + 1];
		map = new int[N + 1][N + 1];

		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		for (int start = 1, m = 0; start <= N; start++) {
			st = new StringTokenizer(in.readLine());
			m = Integer.parseInt(st.nextToken());
			for (int i = 0, end = 0; i < m; i++) {
				end = Integer.parseInt(st.nextToken());
				map[start][end] = 1;
			}
		}

		combi();
		
		System.out.println(min==Integer.MAX_VALUE ? -1 : min);
	}

	private static void combi() {
		min = Integer.MAX_VALUE;
		for (int i = 1, size = (1 << (N))-1; i < size; i++) {
			check = new boolean[N + 1];
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					check[j + 1] = true;
				}
			}
			if (divide(true) & divide(false)) {
				min = Math.min(getInterval(), min);
			}
		}
	}

	private static int getInterval() {
		int a, b;
		a = b = 0;
		for (int i = 1; i <= N; i++) {
			if (check[i]) {
				a += people[i];
			} else {
				b += people[i];
			}
		}
		return (int) Math.abs(a - b);
	}

	private static boolean divide(boolean flag) {
		parent_init();

		for (int i = 1; i <= N; i++) {
			if (check[i] == flag) {
				for (int j = 1; j <= N; j++) {
					if (check[j] == flag && map[i][j] == 1) {
						union(i, j);
					}
				}
			}
		}
		int key = 0;
		for (int i = 1; i <= N; i++) {
			if (check[i] == flag) {
				key = parent[i];
				break;
			}
		}
		for (int i = 1; i <= N; i++) {
			if (check[i] == flag && parent[i] != key) {
				return false;
			}
		}
		return true;
	}

	private static void union(int start, int end) {
		int pS = find(start);
		int pE = find(end);
		if (pS == pE)
			return;
		
		if(pE < pS) {
			int tmp = pE;
			pE = pS;
			pS = tmp;
		}
		
		parent[pE] = pS;
		
		for(int i=1; i<=N; i++) {
			if(parent[i] == pE) {
				parent[i] = pS;
			}
		}
	}

	private static int find(int x) {
		if (x == parent[x])
			return x;
		parent[x] = find(parent[x]);
		return parent[x];
	}

	private static void parent_init() {
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}

}
