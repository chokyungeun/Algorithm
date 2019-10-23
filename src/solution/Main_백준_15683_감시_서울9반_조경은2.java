package solution;

import java.io.*;
import java.util.*;

public class Main_백준_15683_감시_서울9반_조경은2 {
	public static int[][] arr;
	public static int N, M;
	public static int[] di = { -1, 0, 1, 0 }; // 상우하좌
	public static int[] dj = { 0, 1, 0, -1 }; // 상우하좌
	public static ArrayList<int[]> cctv;

	public static int up(int i, int j) {
		int temp = 0;
		for (int x = i - 1; x >= 0; x--) {
			if (arr[x][j] == 0) {
				temp++;
			} else if (arr[x][j] == 6) {
				break;
			}
		}
		return temp;
	}

	public static int right(int i, int j) {
		int temp = 0;
		for (int x = j + 1; x < M; x++) {
			if (arr[i][x] == 0) {
				temp++;
			} else if (arr[i][x] == 6) {
				break;
			}
		}
		return temp;
	}

	public static int down(int i, int j) {
		int temp = 0;
		for (int x = i + 1; x < N; x++) {
			if (arr[x][j] == 0) {
				temp++;
			} else if (arr[x][j] == 6) {
				break;
			}
		}
		return temp;
	}

	public static int left(int i, int j) {
		int temp = 0;
		for (int x = j - 1; x >= 0; x--) {
			if (arr[i][x] == 0) {
				temp++;
			} else if (arr[i][x] == 6) {
				break;
			}
		}
		return temp;
	}
	
	public static void oversee(int i, int j, int num) {
		if (num == 1) {
			int max = 0;
			int index = 0;
			for (int k = 0; k < 4; k++) {
				int ni = i;
				int nj = j;
				int temp = 0;
				for (int x = 0; x < M; x++) {
					ni += di[k];
					nj += dj[k];
					if (ni < 0 || ni >= N || nj < 0 || nj >= M || arr[ni][nj] == 6) {
						break;
					} else if (arr[ni][nj] == 0) {
						temp++;
					}
				}
				if (max < temp) {
					max = temp;
					index = k;
				}
			}
			for (int k = 0; k < 4; k++) {
				if (index == k) {
					int ni = i;
					int nj = j;
					for (int x = 0; x < M; x++) {
						ni += di[k];
						nj += dj[k];
						if (ni < 0 || ni >= N || nj < 0 || nj >= M || arr[ni][nj] == 6) {
							break;
						} else if (arr[ni][nj] == 0) {
							arr[ni][nj] = 7;
						}
					}
					break;
				}
			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		cctv = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] != 6 && arr[i][j] != 0) {
					cctv.add(new int[] { i, j, arr[i][j] });
				}
			}
		}

	}

}
