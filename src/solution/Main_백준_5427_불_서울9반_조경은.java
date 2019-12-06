package solution;
import java.io.*;
import java.util.*;

public class Main_백준_5427_불_서울9반_조경은 {
	public static int w,h;
	public static char[][] map;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			int si=0;
			int sj=0;
			for(int i=0; i<h; i++) {
				String s = br.readLine();
				for(int j=0; j<w; j++) {
					map[i][j]= s.charAt(j);
					if(map[i][j]=='@') {
						si=i;
						sj=j;
					}
					else if(map[i][j]=='*') {
						
					}
				}
			}
			
			
		}
	}

}
