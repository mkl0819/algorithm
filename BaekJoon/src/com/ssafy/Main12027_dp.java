package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main12027_dp {
	static int N;
	static String str;
	static int[] d;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine().trim());
		str = in.readLine();
		d = new int[N];
		Arrays.fill(d, -1);
		
		
		
		System.out.println(go(0));
	}

	private static int go(int index) {

		// index -> ... -> N-1 ( minimun energy )
		if (index == N - 1) {
			return 0;
		}
		if(d[index]!=-1){
			return d[index];
		}

		// index -> ?
		char next_char = get_next(str.charAt(index));
		int ans = -1;
		for (int j = index + 1; j < N; j++) {
			if (str.charAt(j) == next_char) {
				// index -> j-> .. ->n-1
				// --------------------
				// (j-index)^2 go(j)
				// d[index = min((j-index)^2 +go(j))
				// index < j && s[index] -> s[j]
				int temp = go(j);
				if (temp != -1) {
					int val = (j - index) * (j - index) + temp;
					if (ans == -1 || ans > val) {
						ans = val;
					}
				}
			}
		}
		d[index] = ans;
		return ans;
	}

	static char get_next(char cur) {
		if (cur == 'B')
			return 'O';
		else if (cur == 'O')
			return 'J';
		else
			return 'B';
	}
}
