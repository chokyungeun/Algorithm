package a1113;
import java.io.*;
import java.util.*;

public class Solution_D9_1952_수영장_서울9반_조경은 {
	public static int one, two, three, four,res;
	public static int[] plan;
	
	public static void dfs(int month, int val) {
		if(val>res) return;
		if(month>=12) {
			res = Math.min(res, val);
			return;
		}
		if(plan[month]!=0) {
			dfs(month+1, val+(one*plan[month]));
			dfs(month+1, val+two);
			dfs(month+3, val+three);
		}
		else {
			dfs(month+1, val);
			dfs(month+3, val+three);
		}
		
	}
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d9_1952.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			one = Integer.parseInt(st.nextToken());
			two = Integer.parseInt(st.nextToken());
			three = Integer.parseInt(st.nextToken());
			four = Integer.parseInt(st.nextToken());
			plan = new int[12];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			res = four;
			dfs(0,0);
			System.out.println("#" + t + " " + res);
		}
		
	}
}