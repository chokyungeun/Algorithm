package solution;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution32_조경은 {
	static int[] drow = { 0, 1, 0, -1 };
	static int[] dcol = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_Solution32.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			int Y = sc.nextInt();
			int X = sc.nextInt();
			int N = sc.nextInt();
			int price = 0;
			int[][] arr = new int[Y][X];
			int[] urow = new int[N];
			int[] ucol = new int[N];
			int[] unum = new int[N];
			for (int row = 0; row < Y; row++) {
				for (int col = 0; col < X; col++) {
					arr[row][col] = sc.nextInt();
				}
			}
			for (int i = 0; i < N; i++) {
				urow[i] = sc.nextInt();
				ucol[i] = sc.nextInt();
				unum[i] = sc.nextInt();
			}
			int trap_num = sc.nextInt();
			int[] trow = new int[trap_num];
			int[] tcol = new int[trap_num];

			for (int i = 0; i < trap_num; i++) {
				trow[i] = sc.nextInt() - 1;
				tcol[i] = sc.nextInt() - 1;
				arr[trow[i]][tcol[i]] = 0;
			}
			for (int i = 0; i < N; i++) {
				int ur = urow[i] - 1;
				int uc = ucol[i] - 1;
				
				boolean b = true;
				for (int j = 0; j < unum[i]; j++) {
					int x = arr[ur][uc];
					ur = ur + drow[(x / 10 - 1)] * (x % 10);
					uc = uc + dcol[(x / 10 - 1)] * (x % 10);
					if (ur < 0 || ur >= Y || uc < 0 || uc >= X || arr[ur][uc] == 0) {
						b = false;
						break;
					}
				}
				if(b)
					price += (arr[ur][uc] * 100);
			}
			int result = price - (N * 1000);
			System.out.println("#" + tc + " " + result);
		}
	}
}
