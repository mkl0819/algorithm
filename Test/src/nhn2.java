import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class nhn2 {
	static int N;
	static LinkedList<Integer> FQ;
	static final int MAXN = 0;
	static int counting[][];
	static StringBuilder sb;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine().trim());

		FQ = new LinkedList<>();
		counting = new int[101][2];
		sb = new StringBuilder();

		countingInit();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			command(st.nextToken(), st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : -1);
		}
		sb.deleteCharAt(sb.lastIndexOf(" "));
		System.out.println(sb.toString());
	}

	private static void countingInit() {
		for (int i = 1; i < 101; i++) {
			counting[i][0] = i;
		}
	}

	private static void command(String com, int num) {
		switch (num) {
		// dequeue
		case -1:
			dequeue();
			break;
		// enqueue
		default:
			FQ.add(num);
			counting[num][1]++;
//			System.out.println(num+" pluse "+ Arrays.toString(counting[num]));
			break;
		}
//		System.out.println(FQ);
	}

	private static void dequeue() {
		Arrays.sort(counting, new comp());
				
		int maxCount = counting[0][1];
//		System.out.println(maxCount+" is MAX");
		
		for (Integer n : FQ) {
			for(int i=0; counting[i][1]==maxCount; i++) {
//				System.out.println(n+" --> "+Arrays.toString(counting[i]));
				if(n==counting[i][0]) {
					FQ.remove(n);
					sb.append(n).append(" ");
					counting[i][1]--;
					return;
				}
			}
		}
	}
}

class comp implements Comparator<int[]> {

	@Override
	public int compare(int[] o1, int[] o2) {
		return o2[1] - o1[1];
	}

}