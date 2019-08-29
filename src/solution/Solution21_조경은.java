package solution;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution21_조경은 {
	static int[] drow = { 1, 0 };
	static int[] dcol = { 0, 1 };

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/Solution21.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc < T + 1; tc++) {

			int N = sc.nextInt();
			int num = sc.nextInt();
			int[][] arr = new int[N][N];
			int[] row = new int[num];
			int[] col = new int[num];
			int bug = 0;
			int result = 0;
			int[] dir = new int[num];

			for (int i = 0; i < num; i++) {
				row[i] = sc.nextInt();
				col[i] = sc.nextInt();
				dir[i] = sc.nextInt() - 1;
				arr[row[i]][col[i]] = 1;
			}

			Loop: for (int i = 0; i < num; i++) {
				int nrow = row[i];
				int ncol = col[i];
				for (int jump = 3; jump > 0; jump--) {
					nrow = nrow + (drow[dir[i]] * jump);
					ncol = ncol + (dcol[dir[i]] * jump);
					if (nrow >= 0 && nrow < N && ncol >= 0 && ncol < N) {
						if (arr[nrow][ncol] == 0) {
							arr[nrow][ncol] = -1;
						}
						else {
							result = bug + 1;
							break Loop;
						}
					}
					else {
						break;
					}
				}
				++bug;
			}
			System.out.println("#" + tc + " " + result);
		}
	}
}
