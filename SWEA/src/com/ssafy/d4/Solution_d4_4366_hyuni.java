package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_d4_4366_hyuni {

	static long Answer;
	static StringBuilder twoJinsu = new StringBuilder();
	static StringBuilder threeJinsu = new StringBuilder();
	static ArrayList<Long> store = new ArrayList<>();
	
	public static void makeSet() {
		int size = twoJinsu.length();
		char tmpChar;
		String tmpStr;
		
		for(int i = 0; i < size; i++) {
			tmpChar = twoJinsu.charAt(i);
			
			if(tmpChar == '0') {
				twoJinsu.replace(i, i+1, "1");
				tmpStr = twoJinsu.toString();
				store.add(Long.parseLong(tmpStr, 2));
				twoJinsu.replace(i, i+1, "0");				// 원상복구
			}else {
				twoJinsu.replace(i, i+1, "0");
				tmpStr = twoJinsu.toString();
				store.add(Long.parseLong(tmpStr, 2));
				twoJinsu.replace(i, i+1, "1");				// 원상복구
			}

		}
	}
	
	public static boolean isOK(long num) {
		int size = store.size();
		
		for(int i = 0; i < size; i++) {
			if(num == store.get(i)) {
				Answer = num;
				return true;
			}
		}
		
		return false;
	}
	
	public static void findNum() {
		int size = threeJinsu.length();
		char tmpChar;
		String tmpStr;
		
		for(int i = 0; i < size; i++) {
			tmpChar = threeJinsu.charAt(i);
			if(tmpChar == '0') {
				threeJinsu.replace(i, i+1, "1");
				tmpStr = threeJinsu.toString();
				if(isOK(Long.parseLong(tmpStr, 3))) {
					return;
				}
				
				threeJinsu.replace(i, i+1, "2");
				tmpStr = threeJinsu.toString();
				
				if(isOK(Long.parseLong(tmpStr, 3))) {
					return;
				}
				
				threeJinsu.replace(i, i+1, "0");
			}else if(tmpChar == '2'){
				threeJinsu.replace(i, i+1, "1");
				tmpStr = threeJinsu.toString();
				
				if(isOK(Long.parseLong(tmpStr, 3))) {
					return;
				}
				
				threeJinsu.replace(i, i+1, "0");
				tmpStr = threeJinsu.toString();
				
				if(isOK(Long.parseLong(tmpStr, 3))) {
					return;
				}
				
				threeJinsu.replace(i, i+1, "2");
			}else if(tmpChar == '1') {	// 처리 복잡
				// case 1. 2로 변경해주기
				threeJinsu.replace(i, i+1, "2");
				tmpStr = threeJinsu.toString();
				
				if(isOK(Long.parseLong(tmpStr, 3))) {
					return;
				}
				
				// case 2. 0으로 변경해주기
				threeJinsu.replace(i, i+1, "0");
				tmpStr = threeJinsu.toString();
				
				if(isOK(Long.parseLong(tmpStr, 3))) {
					return;
				}
				
				// 원상복구
				threeJinsu.replace(i, i+1, "1");
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine().trim());
		String line;
		
		for (int testcase = 1; testcase <= TC; testcase++) {
			line = br.readLine().trim();
			twoJinsu.append(line);
			
			line = br.readLine().trim();
			threeJinsu.append(line);
			
			// Init
			Answer = 0;
			
			// Sol
			makeSet();	// 2진수를 변환하여 후보군 구성
			findNum();	// 값 찾기
			
//			for(int i = 0; i < store.size(); i++) {
//				System.out.print(store.get(i) + " ");
//			}
//			System.out.println();
			
			store.clear();
			twoJinsu.setLength(0);
			threeJinsu.setLength(0);
			System.out.println("#" + testcase + " " + Answer);
		}
	}
}