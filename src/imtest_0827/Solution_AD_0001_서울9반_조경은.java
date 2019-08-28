package imtest_0827;

import java.io.*;
import java.util.*;

public class Solution_AD_0001_서울9반_조경은 {
	public static int N;
	public static int x = -1;

	public static int[
	                  ] arr;

	public static void shuffle(int[] arr1, int[] front, int[] back) {
		x++;
		arr = Arrays.copyOf(arr1, N);
		int[] arr2 = new int[N];
		arr2 = Arrays.copyOf(arr1, N);
		Arrays.sort(arr2);
		int num = 0;
		for (int i = 0; i < N; i++) {
			if (arr2[i] != arr1[i]) {
				num++;
			}
		}
		if (num == 0) {
			return;
		}
		num = 0;
		for (int i = 0; i < N; i++) {
			if (arr2[N - i - 1] != arr1[i]) {
				num++;
			}
		}
		if (num == 0) {
			return;
		}
		int[] narr = new int[N];
		int n = 0;
		int b = 0;
		int f = 0;
		
		if(x == N+1) {
			x = -1;
			return;
		}
		if (N / 2 - x >= 0) {
			for (int i = 0; i < N / 2 - x; i++) {
				narr[n++] = front[f++];
			}
			for (int i = 0; i < x; i++) {
				narr[n++] = back[b++];
				narr[n++] = front[f++];
			}
			for (int i = 0; i < N / 2 - x; i++) {
				narr[n++] = back[b++];
			}
		} else {
			for (int i = 0; i < x - N / 2 + 1; i++) {
				narr[n++] = back[b++];
			}
			for (int i = 0; i < N / 2 - x - 1; i++) {
				narr[n++] = front[f++];
				narr[n++] = back[b++];
			}
			for (int i = 0; i < x - N / 2 + 1; i++) {
				narr[n++] = front[f++];
			}
		}
		
		shuffle(narr, front, back);

	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_ad_0001.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			arr = new int[N];
			int[] front = new int[N/2];
			int[] back = new int[N/2];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			int res = 0;
			for(int i=0; i<N; i++) {
				if(x == -1) {
					for(int j=0; j<N/2; j++) {
						front[j] = arr[j];
						back[j] = arr[j+N/2];
					}
					x = 0;
					shuffle(arr, front, back);
				}
				else {
					break;
				}
				res++;
			}
			if(res == N) {
				res = -1;
			}
			
			System.out.println("#" + t + " " + (res-1));

		}

	}
}
