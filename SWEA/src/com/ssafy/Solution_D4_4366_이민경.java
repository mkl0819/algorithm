package com.ssafy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D4_4366_이민경 {
	static int T;
	static long bi[], tri[];
	static String binary, trinary;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/Solution_d4_4366.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine().trim());
		for(int test_case=1; test_case<=T;test_case++) {
			binary = in.readLine();
			trinary =in.readLine();
			
			bi = new long[binary.length()];
			tri = new long[trinary.length()*2];
			sb = new StringBuilder();
			getbi();
			sb = new StringBuilder();
			gettri();
			
			System.out.println(Arrays.toString(bi));
			System.out.println(Arrays.toString(tri));
			System.out.println("#"+test_case+" "+getNum());
		}
	}

	private static long getNum() {
		for(int i=0, I = bi.length; i<I; i++) {
			for(int j=0, J=tri.length; j<J; j++) {
				if(bi[i]==tri[j]) {
					return bi[i];
				}
			}
		}
		return -1;
	}

	private static void gettri() {
		for(int i=0, cnt = 0, size = trinary.length(); i<size; i++) {
			sb.delete(0, size);
			sb.append(trinary);
			for(int j=0; j<3; j++) {
				if(Long.parseLong( trinary.charAt(i)+"" )==j) {
					continue;
				}
				sb.replace(i, i+1, j+"");
				tri[cnt++] = Integer.parseInt(sb.toString(), 3);
			}
		}
	}

	private static void getbi() {
		for(int i=0, size = bi.length; i<size; i++	) {
			sb.delete(0, size);
			sb.append(binary);
			sb.replace(i, i+1, (1-(binary.charAt(i)-'0'))+"");
			bi[i] = Long.parseLong(sb.toString(), 2);
		}
	}
}
