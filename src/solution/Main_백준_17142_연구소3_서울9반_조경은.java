package solution;

import java.io.*;
import java.util.*;

public class Main_백준_17142_연구소3_서울9반_조경은 {
	public static int N, M, res;
	public static int[][] arr, rv, temp;
	public static Queue<int[]> q;
	public static ArrayList<int[]> virus;
	public static boolean[] v;
	public static boolean[][] visit, vis;
	public static int[] di = { -1, 1, 0, 0 };
	public static int[] dj = { 0, 0, -1, 1 };

	public static void permComb(int start, int count) {
		if (count == M) {
			vis = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				vis[i] = visit[i].clone();
				temp[i] = arr[i].clone();
			}
			for (int i = 0; i < M; i++) {
				temp[rv[i][0]][rv[i][1]] = 2;
				vis[rv[i][0]][rv[i][1]] = true;
				
				q.offer(rv[i]);
			}
			int r = bfs();
			Loop: for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (temp[i][j] == 0 && vis[i][j]) {
						r = Integer.MAX_VALUE;
						break Loop;
					}
				}
			}
			res = Math.min(res, r);

			return;
		}
		for (int i = start; i < virus.size(); i++) {
			if (!v[i]) {
				v[i] = true;
				rv[count] = virus.get(i);
				permComb(i, count + 1);
				v[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		temp = new int[N][N];
		visit = new boolean[N][N];
		virus = new ArrayList<>();
		q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					virus.add(new int[] { i, j, 0 });
				}
				else if(arr[i][j]==0) {
					visit[i][j] = true;
				}
			}
		}
		boolean bf = false;
		Loop: for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 0) {
					bf = true;
					break Loop;
				}

			}
		}
		if (!bf)
			System.out.println(0);
		else {
			v = new boolean[virus.size()];
			res = Integer.MAX_VALUE;
			rv = new int[M][3];
			permComb(0, 0);

			if (res == Integer.MAX_VALUE)
				res = -1;

			System.out.println(res);
		}
	}

	private static int bfs() {
		int time = 0;
		while (!q.isEmpty()) {
			boolean bf = false;
			Loop: for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (vis[i][j]) {
						bf = true;
						break Loop;
					}
				}
			}
			if (!bf)
				return time;
			int[] curr = q.poll();
			time = Math.max(time, curr[2]);
			
			for (int k = 0; k < di.length; k++) {
				int ni = curr[0] + di[k];
				int nj = curr[1] + dj[k];
				int t = curr[2];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && (vis[ni][nj] || (arr[ni][nj]==2&&!vis[ni][nj]))) {
					vis[ni][nj] = false;
					q.offer(new int[] { ni, nj, t + 1 });
				}
			}

		}
		return time;
	}
}