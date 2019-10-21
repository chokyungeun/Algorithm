package solution;

import java.io.*;
import java.util.*;

public class Main_백준_15683_감시_서울9반_조경은 {
	public static int[][] arr, temp;
	public static int N, M;
	public static int[] di = { -1, 0, 1, 0 }; // 상우하좌
	public static int[] dj = { 0, 1, 0, -1 }; // 상우하좌
	public static ArrayList<int[]> cctv;

	public static void oversee(int i, int j, int num) {
		int max = 0;
		temp = new int[N][M];
		for(int k=0; k<arr.length; k++) {
			temp[k] = arr[k].clone();
		}
		
		if (num == 1) {
			for(int k=0; k<4; k++) {
				dfs(i,j,k);
			}
			
		} else if (num == 2) {

		} else if (num == 3) {

		} else if (num == 4) {

		} else if (num == 5) {

		}
	}
	
	public static void dfs(int i, int j, int d) {
		
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

		for (int i = 0; i < cctv.size(); i++) {
			oversee(cctv.get(i)[0], cctv.get(i)[1], cctv.get(i)[2]);
		}

	}

}
