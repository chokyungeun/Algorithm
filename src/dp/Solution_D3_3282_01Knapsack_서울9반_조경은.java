package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_3282_01Knapsack_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_3282.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			int[] w = new int[N + 1];
			int[] v = new int[N + 1];
			int[][] k = new int[N + 1][W + 1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				w[i] = Integer.parseInt(st.nextToken());
				v[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= W; j++) {
					if (w[i] > j) {
						k[i][j] = k[i - 1][j];
					} else {
						k[i][j] = Math.max(k[i - 1][j - w[i]] + v[i], k[i - 1][j]);
					}
				}
			}

			System.out.println("#" + t + " " + k[N][W]);

		}
	}

}
