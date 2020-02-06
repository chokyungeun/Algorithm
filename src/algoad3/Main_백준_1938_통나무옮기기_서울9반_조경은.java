package algoad3;

import java.io.*;
import java.util.*;

public class Main_백준_1938_통나무옮기기_서울9반_조경은 {
	public static int N, res;
	public static tongtree heretree;
	public static char[][] map;
	public static int[][] v;
	public static int[] di = { -1, -1, -1, 0, 1, 1, 1, 0 };
	public static int[] dj = { -1, 0, 1, 1, 1, 0, -1, -1 };

//방문처리!!
	public static class tongtree {
		int x1;
		int y1;
		int x2;
		int y2;
		int x3;
		int y3;
		int dir;
		int count;

		public tongtree(int x1, int y1, int x2, int y2, int x3, int y3, int dir, int count) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			this.x3 = x3;
			this.y3 = y3;
			this.dir = dir;
			this.count = count;
		}

	}
	
	//위로 이동
	public static tongtree up(tongtree t) {
		tongtree nt = new tongtree(t.x1, t.y1, t.x2, t.y2, t.x3, t.y3, t.dir, t.count);
		if (t.x1 - 1 >= 0 && map[t.x1 - 1][t.y1] != '1' && map[t.x2 - 1][t.y2] != '1' && map[t.x3 - 1][t.y3] != '1') { //이동할수있는지 체크
			nt = new tongtree(t.x1 - 1, t.y1, t.x2 - 1, t.y2, t.x3 - 1, t.y3, t.dir, t.count);
		}
		return nt;

	}

	public static tongtree down(tongtree t) {
		tongtree nt = new tongtree(t.x1, t.y1, t.x2, t.y2, t.x3, t.y3, t.dir, t.count);
		if (t.x3 + 1 < N && map[t.x3 + 1][t.y3] != '1' && map[t.x2 + 1][t.y2] != '1' && map[t.x1 + 1][t.y1] != '1') {//이동할수있는지 체크
			nt = new tongtree(t.x1 + 1, t.y1, t.x2 + 1, t.y2, t.x3 + 1, t.y3, t.dir, t.count);
		}
		return nt;
	}

	public static tongtree left(tongtree t) {
		tongtree nt = new tongtree(t.x1, t.y1, t.x2, t.y2, t.x3, t.y3, t.dir, t.count);
		if (t.y1 - 1 >= 0 && map[t.x1][t.y1 - 1] != '1' && map[t.x2][t.y2 - 1] != '1' && map[t.x3][t.y3 - 1] != '1') {//이동할수있는지 체크
			nt = new tongtree(t.x1, t.y1 - 1, t.x2, t.y2 - 1, t.x3, t.y3 - 1, t.dir, t.count);

		}
		return nt;
	}

	public static tongtree right(tongtree t) {
		tongtree nt = new tongtree(t.x1, t.y1, t.x2, t.y2, t.x3, t.y3, t.dir, t.count);
		if (t.y3 + 1 < N && map[t.x3][t.y3 + 1] != '1' && map[t.x2][t.y2 + 1] != '1' && map[t.x1][t.y1 + 1] != '1') {//이동할수있는지 체크
			nt = new tongtree(t.x1, t.y1 + 1, t.x2, t.y2 + 1, t.x3, t.y3 + 1, t.dir, t.count);
		}
		return nt;
	}

	public static tongtree rotate(tongtree t) {
		tongtree nt = new tongtree(t.x1, t.y1, t.x2, t.y2, t.x3, t.y3, t.dir, t.count);
		boolean b = true;
		for (int k = 0; k < di.length; k++) {
			int ni = t.x2 + di[k];
			int nj = t.y2 + dj[k];
			if (ni < 0 || ni >= N || nj < 0 || nj >= N || map[ni][nj] == '1') {//이동할수있는지 체크
				b = false;
				break;
			}
		}
		if (b) {//이동가능한 경우
			if (t.dir == -1) {
				nt = new tongtree(t.x1 - 1, t.y1 + 1, t.x2, t.y2, t.x3 + 1, t.y3 - 1, t.dir * -1, t.count);

			} else {
				nt = new tongtree(t.x1 + 1, t.y1 - 1, t.x2, t.y2, t.x3 - 1, t.y3 + 1, t.dir * -1, t.count);

			}
		}
		return nt;
	}

	public static void bfs(ArrayList<int[]> tree) {
		int x = 0;

		if (tree.get(0)[0] == tree.get(1)[0])
			x = -1;
		else
			x = 1;

		tongtree t = new tongtree(tree.get(0)[0], tree.get(0)[1], tree.get(1)[0], tree.get(1)[1], tree.get(2)[0],
				tree.get(2)[1], x, 0);
		v[t.x2][t.y2] = t.dir;
		Queue<tongtree> q = new LinkedList<>();
		q.offer(t);
		while (!q.isEmpty()) {
			tongtree tt = q.poll();
			// System.out.println(tt.x2 + " " + tt.y2 + " " + tt.dir + " " + tt.count);
			if (tt.x2 == heretree.x2 && tt.y2 == heretree.y2 && tt.dir == heretree.dir) {
				res = tt.count;
				return;
			}

			tongtree nt = up(tt);
			if (v[nt.x2][nt.y2] != 3 && v[nt.x2][nt.y2] != nt.dir) {
				nt.count++;
				q.offer(nt);
				if (v[nt.x2][nt.y2] == 0) {
					v[nt.x2][nt.y2] = nt.dir;
				} else {
					v[nt.x2][nt.y2] = 3;
				}
			}
			nt = down(tt);
			if ( v[nt.x2][nt.y2] != 3 && v[nt.x2][nt.y2] != nt.dir) {
				nt.count++;
				q.offer(nt);
				if (v[nt.x2][nt.y2] == 0) {
					v[nt.x2][nt.y2] = nt.dir;
				} else {
					v[nt.x2][nt.y2] = 3;
				}
			}
			nt = left(tt);
			if ( v[nt.x2][nt.y2] != 3 && v[nt.x2][nt.y2] != nt.dir) {
				nt.count++;
				q.offer(nt);
				if (v[nt.x2][nt.y2] == 0) {
					v[nt.x2][nt.y2] = nt.dir;
				} else {
					v[nt.x2][nt.y2] = 3;
				}
			}
			nt = right(tt);
			if ( v[nt.x2][nt.y2] != 3 && v[nt.x2][nt.y2] != nt.dir) {
				nt.count++;
				q.offer(nt);
				if (v[nt.x2][nt.y2] == 0) {
					v[nt.x2][nt.y2] = nt.dir;
				} else {
					v[nt.x2][nt.y2] = 3;
				}
			}
			nt = rotate(tt);
			if (v[nt.x2][nt.y2] != 3 && v[nt.x2][nt.y2] != nt.dir) {
				nt.count++;
				q.offer(nt);
				if (v[nt.x2][nt.y2] == 0) {
					v[nt.x2][nt.y2] = nt.dir;
				} else {
					v[nt.x2][nt.y2] = 3;
				}
			}

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		v = new int[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		ArrayList<int[]> tree = new ArrayList<>();
		ArrayList<int[]> here = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'B') {
					tree.add(new int[] { i, j });
				} else if (map[i][j] == 'E') {
					here.add(new int[] { i, j });
				}
			}
		}
		int x = 0;

		if (here.get(0)[0] == here.get(1)[0])
			x = -1;
		else
			x = 1;
		heretree = new tongtree(here.get(0)[0], here.get(0)[1], here.get(1)[0], here.get(1)[1], here.get(2)[0],
				here.get(2)[1], x, 0);
		bfs(tree);

		System.out.println(res);
	}

}
