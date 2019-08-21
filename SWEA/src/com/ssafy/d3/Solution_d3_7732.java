package com.ssafy.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 7732. 시간 개념
 * 
 * 입력
 * 3
 * 00:00:00
 * 23:59:59
 * 23:59:59
 * 00:00:00
 * 03:29:35
 * 15:01:52
 * 
 * 출력
 * #1 23:59:59
 * #2 00:00:01
 * #3 11:32:17
 */
public class Solution_d3_7732 {
	static int T;
	static String[] tmp;
	static int start[], end[];
//	static int start[], end[];
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d3_7732.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case <= T; test_case++) {
			start = new int[3];
			end = new int[3];
			
			tmp = br.readLine().split(":");
			
			start[0] = Integer.parseInt(tmp[0]);
			start[1] = Integer.parseInt(tmp[1]);
			start[2] = Integer.parseInt(tmp[2]);
			
			tmp = br.readLine().split(":");
			
			end[0] = Integer.parseInt(tmp[0]);
			end[1] = Integer.parseInt(tmp[1]);
			end[2] = Integer.parseInt(tmp[2]);
			
			
			if(IsTomorrow(0)) {
				end[0] += 24;
			}
			
			getTime(2);
			
			
			sb = new StringBuilder();
			
			sb.append('#').append(test_case).append(' ');
			getResult(0);
			
			System.out.println(sb.toString());
		}
	}

	private static void getResult(int index) {
		end[index] -= start[index];
		
		if(end[index] < 10) {
			sb.append('0');
		}
		sb.append(end[index]);
		
		switch(index) {
		case 0:
		case 1:
			sb.append(':');
			break;
		case 2:
			return;
		}		
		getResult(index+1);
	}

	private static void getTime(int index) {
		if(end[index] < start[index]) {
			end[index] += 60;
			end[index-1] -= 1;
		}
		if(index==0) return;
		getTime(index-1);
	}

	private static boolean IsTomorrow(int index) {
		if(start[index] > end[index]) {
			return true;
		} else if (start[index] == end[index]) {
			return IsTomorrow(index+1);
		} else {
			return false;
		}
	}
}
