package com.ssafy;

import com.ssafy.Solution_1768_숫자야구게임.Result;
import com.ssafy.library.printMing;

class UserSolution {
	public final static int N = 4, FALSE = -1, TRUE = 1;
	public final static String Solution = "Solution_1768_숫자야구게임";

	public int[] guess_digits = new int[10];

	public void doUserImplementation(int guess[]) {
//		printMing.print(guess);
		Result result;
		int[] t = {8, 9, 7, 5};

//		for (int i = 0, j = 0; i < 10; i++, j++) {
//			guess[j] = t[i];
//			if (i % 4 == 3) {
//				printMing.print(guess);
////				result = Solution_1768_숫자야구게임.query(guess);
//				if(resultCheck(guess, Solution_1768_숫자야구게임.query(guess))) {
//					System.out.println(Arrays.toString(guess));
//					return;
//				}
//				j = -1;
//
//			}
//		}
		for(int i=0, j=0, cnt=0; cnt<20; j++, cnt++) {
			i = cnt%4;
			guess[i] = j;
			if(j==9) {
				j = -1;
			}
			if(i==3) {
				printMing.print(guess);
				print(Solution_1768_숫자야구게임.query(guess));
				System.out.println("//");
			}
		}
	}

	private boolean resultCheck(int[] guess, Result result) {
		print(result);
		if(result.strike==4) {
			return true;
		}
		if (result.strike == 0 && result.ball == 0) {
			for(int i=0; i<N; i++) {
				guess_digits[guess[i]] = FALSE;
			}
			printMing.print(guess_digits);
		}
		return false;
	}

	private void print(Result result) {
		System.out.println("RESULT : " + result.strike + " S " + result.ball + " B ");
	}
}