package a1108;

import java.io.*;
import java.util.*;

public class Solution_D4_4261_빠른휴대전화키패드_서울9반_조경은 {
	public static char[][] arr = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
			{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_4261.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			char[] S = st.nextToken().toCharArray();
			int N = Integer.parseInt(st.nextToken());
			char[][] word = new char[N][];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				word[i] = st.nextToken().toCharArray();
			}
			int res = 0;

			for (int i = 0; i < N; i++) {
				if (word[i].length == S.length) {
					int x = 0;
					for (int j = 0; j < S.length; j++) {
						boolean tf = false;
						for (int k = 0; k < arr[S[j] - '0'].length; k++) {
							if (arr[S[j] - '0'][k] == word[i][j]) {
								tf = true;
								x++;
								break;
							}
						}
						if (!tf) {
							break;
						} else if (tf && x == S.length) {
							res++;
						}
					}
				}
			}
			System.out.println("#" + t + " " + res);

		}

	}
}