package com.ssafy;

import java.io.*;
import java.util.*;

public class Main_백준_1941_소문난칠공주_서울9반_조경은 {
	public static char[][] arr;
	public static int[] di = { -1, 1, 0, 0 };
	public static int[] dj = { 0, 0, -1, 1 };
	public static boolean[] v;
	public static boolean[][] v2;
	public static int res;
	public static int[] d;

	public static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { i, j });
		v2[i][j] = false;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int k = 0; k < di.length; k++) {
				int ni = curr[0] + di[k];
				int nj = curr[1] + dj[k];
				if (ni >= 0 && ni < 5 && nj >= 0 && nj < 5 && v2[ni][nj]) {
					v2[ni][nj] = false;
					q.offer(new int[] { ni, nj });
				}
			}
		}
	}

	public static boolean check() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (v2[i][j]) {
					bfs(i, j);
					for (int x = 0; x < 5; x++) {
						for (int y = 0; y < 5; y++) {
							if (v2[x][y]) {
								return false;
							}
						}
					}
					return true;
				}
			}
		}
		return true;
	}

	public static void permComb(int start, int count) {
		if (count == 7) {
			v2 = new boolean[5][5];
			for (int i = 0; i < 7; i++) {
				v2[d[i] / 5][d[i] % 5] = true;
			}
			if (check()) {
				int temp = 0;
				for (int i = 0; i < 7; i++) {
					if (arr[d[i] / 5][d[i] % 5] == 'S') {
						temp++;
					}
				}
				if (temp >= 4) {
					res++;
				}
			}
			return;
		}
		for (int i = start; i < 25; i++) {
			if (!v[i]) {
				v[i] = true;
				d[count] = i;
				permComb(i, count + 1);
				v[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new char[5][5];
		for (int i = 0; i < 5; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		v = new boolean[25];
		d = new int[7];
		permComb(0, 0);
		System.out.println(res);

	}

}
