package solution;
import java.io.*;
import java.util.*;

public class Main_백준_2606_바이러스_서울9반_조경은 {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		boolean[][] v = new boolean[N][N];
		int num = Integer.parseInt(br.readLine());
		for(int i=0; i<num; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			v[a][b] = true;
			v[b][a] = true;
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(v[i][j]) {
					
				}
			}
		}
		
	}

}
