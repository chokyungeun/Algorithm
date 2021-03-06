package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_D4_2819_격자이어붙이기_서울9반_조경은 {
	public static int[] di= {-1,1,0,0};
	public static int[] dj= {0,0,-1,1};
	public static ArrayList<String> list = new ArrayList<>();
	public static char[][] arr;
	public static int res, num;
	public static StringBuilder str;
	
	public static void dfs(int i, int j) {
		num++;
		str.append(arr[i][j]);
		if(num == 7) {
			if(!list.contains(str.toString())) {
				list.add(str.toString());
				res++;
			}
			return;
		}
		for(int d=0; d<di.length; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni>=0 && ni<4 && nj>=0 && nj<4) {
				dfs(ni,nj);
				str.delete(num-1, num);
				num--;
				
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		double start = System.nanoTime();
		System.setIn(new FileInputStream("res/input_d4_2819.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			arr = new char[4][4];
			for(int i=0; i<4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<4; j++) {
					arr[i][j] = st.nextToken().charAt(0);
				}
				
			}
			res = 0;
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					num = 0;
					str = new StringBuilder();
					dfs(i, j);
				}
			}
			
			System.out.println("#" + t + " " + res);
			System.out.println(System.nanoTime()-start);
		}

	}

}
