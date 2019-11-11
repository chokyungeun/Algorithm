package solution;
import java.io.*;
import java.util.*;

public class Main_백준_15651_N과M3_서울9반_조경은 {
	public static int N,M;
	public static int[] a;
	public static boolean[] v;
	public static StringBuilder sb;
	
	public static void permComb(int start, int count) {
		if(count==M) {
			for(int i=0; i<M; i++) {
				sb.append(a[i]+1 + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0; i<N; i++) {
			a[count] = i;
			permComb(i,count+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		a = new int[M];
		v = new boolean[N];
		permComb(0,0);
		System.out.println(sb);
	}

}
