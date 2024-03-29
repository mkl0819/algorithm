package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Solution_d4_7792_반장선출 {
	static int T, N, alpha1, alpha2, CNT;
	static TreeSet<String> nameSet;
	static boolean alpha[];
//	static String name;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d4_7792.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine().trim());
			
			alpha = new boolean[27];
			nameSet = new TreeSet<>(new Comparator<String>() {

				@Override
				public int compare(String name1, String name2) {
					alpha1 = getAlpha(name1);
					alpha2 = getAlpha(name2);
					
					if(alpha1 == alpha2) {
						return name1.compareTo(name2);
					}
					
					return alpha2-alpha1;
				}

				
			});
			
			for(int i=0; i<N; i++) {
				nameSet.add(in.readLine());
			}
			
			System.out.println("#"+test_case+" "+nameSet.first());
		}
	}

	protected static int getAlpha(String name) {
		Arrays.fill(alpha, false);
		CNT = 0;
		
		for(char c:name.toCharArray()) {
			if(c==' ') {
				continue;
			}
			if(!alpha[c-'A']) {
				alpha[c-'A'] = true;
				CNT++;
			}
		}
		return CNT;
	}
}
