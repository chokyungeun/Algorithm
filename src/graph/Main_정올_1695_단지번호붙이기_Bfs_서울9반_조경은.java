package graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main_정올_1695_단지번호붙이기_Bfs_서울9반_조경은 {
	public static int[][] arr;
	public static boolean[][] v;
	public static int N;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static int res;
	
	public static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		res++;
        v[i][j] = true;
        q.offer(new int[] {i,j});
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int d = 0; d < di.length; d++) {
                int ni = curr[0]+di[d];
                int nj = curr[1]+dj[d];
                if(0<=ni && ni<N && 0<=nj && nj<N && v[ni][nj] == false && arr[ni][nj] == 1) {
                    v[ni][nj] = true;
                    res++;
                    q.offer(new int[] {ni,nj});
                }
            }
        }
		
	}
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_jo_1695.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		v = new boolean[N][N];
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split("");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		ArrayList<Integer> r = new ArrayList<>();
		int num =-1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] == 1 && v[i][j] == false) {
					num++;
					res = 0;
					bfs(i, j);
					r.add(res);
				}
			}
		}
		System.out.println(num+1);
		Collections.sort(r);
		for(int i=0; i<=num; i++) {
			System.out.println(r.get(i));
		}
		
	}

}
