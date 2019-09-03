package algoad;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D4_3234_준환이의양팔저울_int_dfs_조경은 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_3234.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			boolean[] v = new boolean[N];
			int[] w = new int[N];
			String[] s = br.readLine().split(" ");
			for(int i=0; i<s.length; i++) {
				w[i] = Integer.parseInt(s[i]);
			}
			sb.append("#" + t + " " + dfs(w, v, 0, 0, 0)+"\n");
		}
		System.out.println(sb);
		br.close();
	}

	public static int dfs(int[] w, boolean[] v, int left, int right, int depth) {
		if(left<right) return 0;
		int r = 0;
		if(w.length == depth) {
			return 1;
		}
		for(int i=0; i<w.length; i++) {
			if(!v[i]) {
				v[i] = true;
				r = r+dfs(w, v, left+w[i], right, depth+1);
				r = r+dfs(w, v, left, right+w[i], depth+1);
				v[i] = false;
			}
		}
		return r;
	}

}
