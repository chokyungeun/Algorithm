package solution;

import java.io.*;
import java.util.*;

public class Main_백준_14499_주사위굴리기_서울9반_조경은 {
	public static int N, M, K, ci, cj, cd;
	public static int[][] map;
	public static int[] inst, dice, temp;
	public static int[] di = { 0, 0, -1, 1 };
	public static int[] dj = { 1, -1, 0, 0 };

	public static void move(int dir) {
		int ni = ci+di[dir];
		int nj = cj+dj[dir];
		if(ni<0 || ni>=N || nj<0 || nj>=M) return;
		
		if(dir==0) {
			temp[1] = dice[4];
			temp[2] = dice[2];
			temp[3] = dice[1];
			temp[4] = dice[6];
			temp[5] = dice[5];
			temp[6] = dice[3];
		}
		else if(dir==1) {
			temp[1] = dice[3];
			temp[2] = dice[2];
			temp[3] = dice[6];
			temp[4] = dice[1];
			temp[5] = dice[5];
			temp[6] = dice[4];
		}
		else if(dir==2) {
			temp[1] = dice[5];
			temp[2] = dice[1];
			temp[3] = dice[3];
			temp[4] = dice[4];
			temp[5] = dice[6];
			temp[6] = dice[2];
		}
		else if(dir==3) {
			temp[1] = dice[2];
			temp[2] = dice[6];
			temp[3] = dice[3];
			temp[4] = dice[4];
			temp[5] = dice[1];
			temp[6] = dice[5];
		}
		
		
		if(map[ni][nj]==0) {
			map[ni][nj]=temp[6];
		} 
		else {
			temp[6] = map[ni][nj];
			map[ni][nj]=0;
		}
		
		ci=ni;
		cj=nj;
		for(int i=1; i<=6; i++) {
			dice[i]=temp[i];
		}
		System.out.println(dice[1]);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		dice = new int[7];
		temp = new int[7];
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ci = Integer.parseInt(st.nextToken());
		cj = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		inst = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			inst[i] = (Integer.parseInt(st.nextToken()) - 1);
			move(inst[i]);
		}

		
	}

}
