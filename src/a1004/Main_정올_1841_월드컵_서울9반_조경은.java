package a1004;

import java.io.*;
import java.util.*;

public class Main_정올_1841_월드컵_서울9반_조경은 {
	public static int[] winn, draw, lose;
	public static int[] gama = {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
	public static int[] gamb = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
	public static int dfs(int n) {
		if(n>=15) {
			return 1;
		}
		int a = gama[n];
		int b = gamb[n];
		if(winn[a]!=0 && lose[b]!=0) {
			winn[a]--; lose[b]--;
			if((dfs(n+1)==1)) 
				return 1;
			winn[a]++; lose[b]++;
		}
		if(draw[a]!=0 && draw[b]!=0) {
			draw[a]--; draw[b]--;
			if((dfs(n+1)==1)) 
				return 1;
			draw[a]++; draw[b]++;
		}
		if(lose[a]!=0 && winn[b]!=0) {
			winn[b]--; lose[a]--;
			if((dfs(n+1)==1)) 
				return 1;
			winn[b]++; lose[a]++;
		}
		return 0;
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s;
		
		for(int t=0; t<4; t++) {
			s = br.readLine().split(" ");
			winn = new int[6];
			draw = new int[6];
			lose = new int[6];
			int j = -1;
			for(int i=0; i<6; i++) {
				winn[i] = Integer.parseInt(s[++j]);
				draw[i] = Integer.parseInt(s[++j]);
				lose[i] = Integer.parseInt(s[++j]);
			}
			int result = 1;
			for(int i=0; i<6; i++) {
				if(winn[i] > 5 || lose[i] > 5 || draw[i] > 5) {
					result = 0;
					break;
				}
			}
			
			if(result != 0) {
				result = dfs(0);
			}
			
			System.out.print(result + " ");
		}
		
	}

}
