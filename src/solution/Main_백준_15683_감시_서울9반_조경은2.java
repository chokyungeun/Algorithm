package solution;

import java.io.*;
import java.util.*;

public class Main_백준_15683_감시_서울9반_조경은2 {
	public static int[][] arr;
	public static int N,M;
	public static int[] di = {-1,0,1,0}; //상우하좌
	public static int[] dj = {0,1,0,-1}; //상우하좌
	public static ArrayList<int[]> cctv;
	
	public static void oversee() {
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		cctv = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] != 6 && arr[i][j]!=0) {
					cctv.add(new int[] {i,j,arr[i][j]});
				}
			}
		}
		
		
		
	}

}
