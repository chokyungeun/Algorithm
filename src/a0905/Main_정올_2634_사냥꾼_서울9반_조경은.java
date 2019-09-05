package a0905;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_정올_2634_사냥꾼_서울9반_조경은 {
	public static class Point implements Comparable<Point> {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public int compareTo(Point o) {
			return Integer.compare(this.r + this.c, o.r + o.c);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken()); 
		int N = Integer.parseInt(st.nextToken()); 
		int L = Integer.parseInt(st.nextToken()); 

		st = new StringTokenizer(br.readLine(), " ");
		int[] gun = new int[M];
		for (int i = 0; i < M; i++) {
			gun[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(gun);

		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			if (r <= L)
				pq.offer(new Point(r, c));
		}
		int ans = 0;
		for (int i = 0; i < gun.length; i++) {
			int cnt = 0;
			while (!pq.isEmpty()) {
				Point cur = pq.peek();
				if ((Math.abs(gun[i] - cur.c) + cur.r) <= L) {
					cnt++;
					pq.poll();
				} else {
					if (cur.c < gun[i]) {
						pq.poll();
					} else {
						break;
					}
				}
			}
			ans += cnt;
		}

		System.out.println(ans);

	}
}
