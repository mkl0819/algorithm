public class mobis02 {
	static int T;

	public static void main(String[] args) throws Exception {
		int n = 10;
		int p[] = { 5, 4, 3, 2, 1, 6, 7, 8, 9, 10 };
		int p1[] = { 5, 7, 8, 2, 4, 6, 1, 8, 9, 10 };
		System.out.println(solution(n, p));
		System.out.println(solution(n, p1));
	}

	public static long solution(int n, int[] P) {
		long answer = 0;
		int min = P[0];
		
		answer = min;
		
		for(int i=1; i<n; i++) {
			if(P[i] < min) {
				min = P[i];
			}
			answer += min;
		}
		
		return answer;
	}

}
