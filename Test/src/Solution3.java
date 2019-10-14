import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3 {
	static StringTokenizer st;
	static int msgSize, consumerSize, time[];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		msgSize = Integer.parseInt(st.nextToken());
		consumerSize = Integer.parseInt(st.nextToken());
		time = new int[msgSize];
		for (int i = 0; i < msgSize; i++) {
			time[i] = Integer.parseInt(in.readLine().trim());
		}
	}
}
