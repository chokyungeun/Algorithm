package a1220;
import java.io.*;
import java.util.*;

public class Solution3_dfs {
	public static char[] N,res;
	public static char x,y;
	
	public static boolean dfs(int index, char[] temp) {
		if(index==N.length) {
			res = temp;
			return true;
		}
		if(N[index]>=x) {
			temp[index]=x;
			if(dfs(index+1, temp)) return true;
		}
		
		if(N[index]>y) {
			temp[index]=y;
			for(int i=index+1; i<N.length; i++) {
				temp[i] = x;
			}
			res = temp;
			return true;
		}
		else if(N[index]==y) {
			temp[index] = y;
			if(dfs(index+1, temp)) return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			String[] s = br.readLine().split(" ");
			N = s[0].toCharArray();
			x = s[1].charAt(0);
			y = s[2].charAt(0);
			char[] temp = N;
			char te;
			if(x<y) {
				te = x;
				x = y;
				y = te;
			}
			if(dfs(0, temp) && !res.equals("0")) {
				System.out.print("#" + t + " ");
				for(int i=0; i<res.length; i++) {
					System.out.print(res[i]);
				}
				System.out.println();
			}
			else {
				System.out.println("#" + t + " " + -1);
			}
		}

	}

}
