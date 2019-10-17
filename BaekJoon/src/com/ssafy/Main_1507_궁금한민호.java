package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import com.ssafy.library.printMing;

public class Main_1507_궁금한민호 {
	static int N, time[][], sum, minCount, orderList[];
	static boolean check[][], visited[];

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		time = new int[N][N];
		check = new boolean[N][N];
		sum = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				time[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		printMing.print(time);

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
//				dijkstra(i, j, time[i][j]);
			}

		}
		dijkstra(1, 3, 8);
		printMing.print(check);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (check[i][j]) {
					sum += time[i][j];
				}
			}
		}

		System.out.println(sum);
	}

	private static void dijkstra(int start, int end, int cost) {
		System.out.println(start + " 에서 " + end + " 로 가는 최소거리 : " + cost);
		int min = cost, next = 0, count = 1;
		int distance[] = new int[N];
		boolean visited[] = new boolean[N];

		visited[start] = true;

		for (int i = 0; i < N; i++) {
			if (i == start || i == end)
				continue;
			if (!visited[i] && time[start][i] < min) {
				distance[i] = time[start][i];
				next = i;
//				System.out.println(i + "를 경유 1-> " + distance[i]);
				visited[next] = true;
				for (int j = 0; j < N; j++) {
					if (j == start)
						continue;
					if (!visited[j]) {
						if (distance[next] + time[next][j] < min) {
							distance[next] += time[next][j];
							check[next][j] = true;
//							System.out.println(next + "를 경유2 -> " + distance[next]);
							count++;
						} else if (j == end && distance[next] + time[next][j] == min) {
							distance[next] += time[next][j];
							count++;
							check[next][j] = true;
							System.out.println(next + "를 경유 하여 도착-> " + distance[next]);
							System.out.println(count + "개 거쳐서 도착");
//							return;
						}
					}
				}
			}
			System.out.println(Arrays.toString(distance));
		}
		check[start][end] = true;
		return;
	}
//	private static void dijkstra(int start, int end, int cost) {
//		System.out.println(start +" ----->");
//		visited = new boolean[N];
//		orderList = new int[N];
//		int order[] = new int[N];
//		order[start] = 1;
//
//		minCount = Integer.MAX_VALUE;
//
//		visited[start] = true;
//
//		for (int i = 0; i < N; i++) {
//			if (i == start) {
//				continue;
//			}
//			if (!visited[i] && time[start][i] <= cost) {
//				visited[i] = true;
//				order[i] = 2;
//				dfs(i, 1, time[start][i], end, cost, order);
//				order[i] = 0;
//				visited[i] = false;
//			}
//		}
//	}
//
//	private static boolean dfs(int e, int count, int dis, int end, int cost, int order[]) {
//		System.out.println(e + " -> "+ dis);
//		if (minCount < count) {
//			return false;
//		}
//		if (e == end && dis == cost) {
//			System.out.println(count+" 번 "+dis);
//			System.out.println(Arrays.toString(order));
//			minCount = count;
//			orderList = order;
//			return true;
//		}
//		for (int i = 0; i < N; i++) {
//			if (!visited[i] && dis + time[e][i] <= cost) {
//				visited[i] = true;
//				order[i] = count+2;
//				dfs(i, count + 1, dis + time[e][i], end, cost, order);
//				order[i] = 0;
//				visited[i] = false;
//			}
//		}
//		return true;
//	}
}
