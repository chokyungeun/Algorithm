package midasIT0523;
import java.io.*;
import java.util.*;

public class Main3 {
	public static int answer,res;
	public static boolean[][] visit;
	
	public static void crush(int[][] board) {
		visit = new boolean[board.length][board.length];
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board.length; j++) {
				if(board[i][j]!=0) {
					int candy = board[i][j];
					int index = 1;
					for(int row=i+1; row<board.length; row++) {
						if(board[row][j]==candy) {
							index++;
						}
						else {
							break;
						}
					}
					if(index>=3) {
						for(int row=0; row<index; row++) {
							visit[i+row][j]=true;
						}
					}
					index=1;
					for(int col=j+1; col<board.length; col++) {
						if(board[i][col]==candy) {
							index++;
						}
						else {
							break;
						}
					}
					if(index>=3) {
						for(int col=0; col<index; col++) {
							visit[i][j+col]=true;
						}
					}
				}
			}
		}
		int[][] temp = new int[board.length][board.length];
		for(int k=0; k<board.length; k++) {
			temp[k] = Arrays.copyOf(board[k], board.length);
		}
		move(temp);
	}
	
	public static void move(int[][] board) {
		boolean flag = false;
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board.length; j++) {
				if(visit[i][j]) {
					flag = true;
					res++;
					board[i][j]=0;
				}
			}
		}
		
		if(!flag) {
			return;
		}
		
		for(int row=board.length-1; row>0; row--) {
			for(int col=0; col<board.length; col++) {
				if(board[row][col]==0) {
					for(int x=row-1; x>=0; x--) {
						if(board[x][col]!=0) {
							board[row][col] = board[x][col];
							board[x][col]=0;
							break;
						}
					}
				}
			}
		}
		
		for(int x=0; x<board.length; x++) {
			for(int y=0; y<board.length; y++) {
				System.out.print(board[x][y] + " ");
			}
			System.out.println();
		}
		System.out.println();
		int[][] temp = new int[board.length][board.length];
		for(int k=0; k<board.length; k++) {
			temp[k] = Arrays.copyOf(board[k], board.length);
		}	
		crush(temp);
	}
	
	public static void main(String[] args) throws Exception {
		int[][] board = {{3,3,3},{3,3,3},{3,3,3}};
		answer = 0;
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board.length; j++) {
				int[][] temp = new int[board.length][board.length];
				for(int k=0; k<board.length; k++) {
					temp[k] = Arrays.copyOf(board[k], board.length);
				}
				res=0;
				visit = new boolean[board.length][board.length];
				visit[i][j]=true;
				move(temp);
				answer = Math.max(answer, res);
			}
		}
		System.out.println(answer);
	}

}
