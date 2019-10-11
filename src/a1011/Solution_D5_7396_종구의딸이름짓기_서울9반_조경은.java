package a1011;

import java.io.*;
import java.util.*;

public class Solution_D5_7396_종구의딸이름짓기_서울9반_조경은 {
	public static class Points {
		int r, c, visit;
		char alpha;

		public Points(int r, int c, char alpha, int visit) {
			this.r = r;
			this.c = c;
			this.alpha = alpha;
			this.visit = visit;
		}
	}

	public static StringBuilder sb;
	public static int N, M;
	public static char[][] arr;
	public static int[][] v;
	public static int[] di = { 0, 1 }, dj = { 1, 0 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d5_7396.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder(10240 * 50);
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new char[N][M];
			v = new int[N][M];
			for (int i = 0; i < N; i++) {
				arr[i] = br.readLine().toCharArray();
			}

			sb.append("#" + tc + " ");
			BFS();
			sb.append("\n");

		} 
		System.out.print(sb);
	}

	public static void BFS() {
		PriorityQueue<Points> q = new PriorityQueue<Points>(new Comparator<Points>() {
			@Override
			public int compare(Points o1, Points o2) {
				if (o1.visit == o2.visit)
					return Character.compare(o1.alpha, o2.alpha);
				else
					return Integer.compare(o1.visit, o2.visit);
			}
		});
		ArrayList<Character> sol = new ArrayList<>(); 
		q.offer(new Points(0, 0, arr[0][0], 1));
		sol.add(arr[0][0]);
		int cnt = v[0][0] = 1;
		char x = '0';
		loop: while (!q.isEmpty()) {
			int r = q.peek().r;
			int c = q.poll().c;
			if (r == N - 1 && c == M - 1 && sol.size() == 1) {
				for (int i = 0; i < sol.size(); i++)
					sb.append(sol.get(i));
				return;
			} else if (r == N - 1 && c == M - 1) {
				sol.add(arr[r][c]);
				for (int i = 0; i < sol.size(); i++)
					sb.append(sol.get(i));
				return;
			}

			if (cnt < v[r][c]) { 
				sol.add(arr[r][c]);
				cnt = v[r][c];
				x = arr[r][c];
			}

			if (cnt == v[r][c] && x != arr[r][c]) {
				x = '0';
				while (!q.isEmpty()) {
					cnt = v[r][c];
					Points px = q.poll();
					if (v[px.r][px.c] != cnt) {
						q.add(px);
						continue loop;
					}
				}
			}

			for (int d = 0; d < di.length; d++) {
				int nr = r + di[d];
				int nc = c + dj[d];

				if (isIn(nr, nc) && v[nr][nc] == 0) {
					v[nr][nc] = v[r][c] + 1;
					q.offer(new Points(nr, nc, arr[nr][nc], v[nr][nc]));
				}
			}
		}
	}

	public static boolean isIn(int r, int c) {
		return (0 <= r && r < N && 0 <= c && c < M);
	}

}