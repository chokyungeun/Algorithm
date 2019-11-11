package solution;

import java.io.*;
import java.util.*;

public class Main_백준_17142_연구소3_서울9반_조경은 {
	public static int N, M, res, t;
	public static int[][] arr, rv, temp;
	public static int[] di = { -1, 1, 0, 0 };
	public static int[] dj = { 0, 0, -1, 1 };
	public static ArrayList<int[]> virus;
	public static Queue<int[]> q;
	public static boolean[] v;
	public static boolean[][] v2;

	public static void permComb(int start, int count) {
		if (count == M) {
			temp = new int[N][N];
			for (int i = 0; i < N; i++) {
				temp[i] = arr[i].clone();
			}
			q = new LinkedList<>();
			v2 = new boolean[N][N];
			for (int i = 0; i < M; i++) {
				q.offer(new int[] { rv[i][0], rv[i][1], 0 });
				v2[rv[i][0]][rv[i][1]] = true;
			}
			t = 0;
			bfs();
			
			if (check()) {
				res = Math.min(res, t);
			}
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

	public static void bfs() {

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			//t = curr[2];
			if (check()) {
				return;
			}
			for (int k = 0; k < di.length; k++) {
				int ni = curr[0] + di[k];
				int nj = curr[1] + dj[k];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && temp[ni][nj] != 1 && !v2[ni][nj]) {
					v2[ni][nj] = true;
					if (temp[ni][nj] == 0) {
						temp[ni][nj] = curr[2]+1;
					}
					q.offer(new int[] { ni, nj, curr[2] + 1 });
					t = curr[2]+1;
				}
			}
		}
	}

	public static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (temp[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];

		virus = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					virus.add(new int[] { i, j });
				}
			}
		}
		rv = new int[M][2];
		res = Integer.MAX_VALUE;
		v = new boolean[virus.size()];
		temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			temp[i] = arr[i].clone();
		}
		if (check()) {
			System.out.println(0);
		} else {
			permComb(0, 0);
			if (res == Integer.MAX_VALUE)
				res = -1;
			System.out.println(res);
		}
	}

}