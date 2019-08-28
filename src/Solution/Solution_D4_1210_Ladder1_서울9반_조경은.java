package Solution;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D4_1210_Ladder1_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1210.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<11; tc++) {
			int[][] arr = new int[100][100];
			int nrow=99;
			int ncol=0;
			int result=0;
			int t = sc.nextInt();
			for(int row=0; row<100; row++) {
				for(int col=0; col<100; col++) {
					arr[row][col] = sc.nextInt();
				}
			}
			
			for(int col=0; col<100; col++) {
				if(arr[99][col] == 2) {
					ncol = col;
					break;
				}
			}
			while(nrow > 0) {
				if(ncol-1>=0) {
					if(arr[nrow][ncol-1]==1) {
						arr[nrow][ncol] = -1;
						ncol = ncol-1;
					}
					else {
						if(ncol+1 < 100) {
							if(arr[nrow][ncol+1]==1) {
								arr[nrow][ncol] = -1;
								ncol = ncol+1;
							}
							else {
								if(nrow-1 > 0) {
									arr[nrow][ncol] = -1;
									nrow -= 1;
								}
								else {
									result = ncol;
									break;
								}
							}
						}
						else {
							if(nrow-1 > 0) {
								arr[nrow][ncol] = -1;
								nrow -= 1;
							}
							else {
								result = ncol;
								break;
							}
						}
					}
				
				}
				else {
					if(ncol+1 < 100) {
						if(arr[nrow][ncol+1]==1) {
							arr[nrow][ncol] = -1;
							ncol = ncol+1;
						}
						else {
							if(nrow-1 > 0) {
								arr[nrow][ncol] = -1;
								nrow -= 1;
							}
							else {
								result = ncol;
								break;
							}
						}
					}
					else {
						if(nrow-1 > 0) {
							arr[nrow][ncol] = -1;
							nrow -= 1;
						}
						else {
							result = ncol;
							break;
						}
					}
					
				}
				if(nrow == 0) {
					result = ncol;
					break;
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}
}
