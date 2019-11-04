package a1031;

import java.io.*;
import java.util.*;

public class Solution_D4_6109_추억의2048게임_서울9반_조경은 {
	public static int N;
	public static int[][] res, arr;
	public static String s;

	public static void left() {
		for(int i=0; i<N; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			int n1=0;
			int n2=0;
			for(int j=0; j<N; j++) {
				if(n1 !=0 && n2 !=0) {
					if(n1==n2) {
						list.add(n1+n2);
						n1=0;
						n2=0;
					}
					else {
						list.add(n1);
						n1=n2;
						n2=0;
					}
				}
				if(arr[i][j]!=0 && n1==0) {
					n1 = arr[i][j];
				}
				else if(arr[i][j]!=0 && n1!=0) {
					n2 = arr[i][j];
				}
				if(n1 !=0 && n2 !=0) {
					if(n1==n2) {
						list.add(n1+n2);
						n1=0;
						n2=0;
					}
					else {
						list.add(n1);
						n1=n2;
						n2=0;
					}
				}
			}
			if(n1 !=0) list.add(n1);
			for(int j=0; j<list.size(); j++) {
				res[i][j] = list.get(j);
			}
		}
	}

	public static void right() {
		for(int i=0; i<N; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			int n1=0;
			int n2=0;
			for(int j=N-1; j>=0; j--) {
				if(n1 !=0 && n2 !=0) {
					if(n1==n2) {
						list.add(n1+n2);
						n1=0;
						n2=0;
					}
					else {
						list.add(n1);
						n1=n2;
						n2=0;
					}
				}
				if(arr[i][j]!=0 && n1==0) {
					n1 = arr[i][j];
				}
				else if(arr[i][j]!=0 && n1!=0) {
					n2 = arr[i][j];
				}
				if(n1 !=0 && n2 !=0) {
					if(n1==n2) {
						list.add(n1+n2);
						n1=0;
						n2=0;
					}
					else {
						list.add(n1);
						n1=n2;
						n2=0;
					}
				}
			}
			if(n1 !=0) list.add(n1);
			int index=N;
			for(int j=0; j<list.size(); j++) {
				res[i][--index] = list.get(j);
			}
		}
	}

	public static void up() {
		for(int j=0; j<N; j++) {
			ArrayList<Integer> list = new ArrayList<>();
			int n1=0;
			int n2=0;
			for(int i=0; i<N; i++) {
				if(n1 !=0 && n2 !=0) {
					if(n1==n2) {
						list.add(n1+n2);
						n1=0;
						n2=0;
					}
					else {
						list.add(n1);
						n1=n2;
						n2=0;
					}
				}
				if(arr[i][j]!=0 && n1==0) {
					n1 = arr[i][j];
				}
				else if(arr[i][j]!=0 && n1!=0) {
					n2 = arr[i][j];
				}
				if(n1 !=0 && n2 !=0) {
					if(n1==n2) {
						list.add(n1+n2);
						n1=0;
						n2=0;
					}
					else {
						list.add(n1);
						n1=n2;
						n2=0;
					}
				}
			}
			if(n1 !=0) list.add(n1);
			for(int i=0; i<list.size(); i++) {
				res[i][j] = list.get(i);
			}
		}
	}

	public static void down() {
		for(int j=0; j<N; j++) {
			ArrayList<Integer> list = new ArrayList<>();
			int n1=0;
			int n2=0;
			for(int i=N-1; i>=0; i--) {
				if(n1 !=0 && n2 !=0) {
					if(n1==n2) {
						list.add(n1+n2);
						n1=0;
						n2=0;
					}
					else {
						list.add(n1);
						n1=n2;
						n2=0;
					}
				}
				if(arr[i][j]!=0 && n1==0) {
					n1 = arr[i][j];
				}
				else if(arr[i][j]!=0 && n1!=0) {
					n2 = arr[i][j];
				}
				if(n1 !=0 && n2 !=0) {
					if(n1==n2) {
						list.add(n1+n2);
						n1=0;
						n2=0;
					}
					else {
						list.add(n1);
						n1=n2;
						n2=0;
					}
				}
			}
			if(n1 !=0) list.add(n1);
			int index = N;
			for(int i=0; i<list.size(); i++) {
				res[--index][j] = list.get(i);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_d4_6109.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] ss = br.readLine().split(" ");
			N = Integer.parseInt(ss[0]);
			s = ss[1];
			res = new int[N][N];
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			if (s.equals("left"))
				left();
			else if (s.equals("right"))
				right();
			else if (s.equals("up"))
				up();
			else if (s.equals("down"))
				down();

			System.out.println("#" + t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(res[i][j] + " ");
				}
				System.out.println();
			}

		}

	}

}