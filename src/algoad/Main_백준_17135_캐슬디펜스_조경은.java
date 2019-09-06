package algoad;

import java.io.*;
import java.util.*;

public class Main_백준_17135_캐슬디펜스_조경은 {
	public static int N, M, D;
	public static int[] l;
	public static boolean[] v;
	public static int[][] arr;
	public static ArrayList<Integer> list;

	private static void comb(int a, int b) {
		if (b == 3) {
			func();
			return;
		}

		for (int i = a; i < M; i++) {
			if(!v[i]) {
				v[i]=true;
				l[b] = i;
				comb(i, b+1);
				v[i] = false;
			}
		}
	}

	private static void func() {
		int[][] arr2 = new int[N + 1][M];
		for (int i = 0; i < arr.length; i++) {
			System.arraycopy(arr[i], 0, arr2[i], 0, arr[i].length);
		}
		int res = 0;
		while (true) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr2[i][j] != 0)
						cnt++;
				}
			}
			if (cnt == 0) {
				break;
			}

			// 궁수가 활쏨(동시에 쏠 수 있음!) 문제 제대로 읽자ㅠㅠㅠㅠㅠㅠ
			ArrayList<int[]> shot = new ArrayList<>();
			
			for (int i = 0; i < 3; i++) {
				Loop: for(int d=1; d<=D; d++) {
					for (int col = 0; col < M; col++) {
						for (int row = 0; row < N; row++) {
							if (Math.abs(row - N) + Math.abs(l[i] - col) == d && arr2[row][col] == 1) {
								shot.add(new int[] {row,col});
								break Loop;
							}
						}
					}
				}
			}
			for(int i=0; i<shot.size(); i++) {
				if(arr2[shot.get(i)[0]][shot.get(i)[1]] == 1) {
					res++;
					arr2[shot.get(i)[0]][shot.get(i)[1]] = 0;
				}
			}
			
			
			// 한 칸씩 이동
			for (int i = N - 1; i > 0; i--) {
				for (int j = 0; j < M; j++) {
					arr2[i][j] = arr2[i - 1][j];
				}
			}
			for (int j = 0; j < M; j++) {
				arr2[0][j] = 0;
			}
		}
		list.add(res);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		l = new int[3];
		v = new boolean[M];
		arr = new int[N + 1][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		list = new ArrayList<>();
		comb(0, 0);

		int max = 0;
		
		for (int i = 0; i < list.size(); i++) {
			max = Math.max(max, list.get(i));
		}

		System.out.println(max);
	}

}
