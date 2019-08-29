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

public class Solution_D4_1251_하나로_서울9반_조경은 {
	public static ArrayList<double[]> v;
	public static int[] p;
	public static int N;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1251.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			v = new ArrayList<>();
			int[] X = new int[N];
			int[] Y = new int[N];
			for(int i=0; i<N; i++) {
				X[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				Y[i] = Integer.parseInt(st.nextToken());
			}
			double E = Double.parseDouble(br.readLine());
			for(int i=0; i<N; i++) {
				v.add(new double[] {X[i], Y[i], E});
			}
			
			
			System.out.println("#" + t + " " + kruskal());
			
		}
	}
	public static double kruskal() {
		Collections.sort(v, new Comparator<double[]>() {
			@Override
			public int compare(double[] o1, double[] o2) {
				return Double.compare(o1[2], o2[2]);
			}
		});

		
		p = new int[N+1];
		for(int i=0; i<N; i++)
			p[i] = i;
		
		double sum = 0;
		for(int i=0; i<v.size(); i++) {
			if(findSet(v.get(i)[0]) != findSet(v.get(i)[1])) {
				sum = sum+v.get(i)[2];
				union(v.get(i)[0], v.get(i)[1]);
			}
			
		}
		return sum;
	}
	public static int findSet(double x) {
		if(p[(int)x] == (int)x)
			return (int)x;
		else
			return p[(int)x] = findSet(p[(int)x]);
	}
	
	public static void union(double a, double b) {
		a = findSet(a);
		b = findSet(b);
		if(a<b) 
			p[(int)b] = (int)a;
		else
			p[(int)a] = (int)b;
	}

}
