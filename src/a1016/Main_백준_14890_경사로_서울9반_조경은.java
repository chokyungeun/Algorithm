package a1016;

import java.io.*;
import java.util.*;

public class Main_백준_14890_경사로_서울9반_조경은 {
	public static int N,L,res,index;
	public static int[][] map;
	public static int[] di = {1,0};
	public static int[] dj = {0,1};
	public static boolean[][] v;
	
	public static void road(int i, int j, int k) {
		int len=1;
		int index = 0;
		while(true) {
			index++;
			if(index == N) {
				res++;
				return;
			}
			int ni = i+di[k];
			int nj = j+dj[k];
			
			if(map[i][j]==map[ni][nj]) { //평지인경우
				len++;
			}
			else { //평지가 아닌 경우
				if(Math.abs(map[i][j]-map[ni][nj])>1) { //경사가 1보다 큰경우
					return;
				}
				else {
					if(map[i][j]-map[ni][nj] == 1) { //낮아진 경우(앞의 상황을 봐야함)
						
						for(int f=0; f<L; f++) {
							int nni = ni+(f*di[k]);
							int nnj = nj+(f*dj[k]);
							if(nni<N && nnj<N && map[nni][nnj] == map[ni][nj] && !v[nni][nnj]) {
								v[nni][nnj] = true;
							}
							else {
								return;
							}
						}
						len=1;
					}
					else { //높아진 경우
						if(len >= L) {
							for(int f=1; f<=L; f++) {
								int nni = ni-(f*di[k]);
								int nnj = nj-(f*dj[k]);
								if(!v[nni][nnj]) {
									v[nni][nnj] = true;
								}
								else {
									return;
								}
							}
							len=1;
						}
						else {
							return;
						}
					}
				}
			}
			
			i = ni;
			j = nj;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		res = 0;
		for(int i=0; i<N; i++) {
			v = new boolean[N][N];
			road(0,i,0);
			v = new boolean[N][N];
			road(i,0,1);
		}
		
		System.out.println(res);
	}

}
