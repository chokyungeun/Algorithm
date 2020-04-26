package SWmaestro2;
import java.io.*;
import java.util.*;

public class Solution1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		for(int k=1; k<=N; k++) {
			for(int i=0; i<=N-k; i++) {
				int sum=0;
				for(int j=i; j<i+k; j++) {
					sum += a[j];
				}
				max = Math.max(max, sum);
			}
		}
		System.out.println(max);
	}

}
