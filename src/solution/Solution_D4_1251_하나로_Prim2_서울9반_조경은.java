package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D4_1251_하나로_Prim2_서울9반_조경은 {
	public static ArrayList<int[]> v;
	public static double[] w;
	public static int N;
	public static double E;
	public static double[][] edge;

	public static long prim() {
        PriorityQueue<double[]> pq = new PriorityQueue<double[]>(new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return Double.compare(o1[0], o2[0]);
            }
        });
 
        boolean[] visit = new boolean[N];
        visit[0] = true;
 
        double sum = 0;
        for (int next = 0; next < N; next++) {
            pq.offer(new double[] { edge[0][next], next });
        }
        while (!pq.isEmpty()) {
            double[] currA = pq.poll();
            double weight = currA[0];
            int curr = (int) currA[1];
 
            if (!visit[curr]) {
                visit[curr] = true;
                sum += Math.pow(weight, 2) * E;
                for (int next = 0; next < N; next++) {
                    pq.offer(new double[] { edge[curr][next], next });
                }
            }
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