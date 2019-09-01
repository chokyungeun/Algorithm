package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_D4_1251_하나로_Kruskal_서울9반_조경은 {
	public static ArrayList<int[]> v;
	public static ArrayList<double[]> e;
	public static int[] p;
	public static int N;
	public static double E;
	public static double[][] edge;

	public static long kruskal() {
		Collections.sort(e, new Comparator<double[]>() {
			@Override
			public int compare(double[] o1, double[] o2) {
				return Double.compare(o1[2], o2[2]);
			}
		});

		p = new int[N];
		for (int i = 0; i < N; i++) {
			p[i] = i;
		}
		double sum = 0;
		for (int i = 0; i < e.size(); i++) {
			if (findSet((int) e.get(i)[0]) != findSet((int) e.get(i)[1])) {
				sum += Math.pow(e.get(i)[2], 2) * E;
				union((int) e.get(i)[0], (int) e.get(i)[1]);
			}
		}
		sum = Math.round(sum);
		return (long) sum;
	}

	public static int findSet(int x) {
		if (p[x] == x)
			return x;
		else
			return p[x] = findSet(p[x]);
	}

	public static void union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		if (a < b)
			p[b] = a;
		else
			p[a] = b;
	}

	public static void make() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				double dis = Math
						.sqrt((Math.pow(v.get(i)[0] - v.get(j)[0], 2) + Math.pow(v.get(i)[1] - v.get(j)[1], 2)));
				edge[i][j] = dis;
				e.add(new double[] { i, j, edge[i][j] });
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1251.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st, st1;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			st1 = new StringTokenizer(br.readLine());
			E = Double.parseDouble(br.readLine());

			edge = new double[N][N];
			v = new ArrayList<int[]>();
			e = new ArrayList<double[]>();
			for (int i = 0; i < N; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st1.nextToken());
				v.add(new int[] { x, y });
			}
			make();
			System.out.println("#" + tc + " " + kruskal());
		}
		br.close();
	}

}