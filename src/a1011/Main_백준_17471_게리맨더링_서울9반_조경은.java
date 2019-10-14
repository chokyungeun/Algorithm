package a1011;

import java.io.*;
import java.util.*;


public class Main_백준_17471_게리맨더링_서울9반_조경은 {
	public static int N, res;
	public static int[][] arr;
	public static int[] ppl,d;
	public static boolean[] v;
	
	public static void powerset(int count) {
		if (count == N) {
			for(int i=0; i<N; i++) {
				if(v[i])
					System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		v[count] = false;
		powerset(count+1);
		v[count] = true;
		powerset(count+1);
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		v = new boolean[N];
		ppl = new int[N];
		d = new int[N];
		String[] s = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			ppl[i] = Integer.parseInt(s[i]);
		}
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			for(int j=0; j<Integer.parseInt(s[0]); j++) {
				arr[i][Integer.parseInt(s[j+1])-1] = 1;
				arr[Integer.parseInt(s[j+1])-1][i] = 1;
			}
		}
		res = -1;
		
		powerset(0);
		System.out.println(res);
		

	}

}
