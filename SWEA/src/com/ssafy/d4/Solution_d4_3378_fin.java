package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_d4_3378_fin {
	static int T, p, q, point;
	static HashSet<Integer> RCS;
	static int rcs[][], rcsq[][], num[];
	static char line[];
	static boolean check, get, r, c, s;
	static String str[];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Solution_d4_3378.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine().trim());
//		T = 1;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			RCS = new HashSet<Integer>();
			rcs = new int[p + 1][7];
			check = get = r = c = s = false;
			for (int i = 1; i <= p; i++) {
				line = in.readLine().toCharArray();
				check = false;
				point = 0;
				for (int j = 1; j < 7; j++) {
					rcs[i][j] = rcs[i - 1][j];
				}
				for (char ch : line) {
					switch (ch) {
					case '.':
						if (!check) {
							rcs[i][0]++;
						}
						break;
					case '(':
						r = true;
						rcs[i][1]++;
						check = true;
						break;
					case ')':
						rcs[i][2]++;
						check = true;
						break;
					case '{':
						c = true;
						rcs[i][3]++;
						check = true;
						break;
					case '}':
						rcs[i][4]++;
						check = true;
						break;
					case '[':
						s = true;
						rcs[i][5]++;
						check = true;
						break;
					case ']':
						rcs[i][6]++;
						check = true;
						break;
					default:
						check = true;
						break;
					}
				}
			}
//			print();
			getRCS();
//			System.out.println(RCS);
			rcsq = new int[q + 1][7];
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ");
			int rr, cc, ss, sum;
			check = r = c = s = false;
			for (int i = 1; i <= q; i++) {
				line = in.readLine().toCharArray();
				point = 0;
				for (int j = 1; j < 7; j++) {
					rcsq[i][j] = rcsq[i - 1][j];
				}
				for (char ch : line) {
					switch (ch) {
					case '(':
						r = true;
						rcsq[i][1]++;
						break;
					case ')':
						rcsq[i][2]++;
						break;
					case '{':
						c = true;
						rcsq[i][3]++;
						break;
					case '}':
						rcsq[i][4]++;
						break;
					case '[':
						s = true;
						rcsq[i][5]++;
						break;
					case ']':
						rcsq[i][6]++;
						break;
					}
				}
				rr = (rcsq[i - 1][1] - rcsq[i - 1][2]);
				cc = (rcsq[i - 1][3] - rcsq[i - 1][4]);
				ss = (rcsq[i - 1][5] - rcsq[i - 1][6]);
				if(rr+cc+ss==0) {
					sb.append(0).append(" ");
					continue;
				}
				int x, y, z, pre=0, cur=0;
				if(RCS.isEmpty()) {
					sb.append(-1).append(" ");
					continue;
				}
				for (int rcs : RCS) {
					if(rcs==0) {
						cur = -1;
//						sb.append(-1).append(" ");
						continue;
					}
					x = rcs / 10000;
					y = rcs % 10000 / 100;
					z = rcs % 100;
					cur = x*rr + y*cc + z*ss;
//					System.out.println(cur);
					if(pre==0) {
						pre = cur;
						continue;
					}
					if(cur!=pre) {
						cur = -1;
						break;
					}
					pre = cur;
				}
//				System.out.println();
				
				sb.append(cur).append(" ");
//				if ((rr > 0 && R.size() != 1) || (cc > 0 && C.size() != 1)
//						|| (ss > 0 && S.size() != 1)) {
//					sb.append(-1).append(" ");
//				} else {
//					sum = 0;
//					if (r) {
//						sum += (((int) R.toArray()[0]) * rr);
//					}
//					if (c) {
//						sum += (((int) C.toArray()[0]) * cc);
//					}
//					if (s) {
//						sum += (((int) S.toArray()[0]) * ss);
//					}
//					sb.append(sum).append(" ");
//				}
//				sb.append(R * (rcsq[i - 1][1] - rcsq[i - 1][2]) + C * (rcsq[i - 1][3] - rcsq[i - 1][4])
//						+ S * (rcsq[i - 1][5] - rcsq[i - 1][6])).append(" ");
			}
//			printq();
			System.out.println(sb.toString());
		}
	}

	private static void getRCS() {
		num = new int[3];
		combi(1, 0);
	}

	private static void combi(int start, int cnt) {
		if (cnt == 3) {
			int result, result2;
//			System.out.println(Arrays.toString(num));
			for (int i = 1; i < p; i++) {
				result = rcs[i + 1][0];
				result2 = 0;
				if (r) {
					result2 += (num[0] * (rcs[i][1] - rcs[i][2]));
				}
				if (c) {
					result2 += (num[1] * (rcs[i][3] - rcs[i][4]));
				}
				if (s) {
					result2 += (num[2] * (rcs[i][5] - rcs[i][6]));
				}
//				System.out.println(i + " -> " + result + " : " + result2);
				if (result != result2) {
					return;
				}
//				System.out.println(result);
			}
//			System.out.println("success");
			if (!r)
				num[0] = 0;
			if (!c)
				num[1] = 0;
			if (!s)
				num[2] = 0;
			RCS.add(num[0] * 10000 + num[1] * 100 + num[2]);
//			if (r) {
//				R.add(num[0]);
////				System.out.println(R);
//			}
//			if (c) {
//				C.add(num[1]);
////				System.out.println(C);
//			}
//			if (s) {
//				S.add(num[2]);
////				System.out.println(S);
//			}
			return;
		}
		for (int i = start; i <= 20; i++) {
			num[cnt] = i;
			combi(start, cnt + 1);
		}
	}

	private static void print() {
		for (int i = 1; i <= p; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.printf("%2d ", rcs[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void printq() {
		for (int i = 1; i <= q; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.printf("%2d ", rcsq[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
