package a1108;

import java.io.*;
import java.util.*;

public class Solution_D9_5656_벽돌깨기_서울9반_조경은 {
	public static int N, W, H, res, res2;
	public static int[][] arr, temp;
	public static int[] a;
	public static int[] di = { -1, 1, 0, 0 };
	public static int[] dj = { 0, 0, -1, 1 };
	public static boolean[][] v;

	public static void bfs(int i) {
		v = new boolean[H][W];
		Queue<int[]> q = new LinkedList<>();
		for (int j = 0; j < H; j++) {
			if (temp[j][i] != 0) {
				v[j][i] = true;
				q.offer(new int[] { j, i });
				break;
			}
		}

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int k = 0; k < di.length; k++) {
				for (int num = 0; num < temp[curr[0]][curr[1]]; num++) {
					int ni = curr[0] + (num * di[k]);
					int nj = curr[1] + (num * dj[k]);
					if (ni >= 0 && ni < H && nj >= 0 && nj < W && temp[ni][nj] != 0 && !v[ni][nj]) {
						v[ni][nj] = true;
						q.offer(new int[] { ni, nj });
					}
				}
			}
		}
		for (int x = 0; x < H; x++) {
			for (int j = 0; j < W; j++) {
				if (v[x][j]) {
					temp[x][j] = 0;
				}
			}
		}

	}

	public static void arrange() {
		for (int j = 0; j < W; j++) {
			int index = 0;
			for (int i = H - 1; i >= 0; i--) {
				if (temp[i][j] == 0) {
					index++;
				} else if (temp[i][j] != 0 && index != 0) {
					temp[i + index][j] = temp[i][j];
					temp[i][j] = 0;
				}
			}
		}
	}

	public static void permComb(int start, int count) {
		if (count == N) {
			temp = new int[H][W];
			for (int x = 0; x < H; x++) {
				temp[x] = arr[x].clone();
			}

			for (int x = 0; x < N; x++) {
				bfs(a[x]);
				arrange();
			}

			res2 = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (temp[i][j] != 0) {
						res2++;
					}
				}
			}
			res = Math.min(res, res2);
			return;
		}
		for (int i = 0; i < W; i++) {
			a[count] = i;
			permComb(i, count + 1);
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d9_5656.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			arr = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			a = new int[N];
			res = Integer.MAX_VALUE;
			permComb(0, 0);

			System.out.println("#" + t + " " + res);

		}

	}
}