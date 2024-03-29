package com.ssafy.mo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

class cluster {
	int num, r, c, size, d;

	public cluster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public cluster(int num, int r, int c, int size, int d) {
		this.num = num;
		this.r = r;
		this.c = c;
		this.size = size;
		this.d = d;
	}

	public void pointChange(int dr, int dc) {
		this.r = dr;
		this.c = dc;
	}

	@Override
	public String toString() {
		return "cluster " + num + " : [r=" + r + ", c=" + c + ", size=" + size + ", d=" + d + "]";
	}

}

class sizeSort implements Comparator<cluster> {

	@Override
	public int compare(cluster o1, cluster o2) {
		return o2.size - o1.size;
	}

}

public class Solution_mo_2382_미생물격리 {
	static int T, N, M, K, area[][];
	static long TOTAL;
//	static HashMap<Integer, cluster> clu;
	static LinkedList<cluster> clu;
//	static cluster clu[];
	static int dir[][] = { {}, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_mo_2382.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
//		T = 1;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			clu = new LinkedList<cluster>();
			area = new int[N][N];
			TOTAL = 0;

			for (int i = 1, r, c, size, d; i <= K; i++) {
				st = new StringTokenizer(in.readLine());

				r = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				size = Integer.parseInt(st.nextToken());
				d = Integer.parseInt(st.nextToken());

				clu.offer(new cluster(i, r, c, size, d));

				area[r][c] = i;
				TOTAL += size;
			}
//			printMing.print(area);
//			print();
//			System.out.println(TOTAL);

			run();
//			print();

			System.out.println("#"+test_case+" "+TOTAL);
		}
	}

	private static void print() {
		for (cluster c : clu) {
			System.out.println(c.toString());
		}
		System.out.println();
	}

	private static void run() {
		for (int m = 0; m < M; m++) {
			Collections.sort(clu, new sizeSort());
//			print();

			for (cluster c : clu) {
				move(c);
			}
			area = new int[N][N];
			for (int i = 0, j = 0, size=clu.size(); j < size; j++) {
				cluster c = clu.get(i);
//				System.out.println(c.toString());
				if (area[c.r][c.c] == 0) {
					area[c.r][c.c] = c.num;
					i++;
				} else {
					int big = area[c.r][c.c];
					for (cluster bc : clu) {
						if (bc.num == big) {
							bc.size += c.size;
							break;
						}
					}
//					bigC.size += c.size;
					clu.remove(i);
//					System.out.println("delete");
				}
			}
//			merge();

		}
	}

	private static void move(cluster c) {
		int dr, dc;
		dr = c.r + dir[c.d][0];
		dc = c.c + dir[c.d][1];

		if (check(dr, dc)) {
			c.pointChange(dr, dc);
		} else {
			c.pointChange(dr, dc);
			TOTAL -= c.size;
			c.size /= 2;
			TOTAL += c.size;
			c.d = changeD(c.d);
		}
	}

	private static boolean check(int r, int c) {
		if (r == 0 || r == N - 1 || c == 0 || c == N - 1) {
			return false;
		}
		return true;
	}

	private static int changeD(int d) {
		switch (d) {
		case 1:
			return 2;
		case 2:
			return 1;
		case 3:
			return 4;
		case 4:
			return 3;
		}
		return -1;
	}
}
