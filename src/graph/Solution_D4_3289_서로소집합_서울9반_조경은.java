package graph;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class Solution_D4_3289_서로소집합_서울9반_조경은 {
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_3289.txt"));
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int t=1; t<=T; t++) {
			String[] nm = sc.nextLine().split(" ");
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			ArrayList<int[]> list = new ArrayList<>();
			for(int i=0; i<m; i++) {
				String[] s = sc.nextLine().split(" ");
				list.add(new int[] {Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2])});
			}
			
			int[] p = new int[n+1];
			for(int i=1; i<=n; i++)
				p[i] = i;
			
			System.out.print("#" + t + " ");
			for(int i=0; i<m; i++) {
				if(list.get(i)[0] == 0) {
					Union(p, list.get(i)[1], list.get(i)[2]);
				}
				else {
					FindSet(p, list.get(i)[1], list.get(i)[2]);
				}
			}
			System.out.println();
		}

	}
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

}
