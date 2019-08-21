package com.ssafy.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_d5_8191_만화책정렬하기2 {
	static int T, N, num;
	static LinkedList<Integer> list;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d5_8191.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine().trim());
			list = new LinkedList<>();
			st = new StringTokenizer(in.readLine());
			for(int i=0; i<N; i++) {
				num = Integer.parseInt(st.nextToken());
				if(list.contains(num-1)) {
					list.remove(num-1);
				}
				list.add(num);
			}
			System.out.println("#"+test_case+" "+list.size());
		}
	}
}
