package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main_정올_2000_동전교환_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		
		int N = Integer.parseInt(br.readLine());
		int[] coin = new int[N];
		String[] s = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			coin[i] = Integer.parseInt(s[i]);
		}
		int W = Integer.parseInt(br.readLine());
		int[] m = new int[W+1];
		
		for(int i=1; i<=W; i++) {
			int min = Integer.MAX_VALUE/2;
			for(int j=0; j<coin.length; j++) {
				if(i-coin[j]>=0) {
					if(min>m[i-coin[j]])
						min = m[i-coin[j]];
				}
			}
			m[i] = min + 1;
		}
		if(m[W] >= Integer.MAX_VALUE/2)
			System.out.println("impossible");
		else
			System.out.println(m[W]);
		

	}

}
