package a1113;

import java.io.*;
import java.util.*;

public class Main_정올_2577_회전초밥고_서울9반_조경은 {
	public static int N, d, k, c, res;
	public static int[] arr;
	public static int[] count;

	public static void rotate() {
		count = new int[d + 1];
		int num = 0;
		for(int i=0; i<k-1; i++) {
			count[arr[i]]++;
			if(count[arr[i]]==1) num++;
		}
		
		for (int i = k-1; i < N+k-1; i++) {
			count[arr[(i) % N]]++;
			if (count[arr[(i) % N]] == 1) {
				num++;
			}
			if (count[c] == 0)
				res = Math.max(num + 1, res);
			else
				res = Math.max(num, res);

			count[arr[i-k+1]]--;
			if (count[arr[i-k+1]] == 0)
				num--;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		res = 0;
		rotate();

		System.out.println(res);
	}

}