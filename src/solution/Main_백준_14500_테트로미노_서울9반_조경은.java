package solution;

import java.io.*;
import java.util.*;

public class Main_백준_14500_테트로미노_서울9반_조경은 {
	public static int N, M, max;
	public static int[][] map;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};

	public static void one() {
		int temp=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M-4; j++) {
				temp += map[i][j];
			}
			max = Math.max(max, temp);
			temp=0;
			for(int j=0; j<M-4; j++) {
				temp+=map[j][i];
			}
			max = Math.max(max, temp);
			temp=0;
		}
	}

	public static void two() {
		int temp=0;
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<N-1; j++) {
				temp+=map[i][j];
				temp+=map[i][j+1];
				temp+=map[i+1][j];
				temp+=map[i][j+1];
				max = Math.max(max, temp);
				temp=0;
			}
		}
	}

	public static void three() {

	}

	public static void four() {

	}

	public static void five() {

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
		one();
		two();
		three();
		four();
		five();
		System.out.println(max);
	}

}
