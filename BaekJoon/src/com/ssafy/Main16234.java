package com.ssafy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16234 {
	static int N, L, R;
	static int map[][];
	static boolean visited[][];
	static LinkedList<Integer> union;
	static Queue<Integer> union_option;
	static Queue<Integer> q;
	static int union_sum;
	static int COUNT;

	static int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Main16234.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N + 2][N + 2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		print();

		q = new LinkedList<Integer>();
		union = new LinkedList<Integer>();
		union_option = new LinkedList<Integer>();

		union.clear();
		COUNT = 0;
		while (true) {
			visited = new boolean[N + 2][N + 2];

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (!visited[i][j]) {
						q.clear();
						q.offer(i);
						q.offer(j);
						union.offer(i);
						union.offer(j);
						visited[i][j] = true;
						union_sum = map[i][j];
						bfs();
//						print();
					}
				}
			}
			if (union.isEmpty()) {
				break;
			}
			move();
			COUNT++;
		}

//		print();
		System.out.println(COUNT);
	}

	private static void print() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void bfs() {
		int r, c, population, dr, dc, usize = 1;
		while (!q.isEmpty()) {
			for (int i = 0, size = q.size() / 2; i < size; i++) {
				r = q.poll();
				c = q.poll();
				population = map[r][c];
//				System.out.println(r + ", " + c + " : " + map[r][c]);
				for (int d = 0; d < 4; d++) {
					dr = r + dir[d][0];
					dc = c + dir[d][1];
					if (map[dr][dc] == 0) {
						continue;
					}
					if (visited[dr][dc]) {
						continue;
					}
					if (canMove(population, map[dr][dc])) {
						visited[dr][dc] = true;
						q.offer(dr);
						q.offer(dc);
						union.offer(dr);
						union.offer(dc);
						union_sum += map[dr][dc];
						usize++;
					}
				}
			}
		}
//		System.out.println(union);

		if (usize == 1) {
			union.removeLast();
			union.removeLast();
			return;
		}
		union_option.offer(usize);
		union_option.offer(union_sum);

	}

	private static void move() {
//		System.out.println("move!!");
//		System.out.println(union_sum);
		int size, population;
		while (!union_option.isEmpty()) {
			size = union_option.poll();
			population = union_option.poll() / size;

			for (int i = 0; i < size; i++) {
				map[union.poll()][union.poll()] = population;
			}
		}
	}

	private static boolean canMove(int p, int dp) {
//		System.out.println(p + "/" + dp);
		p = Math.abs(p - dp);
//		System.out.println("==> " + p);
		if (p < L)
			return false;
		if (R < p)
			return false;
//		System.out.println("true");
		return true;
	}
}
