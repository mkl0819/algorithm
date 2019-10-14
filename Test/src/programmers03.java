public class programmers03 {
	static int L, sum;

	public static void main(String[] args) throws Exception {
		int[] sticker = { 12, 12, 12, 12, 12 };
		System.out.println(solution(sticker));

		int[] sticker2 = { 12, 80, 14, 22, 100, 12, 12, 12, 45};
		System.out.println(solution(sticker2));

	}

	public static int solution(int[] sticker) {
		int answer = 0, len = sticker.length;
		int dp[][] = new int [3][len];

		dp[0][0] = sticker[0];

		for(int i=1; i<len; i++) {
			dp[0][i] = sticker[i] + Math.max(dp[1][i-1], dp[2][i-1]);
			dp[1][i] = Math.max(dp[0][i-1], dp[1][i-1]);
			dp[2][i] = Math.max(dp[1][i-1], dp[2][i-1]);
		}
		len--;
		for(int i=0; i<3; i++) {
			answer = Math.max(answer, dp[i][len]);
		}

		return answer;
	}

}
