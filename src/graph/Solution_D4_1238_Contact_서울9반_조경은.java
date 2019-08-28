package graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_D4_1238_Contact_서울9반_조경은 {
	public static boolean[][] v;
	public static ArrayList<int[]> list;
	public static int[] fin;
	public static int num;
	
	public static void dfs(int x) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i)[0] == x) {
				if(v[list.get(i)[0]][list.get(i)[1]] == true ) {
					dfs(list.get(i)[1]);
				}
			}
		}
		fin[num++] = x;
	}
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1238.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int start = Integer.parseInt(s[1]);
			list = new ArrayList<>();
			s = br.readLine().split(" ");
			for(int i=0; i<N; i++) {
				list.add(new int[] {Integer.parseInt(s[i]), Integer.parseInt(s[++i])});
			}
			
			int max = list.get(0)[0];
			for(int i=0; i<list.size(); i++) {
				if(max < list.get(i)[0])
					max = list.get(i)[0];
				if(max < list.get(i)[1])
					max = list.get(i)[1];
			}
			v = new boolean[max+1][max+1];
			for(int i=0; i<list.size(); i++) {
				v[list.get(i)[0]][list.get(i)[1]] = true;
			}
			num = 0;
			dfs(start);
			int max2 = fin[0];
			for(int i=1; i<fin.length; i++) {
				if(max2 < fin[i])
					max2 = fin[i];
			}
			System.out.println("#" + t + " " + max2);
		}

	}

}
