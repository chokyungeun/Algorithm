package array1;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Practice {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int[][] a = {{1,2,3},
				     {4,5,6}};
		int N = a[0].length;
		int M = a.length;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(a[i][j] == 2) {
					int[] di = {-1, -1, -1, 0, 1, 1, 1, 0};
					int[] dj = {-1, 0, 1, 1, 1, 0, -1, -1};
				
					for(int k=0; k<8; k++) {
						int ni = i + di[k];
						int nj = j + dj[k];
						if(0<=ni && ni<a.length && 0<=nj && nj<a[0].length)
							System.out.print(a[ni][nj]+" ");
					}
				}
			}
		}
		
		
		/*
		int[] arr = new int[10];
		
		for(int i=0; i<10; i++)
			arr[i] = sc.nextInt();
		
		for(int i=arr.length-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		
		*/
		
		
		
		
		
		
		
		
		
		
		/*
		int[] c = {10, 11, 12};
		int[] d = c;
		int[][] arr = {{1, 2, 3}, 
					   {4, 5, 6}};
		
		int[][] f = arr;
		
		
		System.out.println(Arrays.toString(d));
		for(int[] v:f)
			System.out.println(Arrays.toString(v));
		
		*/
	
	
	}
}
