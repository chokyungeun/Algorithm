package solution;

import java.util.*;
import java.io.*;

public class Main_백준_10974_모든순열_서울9반_조경은 {
	public static int N;
	public static int[] arr,a;
	public static boolean[] v;
	public static void permComb(int start, int count) {
		if(count == N) {
			for(int i=0; i<a.length; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i=0; i<N; i++) { 
			if(!v[i]) {
				v[i] = true; 
				a[count] = arr[i];
				permComb(i,count+1);
				v[i] = false; 
			} 
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		v = new boolean[N];
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		a = new int[N];
		permComb(0,0);

	}

}
