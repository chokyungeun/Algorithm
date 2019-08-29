package a0829;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D3_1873_상호의배틀필드_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1873.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] s = br.readLine().split(" ");
			int H = Integer.parseInt(s[0]);
			int W = Integer.parseInt(s[1]);
			char[][] arr = new char[H][W];
			for (int i = 0; i < H; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			int N = Integer.parseInt(br.readLine());
			char[] input = br.readLine().toCharArray();
			int ni = 0;
			int nj = 0;
			Loop: for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (arr[i][j] == '^' || arr[i][j] == 'v' || arr[i][j] == '<' || arr[i][j] == '>') {
						ni = i;
						nj = j;
						break Loop;
					}
				}
			}
			int[] di = { -1, 1, 0, 0 };
			int[] dj = { 0, 0, -1, 1 };

			for (int i = 0; i < N; i++) {
				if (input[i] == 'U') {
					if (ni - 1 >= 0) {
						if (arr[ni - 1][nj] == '.') {
							arr[ni - 1][nj] = '^';
							arr[ni][nj] = '.';
							ni = ni - 1;
						} else {
							arr[ni][nj] = '^';
						}
					} else {
						arr[ni][nj] = '^';
					}
				} else if (input[i] == 'D') {
					if (ni + 1 < H) {
						if (arr[ni + 1][nj] == '.') {
							arr[ni + 1][nj] = 'v';
							arr[ni][nj] = '.';
							ni = ni + 1;
						} else {
							arr[ni][nj] = 'v';
						}
					} else {
						arr[ni][nj] = 'v';
					}
				} else if (input[i] == 'L') {
					if (nj - 1 >= 0) {
						if (arr[ni][nj - 1] == '.') {
							arr[ni][nj - 1] = '<';
							arr[ni][nj] = '.';
							nj = nj - 1;
						} else {
							arr[ni][nj] = '<';
						}
					} else {
						arr[ni][nj] = '<';
					}
				} else if (input[i] == 'R') {
					if (nj + 1 < W) {
						if (arr[ni][nj + 1] == '.') {
							arr[ni][nj + 1] = '>';
							arr[ni][nj] = '.';
							nj = nj + 1;
						} else {
							arr[ni][nj] = '>';
						}
					} else {
						arr[ni][nj] = '>';
					}
				} else if (input[i] == 'S') {

					int num = 4;
					if (arr[ni][nj] == '^')
						num = 0;
					else if (arr[ni][nj] == 'v')
						num = 1;
					else if (arr[ni][nj] == '<')
						num = 2;
					else if (arr[ni][nj] == '>')
						num = 3;
					int ndi = ni;
					int ndj = nj;
					while (true) {
						ndi += di[num];
						ndj += dj[num];

						if (ndi >= 0 && ndi < H && ndj >= 0 && ndj < W) {
							if (arr[ndi][ndj] == '*') {
								arr[ndi][ndj] = '.';
								break;
							} else if (arr[ndi][ndj] == '#') {
								break;
							}
						} else {
							break;
						}

					}
				}
			}
			sb.append("#" + t + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(arr[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}
