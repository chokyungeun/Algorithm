package kakao0509;
import java.io.*;
import java.util.*;

public class Main4 {
	public static int[][] board = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static int result;
	public static boolean[][] v;
	public static void dfs(int i, int j,int st, int cor, int dir) {
		if(i==board.length-1 && j == board.length-1) {
			int num = (st*100) + (cor*500);
			result = Math.min(result, num);
			return;
		}
		v[i][j] = true;
		
		for(int k=0; k<di.length; k++) {
			int ni = i+di[k];
			int nj = j+dj[k];
			if(ni>=0 && ni<board.length && nj>=0 && nj<board.length && board[ni][nj]==0 && !v[ni][nj]) {
				if(k==0 || k==1) {
					if(dir==-1) {
						dfs(ni,nj,st+1,cor+1,1);
						
					}
					else {
						dfs(ni,nj,st+1,cor,1);
					}
				}
				else {
					if(dir==1) {
						dfs(ni,nj,st+1,cor+1,-1);
						
					}
					else {
						dfs(ni,nj,st+1,cor,-1);
					}
				}
			}
		}
		v[i][j] = false;
	}
	public static void main(String[] args) throws Exception {
		v = new boolean[board.length][board.length];
		result = Integer.MAX_VALUE;
		dfs(0,0,0,0,0);
		
		System.out.println(result);
	}

}
