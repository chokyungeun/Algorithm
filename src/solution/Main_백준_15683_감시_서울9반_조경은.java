package solution;

import java.io.*;
import java.util.*;

public class Main_백준_15683_감시_서울9반_조경은 {
	public static int N, M, result;
	public static int[][] arr;
	public static ArrayList<int[]> cctv, cctv5;

	public static void dfs(int i, int j, int num, int index) {
		if (index == cctv.size()-1) {
			int r = 0;
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
					if (arr[x][y] == 0) {
						r++;
					}
				}
			}
			result = Math.min(result, r);
			return;
		}
		if (num == 1) {
			up(i, j, 1, index);
			dfs(cctv.get(index + 1)[0], cctv.get(index + 1)[1], cctv.get(index + 1)[2], index + 1);
			up(i, j, 0, index);
			down(i, j, 1, index);
			dfs(cctv.get(index + 1)[0], cctv.get(index + 1)[1], cctv.get(index + 1)[2], index + 1);
			down(i, j, 0, index);
			left(i, j, 1, index);
			dfs(cctv.get(index + 1)[0], cctv.get(index + 1)[1], cctv.get(index + 1)[2], index + 1);
			left(i, j, 0, index);
			right(i, j, 1, index);
			dfs(cctv.get(index + 1)[0], cctv.get(index + 1)[1], cctv.get(index + 1)[2], index + 1);
			right(i, j, 0, index);
		} else if (num == 2) {
			up(i, j, 1, index);
			down(i, j, 1, index);
			dfs(cctv.get(index + 1)[0], cctv.get(index + 1)[1], cctv.get(index + 1)[2], index + 1);
			down(i, j, 0, index);
			up(i, j, 0, index);
			left(i, j, 1, index);
			right(i, j, 1, index);
			dfs(cctv.get(index + 1)[0], cctv.get(index + 1)[1], cctv.get(index + 1)[2], index + 1);
			right(i, j, 0, index);
			left(i, j, 0, index);
		} else if (num == 3) {
			up(i, j, 1, index);
			right(i, j, 1, index);
			dfs(cctv.get(index + 1)[0], cctv.get(index + 1)[1], cctv.get(index + 1)[2], index + 1);
			right(i, j, 0, index);
			up(i, j, 0, index);
			right(i, j, 1, index);
			down(i, j, 1, index);
			dfs(cctv.get(index + 1)[0], cctv.get(index + 1)[1], cctv.get(index + 1)[2], index + 1);
			down(i, j, 0, index);
			right(i, j, 0, index);
			down(i, j, 1, index);
			left(i, j, 1, index);
			dfs(cctv.get(index + 1)[0], cctv.get(index + 1)[1], cctv.get(index + 1)[2], index + 1);
			left(i, j, 0, index);
			down(i, j, 0, index);
			left(i, j, 1, index);
			up(i, j, 1, index);
			dfs(cctv.get(index + 1)[0], cctv.get(index + 1)[1], cctv.get(index + 1)[2], index + 1);
			up(i, j, 0, index);
			left(i, j, 0, index);
		} else if (num == 4) {
			up(i, j, 1, index);
			left(i, j, 1, index);
			right(i, j, 1, index);
			dfs(cctv.get(index + 1)[0], cctv.get(index + 1)[1], cctv.get(index + 1)[2], index + 1);
			right(i, j, 0, index);
			left(i, j, 0, index);
			up(i, j, 0, index);
			up(i, j, 1, index);
			right(i, j, 1, index);
			down(i, j, 1, index);
			dfs(cctv.get(index + 1)[0], cctv.get(index + 1)[1], cctv.get(index + 1)[2], index + 1);
			down(i, j, 0, index);
			right(i, j, 0, index);
			up(i, j, 0, index);
			left(i, j, 1, index);
			right(i, j, 1, index);
			down(i, j, 1, index);
			dfs(cctv.get(index + 1)[0], cctv.get(index + 1)[1], cctv.get(index + 1)[2], index + 1);
			down(i, j, 0, index);
			right(i, j, 0, index);
			left(i, j, 0, index);
			up(i, j, 1, index);
			down(i, j, 1, index);
			left(i, j, 1, index);
			dfs(cctv.get(index + 1)[0], cctv.get(index + 1)[1], cctv.get(index + 1)[2], index + 1);
			left(i, j, 0, index);
			down(i, j, 0, index);
			up(i, j, 0, index);
		}

	}

	public static void oversee(int i, int j) {
		up(i, j, 1, 100);
		down(i, j, 1, 100);
		left(i, j, 1, 100);
		right(i, j, 1, 100);
	}

	public static void up(int i, int j, int index, int n) {
		if (index == 0) {
			for (int x = i - 1; x >= 0; x--) {
				if (arr[x][j] == n + 10) {
					arr[x][j] = 0;
				}
			}
		} else {
			for (int x = i - 1; x >= 0; x--) {
				if (arr[x][j] == 0) {
					arr[x][j] = n + 10;
				} else if (arr[x][j] == 6) {
					return;
				}
			}
		}
	}

	public static void down(int i, int j, int index, int n) {
		if (index == 0) {
			for (int x = i + 1; x < N; x++) {
				if (arr[x][j] == n + 10) {
					arr[x][j] = 0;
				}
			}
		} else {
			for (int x = i + 1; x < N; x++) {
				if (arr[x][j] == 0) {
					arr[x][j] = n + 10;
				} else if (arr[x][j] == 6) {
					return;
				}
			}
		}
	}

	public static void right(int i, int j, int index, int n) {
		if (index == 0) {
			for (int x = j + 1; x < M; x++) {
				if (arr[i][x] == n + 10) {
					arr[i][x] = 0;
				}
			}
		} else {
			for (int x = j + 1; x < M; x++) {
				if (arr[i][x] == 0) {
					arr[i][x] = n + 10;
				} else if (arr[i][x] == 6) {
					return;
				}
			}
		}
	}

	public static void left(int i, int j, int index, int n) {
		if (index == 0) {
			for (int x = j - 1; x >= 0; x--) {
				if (arr[i][x] == n + 10) {
					arr[i][x] = 0;
				}
			}
		} else {
			for (int x = j - 1; x >= 0; x--) {
				if (arr[i][x] == 0) {
					arr[i][x] = n + 10;
				} else if (arr[i][x] == 6) {
					return;
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
		cctv5 = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] != 0 && arr[i][j] != 6) {
					if (arr[i][j] == 5)
						cctv5.add(new int[] { i, j });
					else
						cctv.add(new int[] { i, j, arr[i][j] });
				}
			}
		}
		cctv.add(new int[] {0,0,0});
		for (int i = 0; i < cctv5.size(); i++) {
			oversee(cctv5.get(i)[0], cctv5.get(i)[1]);
		}
		result = Integer.MAX_VALUE;
		dfs(cctv.get(0)[0], cctv.get(0)[1], cctv.get(0)[2], 0);

		int r=0;
		if(result == Integer.MAX_VALUE) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(arr[i][j]==0) {
						r++;
					}
				}
			}
			result = r;
		}
		System.out.println(result);

	}

}
