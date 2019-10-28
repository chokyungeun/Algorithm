package solution;

import java.io.*;
import java.util.*;

public class Main_백준_14499_주사위굴리기_서울9반_조경은 {
	public static int N, M, K;
	public static int[][] map;
	public static int[] inst, dice;
	public static int[] di = { 0, 0, -1, 1 };
	public static int[] dj = { 1, -1, 0, 0 };

	public static void move(int i, int j, int x, int count) {
		if (count == K) {
			return;
		}
		int up=0;
		int ni=0;
		int nj=0;
		int index=0;
		for (int k = count; k < K; k++) {
			ni = i + di[inst[k]];
			nj = j + dj[inst[k]];
			if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
				if (inst[k] == 0) {
					if(x==0||x==1||x==4||x==5)
						up=3;
					else if(x==2)
						up=0;
					else if(x==3)
						up=5;
					
				} else if (inst[k] == 1) {
					if(x==0||x==1||x==4||x==5)
						up=2;
					else if(x==2)
						up=5;
					else if(x==3)
						up=0;
					
				} else if (inst[k] == 2) {
					if(x==0||x==2||x==3)
						up=4;
					else if(x==1)
						up=0;
					else if(x==4)
						up=5;
					else if(x==5)
						up=1;
				} else if (inst[k] == 3) {
					if(x==0||x==2||x==3)
						up=1;
					else if(x==1)
						up=5;
					else if(x==4)
						up=0;
					else if(x==5)
						up=4;
				}
				if (map[ni][nj] == 0) {
					map[ni][nj] = dice[5-up];
				}
				else {
					dice[5-up] = map[ni][nj];
					map[ni][nj]=0;
				}
				index = k+1;
				break;
			}
			
		}
		System.out.println(dice[up]);
		move(ni,nj,up,index);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		dice = new int[6];
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
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
		}

		move(x, y, 0, 0);
	}

}
