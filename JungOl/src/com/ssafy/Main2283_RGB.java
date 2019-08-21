package com.ssafy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2283_RGB {
	static int N;
	static int RGB[][];
	static int sum;

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Main2283.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		RGB = new int[N + 1][3];
		
		int a, b;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 3; j++) {
				if( j==0) {
					a=1;b=2;
				}else if(j==1) {
					a=0;b=2;
				}else {
					a=0;b=1;
				}
				RGB[i][j] = Math.min(RGB[i-1][a], RGB[i-1][b]) + Integer.parseInt(st.nextToken());
			}
		}
		Arrays.sort(RGB[N]);
		System.out.println(RGB[N][0]);
	}

	private static void print() {
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(RGB[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
