package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

import com.ssafy.library.printMing;

public class Main_17136_색종이붙이기 {
	static int T, COUNT, paper[][], square[], area, sum;
	static TreeSet<int[]> paperSet;
	static boolean visited[][];
//	static int square[] = { 0, 5, 5, 5, 5, 5 };
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/Main_17136.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		paper = new int[12][12];
		square = new int[6];
		COUNT = Integer.MAX_VALUE - 1;

		for (int i = 1; i <= 10; i++) {
			st = new StringTokenizer(in.readLine());

			for (int j = 1; j <= 10; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
				paper[i][j] += paper[i - 1][j] + paper[i][j - 1] - paper[i - 1][j - 1];
			}
		}

		printMing.print(paper);

		area = paper[10][10];
		if(area==0) {
			System.out.println("0");
			return;
		}
//		System.out.println(area);

		sum = 0;

		combi(5);

		System.out.println(COUNT==Integer.MAX_VALUE-1?-1:COUNT);
	}

	private static void combi(int count) {
		if (sum > area) {
			return;
		}
		if (sum == area) {
			if(COUNT < square[0]) {
				return;
			}
			printMing.print(square);
			visited = new boolean[12][12];
			if(match(square, 5, square[5])) {
				COUNT = Math.min(COUNT, square[0]);
			}
			return;
		}
		if (count == 0) {
			return;
		}
		for (int i = 5, subarea = 0; i >= 0; i--) {
			square[count] = i;
			square[0] += i;
			subarea = i * (count * count);
			sum += subarea;
			combi(count - 1);
			sum -= subarea;
			square[0] -= i;
		}
	}

	private static boolean match(int sq[], int size, int count) {
		if(count==0) {
			for(int i=size; i>0; i--) {
				if(sq[i]!=0) {
					size = i;
					count = sq[i];
				}
			}
		}
//		System.out.println(size + " / "+count);
		if(size==0) {
//			System.out.println("zero");
			return true;
		}
		int onearea = size * size, tmpArea;
//		System.out.println("size : " + size);
		for (int i = 10; i > size; i--) {
			for (int j = 10; j > size; j--) {
				if(visited[i][j]) continue;
				tmpArea = paper[i][j] - paper[i - size][j] - paper[i][j - size] + paper[i - size][j - size];
				if (tmpArea == onearea) {
//					System.out.println("가능가능 " + i + " / " + j);
					visitCheck(true, i, j, size);
					match(sq, size, count-1);
					visitCheck(false, i, j, size);
					count--;
				}
			}
		}
		return false;
	}
	
	private static void visitCheck(boolean state, int r, int c, int size) {
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				visited[r-i][c-j] = state;
			}
		}
//		printMing.print(visited);
	}
	
}
