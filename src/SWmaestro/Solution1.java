package SWmaestro;

import java.io.*;
import java.util.*;

public class Solution1 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N%2==0) {
			for(int i=0; i<N/2; i++) {
				System.out.print(1);
			}
		}
		else {
			System.out.print(7);
			for(int i=0; i<N/2-1; i++) {
				System.out.print(1);
			}
		}
		
		System.out.println();
	}

}
