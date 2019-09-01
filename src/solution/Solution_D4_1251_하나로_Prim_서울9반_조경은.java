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

public class Solution_D4_1251_하나로_Prim_서울9반_조경은 {
	public static ArrayList<int[]> v;
	public static double[] w;
	public static int N;
	public static double E;
	public static double[][] edge;

	public static long prim() {
        Arrays.fill(w, -1);
        w[0] = 0;
        for (int k = 1; k < N; k++) {
            double minWeight = Integer.MAX_VALUE;
            int minVertex = 0;
            for (int i = 0; i < N; i++) {
                if (w[i] < 0)
                    continue;
                for (int j = 0; j < N; j++) {
                    if (w[j] >= 0)
                        continue;
                    if (minWeight > edge[i][j]) {
                        minWeight = edge[i][j];
                        minVertex = j;
                    }
                }
            }
            w[minVertex] = minWeight;
        }
        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Math.pow(w[i], 2) * E;
        }
        sum = Math.round(sum);
        return (long) sum;
    }
	

	public static void make() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				double dis = Math
						.sqrt((Math.pow(v.get(i)[0] - v.get(j)[0], 2) + Math.pow(v.get(i)[1] - v.get(j)[1], 2)));
				edge[i][j] = dis;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1251.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1, st2;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			st1 = new StringTokenizer(br.readLine());
			st2 = new StringTokenizer(br.readLine());
			E = Double.parseDouble(br.readLine());

			edge = new double[N][N];
			v = new ArrayList<int[]>();
			w = new double[N];
			for (int i = 0; i < N; i++) {
				int x = Integer.parseInt(st1.nextToken());
				int y = Integer.parseInt(st2.nextToken());
				v.add(new int[] { x, y });
			}
			make();
			System.out.println("#" + tc + " " + prim());
		}
	}

}