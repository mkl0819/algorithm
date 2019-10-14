import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution6 {
	static final int TOP = 1, BOTTOM = 2, MIDDLE = 3;
	static final int FIRST = 1, LINE = 2, LAST = 3, BOTH = 4, EMPTY = 5;
	static int N, sortType, MaxC, MaxR;
	static int[] Csize;
	static String[] numbers;

	static StringTokenizer st;
	static StringBuilder[] sb;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		switch (st.nextToken()) {
		case "TOP":
			sortType = TOP;
			break;
		case "BOTTOM":
			sortType = BOTTOM;
			break;
		case "MIDDLE":
			sortType = MIDDLE;
			break;
		}
		Csize = new int[N];
		MaxC = -1;
		numbers = new String[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			Csize[i] = Integer.parseInt(st.nextToken());
			numbers[i] = st.nextToken();
			if (MaxC < Csize[i]) {
				MaxC = Csize[i];
			}
		}
		MaxR = 2 * MaxC - 1;

		sb = new StringBuilder[MaxR];
		for (int i = 0; i < MaxR; i++) {
			sb[i] = new StringBuilder();
		}

		for (int i = 0; i < N; i++) {
			makeOutPut(Csize[i], numbers[i]);
		}

		for (int i = 0; i < MaxR; i++) {
			System.out.println(sb[i].toString());
		}
	}

	private static void makeOutPut(int C, String numlist) {
		int startR = 0, R;
		R = (2 * C) - 1;
		switch (sortType) {
		case TOP:
			startR = 0;
			break;
		case BOTTOM:
			startR = MaxR - R;
			break;
		case MIDDLE:
			startR = (MaxR - R) / 2;
			break;
		}

		for (char c : numlist.toCharArray()) {
			for (int i = 0; i < startR; i++) {
				sb[i].append(putline(EMPTY, C));
			}
			addNumber(startR, R, C, c - '0');
			for (int i = startR + R; i < MaxR; i++) {
				sb[i].append(putline(EMPTY, C));
			}
		}

	}

	private static void addNumber(int startr, int r, int c, int num) {
		int mid = startr +( r / 2);

		switch (num) {
		case 0:
			sb[startr].append(putline(LINE, c));
			for (int i = startr + 1, endr = startr + r - 1; i < endr; i++) {
				sb[i].append(putline(BOTH, c));
			}
			sb[startr + r - 1].append(putline(LINE, c));
			break;
		case 1:
			for (int i = startr, endr = startr + r; i < endr; i++) {
				sb[i].append(putline(LAST, c));
			}
			break;
		case 2:
			sb[startr].append(putline(LINE, c));
			for (int i = startr + 1; i < mid; i++) {
				sb[i].append(putline(LAST, c));
			}
			sb[mid].append(putline(LINE, c));
			for (int i = mid + 1, endr = startr + r - 1; i < endr; i++) {
				sb[i].append(putline(FIRST, c));
			}
			sb[startr + r - 1].append(putline(LINE, c));
			break;
		case 3:
			sb[startr].append(putline(LINE, c));
			for (int i = startr + 1; i < mid; i++) {
				sb[i].append(putline(LAST, c));
			}
			sb[mid].append(putline(LINE, c));
			for (int i = mid + 1, endr = startr + r - 1; i < endr; i++) {
				sb[i].append(putline(LAST, c));
			}
			sb[startr + r - 1].append(putline(LINE, c));
			break;
		case 4:
			for (int i = startr; i < mid; i++) {
				sb[i].append(putline(BOTH, c));
			}
			sb[mid].append(putline(LINE, c));
			for (int i = mid+1, endr = startr + r ; i < endr; i++) {
				sb[i].append(putline(LAST, c));
			}
			break;
		case 5:
			sb[startr].append(putline(LINE, c));
			for (int i = startr + 1; i < mid; i++) {
				sb[i].append(putline(FIRST, c));
			}
			sb[mid].append(putline(LINE, c));
			for (int i = mid + 1, endr = startr + r - 1; i < endr; i++) {
				sb[i].append(putline(LAST, c));
			}
			sb[startr + r - 1].append(putline(LINE, c));
			break;
		case 6:
			for (int i = startr ; i < mid; i++) {
				sb[i].append(putline(FIRST, c));
			}
			sb[mid].append(putline(LINE, c));
			for (int i = mid + 1, endr = startr + r - 1; i < endr; i++) {
				sb[i].append(putline(BOTH, c));
			}
			sb[startr + r - 1].append(putline(LINE, c));
			break;
		case 7:
			sb[startr].append(putline(LINE, c));
			for (int i = startr + 1, endr = startr + r; i < endr; i++) {
				sb[i].append(putline(LAST, c));
			}
			break;
		case 8:
			sb[startr].append(putline(LINE, c));
			for (int i = startr + 1; i < mid; i++) {
				sb[i].append(putline(BOTH, c));
			}
			sb[mid].append(putline(LINE, c));
			for (int i = mid + 1, endr = startr + r - 1; i < endr; i++) {
				sb[i].append(putline(BOTH, c));
			}
			sb[startr + r - 1].append(putline(LINE, c));
			break;
		case 9:
			sb[startr].append(putline(LINE, c));
			for (int i = startr + 1; i < mid; i++) {
				sb[i].append(putline(BOTH, c));
			}
			sb[mid].append(putline(LINE, c));
			for (int i = mid + 1, endr = startr + r; i < endr; i++) {
				sb[i].append(putline(LAST, c));
			}
			break;
		}
	}

	private static String putline(int type, int c) {
		StringBuilder linesb = new StringBuilder();
		switch (type) {
		case FIRST:
			linesb.append("#");
			for (int i = 1; i < c; i++) {
				linesb.append(".");
			}
			break;
		case LINE:
			for (int i = 0; i < c; i++) {
				linesb.append("#");
			}
			break;
		case LAST:
			for (int i = 1; i < c; i++) {
				linesb.append(".");
			}
			linesb.append("#");
			break;
		case BOTH:
			linesb.append("#");
			for (int i = 1; i < c - 1; i++) {
				linesb.append(".");
			}
			linesb.append("#");
			break;
		case EMPTY:
			for (int i = 0; i < c; i++) {
				linesb.append(".");
			}
			break;
		}
		linesb.append(" ");
		return linesb.toString();
	}

}
