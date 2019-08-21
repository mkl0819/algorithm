package com.ssafy;
/**************************************************************
    Problem: 2097
    User: mkl0819
    Language: Java
    Result: Accepted
****************************************************************/
 
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main2097_이민경{
    static int N, M;
    static int map[][];
    static StringBuilder path;
 
    static StringTokenizer st;
 
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
 
        st = new StringTokenizer(in.readLine());
 
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
 
        map = new int[N+1][N+1];
 
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(i==j) {
                    map[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        path = new StringBuilder();
        path.append("1 ");
        daik();
        path.append(M);
        System.out.println(map[1][M]);
        System.out.println(path);
    }
 
    private static void daik() {
                for(int k=2; k<=N; k++) {
                    if(k==M) {
                        continue;
                    }
                    if(map[1][M] > map[1][k]+map[k][M]) {
                        path.append(k).append(" ");
                        map[1][M] = map[1][k]+map[k][M];
                    }
                }
    }
}