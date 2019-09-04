package solution;

import java.util.*;
import java.io.*;

public class Solution_D4_3124_최소스패닝트리_서울9반_조경은 {
	public static int V,E;
	public static int[] p;
	public static ArrayList<int[]> l;
	public static int find(int i) {
		return p[i]=(p[i]==i)? i:find(p[i]);
	}
	
	public static boolean union(int a, int b) {
		a=find(a);
		b=find(b);
		
		return false;
		
	}
	
	public static long kruskal() {
		p=new int[V+1];
		for(int i=1; i<=V; i++) p[i]=i;
		
		Collections.sort(l, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
			
		});
		long sum=0;
		for(int i=0; i<E; i++) {
			if(union(l.get(i)[0], l.get(i)[1])) sum+=l.get(i)[2];
		}
		
		return sum;
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
	}

}
