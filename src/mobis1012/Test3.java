package mobis1012;

import java.io.*;
import java.util.*;

public class Test3 {
	public static String[] board = {"ABCBA","DABAG","EBABH","FAJAI","AKLMA"};
	public static int[] di = {-1,-1,1,1};
	public static int[] dj = {-1,1,-1,1};
	public static char alpha;
	public static char[][] cb;
	public static int res1, res2,N;
	
	public static void bfs(int i, int j) {
		int index=0;
		res2=0;
		while(true) {
			++index;
			for(int k=0; k<4; k++) {
				int ni = i+(index*di[k]);
				int nj = j+(index*dj[k]);
				if(ni<0 || ni>=N || nj<0 || nj>=N || cb[ni][nj]!=alpha) {
					return;
				}
			}
			res2++;
		}
	}
	
	public static void main(String[] args) {
		int answer = 0;
		N = board.length;
		cb = new char[N][N];
		for(int i=0; i<N; i++) {
			cb[i] = board[i].toCharArray();
		}
		res1 = 0;
		for(int i=1; i<N-1; i++) {
			for(int j=1; j<N-1; j++) {
				alpha = cb[i][j];
				bfs(i,j);
				res1 = Math.max(res1, res2);
			}
		}
		
		answer = (res1*2)+1;
		System.out.println(answer);
	}

}
