package solution;

import java.io.*;
import java.util.*;

public class Main_백준_14503_로봇청소기_서울9반_조경은 {
	public static int[][] map;
	public static boolean[][] v;
	public static int N, M, d, res;
	public static int[] di = { -1, 0, 1, 0 }; // 상우하좌(북동남서)
	public static int[] dj = { 0, 1, 0, -1 };

	public static void clean(int i, int j, int d) {
		v[i][j] = true;
		res++;
		
		for(int k=0; k<di.length; k++) {
			int ni = i + di[(d+3-k)%4];
			int nj = j + dj[(d+3-k)%4];
			if(ni>=0 && ni<N && nj>=0 && nj<M && !v[ni][nj] && map[ni][nj]==0) {
				clean(ni,nj,(d+3-k)%4);
				break;
			}
			if(k==di.length-1) {
				ni = i - di[d];
				nj = j - dj[d];
				if(ni>=0 && ni<N && nj>=0 && nj<M && map[ni][nj]==0) {
					res--;
					clean(ni,nj,d);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M];
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		res = 0;
		
		clean(r,c,d);
		
		System.out.println(res);
	}

}
