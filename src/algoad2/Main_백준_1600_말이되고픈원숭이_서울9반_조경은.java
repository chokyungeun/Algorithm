package algoad2;

import java.io.*;
import java.util.*;

public class Main_백준_1600_말이되고픈원숭이_서울9반_조경은 {
	public static int K, W, H, res, temp;
	public static int[][] arr,memo;
	public static int[] di = { -1, 1, 0, 0 };
	public static int[] dj = { 0, 0, -1, 1 };
	public static int[] ndi = { -1, -2, -2, -1, 1, 2, 2, 1 };
	public static int[] ndj = { -2, -1, 1, 2, 2, 1, -1, -2 };
	public static boolean[][] v;

	public static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { i, j, 0 });

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int siz = q.size();
			if (K > 0) {
				for (int k = 0; k < ndi.length; k++) {
					int ni = curr[0] + ndi[k];
					int nj = curr[1] + ndj[k];
					if (ni >= 0 && ni < H && nj >= 0 && nj < W && arr[ni][nj] != 1) {
						v[ni][nj] = true;
						arr[ni][nj] = curr[2] + 1;
						q.offer(new int[] { ni, nj, curr[2] + 1 });
					}
				}
			}
			for (int k = 0; k < di.length; k++) {
				int ni = curr[0] + di[k];
				int nj = curr[1] + dj[k];
				if (ni >= 0 && ni < H && nj >= 0 && nj < W && arr[ni][nj] != 1 && !v[ni][nj]) {
					if (ni == H - 1 && nj == W - 1) {
						temp = curr[2] + 1;
						return;
					}
					v[ni][nj] = true;
					arr[ni][nj] = curr[2] + 1;
					q.offer(new int[] { ni, nj, curr[2] + 1 });
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H][W];
		memo = new int[H][W];
		v = new boolean[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(memo, Integer.MAX_VALUE);
		}

		bfs(0, 0);
		if(temp==0) {
			temp=-1;
		}
		/*for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}*/

		System.out.println(temp);
	}

}
