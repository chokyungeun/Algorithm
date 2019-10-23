package a1023;

import java.io.*;

public class Main_정올_2074_홀수마방진_서울9반_조경은 {
	public static int[][] arr;
	public static int N;

	public static void func(int i, int j, int num) {
		arr[i][j] = num;
		if (num == N * N) return;
		if (num % N == 0) func((i + 1) % N, j, num + 1);
		else func((i + N - 1) % N, (j + N - 1) % N, num + 1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		func(0, N / 2, 1);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}
