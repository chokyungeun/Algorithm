package solution;
import java.io.*;
import java.util.*;

public class Main_백준_15654_N과M5_서울9반_조경은 {
	public static int N,M;
	public static int[] a,d;
	public static boolean[] v;
	public static StringBuilder sb;
	
	public static void permComb(int start, int count) {
		if(count==M) {
			for(int i=0; i<M; i++) {
				sb.append(a[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0; i<N; i++) {
			if(!v[i]) {
				v[i] = true;
				a[count] = d[i];
				permComb(i,count+1);
				v[i] = false;
			}
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		a = new int[M];
		d = new int[N];
		v = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(d);
		permComb(0,0);
		System.out.println(sb);
	}

}
