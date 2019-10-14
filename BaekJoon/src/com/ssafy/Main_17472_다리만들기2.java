package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import com.ssafy.library.printMing;

public class Main_17472_다리만들기2 {
	static int N, M, map[][], islandCount;
	static int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int matrix[][], parent[], minCost;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		minCost = 0;

		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(in.readLine());
			for (int col = 0; col < M; col++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					map[row][col] = -1;
				}
			}
		}

		islandCount = getIslandCount();

		matrix = new int[islandCount + 1][islandCount + 1];

		setBridge();

		parent_init();

		printMing.print(map);
		
		System.out.println();
		
		printMing.print(matrix);
		
		for (int row = 0; row <= islandCount; row++) {
			for (int col = row + 1; col <= islandCount; col++) {
				if (matrix[row][col] != 0) {
					union(row, col);
				}
			}
		}

		System.out.println(minCost);
	}

	private static void union(int start, int end) {
		int island_1 = find(start);
		int island_2 = find(end);

		if (island_1 == island_2) {
			return;
		}
		parent[island_1] = island_2;
		minCost += matrix[start][end];
	}

	private static void parent_init() {
		parent = new int[islandCount + 1];
		for (int i = 1, size = parent.length; i < size; i++) {
			parent[i] = i;
		}
	}

	private static int find(int island) {
		if (island == parent[island]) {
			return island;
		} else {
			parent[island] = find(parent[island]);
			return parent[island];
		}
	}

	private static void setBridge() {
		int drow, dcol, len;
		int start, end;
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				start = map[row][col];
				if (start >= 1) {
					for (int d = 0; d < 4; d++) {
						drow = row + dir[d][0];
						dcol = col + dir[d][1];
						len = 0;
						while (check(drow, dcol)) {
							end = map[drow][dcol];
							if (end == 0) {
								len++;
							} else if (len > 1) {
									matrix[start][end] = len;
									matrix[end][start] = len;
								break;
							} else {
								break;
							}
							drow += dir[d][0];
							dcol += dir[d][1];
						}
					}
				}
			}
		}
	}

	private static int getIslandCount() {
		int count = 1;
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				if (map[row][col] == -1) {
					bfs(row, col, count++);
				}
			}
		}
		return count - 1;
	}

	private static void bfs(int row, int col, int count) {
		map[row][col] = count;

		Queue<Integer> q = new LinkedList<Integer>();

		q.offer(row);
		q.offer(col);

		int drow, dcol;
		while (!q.isEmpty()) {
			System.out.println(q);
			for (int index = 0, size = q.size() / 2; index < size; index++) {
				row = q.poll();
				col = q.poll();
//				System.out.println(count+" 번째 섬 : "+row +" / "+col);
				for (int d = 0; d < 4; d++) {
					drow = row + dir[d][0];
					dcol = col + dir[d][1];
//					System.out.println(drow +" / "+dcol +" 검사");
					if (check(drow, dcol) && map[drow][dcol] == -1) {
						map[drow][dcol] = count;
						q.offer(drow);
						q.offer(dcol);
					}
				}
			}
		}
	}

	private static boolean check(int row, int col) {
		if (row == -1 || col == -1 || row == N || col == M)
			return false;
		return true;
	}
}