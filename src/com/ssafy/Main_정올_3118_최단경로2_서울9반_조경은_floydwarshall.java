package com.ssafy;
import java.io.*;
import java.util.*;

public class Main_정올_3118_최단경로2_서울9반_조경은_floydwarshall {
	public static int N,M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] d = new int[N][N];
		for(int i=0; i<N; i++) {
			Arrays.fill(d[i], 98765);
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			d[from][to] = weight;
		}
		
		for(int k=0; k<N; k++) { //경유지
			d[0][N-1]=Math.min(d[0][k]+d[k][N-1], d[0][N-1]);
		}
		System.out.println(d[0][N-1]);
	}

}
