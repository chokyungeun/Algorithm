package a1010;

import java.io.*;
import java.util.*;

public class Main_백준_17472_다리만들기2_서울9반_조경은 {
	public static int[][] arr, graph;
	public static int cnt, INF = 987654321, N, M;
	public static int[] di = { -1, 1, 0, 0 };
	public static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()) * -1;
			}
		}
		cnt = 0; // 섬의개수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == -1)
					bfs(i, j, ++cnt); // 섬에 번호 붙임
			}
		}
		graph = new int[cnt][cnt];
		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j < M; j++) {
				if (i == j)
					continue;
				graph[i][j] = INF;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] != 0) {
					for (int d = 0; d < 4; d++) {
						int ni = i + di[d];
						int nj = j + dj[d];
						if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
							if (arr[ni][nj] == 0) {
								dfs(i, j, ni, nj, d, 1);
							}
						}
					}
				}
			}
		}
		System.out.println(prim());

	}

	private static void dfs(int i, int j, int ci, int cj, int d, int cnt) {
		int ni = ci + di[d];
		int nj = cj + dj[d];
		if (0 <= ni && ni < N && 0 <= nj && nj < M) {
			if (arr[ni][nj] == 0) {
				dfs(i, j, ni, nj, d, cnt + 1);
			} else {
				int s = arr[i][j] - 1;
				int e = arr[ni][nj] - 1;
				if (cnt >= 2) {
					if (graph[s][e] > cnt) {
						graph[s][e] = cnt;
						graph[e][s] = cnt;
					}
				}
			}
		}
	}

	public static int prim() {
		int[] w = new int[cnt];
		Arrays.fill(w, -1);

		w[0] = 0;
		for (int k = 0; k < cnt; k++) {
			int minWeight = INF;
			int minVertax = 0;
			for (int i = 0; i < cnt; i++) {
				if (w[i] < 0)
					continue;
				for (int j = 0; j < cnt; j++) {
					if (w[j] >= 0)
						continue;
					if (minWeight > graph[i][j]) {
						minWeight = graph[i][j];
						minVertax = j;
					}
				}
			}
			w[minVertax] = minWeight;
		}
		int sum = 0;
		for (int i = 1; i < cnt; i++) {
			if (w[i] == -1)
				return -1;

		}
		return sum;
	}

	private static void bfs(int i, int j, int k) {
		Queue<int[]> q = new LinkedList<int[]>();
		arr[i][j] = cnt;
		q.offer(new int[] { i, j, cnt });
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int d = 0; d < 4; d++) {
				int ni = curr[0] + di[d];
				int nj = curr[1] + dj[d];
				if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
					if (arr[ni][nj] == -1) {
						arr[ni][nj] = cnt;
						q.offer(new int[] { ni, nj });
					}
				}
			}
		}

	}

}
