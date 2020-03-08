package algoad4;

import java.io.*;
import java.util.*;

public class Solution_D9_2105_디저트카페_서울9반_조경은 {
	public static int N, res;
	public static int[][] map;
	public static int[] di = {1,1,-1,-1};
	public static int[] dj = {1,-1,-1,1};
	public static boolean[] number;
	
	public static void dessert(int i, int j, int row, int col) {
		int index=1;
		int ni = i;
		int nj = j;
		number[map[i][j]] = true;
		for(int x=0; x<row; x++) {
			ni += di[0];
			nj += dj[0];
			if(ni>=0 && ni<N && nj>=0 && nj<N && !number[map[ni][nj]]) {
				number[map[ni][nj]] = true;
				index++;
			}
			else {
				return;
			}
		}
		for(int x=0; x<col; x++) {
			ni += di[1];
			nj += dj[1];
			if(ni>=0 && ni<N && nj>=0 && nj<N && !number[map[ni][nj]]) {
				number[map[ni][nj]] = true;
				index++;
			}
			else {
				return;
			}
		}
		for(int x=0; x<row; x++) {
			ni += di[2];
			nj += dj[2];
			if(ni>=0 && ni<N && nj>=0 && nj<N && !number[map[ni][nj]]) {
				number[map[ni][nj]] = true;
				index++;
			}
			else {
				return;
			}
		}
		for(int x=0; x<col; x++) {
			ni += di[3];
			nj += dj[3];
			if(ni>=0 && ni<N && nj>=0 && nj<N && !number[map[ni][nj]]) {
				number[map[ni][nj]] = true;
				index++;
			}
			else if(ni==i && nj==j){
				res = Math.max(res, index);
				
				return;
			}
			else return;
		}
		
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d9_2105.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			res=-1;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<N-2; i++) {
				for(int j=1; j<N-1; j++) {
					for(int row=1; row<N-1; row++) {
						for(int col=1; col<N-1; col++) {
							number = new boolean[101];
							dessert(i,j,row,col);
						}
					}
					
				}
			}
			
			System.out.println("#" + t + " " + res);
			
		}

	}

}
