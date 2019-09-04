package solution;

import java.util.*;
import java.io.*;

public class Main_백준_17144_미세먼지안녕_서울9반_조경은 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int di[] = {-1,1,0,0};
		int dj[] = {0,0, -1,1};
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] arr = new int[R][C];
		int mi = 0;
		int mj = 0;
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == -1) {
					mi = i;
					mj = j;
				}
			}
		}
		
		int[][] narr;
		for(int t=0; t<T; t++) {
			narr = new int[R][C];
			for(int row=0; row<R; row++) {
				for(int col=0; col<C; col++) {
					if(arr[row][col] != 0 && arr[row][col] != -1) {
						int dust = arr[row][col]/5;
						 for(int d = 0; d < di.length; d++) {
			                int ni = row+di[d];
			                int nj = col+dj[d];
			                if(0<=ni && ni<R && 0<=nj && nj<C && arr[ni][nj] != -1) {
			                    arr[row][col] -= dust;
			                    narr[ni][nj] += dust;
			                }
			            }
						narr[row][col] += arr[row][col];
					}
				}
			}
			for(int i=0; i<narr.length; i++) {
				System.arraycopy(narr[i], 0, arr[i], 0, narr[i].length);
			}
			arr[mi][mj] = -1;
			arr[mi-1][mj] = -1;
			
			mi--;
			
			for(int row=mi-1; row>0; row--) {
				arr[row][mj] = arr[row-1][mj];
			}
			for(int col=mj; col<C-1; col++) {
				arr[0][col] = arr[0][col+1];
			}
			for(int row=0; row<mi; row++) {
				arr[row][C-1] = arr[row+1][C-1];
			}
			for(int col=C-1; col>mj; col--) {
				arr[mi][col] = arr[mi][col-1];
			}
			arr[mi][mj+1] = 0;
			mi++;
			for(int row=mi+1; row<R-1; row++) {
				arr[row][mj] = arr[row+1][mj];
			}
			for(int col=mj; col<C-1; col++) {
				arr[R-1][col] = arr[R-1][col+1];
			}
			for(int row=R-1; row>mi; row--) {
				arr[row][C-1] = arr[row-1][C-1];
			}
			for(int col=C-1; col>mj; col--) {
				arr[mi][col] = arr[mi][col-1];
			}
			arr[mi][mj+1] = 0;
		}
		int sum=0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				sum+=arr[i][j];
			}
		}
		
		System.out.println(sum+2);
	}

}
