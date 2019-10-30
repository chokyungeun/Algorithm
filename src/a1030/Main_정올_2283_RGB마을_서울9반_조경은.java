package a1030;

import java.io.*;
import java.util.*;

public class Main_정올_2283_RGB마을_서울9반_조경은 {
	public static int N;
	public static ArrayList<int[]> list;
	public static int[][] cost;

	public static void dp(int index) {
		if(index==N) return;
		
		cost[index][0] = Math.min(cost[index - 1][1] + list.get(index)[0], cost[index - 1][2] + list.get(index)[0]);
		cost[index][1] = Math.min(cost[index - 1][0] + list.get(index)[1], cost[index - 1][2] + list.get(index)[1]);
		cost[index][2] = Math.min(cost[index - 1][0] + list.get(index)[2], cost[index - 1][1] + list.get(index)[2]);

		dp(index+1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			list.add(new int[] { Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]) });
		}
		cost[0][0] = list.get(0)[0];
		cost[0][1] = list.get(0)[1];
		cost[0][2] = list.get(0)[2];

		dp(1);
		int res = cost[N-1][0];
		res = Math.min(res, cost[N-1][1]);
		res = Math.min(res, cost[N-1][2]);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(cost[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(res);
	}

}
