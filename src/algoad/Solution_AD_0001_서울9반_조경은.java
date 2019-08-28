package algoad;

import java.io.*;
import java.util.*;

public class Solution_AD_0001_서울9반_조경은 {
	public static int res;
	
	public static void shuffle(int[] arr) {
		int[] arr2 = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			arr2[i] = arr[i];
		}
		Arrays.sort(arr2);
		int num=0;
		for(int i=0; i<arr.length; i++) {
			if(arr2[i] != arr[i]) {
				num++;
			}
		}
		if(num==0) {
			return;
		}
		num=0;
		for(int i=0; i<arr.length; i++) {
			for(int j=arr.length-1; j>=0; j--) {
				if(arr2[j] != arr[i]) {
					num++;
				}
			}
			
		}
		if(num==0) {
			return;
		}
		
		
		
		res++;
		shuffle(arr);
		
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			res=0;
			shuffle(arr);
			
			System.out.println("#" + t + " " + res);
			
			
		}
		
	}
}
