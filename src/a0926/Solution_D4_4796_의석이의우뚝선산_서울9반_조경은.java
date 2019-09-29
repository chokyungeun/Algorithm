package a0926;

import java.io.*;
import java.util.*;

public class Solution_D4_4796_의석이의우뚝선산_서울9반_조경은 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_4796.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int a = sc.nextInt();
			int b = a;
			
			for(int i=1; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			int res = 0;
			int index = 0;
			int index2 = 0;
			boolean tf = false;
			for(int i=1; i<N; i++) {
				if(a <= arr[i]) {
					if(index2 !=0) {
						if(tf == true)
							res += (index*index2);
						index = 0;
					}
					
					a = arr[i];
					b = arr[i];
					index++;
					index2 = 0;
					tf = true;
				}
				else {
					if(b > arr[i]) {
						index2++;
						b = arr[i];
					}
					else{
						res += (index*index2);
						index = 1;
						index2=0;
						a = arr[i];
						b = arr[i];
					}
				}
				if(i == N-1) {
					if(tf == true)
						res += (index*index2);
				}
			}
			
			System.out.println("#" + t + " " + res);
		}
	}
}
