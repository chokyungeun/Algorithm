package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KruskalTest {
	public static int N=7;
	public static List<int[]> v;
	public static int[] p;
	public static int INF=Integer.MAX_VALUE/2;
	public static int[][] a={
		{  0, 67,INF, 28, 17,INF, 12},
		{ 67,  0,INF, 24, 62,INF,INF},
		{INF,INF,  0,INF, 20, 37,INF},
		{ 28, 24,INF,  0,INF,INF, 13},
		{ 17, 62, 20,INF,  0, 45, 73},
		{INF,INF, 37,INF, 45,  0,INF},
		{ 12,INF,INF, 13, 73,INF,  0},
	};
	
	
	public static int findSet(int x) {
		if(p[x] == x)
			return x;
		else
			return p[x] = findSet(p[x]);
	}
	
	public static void union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		if(a<b) 
			p[b] = a;
		else
			p[a] = b;
	}
	
	public static int kruskal() {
		Collections.sort(v, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		for(int[] e:v)
			System.out.println(Arrays.toString(e));
		
		p = new int[N+1];
		for(int i=0; i<N; i++)
			p[i] = i;
		
		int sum = 0;
		for(int i=0; i<v.size(); i++) {
			if(findSet(v.get(i)[0]) != findSet(v.get(i)[1])) {
				System.out.println("->" + Arrays.toString(v.get(i)));
				sum = sum+v.get(i)[2];
				union(v.get(i)[0], v.get(i)[1]);
			}
			
		}
		return sum;
	}
	public static void main(String[] args) {
		v = new ArrayList<int[]>();
		v.add(new int[]{1,7,12});
		v.add(new int[]{1,4,28});
		v.add(new int[]{1,2,67});
		v.add(new int[]{1,5,17});
		v.add(new int[]{2,4,24});
		v.add(new int[]{2,5,62});
		v.add(new int[]{3,5,20});
		v.add(new int[]{3,6,37});
		v.add(new int[]{4,7,13});
		v.add(new int[]{5,6,45});
		v.add(new int[]{5,7,73});
		System.out.println(kruskal());
		
	}

}


	



