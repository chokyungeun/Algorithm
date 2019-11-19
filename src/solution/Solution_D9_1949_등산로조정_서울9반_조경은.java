package solution;

import java.io.*;
import java.util.*;

public class Solution_D9_1949_등산로조정_서울9반_조경은 {
	public static int N, K, res;
	public static boolean[][] v;
	public static int[] di = { -1, 1, 0, 0 };
	public static int[] dj = { 0, 0, -1, 1 };

	public static void dfs(int i, int j, int[][] map, int index) {
		res = Math.max(res, index);
		
		v[i][j] = true;
		for (int k = 0; k < di.length; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			if (ni >= 0 && ni < N && nj >= 0 && nj < N && !v[ni][nj]) {
				if(map[ni][nj]<map[i][j]) {
					dfs(ni,nj,map,index+1);
				}
				else {
					for(int x=1; x<=K; x++) {
						if(map[ni][nj]-x>=0 && map[ni][nj]-x<map[i][j]) {
							map[ni][nj]-=x;
							dfs(ni,nj,map,index+1);
							map[ni][nj]+=x;
						}
					}
				}
			}
		}
		v[i][j] = false;
	}

	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("res/input_d9_1949.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			int max = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}
			res = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == max) {
						v = new boolean[N][N];
						dfs(i, j, map, 1);
					}
				}
			}
			System.out.println("#" + t + " " + res);

		}

	}
}