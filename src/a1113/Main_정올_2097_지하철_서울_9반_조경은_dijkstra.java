package a1113;
import java.io.*;
import java.util.*;

public class Main_정올_2097_지하철_서울_9반_조경은_dijkstra {
	public static int N,M;
	public static int[][] map;
	public static ArrayList<Integer>[][] list;
	
	public static void func() {
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][k]+map[k][j]< map[i][j]) {
						map[i][j]=map[i][k]+map[k][j];
						for(int x=0; x<list[i][k].size(); x++) {
							list[i][j].add(list[i][k].get(x));
						}
						list[i][j].add(j+1);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		list = new ArrayList[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				list[i][j] = new ArrayList<>();
			}
		}
		
		func();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(list[i][j]);
			}
			System.out.println();
		}
		System.out.println(map[0][M-1]);
		//System.out.println(list[0][M-1]);
	}

}
