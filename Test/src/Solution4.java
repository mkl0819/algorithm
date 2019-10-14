import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4 {
	static int len, space, MAX;
	static boolean start, end;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		len = Integer.parseInt(in.readLine().trim());

		st = new StringTokenizer(in.readLine());
		space = 1;
		MAX = 0;
		for (int i = 0; i < len; i++) {
			switch (Integer.parseInt(st.nextToken())) {
			case 0:
				if(i==0) {
					start = true;
				}
				if(i==len-1) {
					end = true;
				}
				space++;
				break;
			case 1:
				if(start) {
					space = space*2 -1;
				}
				MAX = Math.max(MAX, space);
				space = 1;
				break;
			}
			if(end) {
				space = space*2 -1;
				MAX = Math.max(MAX, space);

			}
		}
		System.out.println(MAX / 2);
	}
}
