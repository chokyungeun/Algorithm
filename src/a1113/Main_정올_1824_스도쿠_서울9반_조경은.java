package a1113;

import java.io.*;
import java.util.*;

public class Main_정올_1824_스도쿠_서울9반_조경은 {
	public static boolean available(int[][] a, int r, int c, int target) {
		for(int k=0; k<a.length; k++) {
			if(a[k][c]==target || a[r][k]==target)
				return false;
		}
		int nr=r/3*3;
		int nc=c/3*3;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(a[nr+i][nc+j]==target)
					return false;
			}
		}
		return true;
	}
	
	public static void dfs(int[][] a, List<int[]> zero, int index) {
		
		if(index==zero.size()) {
			for(int[] b:a) {
				for(int n:b) {
					System.out.print(n+" ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		int[] loc=zero.get(index);
		int i=loc[0];
		int j=loc[1];
		for(int t=1; t<=9; t++) {
			if(available(a,i,j,t)) {
				a[i][j]=t;
				dfs(a,zero,index+1);
				a[i][j]=0;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<int[]> zero = new ArrayList<>();
		int[][] arr = new int[9][9];
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==0) {
					zero.add(new int[] {i,j});
				}
			}
		}
		dfs(arr,zero,0);
		
	}

}
