package a1114;
import java.io.*;
import java.util.*;

public class Solution_D4_1868_파핑파핑지뢰찾기_서울9반_조경은 {
	public static int N,res;
	public static char[][] arr;
	public static int[] di= {-1,-1,-1,0,1,1,1,0};
	public static int[] dj= {-1,0,1,1,1,0,-1,-1};
	public static int[] ddi= {-1,1,0,0};
	public static int[] ddj= {0,0,-1,1};
	public static boolean[][] v;
	public static boolean[][] v2;
	
	public static void check(int i, int j) {
		int num=0;
		for(int k=0; k<di.length; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			if(ni>=0 && ni<N && nj>=0 && nj<N && arr[ni][nj]=='*') {
				num++;
			}
		}
		if(num==0) {
			v[i][j]=true;
			arr[i][j]='0';
			click(i,j);
		}
	}
	public static void click(int i, int j) {
		for(int k=0; k<di.length; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			if(ni>=0 && ni<N && nj>=0 && nj<N && arr[ni][nj]!='*' && !v[ni][nj]) {
				v[ni][nj]=true;
			}
		}
	}
	
	public static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		v2[i][j]=true;
		q.offer(new int[] {i,j});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int k=0; k<di.length; k++) {
				int ni = curr[0] + di[k];
				int nj = curr[1] + dj[k];
				if(ni>=0 && ni<N && nj>=0 && nj<N && !v2[ni][nj] ) {
					if(arr[ni][nj]=='0') {
						v2[ni][nj]=true;
						q.offer(new int[] {ni,nj});
					}
					else {
						v2[ni][nj]=true;
					}
				}
			}
		}
	}
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1868.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new char[N][N];
			v = new boolean[N][N];
			v2 = new boolean[N][N];
			for(int i=0; i<N; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(arr[i][j]=='.') {
						check(i,j);
					}
				}
			}
			
			int num=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!v2[i][j] && v[i][j]) {
						num++;
						bfs(i,j);
					}
				}
			}
			res=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!v[i][j] && arr[i][j]!='*') res++;
				}
			}
			
			System.out.println("#" + t + " " + (res+num));
		}
		
	}
}