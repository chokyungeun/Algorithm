package solution;

import java.io.*;
import java.util.*;

public class Main_백준_14500_테트로미노_서울9반_조경은 {
	public static int N, M, max;
	public static int[][] map;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};

	public static void one(int i, int j) {
		int index1=0;
		int index2=0;
		int index3=0;
		int index4=0;
		
		for(int k=0; k<4; k++) {
			for(int x=0; x<4; x++) {
				int ni = i+di[k];
				int nj = j+dj[k];
				if(ni<0 || ni>=N || nj<0 || nj>=M) {
					break;
				}
				else {
					
				}
			}
		}
		
		
		
	}

	public static void two(int i, int j) {

	}

	public static void three(int i, int j) {

	}

	public static void four(int i, int j) {

	}

	public static void five(int i, int j) {

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				one(i,j);
				two(i,j);
				three(i,j);
				four(i,j);
				five(i,j);
			}
		}
		System.out.println(max);
	}

}
