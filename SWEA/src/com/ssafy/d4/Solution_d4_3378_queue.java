package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_d4_3378_queue {
	static int T, p, q, R, C, S, type, cnt;
	static Queue<Character> PQ;
	static char line[];
	static boolean check, checkR, checkC, checkS;
	static String str[];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d4_3378.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
		T = 1;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			PQ = new LinkedList<Character>();
			for (int i = 0; i < p; i++) {
				line = in.readLine().toCharArray();
				check = false;
				for (char c : line) {
					switch (c) {
					case '.':
						if (!check) {
//							point++;
							PQ.offer(c);
						}
						break;
					case '(':
					case '{':
					case '[':
					case ')':
					case '}':
					case ']':
						check = true;
						PQ.offer(c);
					}
				}
				PQ.offer('/');
			}
			System.out.println(PQ);
			R = C = S = 0;
			type = 0;
			cnt = 0;
			while (!PQ.isEmpty()) {
				switch (PQ.poll()) {
				case '(':
					checkR = true;
					break;
				case '{':
					checkC = true;
					if(checkR) {
						C=cnt-R;
					}else {
						C = cnt;
					}
					cnt=0;
					break;
				case '[':
					checkS = true;
					if(checkC) {
						S = cnt -R-C;
					}else if(checkR) {
						
					}
					if(type==0) {
						S = cnt-R-C;
					}
					if(type==1) {
						S = cnt-R;
						cnt=0;
					}
					if(type ==2) {
						S = cnt;
						cnt=0;
					}
					type = 3;
					break;
				case ')':
					if (type == 1) {
						R = cnt;
						cnt = 0;
					}
					break;
				case '}':
				case ']':
					break;
				case '.':
					cnt++;
					break;
				}
			}
		}
	}

}
