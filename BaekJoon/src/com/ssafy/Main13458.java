package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시험 감독
 *
 */
public class Main13458 {
	static int N, A[], B, C;
	static long cnt;

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine().trim());
		A = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		cnt = N;
		for (int i = 0; i < N; i++) {
			A[i] -= B;
			if (A[i] > 0) {
				cnt += A[i] / C;
				if (A[i] % C != 0) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
