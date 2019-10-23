package a1023;

import java.io.*;

public class Solution_D3_5607_조합_서울9반_조경은 {
	
	public static long fac1(long R) {
		if(R==2) return 2;
		return R*fac1(R-1);
	}
	
	public static long fac2(long N, long R, int index) {
		if(index==R) return 1;
		return N*fac2(N-1,R,index+1);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			String[] s = br.readLine().split(" ");
			long N = Long.parseLong(s[0]);
			long R = Long.parseLong(s[1]);
			
			System.out.println("#" + t + " " + fac2(N,R,0)/fac1(R)%1234567891);
		}
		
	}
	
}
