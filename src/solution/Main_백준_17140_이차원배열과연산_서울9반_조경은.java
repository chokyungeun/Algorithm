package solution;

import java.io.*;
import java.util.*;

public class Main_백준_17140_이차원배열과연산_서울9반_조경은 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int r = Integer.parseInt(s[0])-1;
		int c = Integer.parseInt(s[1])-1;
		int k = Integer.parseInt(s[2]);
		int[][] arr = new int[100][100];
		int res = 0;
		for (int i = 0; i < 3; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		while (true) {
			if (arr[r][c] == k) {
				break;
			}
			res++;
			if(res == 101) {
				res = -1;
				break;
			}
			int[][] narr = new int[100][100];
			int[] num = new int[101];
			int rmax = 0;
			int cmax = 0;
			for (int i = 0; i < 100; i++) {
				int row = 0;
				for (int j = 0; j < 100; j++) {
					if (arr[i][j] == 0) {
						break;
					}
					row++;
				}
				if (row > rmax) {
					rmax = row;
				}
				int col = 0;
				for (int j = 0; j < 100; j++) {
					if (arr[j][i] == 0) {
						break;
					}
					col++;
				}
				if (col > cmax) {
					cmax = col;
				}
			}
			if (cmax >= rmax) {
				for (int i = 0; i < 100; i++) {
					int[] num2 = new int[101];
					for (int j = 0; j < 100; j++) {
						num[arr[i][j]]++;
					}
					System.arraycopy(num, 0, num2, 0, num.length);
					Arrays.sort(num2);
					ArrayList<Integer> list = new ArrayList<>();
					for (int j = 0; j < num2.length; j++) {
						if (num2[j] != 0) {
							for (int l = 0; l < num.length; l++) {
								if (num2[j] == num[l]) {
									if (l != 0) {
										list.add(l);
										list.add(num[l]);
										num[l] = 0;
										break;
									}
								}
							}
						}
					}
					for (int j = 0; j < list.size(); j++) {
						narr[i][j] = list.get(j);
					}
				}
			} else {
				for (int i = 0; i < 100; i++) {
					int[] num2 = new int[101];
					for (int j = 0; j < 100; j++) {
						num[arr[j][i]]++;
					}
					System.arraycopy(num, 0, num2, 0, num.length);
					Arrays.sort(num2);
					ArrayList<Integer> list = new ArrayList<>();
					for (int j = 0; j < num2.length; j++) {
						if (num2[j] != 0) {
							for (int l = 0; l < num.length; l++) {
								if (num2[j] == num[l]) {
									if (l != 0) {
										list.add(l);
										list.add(num[l]);
										num[l] = 0;
										break;
									}
								}
							}
						}
					}
					for (int j = 0; j < list.size(); j++) {
						narr[j][i] = list.get(j);
					}
				}
			}

			arr = new int[100][100];
			for (int i = 0; i < narr.length; i++) {
				System.arraycopy(narr[i], 0, arr[i], 0, narr[i].length);
			}

		}

		System.out.println(res);

	}

}
