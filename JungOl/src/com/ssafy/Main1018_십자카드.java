package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1018_십자카드{
	static int num;
	static int cnum;
	static int ANS;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());

		num = 0;

		for (int i = 0; i < 4; i++) {
			num = num * 10 + Integer.parseInt(st.nextToken());
		}
		num = num * 1000 + num / 10;
		System.out.println(num);

		getCnum();

		System.out.println(cnum);
		System.out.println();
		getIndex();

//		System.out.println();
//		System.out.println(cnum % 10);
//		System.out.println(cnum % 100 / 10);
//		System.out.println(cnum % 1000 / 100);
//		System.out.println(cnum % 10000 / 1000);
		System.out.println(ANS);
	}

	private static void getIndex() {
		ANS = 0;
		int tmp;
		for (int i = 1; i <= 1000; i *= 10) {
			tmp = (cnum % (i * 10) / i);
			if (tmp == 1) {
				break;
			}
			ANS = ANS * 10 + (tmp - 1);
			System.out.println(ANS);
		}
	}

	private static int getCnum() {
		cnum = Integer.MAX_VALUE;
		for (int i = 1000; i >= 1; i /= 10) {
			cnum = Math.min(cnum, (num % (10000 * i) / i));
			System.out.println((num % (10000 * i) / i));
		}
		return cnum;
	}
}
