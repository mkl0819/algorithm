package com.ssafy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main13911 {
	static int V, E, u, v, w, M[], x, S[], y, map[][], size;
	static ArrayList<Integer> MSG, SSG;
	static boolean visited[];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Main13911.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		map = new int[V + 1][V + 1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map[u][v] = w;
			map[v][u] = w;
		}

		print();

		st = new StringTokenizer(in.readLine());

		size = Integer.parseInt(st.nextToken());
		M = new int[size];
		x = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine());
		
		for (int i = 0; i < size; i++) {
			M[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(Arrays.toString(M));
		
		st = new StringTokenizer(in.readLine());

		size = Integer.parseInt(st.nextToken());
		S = new int[size];
		y = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < size; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(Arrays.toString(S));
	}

	private static void getMSG(int mac, int sum) {
		visited[mac] = true;
		for (int i = 1; i <= V; i++) {
			if (visited[i] || map[mac][i]==0) {
				continue;
			}
			if (!visited[i] && sum + map[mac][i] <= x) {
				visited[i] = true;
				System.out.println(i);
				MSG.add(i);
				getMSG(i, sum + map[mac][i]);
				visited[i] = false;
			}else {
				return;
			}
			System.out.println();
		}
	}

	private static void print() {
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
