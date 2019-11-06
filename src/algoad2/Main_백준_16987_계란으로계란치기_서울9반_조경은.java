package algoad2;
import java.io.*;
import java.util.*;

public class Main_백준_16987_계란으로계란치기_서울9반_조경은 {
	public static int N,res;
	public static boolean[] v;
	public static ArrayList<int[]> egg;
	

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		egg = new ArrayList<>();
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			egg.add(new int[] {Integer.parseInt(s[0]), Integer.parseInt(s[1]),i});
		}
		v = new boolean[N];
		int[] temp = egg.get(0);
		v[0] = true;
		
		res=0;
		
		dfs(0,temp);
		
		
	}

	private static void dfs(int num, int[] left) {
		if(left[2]==N) {
			res = Math.max(res, num);
			return;
		}
		
		for(int i=1; i<N; i++) {
			if(!v[i]) {
				if(left[0]-egg.get(i)[1]<=0 && egg.get(i)[0]-left[1]<=0) {
					v[left[2]]=false;
					for(int j=0; j<N; j++) {
						if(!v[j]) {
							left = egg.get(j);
						}
					}
					dfs(num,left);
				}
				else if(left[0]-egg.get(i)[1]<=0 && egg.get(i)[0]-left[1]>0) {
					
				}
			}
		}
		
		
	}

}
