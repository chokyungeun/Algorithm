package solution;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution22_조경은 {

	static int[] drow = { -1, 1, 0, 0 };
	static int[] dcol = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_Solution22.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			int N = sc.nextInt();
			int num = sc.nextInt();
			int[][] d = new int[N][N];
			int[][] n = new int[N][N];
			int[][] arr = new int[N][N];
			int result = 0;

			for (int i = 0; i < num; i++) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				if (arr[n1][n2] != 0) {
					n[n1][n2] = sc.nextInt();
					continue;
				} else {
					arr[n1][n2] = 1;
					d[n1][n2] = sc.nextInt();
				}
			}
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					int nrow = row;
					int ncol = col;
					int nd = d[nrow][ncol]-1;
					if (arr[nrow][ncol] == 1) {
						for (int jump = 3; jump > 0; jump--) {
							arr[nrow][ncol] = 0;
							
							nrow = nrow + (drow[nd]*jump);
							ncol = ncol + (dcol[nd]*jump);
							
							if(nrow>=0 && nrow<N && ncol >=0 && ncol <N) {
								if(arr[nrow][ncol] != 0) {
									break;
								}
								else {
									 
									 if(jump == 1) {
										 arr[nrow][ncol] = -1;
									 }
								}
							}
							else {
								break;
							}
						}
					}
				}
			}
			for(int row=0; row<N; row++) {
				for(int col = 0; col < N; col++) {
					if(arr[row][col] == -1) {
						++result;
					}
				}
			}

			System.out.println("#" + tc + " " + result);
		}
	}
}
