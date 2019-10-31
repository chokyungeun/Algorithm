package a1031;

import java.io.*;
import java.util.*;

public class Solution_D4_6109_추억의2048게임_서울9반_조경은 {
	public static int N;
	public static int[][] res, arr;
	public static String s;

	public static void move(String dir) {
		if(dir.equals("left")) {
			for(int i=0; i<N; i++) {
				int index=-1;
				for(int j=0; j<N-1; j+=2) {
					if(arr[i][j] == arr[i][j+1]&& arr[i][j]!=0) {
						res[i][index++] = arr[i][j] + arr[i][j+1];
						arr[i][j+1]=0;
					}
					else if(arr[i][j+1]==0) {
						if(j+1==0) {
							res[i][index++] = arr[i][j];
							break;
						}
						arr[i][j+1]=arr[i][j];
						arr[i][j]=0;
						j--;
					}
					else {
						res[i][index++] = arr[i][j];
						j--;
					}
				}
				if(N%2==1) {
					res[i][index++] = arr[i][N-1];
				}
			}
			
		}
		else if(dir.equals("right")) {
			for(int i=0; i<N; i++) {
				int index=N;
				for(int j=N-1; j>0; j-=2) {
					if(arr[i][j] == arr[i][j-1]&& arr[i][j]!=0) {
						res[i][index--] = arr[i][j] + arr[i][j-1];
						arr[i][j-1]=0;
					}
					else if(arr[i][j-1]==0) {
						if(j-1==0) {
							res[i][index--] = arr[i][j];
							break;
						}
						arr[i][j-1]=arr[i][j];
						arr[i][j]=0;
						j++;
					}
					else {
						res[i][index--] = arr[i][j];
						j++;
					}
				}
				if(N%2==1) {
					res[i][index--] = arr[i][0];
				}
			}
			
			
		}
		else if(dir.equals("up")) {
			for(int i=0; i<N; i++) {
				int index = 0;
				for(int j=0; j<N-1; j+=2) {
					if(arr[j][i] == arr[j+1][i]&& arr[j][i]!=0) {
						res[index++][i] = arr[j][i] + arr[j+1][i];
						arr[j][i]=0;
						arr[j+1][i]=0;
					}
					else if(arr[j+1][i]==0) {
						if(j+1==N-1) {
							res[index++][i] = arr[j][i];
							break;
						}
						arr[j+1][i]=arr[j][i];
						arr[j][i]=0;
						j--;
					}
					else {
						res[index++][i] = arr[j][i];
						j--;
					}
				}
				if(N%2==1) {
					res[index++][i] = arr[N-1][i];
				}
			}
			
		}
		else if(dir.equals("down")) {
			for(int i=N-1; i>=0; i--) {
				int index = N;
				for(int j=N-1; j>0; j-=2) {
					if(arr[j][i] == arr[j-1][i] && arr[j][i]!=0) {
						res[--index][i] = arr[j][i] + arr[j-1][i];
						arr[j-1][i]=0;
					}
					else if(arr[j-1][i]==0) {
						if(j-1==0) {
							res[--index][i] = arr[j][i];
							break;
						}
						arr[j-1][i]=arr[j][i];
						arr[j][i]=0;
						j++;
					}
					else {
						res[--index][i] = arr[j][i];
						j++;
					}
				}
				if(N%2==1) {
					res[--index][i] = arr[0][i];
				}
			}
			
			
		}
		
		
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_6109.txt"));
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
			move(s);

			System.out.println("#" + t);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(res[i][j] + " ");
				}
				System.out.println();
			}
			
		}

	}

}
