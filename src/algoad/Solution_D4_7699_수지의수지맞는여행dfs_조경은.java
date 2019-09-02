package algoad;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_D4_7699_수지의수지맞는여행dfs_조경은 {
	public static int[] di = {-1, 1, 0, 0};
	public static int[] dj = {0,0,-1, 1};
	public static char[][] arr;
	public static int res;
	public static int R;
	public static int C;
	public static ArrayList<Character> list;
	
	private static void dfs(int i, int j) {
		list.add(arr[i][j]);
		if(res < list.size())
			res = list.size();
		for(int d = 0; d < di.length; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(0<=ni && ni<R && 0<=nj && nj<C && !list.contains(arr[ni][nj])) {
				dfs(ni,nj);
				
			}
		}
		list.remove(list.size()-1);
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_7699.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			String[] s = br.readLine().split(" ");
			R = Integer.parseInt(s[0]);
			C = Integer.parseInt(s[1]);
			arr = new char[R][C];
			for(int i=0; i<R; i++) {
				String st = br.readLine();
				arr[i] = st.toCharArray();
			}
			list = new ArrayList<>();
			res = 0;
			dfs(0,0);
			
			System.out.println("#" + t + " " + res);
		}
	}

}
