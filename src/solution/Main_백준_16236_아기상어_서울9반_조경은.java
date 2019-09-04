package solution;

import java.util.*;
import java.io.*;

public class Main_백준_16236_아기상어_서울9반_조경은 {
	public static int[] di = {-1,0,1,0};
	public static int[] dj = {0,-1,0,1};
	public static int[][] arr;
	public static int N, res, size, f;
	public static ArrayList<int[]> l;
	
	public static void bfs(int i, int j) {
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		int row = 0;
		int col = 0;
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
				if(arr[i][j] == 9) {
					row = i;
					col = j;
				}
			}
		}
		res = 0;
		bfs(row, col);
		
		System.out.println(res);


	}

}
