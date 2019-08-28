package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnionFind {
	public static int N=7;
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
	public static class Edge implements Comparable<Edge>{
		int a;
		int b;
		int distance;
		Edge(int a, int b, int distance){
			this.a = a;
			this.b = b;
			this.distance = distance;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(distance, o.distance);
		}
		@Override
		public String toString() {
			return "("+ a + "," + b +")" + distance;
		}
	}
	
	public static int getParent(int[] p, int x) {
		if(p[x] == x)
			return x;
		else
			return p[x] = getParent(p,p[x]);
	}
	
	public static void unionParent(int[] p, int a, int b) {
		a = getParent(p, a);
		b = getParent(p, b);
		if(a<b) 
			p[b] = a;
		else
			p[a] = b;
	}
	public static boolean findParent(int[] p, int a, int b) {
		a = getParent(p, a);
		b = getParent(p, b);
		if(a==b) 
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		int n = 7;
		int m = 11;
		List<Edge> v = new ArrayList<Edge>();
		v.add(new Edge(1,7,12));
		v.add(new Edge(1,4,28));
		v.add(new Edge(1,2,67));
		v.add(new Edge(1,5,17));
		v.add(new Edge(2,4,24));
		v.add(new Edge(2,5,62));
		v.add(new Edge(3,5,20));
		v.add(new Edge(3,6,37));
		v.add(new Edge(4,7,13));
		v.add(new Edge(5,6,45));
		v.add(new Edge(5,7,73));
		
		Collections.sort(v);
		for(Edge e:v)
			System.out.println(e);
		
		//make-set
		int[] p = new int[n];
		for(int i=0; i<n; i++)
			p[i] = i;
		
		int sum = 0;
		for(int i=0; i<v.size(); i++) {
			if(!findParent(p,v.get(i).a-1, v.get(i).b-1)) {
				System.out.println("->"+v.get(i));
				sum = sum+v.get(i).distance;
				unionParent(p,v.get(i).a-1, v.get(i).b-1);
			}
			
		}
		System.out.println(sum);
	}

}



/*
..........[6]
.....13.....73..12
[3].28.............[0]
..24............67.17
....[1].62.........[4]
...................20
...............45....
..........[5]..37..[2]      
*/


	



