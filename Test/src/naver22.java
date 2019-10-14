import java.util.Arrays;

public class naver22 {
	static int T;

	public static void main(String[] args) throws Exception {
		int n = 9;
		System.out.println((solution(n)));
	}

	private static long solution(int n) {

		return n * (n - 1);
	}
}
