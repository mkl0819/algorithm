package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Solution_d4_7701_염라대왕의이름정렬 {
	static int T, N;
//	static TreeSet<String> nameSet[] = new TreeSet[50];
	static List<TreeSet<String>> nameSet;
	
	static String s;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d4_7701.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine().trim());
				
			nameSet = new ArrayList<TreeSet<String>>();
			
			for(int i=0; i<50; i++) {
				nameSet.add(new TreeSet<String>());
			}

			for(int i=0; i<N; i++) {
				s = in.readLine();
				nameSet.get(s.length()-1).add(s);
			}
			
			System.out.println("#"+test_case);
			
			for(int i=0; i<50; i++) {
				for(String s : nameSet.get(i)) {
					System.out.println(s);
				}
			}
		}
	}
}
