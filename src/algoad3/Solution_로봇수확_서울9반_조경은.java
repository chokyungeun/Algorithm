package algoad3;

import java.io.*;
import java.util.*;

public class Solution_로봇수확_서울9반_조경은 {
	public static int N, M, res, day, max, dir;
	public static int[][] map, seed; //씨앗을 심은 횟수 저장
	public static int[][] v; //씨앗을 심은 날짜를 저장
	public static int[] di = { 0, -1, 0, 1 };
	public static int[] dj = { 1, 0, -1, 0 };

	public static boolean go(int i, int j) {
		if (day > M) {
			return true;
		}
		if (v[i][j] == 0) {
			for (int k = 0; k < di.length; k++) {
				int ni = i + di[(dir + 3 + k) % 4];
				int nj = j + dj[(dir + 3 + k) % 4];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && map[ni][nj] != 1) {
					if (v[ni][nj] != 0) {
						if (day > v[ni][nj] + 3 + seed[ni][nj]) { // 현재 빈농지이고 다음에 수확할 곡식농지
							v[i][j] = day;
							seed[i][j]++;
							day++;
							dir = (dir + 3 + k) % 4;
							if (go(ni, nj))
								return true;
							return false;
						}
					} else {
						v[i][j] = day;
						seed[i][j]++;
						day++;
						dir = (dir + 3 + k) % 4;
						if (go(ni, nj))
							return true;
						return false;
					}
				}
			}
		} else {
			res++;
			v[i][j] = 0;
			for (int k = 0; k < di.length; k++) {
				int ni = i + di[(dir + 3 + k) % 4];
				int nj = j + dj[(dir + 3 + k) % 4];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && map[ni][nj] != 1) {
					if (v[ni][nj] != 0) {
						if (day > v[ni][nj] + 3 + seed[ni][nj]) {
							day++;
							dir = (dir + 3 + k) % 4;
							if (go(ni, nj))
								return true;
							return false;
						}
					} else {
						day++;
						dir = (dir + 3 + k) % 4;
						if (go(ni, nj))
							return true;
						return false;
					}
				}
			}
		}
		day++;
		if (go(i, j))
			return true;
		return false;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++,System.out.println( "dfdf")) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			max = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) {
						for (int k = 0; k < 4; k++) {
							dir = k;
							res = 0;
							day = 1;
							seed = new int[N][N];
							v = new int[N][N];
							go(i, j);
							max = Math.max(max, res);
						}
					}
				}
			}
			System.out.println("#" + t + " " + max);
		}
	}
}
