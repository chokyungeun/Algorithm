package a0904;

import java.io.*;

public class Main_정올_1863_종교_서울9반_조경은 {
	public static int[] p;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		
		p = new int[n+1];
		for(int i=0; i<n+1; i++) {
			p[i] = i;
		}
		
		for(int k=0; k<m; k++) {
			s = br.readLine().split(" ");
			int i = Integer.parseInt(s[0]);
			int j = Integer.parseInt(s[1]);
			union(i, j);
		}
		int cnt=0;
		for(int i=1; i<n+1; i++) {
			if(p[i]==i) cnt++;
		}
		
		System.out.println(cnt);
	}

	private static void union(int a, int b) {
		int pa =find(a);
		int pb =find(b);
		if(pa!=pb) p[pb]=pa;
	}

	private static int find(int a) {
		if(p[a]==a) return a;
		return p[a]=find(p[a]);
	}

}
