package com.ssafy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16235 {
	static int N;
	static int M;
	static int K;
	static int[][] map;
	static int[][] init;
	static int tree;
	static LinkedList<Tree> trees, addtrees;
	static StringTokenizer st;
	static String[] str;
	static int dir[][] = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Main16235.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		init = new int[N][N];

		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = 5;
				init[i][j] = Integer.parseInt(str[j]);
			}
		}
//		print();
		trees = new LinkedList<Tree>();
		addtrees = new LinkedList<Tree>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			trees.add(new Tree(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())));
		}
//		for (int i = 0; i < M; i++) {
//			System.out.println(trees[i].toString());
//		}
//		Arrays.sort(trees, treecomp);

//		for (int i = 0; i < M; i++) {
//			System.out.println(trees[i].toString());
//		}
		for (int i = 0; i < K; i++) {
			Collections.sort(trees);
//			System.out.println(i+"년째 : "+M);
			// 봄 - 나이만큼 양분먹고 나이 증가 / 어린 나무 부터 / 못먹으면 죽음
			for(Tree t : trees) {
				if(t.life==1) {
					if(map[t.rt][t.ct]< t.age) {
						t.life = 0;
						continue;
					}
					map[t.rt][t.ct]-= t.age;
					t.age++;
				}
			}
//			System.out.println("봄");
//			print();
			// 여름 - 죽은 나무 양분으로
			for(Tree t:trees) {
				addtrees.clear();
				if(t.life==0) {
					map[t.rt][t.ct]  += t.age/2;
					t.life--;
				}else {
					int r, c, dr, dc;
					if(t.life==1 && t.age%5==0) {
						r = t.rt;
						c= t.ct;
						for(int k=0; k<8; k++) {
							dr = r+dir[k][0];
							dc = c+dir[k][1];
							if(check(dr, dc)) {
								addtrees.add(new Tree(dr, dc, 1));
							}
						}
					}
				}
			}
//			System.out.println("여름");
//			print();
			// 가을 - 나이가 5 배수이면 번식
			
//			System.out.println("가을");
//			print();
			// 겨울 - 양분추가 입력받기
			for (int n = 0; n < N; n++) {
//				str = br.readLine().split(" ");
				for (int m = 0; m < N; m++) {
					map[n][m] += init[n][m];
				}
			}
//			System.out.println("겨울");
//			print();
//			System.out.println();
		}
		int cnt = 0;
//		System.out.println(M+"  dddd");
		for(Tree t:trees) {
			if(t.life==1) {
				cnt++;
			}
		}
		System.out.println(cnt);

	}

	public static boolean check(int r, int c) {
		if (r < 0 || c < 0 || r >= N || c >= N) {
			return false;
		}
		return true;
	}

	public static class Tree implements Comparable<Tree> {
		public int rt;
		public int ct;
		public int age;
		public int life;

		public Tree(int rt, int ct, int age) {
			super();
			this.rt = rt;
			this.ct = ct;
			this.age = age;
			this.life = 1;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Tree [rt=").append(rt).append(", ct=").append(ct).append(", age=").append(age).append("]");
			return builder.toString();
		}

		@Override
		public int compareTo(Tree t2) {
			if (rt != t2.rt) {
				return rt - t2.rt;
			} else if (ct != t2.ct) {
				return ct - t2.ct;
			}
			return age - t2.age;
		}

	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
