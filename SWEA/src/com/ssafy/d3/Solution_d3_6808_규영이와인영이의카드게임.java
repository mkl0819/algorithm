package com.ssafy.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import com.ssafy.library.printMing;

public class Solution_d3_6808_규영이와인영이의카드게임 {
	static int T, GY[], IY[], card[], win, lose;
	static boolean IYcard[];
	
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d3_6808.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		T=1;
		for (int test_case = 1; test_case <= T; test_case++) {
			GY = new int[9];
			IY = new int[9];
			IYcard = new boolean[18];
			
			st = new StringTokenizer(in.readLine());
			for(int i=0; i<9; i++) {
				GY[i] = Integer.parseInt(st.nextToken())-1;
				IYcard[GY[i]] = true;
			}
			printMing.print(GY);
			for(int i=0, j=0; i<18; i++) {
				if(!IYcard[i]) {
					IY[j++] = i;
				}
			}
			printMing.print(IY);
		}
	}
}
