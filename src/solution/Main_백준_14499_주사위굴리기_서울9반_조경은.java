package solution;

import java.io.*;
import java.util.*;

public class Main_백준_14499_주사위굴리기_서울9반_조경은 {
	public static int N, M, K;
	public static int[][] map;
	public static int[] inst, dice;
	public static int[] di = { 0, 0, -1, 1 };
	public static int[] dj = { 1, -1, 0, 0 };

	public static void move(int i, int j, int count) {
		

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		dice = new int[6];
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		inst = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			inst[i] = (Integer.parseInt(st.nextToken()) - 1);
		}

		
	}

}
