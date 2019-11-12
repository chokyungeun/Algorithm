package solution;

import java.io.*;
import java.util.*;

public class Main_백준_15685_드래곤커브_서울9반_조경은 {
	public static int N,res;
	public static ArrayList<int[]> curve;
	public static int[] di = {0,-1,0,1};
	public static int[] dj = {1,0,-1,0};
	public static boolean[][] v;
	public static ArrayList<Integer> dir;
	
	public static void dragon(int i, int j, int d, int g) {
		dir = new ArrayList<>();
		v[i][j] = true;
		dir.add(d);
		i = i+di[d];
		j = j+dj[d];
		v[i][j] = true;
		
		for(int x=1; x<=g; x++) {
			ArrayList<Integer> temp = new ArrayList<>();
			for(int y=dir.size()-1; y>=0; y--) {
				int ni=i+di[(dir.get(y)+1)%4];
				int nj=j+dj[(dir.get(y)+1)%4];
				if(ni>=0 && ni<=100 && nj>=0 && nj<=100) {
					v[ni][nj] = true;
					i = ni;
					j = nj;
					temp.add((dir.get(y)+1)%4);
				}
			}
			for(int y=0; y<temp.size(); y++) {
				dir.add(temp.get(y));
			}
			
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = new boolean[101][101];
		N = Integer.parseInt(st.nextToken());
		curve = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			curve.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		res = 0;
		for(int i=0; i<N; i++) {
			int y = curve.get(i)[0];
			int x = curve.get(i)[1];
			int d = curve.get(i)[2];
			int g = curve.get(i)[3];
			dragon(x,y,d,g);
		}
		
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(v[i][j] && v[i+1][j] && v[i+1][j+1] && v[i][j+1]) {
					res++;
				}
			}
		}
		System.out.println(res);
	}

}
