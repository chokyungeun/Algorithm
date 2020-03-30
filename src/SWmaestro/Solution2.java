package SWmaestro;

import java.io.*;
import java.util.*;

public class Solution2 {
	public static int N, M, res;
	public static int[][] map;
	public static boolean[][] v;

	public static boolean one(int i, int j) {
		if(i+1<N && j+1<M && map[i][j+1]==1 && map[i+1][j]==1 &&map[i+1][j+1]==1) {
			v[i][j] = true;
			v[i][j+1] = true;
			v[i+1][j] = true;
			v[i+1][j+1] = true;
			return true;
		}
		return false;
	}

	public static boolean two(int i, int j) {
		if(i+1<N && j-1>=0 && map[i][j-1]==1 && map[i+1][j]==1 &&map[i+1][j-1]==1) {
			v[i][j] = true;
			v[i][j-1] = true;
			v[i+1][j] = true;
			v[i+1][j-1] = true;
			return true;
		}
		return false;
	}

	public static boolean three(int i, int j) {
		if(i-1>=0 && j-1>=0 && map[i][j-1]==1 && map[i-1][j]==1 &&map[i-1][j-1]==1) {
			v[i][j] = true;
			v[i][j-1] = true;
			v[i-1][j] = true;
			v[i-1][j-1] = true;
			return true;
		}
		return false;
	}

	public static boolean four(int i, int j) {
		if(i-1>=0 && j+1<M && map[i][j+1]==1 && map[i-1][j]==1 &&map[i-1][j+1]==1) {
			v[i][j] = true;
			v[i][j+1] = true;
			v[i-1][j] = true;
			v[i-1][j+1] = true;
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			res=0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			v = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			Loop: for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1 && !v[i][j]) {
						if (!one(i, j)) {
							if (!two(i, j)) {
								if (!three(i, j)) {
									if (!four(i, j)) {
										res = 1;
										break Loop;
									}
								}
							}
						}

					}
				}
			}
			
			if(res==0) System.out.println("YES");
			else System.out.println("NO");
		}
	}

}
