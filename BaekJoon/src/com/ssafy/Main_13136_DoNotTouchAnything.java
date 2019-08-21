package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_13136_DoNotTouchAnything {
	static int R, C, N;
	static BigInteger answer;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		R = R % N == 0 ? R / N : R / N + 1;
		C = C % N == 0 ? C / N : C / N + 1;
		answer = BigInteger.ONE.multiply(BigInteger.valueOf(R)).multiply(BigInteger.valueOf(C));
		System.out.println(answer);
	}
}
