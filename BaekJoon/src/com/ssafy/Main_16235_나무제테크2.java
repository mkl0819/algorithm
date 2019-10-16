//package com.ssafy;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.LinkedList;
//import java.util.StringTokenizer;
//
//import com.ssafy.library.printMing;
//
//public class Main_16235_나무제테크2 {
//	static int N, M, K, map[][], feed[][];
//	static int dir[][] = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
//
//	static LinkedList<Tree> trees;
//
//	static StringTokenizer st;
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//
//		st = new StringTokenizer(in.readLine());
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		K = Integer.parseInt(st.nextToken());
//
//		map = new int[N][N];
//		feed = new int[N][N];
//
//		init();
//
//		trees = new LinkedList<>();
//
//		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(in.readLine());
//			for (int j = 0; j < N; j++) {
//				feed[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//
//		for (int i = 0, r = 0, c = 0, age = 0; i < M; i++) {
//			st = new StringTokenizer(in.readLine());
//			r = Integer.parseInt(st.nextToken()) - 1;
//			c = Integer.parseInt(st.nextToken()) - 1;
//			age = Integer.parseInt(st.nextToken());
//			trees.add(new Tree(r, c, age));
//		}
//
//		for (int i = 0; i < K; i++) {
//			Collections.sort(trees);
//
//			year();
//		}
//		System.out.println(trees.size());
//	}
//
//	private static void year() {
//		springAndSummer();
//		fall();
//		winter();
//	}
//
//	private static void winter() {
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				map[i][j] += feed[i][j];
//			}
//		}
//	}
//
//	private static boolean check(int r, int c) {
//		if (r == -1 || c == -1 || r == N || c == N)
//			return false;
//		return true;
//	}
//
//	private static void fall() {
//		for (int i = 0, r = 0, c = 0, size = trees.size(); i < size; i++) {
//			if (trees.get(i).age % 5 == 0) {
//				r = trees.get(i).r;
//				c = trees.get(i).c;
//				for (int d = 0, dr = 0, dc = 0; d < 8; d++) {
//					dr = r + dir[d][0];
//					dc = c + dir[d][1];
//					if (check(dr, dc)) {
//						trees.add(new Tree(dr, dc, 1));
//					}
//				}
//			}
//		}
//	}
//
//	private static void springAndSummer() {
//
//		for (int i = 0, feed = 0, r = 0, c = 0, age = 0, size = trees.size(); i < size; i++) {
//			r = trees.get(i).r;
//			c = trees.get(i).c;
//			age = trees.get(i).age;
//			feed = map[r][c];
//			if (feed < age) {
//				trees.get(i).death = true;
//			} else {
//				map[r][c] -= age;
//				trees.get(i).age++;
//			}
//		}
//
//		for (int i = 0; i < trees.size(); i++) {
//			if (trees.get(i).death) {
//				map[trees.get(i).r][trees.get(i).c] += (trees.get(i).age / 2);
//				trees.remove(trees.get(i));
//				i--;
//			}
//		}
//
//	}
//
//	private static void init() {
//		for (int i = 0; i < N; i++) {
//			Arrays.fill(map[i], 5);
//		}
//	}
//}
//
//class Tree implements Comparable<Tree> {
//	int r, c, age;
//	boolean death;
//
//	public Tree(int r, int c, int age) {
//		super();
//		this.r = r;
//		this.c = c;
//		this.age = age;
//		this.death = false;
//	}
//
//	@Override
//	public String toString() {
//		return "\nTree [r=" + r + ", c=" + c + ", age=" + age + "]";
//	}
//
//	@Override
//	public int compareTo(Tree o) {
//		if (this.r == o.r) {
//			if (this.c == o.c) {
//				return this.age - o.age;
//			}
//			return this.c - o.c;
//		}
//		return this.r - o.r;
//	}
//
//}
