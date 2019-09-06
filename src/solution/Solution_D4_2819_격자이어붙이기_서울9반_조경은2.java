package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_D4_2819_격자이어붙이기_서울9반_조경은2 {
	public static int[] di= {-1,1,0,0};
	public static int[] dj= {0,0,-1,1};
	public static ArrayList<String> list = new ArrayList<>();
	public static char[][] arr;
	public static int[][] v;
	public static int[] a;
	public static int res, num;
	public static StringBuilder str;
	public static void permComb(int start, int start2, int count) {
		if(count == 7) {
			res++;
			return;
		}
		for(int i=0; i<4; i++) { //i=start로 시작하면 조합, 0으로 시작하면 순열
			for(int j=0; j<4; j++) {
				if(v[i][j]==0) { //!!
					v[i][j] = 1; //visit 배열에 방문처리 //!!
					a[count] = arr[i][j];
					permComb(i,j,count+1);
					v[i][j] = 0; //방문 해제. //!!
				} //!!
			}
			
		}
		//!!주석처리 하면 중복허용, 주석처리 안하면 중복제거
	}
	
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_2819.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			arr = new char[4][4];
			v = new int[4][4];
			a = new int[7];
			for(int i=0; i<4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<4; j++) {
					arr[i][j] = st.nextToken().charAt(0);
				}
				
			}
			res = 0;
			permComb(0,0, 0);
			System.out.println("#" + t + " " + res);
		}

	}

}
