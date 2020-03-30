package SWmaestroPrac;

import java.io.*;
import java.util.*;

public class Solution1 {
	public static int N, K, res, index;
	public static int[] arr;

	public static void go() {
		for (int i = index + 1; i < N; i++) {
			if (arr[i] != arr[0]) {
				res++;
				for (int j = i; j < K + i - 1; j++) {
					if (j == N) {
						return;
					}
					arr[j] = arr[0];
				}
				index = K + i - 2;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		res = 0;
		index = 0;
		go();

		System.out.println(res);
	}

}
