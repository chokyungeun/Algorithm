package SWmaestro2;
import java.io.*;
import java.util.*;

public class Solution2 {
	public static int N,M,max;
	public static ArrayList<int[]> power;
	public static int[] p;
	public static boolean[] v;
	
	public static void func(ArrayList<Integer> list) {
		int si = power.get(list.get(0))[0];
		int sj = power.get(list.get(0))[1];
		int bi = power.get(list.get(0))[0];
		int bj = power.get(list.get(0))[1];
		for(int i=1; i<list.size(); i++) {
			si = Math.min(si, power.get(list.get(i))[0]);
			sj = Math.min(sj, power.get(list.get(i))[1]);
			bi = Math.max(bi, power.get(list.get(i))[0]);
			bj = Math.max(bj, power.get(list.get(i))[1]);
		}
		int sum = (bi-si)*2+(bj-sj)*2;
		max = Math.max(sum, max);
	}
	
	public static int getParent(int x) {
		if(p[x] == x)
			return x;
		else
			return p[x] = getParent(p[x]);
	}
	
	public static void unionParent(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		if(a<b) 
			p[b] = a;
		else
			p[a] = b;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		power = new ArrayList<>();
		v = new boolean[N];
		p = new int[N+1];
		for(int i=1; i<=N; i++)
			p[i] = i;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			power.add(new int[] {x, y});
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			unionParent(a, b);
		}
		max = 0;
		for(int i=0; i<N; i++) {
			if(!v[i]) {
				ArrayList<Integer> list = new ArrayList<>();
				v[i] = true;
				list.add(i);
				for(int j=0; j<N; j++) {
					if(!v[j] && getParent(j+1)==getParent(i+1)) {
						list.add(j);
						v[j] = true;
					}
				}
				func(list);
			}
			
		}
		System.out.println(max);
			
	}

}
