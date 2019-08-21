package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

import com.ssafy.library.printMing;

public class Solution_d4_6907_단위변환기프로그램 {
	static int T, multiplier, dot;
	static String value, prefix, unit;

	static HashMap<String, Integer> prefixMap;
	static StringTokenizer st;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d4_6907.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		init();
		sb = new StringBuilder();
		T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
//			System.out.println(test_case + "=============");
			sb.append("#").append(test_case).append(" ");
			st = new StringTokenizer(in.readLine());
			

			if (st.countTokens() == 3) {
				value = st.nextToken();
				prefix = st.nextToken();
				unit = st.nextToken();
			} else {
				value = st.nextToken();
				prefix = "zero";
				unit = st.nextToken();
			}

			multiplier = prefixMap.get(prefix);
//			printMing.print(prefix, multiplier);

			sb.append(getValue(value)).append(" * 10^").append(multiplier).append(' ').append(unit);
			
			

			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

	private static String getValue(String value) {
		StringBuilder tmp = new StringBuilder();
		if (!value.contains("0.")) {
			dot = value.indexOf(".");
			if (dot == -1) {
//				System.out.println("dot 없는 양수");
				tmp.append(value);
				tmp.insert(1, '.');
//				System.out.println(tmp.toString());
				dot = tmp.length()-2;
//				System.out.println(tmp.length() - 2);
			} else {
//				System.out.println("dot 있는 양수");

				tmp.append(value);
				tmp.deleteCharAt(dot);
				tmp.insert(1, '.');
//				System.out.println(tmp.toString());
				dot = dot - 1;
//				System.out.println(dot - 1);
			}
			multiplier += dot;
		} else {
//			System.out.println("dot 있는 실수");
			dot = value.indexOf('.');
			for (char c : value.substring(dot + 1).toCharArray()) {
				if (c != '0') {
					tmp.append(value.substring(value.indexOf(c)));
					if (tmp.length() >= 2) {
						tmp.insert(1, '.');
					}
//					System.out.println(tmp.toString());
					dot = (value.indexOf(c)-dot);
//					System.out.println("dot구하기 : " + (value.indexOf(c)-dot));
					break;
				}
			}
			multiplier -= dot;
		}
		return tmp.toString();
	}

	private static void init() {
		prefixMap = new HashMap<>();
		prefixMap.put("yotta", 24);
		prefixMap.put("zetta", 21);
		prefixMap.put("exa", 18);
		prefixMap.put("peta", 15);
		prefixMap.put("tera", 12);
		prefixMap.put("giga", 9);
		prefixMap.put("mega", 6);
		prefixMap.put("kilo", 3);
		prefixMap.put("hecto", 2);
		prefixMap.put("deca", 1);
		prefixMap.put("zero", 0);
		prefixMap.put("deci", -1);
		prefixMap.put("centi", -2);
		prefixMap.put("milli", -3);
		prefixMap.put("micro", -6);
		prefixMap.put("nano", -9);
		prefixMap.put("pico", -12);
		prefixMap.put("femto", -15);
		prefixMap.put("ato", -18);
		prefixMap.put("zepto", -21);
		prefixMap.put("yocto", -24);
	}
}
