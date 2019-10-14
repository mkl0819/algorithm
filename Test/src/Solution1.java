import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1 {
	static StringTokenizer st;
	static int consumer[], conSize, msgSize, msg;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(in.readLine());

		msgSize = Integer.parseInt(st.nextToken());
		conSize = Integer.parseInt(st.nextToken());

		consumer = new int[conSize];

		for (int i = 0; i < msgSize; i++) {
			msg = Integer.parseInt(in.readLine().trim());
			if (i > 0) {
				Arrays.sort(consumer);
			}
			consumer[0] += msg;
		}

		Arrays.sort(consumer);

		System.out.println(consumer[conSize - 1]);
	}
}
