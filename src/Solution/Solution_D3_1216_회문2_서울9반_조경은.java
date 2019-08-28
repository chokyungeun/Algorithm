package Solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D3_1216_회문2_서울9반_조경은 {

	static char[][] arr;
	static int res = 0;

	static void func() {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				int len = 1;
				while (j + len < 100 && j - len > 0 && arr[i][j + len] == arr[i][j - len]) {
					len++;
				}
				if (len != 1 && res < len * 2 - 1)
					res = len * 2 - 1;

				len = 0;
				while (j + len + 1 < 100 && j - len > 0 && arr[i][j + len + 1] == arr[i][j - len]) {
					len++;
				}
				if (len != 0 && res < len * 2)
					res = len * 2;
			}
		}
		for (int j = 0; j < 100; j++) {
			for (int i = 0; i < 100; i++) {
				int len = 1;
				while (i + len < 100 && i - len > 0 && arr[i + len][j] == arr[i - len][j]) {
					len++;
				}
				if (len != 1 && res < len * 2 - 1)
					res = len * 2 - 1;
				len = 0;
				while (i + len + 1 < 100 && i - len > 0 && arr[i + len + 1][j] == arr[i - len][j]) {
					len++;
				}
				if (len != 0 && res < len * 2)
					res = len * 2;
			}
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_D3_1216.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			res = 0;
			int n = Integer.parseInt(br.readLine());
			arr = new char[100][100];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			func();
			System.out.println("#" + n + " " + res);
		}
	}

}
