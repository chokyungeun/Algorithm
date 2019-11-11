package solution;
import java.io.*;
import java.util.*;

public class Main_백준_15650_N과M2_서울9반_조경은 {
	public static int N,M;
	public static int[] a;
	public static boolean[] v;
	
	public static void permComb(int start, int count) {
		if(count==M) {
			for(int i=0; i<M; i++) {
				System.out.print(a[i]+1 + " ");
			}
			System.out.println();
			return;
		}
		for(int i=start; i<N; i++) {
			if(!v[i]) {
				v[i] = true;
				a[count] = i;
				permComb(i,count+1);
				v[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		a = new int[M];
		v = new boolean[N];
		permComb(0,0);
	}

}
