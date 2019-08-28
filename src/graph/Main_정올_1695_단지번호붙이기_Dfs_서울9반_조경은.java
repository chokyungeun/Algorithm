package graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main_정올_1695_단지번호붙이기_Dfs_서울9반_조경은 {
	public static int[][] arr;
	public static boolean[][] v;
	public static int N;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static int res;
	
	public static void dfs(int i, int j) {
		v[i][j] = true;
		res++;
		for(int k=0; k<di.length; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			if(ni>=0 && ni<N && nj>=0 && nj<N && v[ni][nj] == false && arr[ni][nj] == 1) {
				dfs(ni, nj);
			}
		}
		
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_jo_1695.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		v = new boolean[N][N];
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split("");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		ArrayList<Integer> r = new ArrayList<>();
		int num =0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] == 1 && v[i][j] == false) {
					num++;
					res = 0;
					dfs(i, j);
					r.add(res);
				}
			}
		}
		System.out.println(num);
		Collections.sort(r);
		for(int i=0; i<num; i++) {
			System.out.println(r.get(i));
		}
		
	}

}
