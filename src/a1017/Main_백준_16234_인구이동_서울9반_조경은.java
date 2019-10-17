package a1017;

import java.io.*;
import java.util.*;

public class Main_백준_16234_인구이동_서울9반_조경은 {
	public static int N,L,R,idx;
	public static int[][] arr, line;
	public static int[] di= {-1,1,0,0};
	public static int[] dj= {0,0,-1,1};
	public static ArrayList<int[]> info;
	
	public static void open(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		int n = 1;
		int sum = arr[i][j];
		line[i][j] = idx;
		q.offer(new int[] {i,j});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int k=0; k<di.length; k++) {
				int ni = curr[0]+di[k];
				int nj = curr[1]+dj[k];
				if(ni>=0 && ni<N && nj>=0 && nj<N && line[ni][nj]==0 && Math.abs(arr[curr[0]][curr[1]]-arr[ni][nj])>=L && Math.abs(arr[curr[0]][curr[1]]-arr[ni][nj])<=R) {
					line[ni][nj] = idx;
					n++;
					sum += arr[ni][nj];
					q.offer(new int[] {ni,nj});
				}
			}
		}
		
		info.add(new int[] {sum,n,idx});
	}
	
	public static boolean move() {
		int[][] map = new int[N][N];
		for(int i=0; i<info.size(); i++) {
			int p = info.get(i)[0]/info.get(i)[1];
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					if(line[j][k]==info.get(i)[2]) {
						map[j][k] = p;
					}
				}
			}
		}
		int x=0;
		Loop:for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] != map[i][j]) {
					x++;
					break Loop;
				}
			}
		}
		if(x==0) {
			return true;
		}
		for(int i=0; i<N; i++) {
			arr[i] = Arrays.copyOf(map[i], N);
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int res=0;
		while(true) {
			line = new int[N][N];
			info = new ArrayList<>();
			idx=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(line[i][j] == 0) {
						idx++;
						open(i,j);
					}
				}
			}
			
			
			if(move()) {
				break;
			}
			res++;
		}
		
		System.out.println(res);
		
		
	}
}
