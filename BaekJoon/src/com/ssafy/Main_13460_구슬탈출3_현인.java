package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_13460_구슬탈출3_현인 {
	// 어차피 최대 변의 길이는 10이다.
	// 따라서 y좌표값에 10을 곱하고 x좌표값과 더해서 하나로 들고 다녀도 좌표처럼 사용이 가능
	// 방향에 따른 이동처리 배열도 dir배열 하나로 처리한다.
	static int dir[] = { -10, 10, -1, 1 };
	static final int up = 0;
	static final int down = 1;
	static final int left = 2;
	static final int right = 3;
	// marble 배열에서 인덱스 0이 빨간놈 1이 파란놈
	static final int redMarble = 0;
	static final int blueMarble = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sero = Integer.parseInt(st.nextToken());
		int garo = Integer.parseInt(st.nextToken());
		// 빨간놈위치, 파란놈위치, 굴린 방향
		int marble[] = { -1, -1, -1 };
		int dest = -1;
		// 그냥 contains메소드를 사용해 현재 위치가 #인지 확인하려고 set 사용
		HashSet<Integer> block = new HashSet<Integer>();
		LinkedList<int[]> queue = new LinkedList<int[]>();
		for (int i = 0; i < sero; ++i) {
			String line = br.readLine();
			for (int j = 0; j < garo; ++j) {
				char cur = line.charAt(j);
				if (cur == 'B') {
					marble[blueMarble] = i * 10 + j;
				} else if (cur == 'R') {
					marble[redMarble] = i * 10 + j;
				} else if (cur == 'O') {
					dest = i * 10 + j;
				} else if (cur == '#') {
					block.add(i * 10 + j);
				}
			}
		}
		queue.offer(marble);
		int time = 0;
		int ans = -1;
		while (!queue.isEmpty() && time < 10) {
			for (int q = 0, size = queue.size(); q < size; ++q) {
				int cur[] = queue.poll();
				// 아래의 값들은 그냥 누가 먼저 움직일지 고르려고 미리 계산해둔 값이다.
				// 이짓을 하는 이유는 굴릴때 빨간색 구슬과 파란색 구슬이 붙어있을 때
				// 굴리는 방향쪽에 있는 놈을 먼저 굴리려고.(ex위로 굴리면 더 위에있는 놈 먼저 굴림)
				// 나중에 굴리는 놈은 먼저 굴러간 놈을 장애물처럼 써먹을 수 있다.
				int redX = cur[0] % 10;
				int redY = cur[0] / 10;
				int blueX = cur[1] % 10;
				int blueY = cur[1] / 10;
				int prevDir = cur[2];
				for (int i = 0; i < 4; ++i) {
					// 굴릴때 빨간놈 파란놈 둘다 시작하자마자 장애물에 가로막힌다면 굴릴 필요도 없다.
					// 옆으로 굴렸는데 다시 옆으로 굴릴필요도 없고
					// 위아래로 굴렸는데 다시 위아래로 굴릴필요도 없다.
					if (block.contains(cur[0] + dir[i]) && block.contains(cur[1] + dir[i])
							|| ((prevDir == up || prevDir == down) && (i == up || i == down))
							|| ((prevDir == left || prevDir == right) && (i == left || i == right))) {
						continue;
					}
					// 장애물만난 경우를 체크해줌.
					boolean stop[] = { false, false };
					// 골인한 경우를 체크해줌.
					boolean finish[] = { false, false };
					int firstMarble = 0;
					switch (i) {
					case up:
						firstMarble = redY < blueY ? 0 : 1;
						break;
					case down:
						firstMarble = redY < blueY ? 1 : 0;
						break;
					case left:
						firstMarble = redX < blueX ? 0 : 1;
						break;
					case right:
						firstMarble = redX < blueX ? 1 : 0;
						break;
					}
					int distance = 1;

					int next[] = { -1, -1, i };
					while (!stop[firstMarble]) {
						int nextPos = distance * dir[i] + cur[firstMarble];
						if (nextPos == dest) {
							finish[firstMarble] = true;
							break;
						}
						stop[firstMarble] = block.contains(nextPos) ? true : false;
						++distance;
					}
					// 도착지 도달한 경우는 값을 변경하지 않아서 맵상에 존재하지 않는것처럼 처리한다.
					if (!finish[firstMarble]) {
						next[firstMarble] = cur[firstMarble] + (distance - 2) * dir[i];
					}

					distance = 1;
					// xor로 선수교대(0과 1을 구슬 번호로 쓴 쓸데없는 이유)
					int secondMarble = firstMarble ^ 1;
					while (!stop[secondMarble]) {
						int nextPos = distance * dir[i] + cur[secondMarble];
						if (nextPos == dest) {
							finish[secondMarble] = true;
							break;
						}
						// #체크뿐만이 아니라 먼저 움직인놈 위치도 체크해준다.
						stop[secondMarble] = block.contains(nextPos) || nextPos == next[firstMarble] ? true : false;
						++distance;
					}
					next[secondMarble] = cur[secondMarble] + (distance - 2) * dir[i];

					if (finish[blueMarble]) // 파란놈이 골인한 경우
					{
						continue;
					} else if (finish[redMarble]) // 빨간놈만 골인한 경우
					{
						System.out.println((time + 1));
						return;
					}
					queue.offer(next);
				}
			}
			++time;
		}

		System.out.println(-1);

	}
}