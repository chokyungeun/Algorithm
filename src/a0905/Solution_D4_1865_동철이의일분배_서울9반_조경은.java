package a0905;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_D4_1865_동철이의일분배_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1865.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			ArrayList<Integer> row = new ArrayList<>();
			ArrayList<Integer> col = new ArrayList<>();
			ArrayList<Integer> va = new ArrayList<>();
			int ni = 0;
			int nj = 0;
			for(int k=0; k<N; k++) {
				for(int i=0; i<N; i++) {
					max = 0;
					if(!row.contains(i)) {
						for(int j=0; j<N; j++) {
							if(!col.contains(j)) {
								if(max < arr[i][j]) {
									max = arr[i][j];
									ni = i;
									nj = j;
								}
							}
						}
					}
					
				}
				va.add(max);
				row.add(ni);
				col.add(nj);
			}
			
			double[] d = new double[va.size()];
			double s = 1;
			for(int i=0; i<va.size(); i++) {
				d[i] = va.get(i)*0.01;
				s *= d[i];
			}
			
			System.out.println("#" + t + " " + String.format("%.6f", (s*100)));
			
		}
	}

}
