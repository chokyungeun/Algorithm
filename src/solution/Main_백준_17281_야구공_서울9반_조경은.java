package solution;

import java.io.*;
import java.util.*;

public class Main_백준_17281_야구공_서울9반_조경은 {
	public static int N, res, max, out, result, index;
	public static int[] d;
	public static int[][] arr;
	public static boolean[] v;
	public static boolean[] player;

	public static void play(int num, int[] order) {
		while (true) {
			if (arr[num][order[index % 9]] == 0) {
				out++;
				if (out >= 3) {
					index++;
					return;
				}
			} else if (arr[num][order[index % 9]] == 1) {
				if (player[2]) res++;

				player[2] = player[1];
				player[1] = player[0];
				player[0] = true;
			} else if (arr[num][order[index % 9]] == 2) {
				if (player[2]) res++;
				if (player[1]) res++;

				player[2] = player[0];
				player[1] = true;
				player[0] = false;
			} else if (arr[num][order[index % 9]] == 3) {
				if (player[2]) res++;
				if (player[1]) res++;
				if (player[0]) res++;

				player[2] = true;
				player[1] = false;
				player[0] = false;
			} else if (arr[num][order[index % 9]] == 4) {
				res++;
				for (int i = 0; i < 3; i++) {
					if (player[i])
						res++;
				}
				player = new boolean[3];
			}
			index++;
		}
	}

	public static void permComb(int start, int count) {
		if (count == 3) {
			permComb(start, count + 1);
			return;
		}
		if (count == 9) {
			System.out.println(Arrays.toString(d));
			result = 0;
			index = 0;
			for (int i = 0; i < N; i++) {
				out = 0;
				res = 0;
				player = new boolean[3];
				play(i, d);
				result += res;
			}
			max = Math.max(max, result);
			return;
		}
		for (int i = 1; i < 9; i++) {
			if (!v[i]) {
				v[i] = true;
				d[count] = i;
				permComb(i, count + 1);
				v[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][9];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		v = new boolean[9];
		d = new int[9];
		d[3] = 0;
		permComb(1, 0);

		System.out.println(max);
	}

}
