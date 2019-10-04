package a1004;

import java.io.*;
import java.util.*;

public class Main_정올_1840_치즈_서울9반_조경은_dfs {
	public static int arr[][], N, M;
	public static boolean[][] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		int cnt = 0;
		int num = 0;
		int cur_check = 0;
		while (true) {
			cur_check = check(arr);
			if (cur_check == 0)
				break;
			else
				num = cur_check;
			v = new boolean[N][M];
			dfs(0, 0);
			cnt++;
		}
		System.out.println(cnt + "\n" + num);
	}

	private static void dfs(int i, int j) {
		v[i][j] = true;
		if (arr[i][j] == 1) {
			arr[i][j] = 0;
			return;
		}
		int[] di = { 0, -1, 0, 1 };
		int[] dj = { -1, 0, 1, 0 };
		for (int z = 0; z < 4; z++) {
			int ni = i + di[z];
			int nj = j + dj[z];
			if (ni >= 0 && ni < N && nj >= 0 && nj < M && !v[ni][nj]) {
				dfs(ni, nj);
			}
		}

	}

	private static int check(int[][] v2) {
		int c = 0;
		for (int m = 0; m < N; m++) {
			for (int n = 0; n < M; n++) {
				c += v2[m][n];
			}
		}
		return c;
	}

}
