package algoad3;

import java.io.*;
import java.util.*;

public class Main_백준_1937_욕심쟁이판다_서울9반_조경은 {
	public static int n, res;
	public static int[][] map, memo;
	public static int[] di = { -1, 1, 0, 0 };
	public static int[] dj = { 0, 0, -1, 1 };

	public static int dfs(int i, int j) {
		if (memo[i][j] != 0) {
			return memo[i][j];
		}
		memo[i][j] = 1;
		for (int k = 0; k < di.length; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			if (ni >= 0 && ni < n && nj >= 0 && nj < n && map[ni][nj] > map[i][j]) {
				memo[i][j] = Math.max(memo[i][j], dfs(ni, nj) + 1);
			}
		}
		return memo[i][j];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[n][n];
		memo = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				res = Math.max(res, dfs(i, j));
			}
		}
		System.out.println(res);
	}

}
