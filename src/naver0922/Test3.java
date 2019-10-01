package naver0922;

import java.util.*;

import graph.UnionFind.Edge;

import java.io.*;

public class Test3 {
	public static int getParent(int[] p, int x) {
		if(p[x] == x)
			return x;
		else
			return p[x] = getParent(p,p[x]);
	}
	
	private static void Union(int[] p, int a, int b) {
		a = getParent(p, a);
		b = getParent(p, b);
		if(a<b) 
			p[b] = a;
		else
			p[a] = b;
		
	}

	private static void FindSet(int[] p, int a, int b) {
		int res = 0;
		a = getParent(p, a);
		b = getParent(p, b);
		if(a==b) 
			res = 1;
			
		System.out.print(res);
	}
	
	public static void main(String[] args) {
		int[] cook_times = {5, 30, 15, 30, 35, 20, 4};
		int[][] order = {{2,4},{2,5},{3,4},{3,5},{1,6},{4,6},{5,6},{6,7}};
		int k = 6;
		int[] answer = new int[2];
		int[] p = new int[cook_times.length+1];
		for(int i=1; i<=p.length-1; i++)
			p[i] = i;
		
		for(int i=0; i<order.length; i++) {
			Union(p, order[i][0], order[i][1]);
		}
		
		answer[0] = k-p[k];
		for(int i=p[k]-1; i<k-1; i++) {
			answer[1] += cook_times[i];
		}
		
		System.out.println(answer[0]);
		System.out.println(answer[1]);

	}

}
