package com.ssafy;

import java.io.*;
import java.util.*;

public class Main_백준_15683_감시_서울9반_조경은 {
	public static int N, M, res;
	public static int[][] map;
	public static ArrayList<int[]> cctv, cctv5;

	public static void doup(int i, int j, int num) {
		for (int x = i - 1; x >= 0; x--) {
			if (map[x][j] == 0) {
				map[x][j] = num;
			} else if (map[x][j] == 6) {
				return;
			}
		}
	}

	public static void dodown(int i, int j, int num) {
		for (int x = i + 1; x < N; x++) {
			if (map[x][j] == 0) {
				map[x][j] = num;
			} else if (map[x][j] == 6) {
				return;
			}
		}
	}

	public static void doleft(int i, int j, int num) {
		for (int x = j - 1; x >= 0; x--) {
			if (map[i][x] == 0) {
				map[i][x] = num;
			} else if (map[i][x] == 6) {
				return;
			}
		}
	}

	public static void doright(int i, int j, int num) {
		for (int x = j + 1; x < M; x++) {
			if (map[i][x] == 0) {
				map[i][x] = num;
			} else if (map[i][x] == 6) {
				return;
			}
		}
	}

	public static void backup(int i, int j, int num) {
		for (int x = i - 1; x >= 0; x--) {
			if (map[x][j] == num) {
				map[x][j] = 0;
			}
		}
	}

	public static void backdown(int i, int j, int num) {
		for (int x = i + 1; x < N; x++) {
			if (map[x][j] == num) {
				map[x][j] = 0;
			}
		}
	}

	public static void backleft(int i, int j, int num) {
		for (int x = j - 1; x >= 0; x--) {
			if (map[i][x] == num) {
				map[i][x] = 0;
			}
		}
	}

	public static void backright(int i, int j, int num) {
		for (int x = j + 1; x < M; x++) {
			if (map[i][x] == num) {
				map[i][x] = 0;
			}
		}
	}

	public static void oversee(int index) {
		if (index == cctv.size()) {
			int r = 0;
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
					if (map[x][y] == 0) {
						r++;
					}
				}
			}
			res = Math.min(res, r);
			return;
		}

		int i = cctv.get(index)[0];
		int j = cctv.get(index)[1];
		int cnum = cctv.get(index)[2];

		if (cnum == 1) {
			doup(i, j, index + 10);
			oversee(index + 1);
			backup(i, j, index + 10);
			dodown(i, j, index + 10);
			oversee(index + 1);
			backdown(i, j, index + 10);
			doleft(i, j, index + 10);
			oversee(index + 1);
			backleft(i, j, index + 10);
			doright(i, j, index + 10);
			oversee(index + 1);
			backright(i, j, index + 10);
		} 
		else if (cnum == 2) {
			doup(i, j, index + 10);
			dodown(i, j, index + 10);
			oversee(index + 1);
			backdown(i, j, index + 10);
			backup(i, j, index + 10);
			doleft(i, j, index + 10);
			doright(i, j, index + 10);
			oversee(index + 1);
			backright(i, j, index + 10);
			backleft(i, j, index + 10);
		} 
		else if (cnum == 3) {
			doup(i, j, index + 10);
			doright(i, j, index + 10);
			oversee(index + 1);
			backup(i, j, index + 10);
			dodown(i, j, index + 10);
			oversee(index + 1);
			backright(i, j, index + 10);
			doleft(i, j, index + 10);
			oversee(index + 1);
			backdown(i, j, index + 10);
			doup(i, j, index + 10);
			oversee(index + 1);
			backup(i, j, index + 10);
			backleft(i, j, index + 10);
		} 
		else if (cnum == 4) {
			doup(i, j, index + 10);
			doright(i, j, index + 10);
			doleft(i, j, index + 10);
			oversee(index + 1);
			backleft(i, j, index + 10);
			dodown(i, j, index + 10);
			oversee(index + 1);
			backup(i, j, index + 10);
			doleft(i, j, index + 10);
			oversee(index + 1);
			backright(i, j, index + 10);
			doup(i, j, index + 10);
			oversee(index + 1);
			backup(i, j, index + 10);
			backleft(i, j, index + 10);
			backdown(i, j, index + 10);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctv = new ArrayList<>();
		cctv5 = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					if (map[i][j] == 5) {
						cctv5.add(new int[] { i, j });
					} else {
						cctv.add(new int[] { i, j, map[i][j] });
					}
				}
			}
		}

		// 5번 cctv 먼저 처리
		for (int i = 0; i < cctv5.size(); i++) {
			doup(cctv5.get(i)[0], cctv5.get(i)[1], Integer.MAX_VALUE);
			dodown(cctv5.get(i)[0], cctv5.get(i)[1], Integer.MAX_VALUE);
			doleft(cctv5.get(i)[0], cctv5.get(i)[1], Integer.MAX_VALUE);
			doright(cctv5.get(i)[0], cctv5.get(i)[1], Integer.MAX_VALUE);
		}

		res = Integer.MAX_VALUE;
		oversee(0);
		int r = 0;
		if (res == Integer.MAX_VALUE) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]==0) {
						r++;
					}
				}
			}
			res = r;
		}
		System.out.println(res);
	}

}
