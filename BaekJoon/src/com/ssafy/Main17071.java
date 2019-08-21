package com.ssafy;

import java.util.StringTokenizer;
/*
 * 시간초과 날때 visited 배열 을 테스트케이스로 주면 초기화 필요없오;; 신박하다 
 *
 */


/*
 * i초 후의 동생의 위치를 알 수 있다.
 * 동생이 이동할 때마다 BFS를 이용해 가장 빠른 시간을 구해볼 수 있다.
 * 
 * 동생은 최대 몇 번 이동 ? -> 루트 N 번 -> 루트 500,000 번
 * BFS의 시간복잡도는 O(N) 이기 때문에 총 500,000(루트500,000)이다 -> 오래걸린다
 * 
 * dist[v][t] -> v 위치 t (짝수:0, 홀수:1) = 빠른 시간
 * 
 * 수빈이가 위치에 도착하는 가장 빠른시간을 BFS로 구함 ( 홀수 / 짝수 나눠서 )
 * 동생의 위치를 구하면서 수빈이가 그 시간 내에 도착할 수 있는지 검사
 *  
 */
public class Main17071 {
	static int N, K;
	
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		
	}
}
