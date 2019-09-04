package a0904;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_D4_1494_사랑의카운슬러_서울9반_조경은 {
	public static int N;
	public static int[] move;
	public static int[] arr;
	public static long min;
	public static long INF = Long.MAX_VALUE;
	public static ArrayList<int[]> list;

	private static void comb(int a, int b) {
		if (b == N / 2) {
			cal();
			return;
		}

		for (int i = a; i < N; i++) {
			if (move[i] == 0) {
				move[i] = 1;
				arr[b] = i;
				comb(i, b + 1);
				move[i] = 0;
			}
		}
	}

	public static void cal() {
		long x = 0;
		long y = 0;

		for (int i = 0; i < N; i++) {
			if (move[i] == 0) {
				x += list.get(i)[0];
				y += list.get(i)[1];
			} 
			else {
				x -= list.get(i)[0];
				y -= list.get(i)[1];
			}
		}

		if (min > x * x + y * y) {
			min = x * x + y * y;
		}

	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1494.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			arr = new int[N];
			move = new int[N];
			for (int i = 0; i < N; i++) {
				String[] s = br.readLine().split(" ");
				list.add(new int[] { Integer.parseInt(s[0]), Integer.parseInt(s[1])});
			}
			min = INF;
			comb(0, 0);

			System.out.println("#" + t + " " + min);
		}

	}

}
