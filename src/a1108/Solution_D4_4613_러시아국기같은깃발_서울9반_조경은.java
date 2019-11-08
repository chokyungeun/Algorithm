package a1108;

import java.io.*;

public class Solution_D4_4613_러시아국기같은깃발_서울9반_조경은 {
	public static int N, M, res;
	public static char[][] arr;

	public static void dfs(int i, int temp, boolean bb, boolean rr) {
		if (temp >= res)
			return;

		if (i == N - 1) {
			if (bb) res = Math.min(res, temp);
			return;
		}
		int w = 0, r = 0, b = 0;
		for (int j = 0; j < M; j++) {
			if (arr[i][j] != 'W')
				w++;
			if (arr[i][j] != 'R')
				r++;
			if (arr[i][j] != 'B')
				b++;
		}
		if (bb) {
			if (rr) {
				dfs(i + 1, temp + r, bb, true);
			} 
			else {
				dfs(i + 1, temp + b, true, rr);
				dfs(i + 1, temp + r, bb, true);
			}
		} 
		else {
			dfs(i + 1, temp + w, bb, rr);
			dfs(i + 1, temp + b, true, rr);
		}

	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_4613.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			arr = new char[N][M];
			for (int i = 0; i < N; i++) {
				arr[i] = br.readLine().toCharArray();
			}

			int first = 0;
			int last = 0;
			for (int j = 0; j < M; j++) {
				if (arr[0][j] != 'W') first++;
			}
			for (int j = 0; j < M; j++) {
				if (arr[N - 1][j] != 'R') last++;
			}

			res = Integer.MAX_VALUE;
			dfs(1, 0, false, false);
			System.out.println("#" + t + " " + (res + first + last));

		}

	}
}