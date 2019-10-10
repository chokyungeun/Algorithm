package a1010;

import java.io.*;
import java.util.*;

public class Main_백준_4963_섬의개수_서울9반_조경은_dfs {
	public static int[][] map;
	public static boolean[][] v;
	public static int w, h;
	public static int[] di = { -1, 1, 0, 0, -1, -1, 1, 1 };
	public static int[] dj = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void dfs(int i, int j) {
		v[i][j] = true;

		for (int k = 0; k < di.length; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			if (ni >= 0 && ni < h && nj >= 0 && nj < w && !v[ni][nj] && map[ni][nj] == 1) {
				dfs(ni, nj);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0)
				break;
			map = new int[h][w];
			v = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int res = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!v[i][j] && map[i][j] == 1) {
						res++;
						dfs(i, j);

					}
				}
			}

			System.out.println(res);
		}

	}

}
