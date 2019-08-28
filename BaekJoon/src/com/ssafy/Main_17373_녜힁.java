package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_17373_녜힁 {
	static int N, M, Q, word[], K[];
	static TreeSet<String> wordSet;
	static StringTokenizer st;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		word = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			word[i] = Integer.parseInt(st.nextToken());
		}
		K = new int[Q];
		for (int i = 0; i < Q; i++) {
			K[i] = Integer.parseInt(in.readLine().trim()) - 1;
		}

		wordSet = new TreeSet<>();

		sb = new StringBuilder();
		combi(0, 0);

		int i = 0, j = 0;
		for (String nickname : wordSet) {
			if (i++ == K[j]) {
				System.out.println(nickname);
				j++;
			}
		}

		for (i = j; j < Q; j++) {
			System.out.println("-1 -1");
		}

	}

	private static void combi(int count, int start) {
		if (count == 2) {
			wordSet.add(sb.charAt(0) + " " + sb.charAt(1));
			return;

		}
		for (int i = start; i < N; i++) {
			sb.replace(count, count + 1, word[N - 1 - i] + "");
			combi(count + 1, i);
		}
	}
}
