package a0905;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1861_정사각형방_서울9반_조경은 {
	public static int[][] arr;
	public static int N;
	public static int mx;
	public static int[] di = { -1, 1, 0, 0 };
	public static int[] dj = { 0, 0, -1, 1 };
	public static boolean[][] v;

	public static void dfs(int i, int j) {
		mx++;
		v[i][j] = true;
		for (int k = 0; k < di.length; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			if (ni >= 0 && ni < N && nj >= 0 && nj < N && arr[ni][nj] == arr[i][j] + 1) {
				dfs(ni, nj);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1861.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			v = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			int ni = 0;
			int nj = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!v[i][j]) {
						mx = 0;
						dfs(i, j);
						if (mx > max) {
							max = mx;
							ni = i;
							nj = j;
						} else if (mx == max) {
							if (arr[i][j] < arr[ni][nj]) {
								max = mx;
								ni = i;
								nj = j;
							}
						}
					}
				}
			}
			System.out.println("#" + t + " " + arr[ni][nj] + " " + max);
		}
	}

}
