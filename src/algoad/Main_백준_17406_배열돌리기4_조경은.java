package algoad;

import java.util.*;
import java.io.*;

public class Main_백준_17406_배열돌리기4_조경은 {
	public static int K,cnt,a[];
	
	public static int[][] rotation(int[][] B, int r, int c, int s) {
		for(int i=0; i<(2*s+1)/2; i++) {
			int temp = B[r-s-1][c-s-1];
			for(int j=r-s+i; j<r+s-i; j++) {
				B[j-1][c-s-1+i] = B[j][c-s-1+i];
			}
			for(int j=c-s+i; j<c+s-i; j++) {
				B[r+s-1-i][j-1] = B[r+s-1-i][j];
			}
			for(int j=r+s-2-i; j>=r-s-1+i; j--) {
				B[j+1][c+s-1-i] = B[j][c+s-1-i];
			}
			for(int j=c+s-2-i; j>=c-s-1+i; j--) {
				B[r-s-1+i][j+1] = B[r-s-1+i][j];
			}
			B[r-s-1+i][c-s+i] = temp;
		}
		return B;
	}
	
	public static void permutation(int count) {
		if(count == K) {
			for(int i=0; i<K; i++) {
				for(int j=i+1; j<K; j++) {
					if(a[i] == a[j]) return;
				}
			}
			cnt++;
			System.out.println(Arrays.toString(a));
			return;
		}
		
		for(int i=1; i<=K; i++) {
			a[count] = i;
			permutation(count+1);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		K = sc.nextInt();
		int[][] A = new int[N][M];
		for(int i=0; i<N;i++) {
			for(int j=0; j<M; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		int[] r = new int[K];
		int[] c = new int[K];
		int[] s = new int[K];
		for(int i=0; i<K; i++) {
			r[i] = sc.nextInt();
			c[i] = sc.nextInt();
			s[i] = sc.nextInt();
		}
		int[][] C = new int[N][M];
		for(int i=0; i<A.length; i++) {
			C[i] = A[i].clone();
		}
		for(int i=0; i<K; i++) {
			C = rotation(C, r[i], c[i], s[i]);
		}
		
		int[] sum = new int[N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sum[i] += C[i][j];
			}
		}
		int min = sum[0];
		for(int i=1; i<N; i++) {
			if(sum[i] < min) {
				min = sum[i];
			}
		}
		
		System.out.println(min);
		/*for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(C[i][j] + " ");
			}
			System.out.println();
		}*/
		
	}

}
