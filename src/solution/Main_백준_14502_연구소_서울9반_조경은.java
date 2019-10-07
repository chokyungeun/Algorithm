package solution;

import java.io.*;
import java.util.*;

public class Main_백준_14502_연구소_서울9반_조경은 {
	public static int N, M, answer;
	public static int[][] arr, temp;
	public static ArrayList<int[]> virus;
	public static boolean[][] v;
	public static int[] di = { -1, 1, 0, 0 };
	public static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		temp = new int[N][N];
		virus = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2)
					virus.add(new int[] { i, j });
			}
		}
		v = new boolean[N][N];
		answer = 0;
		
		
		
		System.out.println(answer);
	}

	private static void vir(int i, int j, int cnt) {
		
		
		
		
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { i, j });
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int k = 0; k < di.length; k++) {
				int ni = curr[0] + di[k];
				int nj = curr[1] + dj[k];
				if (ni >= 0 && ni < N && nj >= 0 && nj < M && temp[ni][nj] == 0) {
					temp[ni][nj] = 2;
					q.offer(new int[] { ni, nj });
				}
			}
		}
	}
}
