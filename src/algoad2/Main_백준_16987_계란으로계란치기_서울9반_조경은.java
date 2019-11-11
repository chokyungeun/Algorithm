package algoad2;
import java.io.*;
import java.util.*;

public class Main_백준_16987_계란으로계란치기_서울9반_조경은 {
	public static int N,res;
	public static ArrayList<int[]> egg;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		egg = new ArrayList<>();
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			egg.add(new int[] {Integer.parseInt(s[0]), Integer.parseInt(s[1]), i, 1});
		}
		res = 0;
		dfs(0, 0);
		
		System.out.println(res);
		
	}
	public static void dfs(int left, int num) {
		if(left == N) {
			res = Math.max(res, num);
			return;
		}
		if(egg.get(left)[0]<=0) {
			dfs(left+1,num);
			return;
		}
		boolean bf=false;
		for(int i=0; i<N; i++) {
			if(i!=left && egg.get(i)[0]>0) {
				bf=true;
				egg.get(left)[0]-=egg.get(i)[1];
				egg.get(i)[0]-=egg.get(left)[1];
				if(egg.get(left)[0]<=0 && egg.get(i)[0]<=0)
					dfs(left+1,num+2);
				else if(egg.get(left)[0]>0 && egg.get(i)[0]>0)
					dfs(left+1, num);
				else
					dfs(left+1, num+1);
				egg.get(left)[0]+=egg.get(i)[1];
				egg.get(i)[0]+=egg.get(left)[1];
			}
		}
		if(!bf)
			dfs(left+1,num);
	}

}
