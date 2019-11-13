package a1113;
import java.io.*;
import java.util.*;

public class Main_정올_2097_지하철_서울_9반_조경은_dfs {
	public static int N,M,res;
	public static int[][] map;
	public static ArrayList<Integer> rlist;
	
	public static void dfs(int i, int temp, ArrayList<Integer> list, boolean[] v) {
		if(temp>res) {
			return;
		}
		if(i==M) {
			if(res>temp) {
				res = temp;
				rlist = new ArrayList<>(list);
			}
			return;
		}
		for(int k=0; k<N; k++) {
			if(!v[k]) {
				v[k] = true;
				list.add(k);
				dfs(k,temp+map[i][k],list,v);
				list.remove((Object)k);
				v[k] = false;
			}
			
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken())-1;
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		res = Integer.MAX_VALUE;
		list.add(0);
		boolean[] v = new boolean[N];
		v[0] = true;
		dfs(0,0,list,v);
		System.out.println(res);
		for(int i=0; i<rlist.size(); i++) {
			System.out.print(rlist.get(i)+1 + " ");
		}
		
	}

}
