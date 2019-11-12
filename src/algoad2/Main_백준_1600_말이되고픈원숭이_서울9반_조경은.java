package algoad2;

import java.io.*;
import java.util.*;

public class Main_백준_1600_말이되고픈원숭이_서울9반_조경은 {
	public static int K, W, H;
	public static int[][] arr;
	public static int[] di = { -1, 1, 0, 0 };
	public static int[] dj = { 0, 0, -1, 1 };
	public static int[] ndi = { -1, -2, -2, -1, 1, 2, 2, 1 };
	public static int[] ndj = { -2, -1, 1, 2, 2, 1, -1, -2 };
	public static boolean[][][] v;

	public static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0, K, 0 });

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			if (curr[0] == H - 1 && curr[1] == W - 1) {
				return curr[3];
			}

			for (int k = 0; k < di.length; k++) {
				int ni = curr[0] + di[k];
				int nj = curr[1] + dj[k];
				if (ni >= 0 && ni < H && nj >= 0 && nj < W && arr[ni][nj] != 1 && !v[curr[3]][ni][nj]) {
					v[curr[3]][ni][nj] = true;
					q.offer(new int[] { ni, nj, curr[2] + 1, curr[3] + 1 });
				}
			}
			if (curr[2] > 0) {
				for (int k = 0; k < 8; k++) {
					int ni = curr[0] + ndi[k];
					int nj = curr[1] + ndj[k];
					if (ni >= 0 && ni < H && nj >= 0 && nj < W && arr[ni][nj] != 1) {
						q.offer(new int[] { ni, nj, curr[2] - 1, curr[3] + 1 });
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H][W];
		v = new boolean[201][H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(bfs());
	}

}
