package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import com.ssafy.library.printMing;

public class Solution_d4_6959_이상한나라의덧셈게임 {
	static int T, count;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d4_6959.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
//		T = 1;
		for (int test_case = 1; test_case <= T; test_case++) {
			count = 0;
			getResult(in.readLine().toCharArray());
//			sb= new StringBuilder();
//			for(int i=0; i<1000; i++) {
//				sb.append("9");
//			}
//			System.out.println("start");
//			getResult(sb.toString().toCharArray());
//			System.out.println("end");
			System.out.println(count);
			System.out.println("#" + test_case + " " + (count % 2 == 1 ? 'A' : 'B'));
		}
	}

	private static void getResult(char[] num) {
		sb = new StringBuilder();
		int i = 0, size = num.length;
		System.out.println(size);
		if(size ==1) {
			return;
		}
		for ( ; i < size-1; i += 2) {
			sb.append(((num[i] - '0') + (num[i+1] - '0')));
			count++;
		}
		if(size%2==1) {
			sb.append((num[size-1]-'0'));
		}
//		if(sb.length()==1) {
//			return;
//		}
		getResult(sb.toString().toCharArray());
	}

}
