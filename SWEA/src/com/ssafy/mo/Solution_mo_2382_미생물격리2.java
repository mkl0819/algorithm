//package com.ssafy.mo;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.StringTokenizer;
//import java.util.TreeMap;
//
//import com.ssafy.library.printMing;
//
//class cluster {
//	int r, c, size, d;
//
//	public cluster() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public cluster(int r, int c, int size, int d) {
//		super();
//		this.r = r;
//		this.c = c;
//		this.size = size;
//		this.d = d;
//	}
//
//	public void pointChange(int dr, int dc) {
//		this.r = dr;
//		this.c = dc;
//	}
//
//	@Override
//	public String toString() {
//		return "cluster [r=" + r + ", c=" + c + ", size=" + size + ", d=" + d + "]";
//	}
//
//}
//
//public class Solution_mo_2382_미생물격리2 {
//	static int T, N, M, K, area[][], TOTAL;
//	static HashMap<Integer, cluster> clu;
////	static cluster clu[];
//	static int dir[][] = { {}, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
//	static StringTokenizer st;
//
//	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/Solution_mo_2382.txt"));
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//
//		T = Integer.parseInt(in.readLine().trim());
//		T = 1;
//		for (int test_case = 1; test_case <= T; test_case++) {
//			st = new StringTokenizer(in.readLine());
//
//			N = Integer.parseInt(st.nextToken());
//			M = Integer.parseInt(st.nextToken());
//			K = Integer.parseInt(st.nextToken());
//
//			clu = new HashMap<>();
////			clu = new cluster[K];
//			area = new int[N][N];
//			TOTAL = 0;
//
//			for (int i = 1, r, c, size, d; i <= K; i++) {
//				st = new StringTokenizer(in.readLine());
//
//				r = Integer.parseInt(st.nextToken());
//				c = Integer.parseInt(st.nextToken());
//				size = Integer.parseInt(st.nextToken());
//				d = Integer.parseInt(st.nextToken());
//
//				clu.put(i, new cluster(r, c, size, d));
//
//				area[r][c] = i;
//				TOTAL += size;
//			}
////			System.out.println(clu);
////			printMing.print(area);
//			run();
//			System.out.println(TOTAL);
//		}
//	}
//
//	private static void run() {
//		for (int m = 0; m < M; m++) {
//			for (Integer idx : clu.keySet()) {
//				cluster c = clu.get(idx);
//				System.out.println(c);
//				move(idx, clu.get(idx));
//			}
//		}
//		System.out.println();
//	}
//
//	private static void move(int idx, cluster c) {
//		int dr, dc;
//		dr = c.r + dir[c.d][0];
//		dc = c.c + dir[c.c][1];
//
//		if (check(dr, dc)) {
//			if (area[dr][dc] == 0) {
//				area[c.r][c.c] = 0;
//				c.pointChange(dr, dc);
//				area[dr][dc] = idx;
//			} else {
//				cluster c2 = clu.get(area[dr][dc]);
//				if (c.size < c2.size) {
//					c2.size += c.size;
//					clu.remove(idx);
//				} else {
//					c.size += c2.size;
//					clu.remove(area[dr][dc]);
//					area[c.r][c.c] = 0;
//					c.pointChange(dr, dc);
//					area[dr][dc] = idx;
//				}
//			}
//		} else {
//			area[c.r][c.c] = 0;
//			c.pointChange(dr, dc);
//			area[dr][dc] = idx;
//			TOTAL -= c.size;
//			c.size /= 2;
//			TOTAL += c.size;
//			c.d = changeD(c.d);
//		}
//	}
//
//	private static boolean check(int r, int c) {
//		if (r == 0 || r == N - 1 || c == 0 || c == N - 1) {
//			return false;
//		}
//		return true;
//	}
//
//	private static int changeD(int d) {
//		switch (d) {
//		case 1:
//			return 2;
//		case 2:
//			return 1;
//		case 3:
//			return 4;
//		case 4:
//			return 3;
//		}
//		return -1;
//	}
//}
