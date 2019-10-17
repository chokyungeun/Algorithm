package a1017;

import java.io.*;
import java.util.*;

public class Main_백준_16236_아기상어_서울9반_조경은 {
	public static int N, size, temp, r, c, res;
	public static int[][] arr;
	public static boolean[][] v;
	public static int[] di = { -1, 0, 0, 1 };
	public static int[] dj = { 0, -1, 1, 0 };

	public static boolean bfs(int i, int j) {
		ArrayList<int[]> fish = new ArrayList<>();
		Queue<int[]> q = new LinkedList<>();
		v[i][j] = true;
		int o = Integer.MAX_VALUE;
		q.offer(new int[] { i, j, 1 });
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			if (curr[2] > o) {
				eat(fish);
				return true;
			}
			for (int k = 0; k < di.length; k++) {
				int ni = curr[0] + di[k];
				int nj = curr[1] + dj[k];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && !v[ni][nj] && arr[ni][nj] <= size) {
					if (arr[ni][nj] < size && arr[ni][nj] != 0) {
						fish.add(new int[] { ni, nj, curr[2] });
						o = curr[2];
						v[ni][nj] = true;
					} else if (arr[ni][nj] == size || arr[ni][nj] == 0) {
						v[ni][nj] = true;
						q.offer(new int[] { ni, nj, curr[2] + 1 });
					}
				}
			}
		}
		if (o != Integer.MAX_VALUE) {
			eat(fish);
			return true;
		}
		return false;
	}

	private static void eat(ArrayList<int[]> fish) {
		Collections.sort(fish, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});
		temp++;
		if (temp == size) {
			temp = 0;
			size++;
		}
		r = fish.get(0)[0];
		c = fish.get(0)[1];
		arr[r][c] = 0;
		res += fish.get(0)[2];

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					r = i;
					c = j;
					arr[i][j] = 0;
				}
			}
		}
		size = 2;
		temp = 0;
		while (true) {
			v = new boolean[N][N];
			boolean bf = bfs(r, c);
			if (bf == false) {
				break;
			}
		}

		System.out.println(res);
	}
}
