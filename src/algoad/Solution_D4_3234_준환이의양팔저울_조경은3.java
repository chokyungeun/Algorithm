package algoad;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D4_3234_준환이의양팔저울_조경은3 {
	public static int N;
	public static int nSum;
	public static int[] sinker;
	public static int T;
	public static int cnt;
	public static int[] w;
	
	public static void permu(int depth) {
		if(depth==N) {
			dfs(0,0,0);
			return;
		}
		for(int i=depth; i<N; i++) {
			T=sinker[depth];
			sinker[depth]=sinker[i];
			sinker[i]=T;
			permu(depth+1);
			T=sinker[depth];
			sinker[depth]=sinker[i];
			sinker[i]=T;
		}
	}
	public static void dfs(int depth, int left, int right) {
		if(depth==N) {
			cnt++;
			return;
		}
		nSum=left+w[depth];
		dfs(depth+1,nSum,right);
		nSum=right+w[depth];
		if(nSum<=left) {
			dfs(depth+1, left, nSum);
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_3234.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=Tc; t++) {
			N = Integer.parseInt(br.readLine());
			w = new int[N];
			sinker = new int[N];
			nSum = 0;
			T = 0;
			String[] s = br.readLine().split(" ");
			for(int i=0; i<s.length; i++) {
				w[i] = Integer.parseInt(s[i]);
			}
			cnt = 0;
			permu(0);
			System.out.println("#" + t + " " + cnt);
		}
		br.close();
	}



}
