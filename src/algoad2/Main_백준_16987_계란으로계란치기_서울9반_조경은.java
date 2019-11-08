package algoad2;
import java.io.*;
import java.util.*;

public class Main_백준_16987_계란으로계란치기_서울9반_조경은 {
	public static int N,res;
	public static boolean[] v;
	public static ArrayList<int[]> egg;
	public static int[] order;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		egg = new ArrayList<>();
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			egg.add(new int[] {Integer.parseInt(s[0]), Integer.parseInt(s[1]), i, 1});
		}
		v = new boolean[N];
		order = new int[N-1];
		int[] left = egg.get(0);
		v[0] = true;
		res=0;
		
		dfs(0,0);
		
		
	}

	private static void dfs(int index, int x) {
		if(index == N) {
			res = Math.max(res, x);
			return;
		}
		int ls = egg.get(index)[0];
		int lw = egg.get(index)[1];
		
		for(int i=0; i<N; i++) {
			if(!v[i]) {
				int rs = egg.get(i)[0];
				int rw = egg.get(i)[1];
				//깨트림
				v[i] = true;
				//둘다 깨질 때
				if(ls-rw<=0 && rs-lw<=0) {
					v[index]=false;
					dfs(index+1, x);
					v[index] = true;
				}
				//손에 든 계란만 깨질 때
				else if(ls-rw>0 && rs-lw<=0) {
					egg.get(i)[0]-=egg.get(index)[1];
					dfs(index+1,x+1);
					egg.get(i)[0]+=egg.get(index)[1];
				}
				//손에 안든 계란이 깨질 때
				else if(ls-rw<=0 && rs-lw>0) {
					
				}
				//둘 다 안깨질때
				else { 
					
				}
				int x2 = x;
				
				v[i] = false;
			}
		}
		
	}

	
		
	

}
