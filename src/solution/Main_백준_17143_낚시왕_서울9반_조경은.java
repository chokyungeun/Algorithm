package solution;

import java.util.*;
import java.io.*;

public class Main_백준_17143_낚시왕_서울9반_조경은 {
	public static ArrayList<Shark> list;
	public static int[] di = { -1, 1, 0, 0 };
	public static int[] dj = { 0, 0, 1, -1 };
	public static int R, C, M;
	public static Shark arr[][];

	public static class Shark {
		int r;
		int c;
		int speed;
		int d;
		int size;

		public Shark(int r, int c, int speed, int d, int size) {
			this.r = r;
			this.c = c;
			this.speed = speed;
			this.d = d;
			this.size = size;
		}
	}

	public static void move() {
		// 상어이동
		for (int i = 0; i < list.size(); i++) {
			Shark shark = list.get(i);
			int ni = shark.r;
			int nj = shark.c;
			for (int j = 0; j < shark.speed; j++) {
				if (shark.d == 0 || shark.d == 1) {
					if (ni == 0) {
						shark.d = 1;
					} else if (ni == R - 1) {
						shark.d = 0;
					}
				} else {
					if (nj == 0) {
						shark.d = 2;
					} else if (nj == C - 1) {
						shark.d = 3;
					}
				}
				ni += di[shark.d];
				nj += dj[shark.d];
			}
			arr[shark.r][shark.c] = null;
			shark.r = ni;
			shark.c = nj;
		}

		// 중복제거
		for (int i = 0; i < list.size(); i++) {
			Shark shark = list.get(i);
			if (arr[shark.r][shark.c] == null) {
				arr[shark.r][shark.c] = shark;
			} else if (arr[shark.r][shark.c].size > shark.size) {
				list.remove(shark);
				i--;
			} else {
				list.remove(arr[shark.r][shark.c]);
				arr[shark.r][shark.c] = shark;
				i--;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new Shark[R][C];
		list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int speed = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int size = Integer.parseInt(st.nextToken());
			Shark shark = new Shark(r, c, speed, d, size);
			list.add(shark);
			arr[r][c] = shark;
		}

		int res = 0;
		for (int t = 0; t < C; t++) {
			// 낚시왕 낚시 시작!
			for (int i = 0; i < R; i++) {
				if (arr[i][t] != null) {
					res += arr[i][t].size;
					list.remove(arr[i][t]);
					arr[i][t] = null;
					break;
				}
			}
			move();
		}
		System.out.println(res);

	}

}
