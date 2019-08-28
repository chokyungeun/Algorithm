package imtest_0827;

import java.io.*;
import java.util.*;

public class Solution_AD_0001_서울9반_조경은 {
	public static int N;
	public static int n = 0;
	public static int[] front;
	public static int[] back;
	public static int[] arr;

	public static void shuffle(int[] arr) {
		int[] arr2 = new int[N];
		arr2 = Arrays.copyOf(arr, N);
		Arrays.sort(arr2);
		int num = 0;
		for (int i = 0; i < N; i++) {
			if (arr2[i] != arr[i]) {
				num++;
			}
		}
		if (num == 0) {
			return;
		}
		num = 0;
		for (int i = 0; i < N; i++) {
			if (arr2[N - i - 1] != arr[i]) {
				num++;
			}
		}
		if (num == 0) {
			return;
		}

		

	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_ad_0001.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			System.out.println("#" + t + " " );

		}

	}
}
