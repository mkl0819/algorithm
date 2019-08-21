package com.ssafy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;
public class Main2665_fail {
	static class Node implements Comparable<Node> {
		int s, e;

		public Node(int s, int e) {
			super();
			if (s == e)
				return;
			if (s < e) {
				this.s = s;
				this.e = e;
			} else {
				this.s = e;
				this.e = s;
			}
		}

		@Override
		public int compareTo(Node o) {
			if (this.s == o.s) {
				return this.e - o.e;
			}
			return this.s - o.s;
		}
	}

	static int N, map[][];
	static boolean graph[][];
	static int START, END;
	static int count;
	static Queue<Integer> q;
	static boolean visited[][];
	static int area[];
	static TreeSet<Node> connected;
	static int result;

	static int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	static char[] str;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_mo_5650.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine().trim());

		map = new int[N + 1][N + 1];
		area = new int[4];

		for (int i = 1; i <= N; i++) {
			str = in.readLine().toCharArray();
			for (int j = 1; j <= N; j++) {
				map[i][j] = str[j - 1] - '0';
			}
		}
		START = 1;
		getCount();
		connected = new TreeSet<Node>();
		graph = new boolean[count][count];
		getNode();
		setGraph();
		result = Integer.MAX_VALUE;
		getResult(START, 0);
		System.out.println( (result == Integer.MAX_VALUE || result==1) ? "0" : result);
	}

	private static void setGraph() {
		for (Node n : connected) {
			graph[n.s][n.e] = true;
		}
	}

	private static void getResult(int s, int cnt) {
		if (s == END) {
			result = Math.min(cnt, result);
			return;
		}
		if (result < cnt) {
			return;
		}
		for (int i = 0; i < count; i++) {
			if (i == s)
				continue;
			if (graph[s][i]) {
				getResult(i, cnt + 1);
			}
		}
	}

	private static void getNode() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 0) {
					isConnected(i, j);
				}
			}
		}
	}

	private static void isConnected(int r, int c) {
		int dr, dc, acnt = 0;

		for (int d = 0; d < 4; d++) {
			dr = r + dir[d][0];
			dc = c + dir[d][1];
			if (check(dr, dc) && map[dr][dc] != 0) {
				area[acnt++] = map[dr][dc];
			}
		}
		if (acnt > 1) {
			for (int i = 0; i < acnt; i++) {
                for(int j=0; j<acnt; j++){
                    if(i==j) continue;
				    connected.add(new Node(area[i], area[j]));
                }
			}
		}
		Arrays.fill(area, 0);
		return;
	}

	private static void getCount() {
		count = 1;
		q = new LinkedList<>();
		visited = new boolean[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (!visited[i][j] && map[i][j] != 0) {
					q.offer(i);
					q.offer(j);
					visited[i][j] = true;
					map[i][j] = count;
					bfs();
					count++;
				}
			}
		}
	}

	private static void bfs() {
		int r, c, dr, dc;
		while (!q.isEmpty()) {
			for (int i = 0, size = q.size() / 2; i < size; i++) {
				r = q.poll();
				c = q.poll();
				if (r == N && c == N) {
					END = count;
				}
				for (int d = 0; d < 4; d++) {
					dr = r + dir[d][0];
					dc = c + dir[d][1];
					if (check(dr, dc) && !visited[dr][dc] && map[dr][dc] != 0) {
						visited[dr][dc] = true;
						map[dr][dc] = count;
						q.offer(dr);
						q.offer(dc);
					}
				}
			}

		}
	}
	private static boolean check(int r, int c) {
		if (r == 0 || c == 0) {
			return false;
		}
		if (r == N + 1 || c == N + 1) {
			return false;
		}
		return true;
	}
}
