package solution;
import java.io.*;
import java.util.*;

public class Main_백준_9676_탈옥_서울9반_조경은 {
	public static char[][] arr,a;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static ArrayList<int[]> list,door,door2;
	public static int res,w,h,res2;
	public static boolean[][] v,v2,v3;
	
	public static void dfs(int i, int j, int temp) {
		if(temp>res) {
			return;
		}
		if(i==0 || i==h-1 || j==0 || j==w-1) {
			if(res > temp) {
				res = temp;
				door = new ArrayList<>();
				for(int x=0; x<h; x++) {
					for(int y=0; y<w; y++) {
						if(arr[x][y]=='#'&&v[x][y]) {
							door.add(new int[] {x,y});
						}
					}
				}
				v3 = v;
			}
		}
		
		v[i][j]=true;
		
		for(int k=0; k<di.length; k++) {
			int ni = i+di[k];
			int nj = j+dj[k];
			if(ni>=0 && ni<h && nj>=0 && nj<w && !v[ni][nj] && arr[ni][nj]!='*') {
				if(arr[ni][nj]=='#') {
					dfs(ni,nj,temp+1);
				}
				else {
					dfs(ni,nj,temp);
				}
			}
		}
		v[i][j] = false;
	}
	
	public static boolean dfs2(int i, int j, int temp) {
		if(temp>res2) {
			return false;
		}
		if(i==0 || i==h-1 || j==0 || j==w-1) {
			if(res2 > temp) {
				res2 = temp;
				door2 = new ArrayList<>();
				for(int x=0; x<h; x++) {
					for(int y=0; y<w; y++) {
						if(arr[x][y]=='#'&& v2[x][y]) {
							door2.add(new int[] {x,y});
						}
					}
				}
			}
		}
		
		v2[i][j]=true;
		
		for(int k=0; k<di.length; k++) {
			int ni = i+di[k];
			int nj = j+dj[k];
			if(ni>=0 && ni<h && nj>=0 && nj<w && !v2[ni][nj] && arr[ni][nj]!='*') {
				if(v3[ni][nj]) {
					return true;
				}
				if(arr[ni][nj]=='#') {
					if(dfs2(ni,nj,temp+1)) return true;
				}
				else {
					if(dfs2(ni,nj,temp)) return true;
				}
			}
		}
		v2[i][j] = false;
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();
			door = new ArrayList<>();
			door2 = new ArrayList<>();
			arr = new char[h][w];
			
			for(int i=0; i<h; i++) {
				String s = br.readLine();
				for(int j=0; j<w; j++) {
					arr[i][j] = s.charAt(j);
					if(arr[i][j]=='$') {
						list.add(new int[] {i,j});
					}
				}
			}
			
			res=Integer.MAX_VALUE;
			v = new boolean[h][w];
			dfs(list.get(0)[0],list.get(0)[1],0);
			
			res2=Integer.MAX_VALUE;
			v2 = new boolean[h][w];
			dfs2(list.get(1)[0],list.get(1)[1],0);
			
			int minus = 0;
			for(int i=0; i<door2.size(); i++) {
				if(door.contains(door2.get(i))){
					minus++;
				}
			}
			/*for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					System.out.print(x[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();*/
			System.out.println(res + " " + res2 + " " + minus);
			
			
			
			//System.out.println(res+res2-minus);
			
		}	
	}

}
