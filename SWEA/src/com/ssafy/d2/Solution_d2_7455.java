package com.ssafy.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
/*
 * 1                     N
 * 1           i         N
 *     (i-1)       (N-i)
 *    d[i-1]   *  d[N-1]
 *    
 * => D[N] = ��( d[i-1] * d[N-i] )   ( i = 2, 4, 6, 8, ... )
 * 
 */


/*  [ ��ȭ ���� ]
 * 
 *  D[L][O] = ���̰� L �� ������ ¦�� ���� �ʴ� ���� ��ȣ ���� O��
 *  
 *  
 *  1) �������� �ݴ� ��ȣ �϶�
 *  	D[N-1][O+1]
 *  
 *  2) �������� ���� ��ȣ �϶�
 *  	D[N-1][O-1]
 *  
 *  ==> D[N][O] = D[N-1][O+1] + D[N-1][O-1]
 * 
 * 
 */
public class Solution_d2_7455 {
	static int T, N;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/Solution_d2_7455.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(in.readLine().trim());
		
		for(int test_case=1; test_case<=T; test_case++) {
			N = Integer.parseInt(in.readLine().trim());
			
			System.out.println("#"+test_case+" ");
		}
	}
}
